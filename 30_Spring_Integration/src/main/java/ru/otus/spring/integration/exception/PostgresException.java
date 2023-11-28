package ru.otus.spring.integration.exception;

import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;

public class PostgresException extends BadSqlGrammarException {
    public PostgresException(String task, String sql, SQLException ex) {
        super(task, sql, ex);
    }
}
