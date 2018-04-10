package com.tr.mybatis.executor.handler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface StatementHandler {
	Statement prepare(Connection connection) throws SQLException;
	<E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
}
