package com.java.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DbUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String dbUsername = "root";// �û���
	private static String dbPassword = "orcl";// ����

	// ��ȡ���ݿ����Ӷ���
	public static Connection getConnection() {
		Connection c = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");// ����MySQL��jdbc����
				c = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	// �ͷ���Դ
	public static void close(Connection c, Statement stat, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
