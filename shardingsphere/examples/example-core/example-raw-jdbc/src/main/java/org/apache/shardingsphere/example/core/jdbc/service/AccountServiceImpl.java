/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.example.core.jdbc.service;

import org.apache.shardingsphere.example.core.api.entity.Account;
import org.apache.shardingsphere.example.core.api.repository.AccountRepository;
import org.apache.shardingsphere.example.core.api.service.ExampleService;
import org.apache.shardingsphere.example.core.jdbc.repository.AccountRepositoryImpl;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class AccountServiceImpl implements ExampleService {
    
    private final AccountRepository accountRepository;
    
    public AccountServiceImpl(final DataSource dataSource) {
        accountRepository = new AccountRepositoryImpl(dataSource);
    }
    
    public AccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @Override
    public void initEnvironment() throws SQLException {
        accountRepository.createTableIfNotExists();
        accountRepository.truncateTable();
    }
    
    @Override
    public void cleanEnvironment() throws SQLException {
        accountRepository.dropTable();
    }
    
    @Override
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> accountIds = insertData();
        printData();
        deleteData(accountIds);
        printData();
        System.out.println("-------------- Process Success Finish --------------");
    }
    
    @Override
    public void processFailure() throws SQLException {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }
    
    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            Account account = insertAccounts(i);
            result.add(account.getAccountId());
        }
        return result;
    }
    
    private Account insertAccounts(final int i) throws SQLException {
        Account account = new Account();
        account.setUserId(i);
        account.setStatus("INSERT_TEST");
        accountRepository.insert(account);
        return account;
    }
    
    private void deleteData(final List<Long> accountIds) throws SQLException {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : accountIds) {
            accountRepository.delete(each);
        }
    }
    
    @Override
    public void printData() throws SQLException {
        System.out.println("---------------------------- Print Account Data -----------------------");
        for (Object each : accountRepository.selectAll()) {
            System.out.println(each);
        }
    }
}
