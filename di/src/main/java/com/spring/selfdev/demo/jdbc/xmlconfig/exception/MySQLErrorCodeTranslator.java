package com.spring.selfdev.demo.jdbc.xmlconfig.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.lang.Nullable;

import java.sql.SQLException;

public class MySQLErrorCodeTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Nullable
    @Override
    protected DataAccessException customTranslate(String task, @Nullable String sql, SQLException sqlEx) {
        if (sqlEx.getErrorCode() == -12345) {
            return new DeadlockLoserDataAccessException(task, sqlEx);
        }

        return null;
    }
}
