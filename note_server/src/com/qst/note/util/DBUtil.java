package com.qst.note.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtil {
	static String dbName = "note";// ���ݿ���
	static String name = "root";
	static String pass = "orcl";

	// main��������һ���Ƿ������ӵ����ݿ�
	// public static void main(String[] args) {
	// DBUtil dbUtil = new DBUtil();
	// dbUtil.getConnection();
	// System.out.println("���ӳɹ�");
	// }

	// ��ȡ���ݿ����Ӷ���
	public static Connection getConnection() {
		Connection c = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");// ����MySQL��jdbc����
				c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?ssl=true",
						name, pass);
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
