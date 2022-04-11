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

package org.apache.shardingsphere.driver.state.circuit.connection;

import java.sql.Array;
import org.apache.shardingsphere.driver.state.circuit.metadata.CircuitBreakerDatabaseMetaData;
import org.apache.shardingsphere.driver.state.circuit.statement.CircuitBreakerPreparedStatement;
import org.apache.shardingsphere.driver.state.circuit.statement.CircuitBreakerStatement;
import org.apache.shardingsphere.driver.jdbc.unsupported.AbstractUnsupportedOperationConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Circuit breaker connection.
 */
public final class CircuitBreakerConnection extends AbstractUnsupportedOperationConnection {
    
    @Override
    public DatabaseMetaData getMetaData() {
        return new CircuitBreakerDatabaseMetaData();
    }
    
    @Override
    public void setReadOnly(final boolean readOnly) {
    }
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    @Override
    public void setCatalog(final String catalog) {
    }
    
    @Override
    public String getCatalog() {
        return "";
    }
    
    @Override
    public void setTransactionIsolation(final int level) {
    }
    
    @Override
    public int getTransactionIsolation() {
        return Connection.TRANSACTION_NONE;
    }
    
    @Override
    public SQLWarning getWarnings() {
        return null;
    }
    
    @Override
    public void clearWarnings() {
    }
    
    @Override
    public void setAutoCommit(final boolean autoCommit) {
    }
    
    @Override
    public boolean getAutoCommit() {
        return false;
    }
    
    @Override
    public void commit() {
    }
    
    @Override
    public void rollback() {
    }
    
    @Override
    public void rollback(final Savepoint savepoint) throws SQLException {
        throw new SQLFeatureNotSupportedException("rollback savepoint");
    }
    
    @Override
    public Savepoint setSavepoint() throws SQLException {
        throw new SQLFeatureNotSupportedException("setSavepoint");
    }

    @Override
    public Savepoint setSavepoint(final String name) throws SQLException {
        throw new SQLFeatureNotSupportedException("setSavepoint name");
    }

    @Override
    public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
        throw new SQLFeatureNotSupportedException("releaseSavepoint");
    }
    
    @Override
    public void setHoldability(final int holdability) {
    }
    
    @Override
    public int getHoldability() {
        return 0;
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public PreparedStatement prepareStatement(final String sql, final String[] columnNames) {
        return new CircuitBreakerPreparedStatement();
    }
    
    @Override
    public boolean isValid(final int timeout) {
        return true;
    }
    
    @Override
    public Array createArrayOf(final String typeName, final Object[] elements) {
        return null;
    }
    
    @Override
    public void setSchema(final String schema) {
    }
    
    @Override
    public String getSchema() {
        return "";
    }
    
    @Override
    public Statement createStatement() {
        return new CircuitBreakerStatement();
    }
    
    @Override
    public Statement createStatement(final int resultSetType, final int resultSetConcurrency) {
        return new CircuitBreakerStatement();
    }
    
    @Override
    public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) {
        return new CircuitBreakerStatement();
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public boolean isClosed() {
        return false;
    }
}
