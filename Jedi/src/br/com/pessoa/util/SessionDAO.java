package br.com.pessoa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SessionDAO {
	Connection conexao() throws SQLException, ClassNotFoundException;

	void closeStmConnection(Connection conexao, java.sql.Statement stm) throws SQLException;

	void executeAndClose(Connection conexao, PreparedStatement pstmt) throws SQLException;
}
