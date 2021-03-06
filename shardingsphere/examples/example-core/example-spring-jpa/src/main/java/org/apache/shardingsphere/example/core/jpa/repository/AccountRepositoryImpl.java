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

package org.apache.shardingsphere.example.core.jpa.repository;

import org.apache.shardingsphere.example.core.api.entity.Account;
import org.apache.shardingsphere.example.core.api.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }
    
    @Override
    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }
    
    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }
    
    @Override
    public Long insert(final Account account) {
        entityManager.persist(account);
        return account.getAccountId();
    }
    
    @Override
    public void delete(final Long accountId) {
        Query query = entityManager.createQuery("DELETE FROM AccountEntity o WHERE o.accountId = ?1");
        query.setParameter(1, accountId);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Account> selectAll() {
        return (List<Account>) entityManager.createQuery("SELECT o FROM AccountEntity o").getResultList();
    }
}
