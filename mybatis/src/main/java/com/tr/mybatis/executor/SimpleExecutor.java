package com.tr.mybatis.executor;

import java.sql.SQLException;
import java.sql.Statement;

import com.tr.mybatis.executor.handler.StatementHandler;
import com.tr.mybatis.session.Configuration;

public class SimpleExecutor extends BaseExecutor{

	public SimpleExecutor(Configuration configuration) {
		super(configuration);
	}
	
	@Override
	public <T> T query(String statment, String paramter) {
		Statement stmt = null;
		try {
			StatementHandler sh = configuration.newStatementHandler(statment, paramter);
			stmt = prepareInitStatement(sh);
			
			return (T) sh.query(stmt, null);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeStatement(stmt);
		}
		
		return null;
	}
	
	private Statement prepareInitStatement(StatementHandler sh) throws SQLException{
		Statement stmt = sh.prepare(getConnection());
		
		return stmt;
	}

}
