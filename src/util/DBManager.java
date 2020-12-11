package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConn() throws SQLException{
		Connection cn;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envCtx.lookup("dbcp/mysql"); // �Ʒ��� �̸� ���� web.xml - <res-ref-name>dbcp/mysql</res-ref-name> /  context.xml <Resource name="dbcp/mysql"  ... 
			cn = ds.getConnection();
		}catch (NamingException e) {
			e.printStackTrace();
			System.out.println("DBCP �������");
			return null;
		}
		return cn;
	}
	public static void main(String[] args) throws SQLException {
		Connection cn = getConn();
	}
}