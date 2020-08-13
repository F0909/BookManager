package com.java.dao;

import java.sql.ResultSet;

import com.java.bean.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {
	// ��¼��֤
	public User login(Connection c, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where userName=? and passWord=?";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());// ��ȡ���洫�������û���
		pstmt.setString(2, user.getPassWord());// ��ȡ���洫����������
		ResultSet rs = pstmt.executeQuery();// ִ��sql���ؽ��ֵ
		if (rs.next()) {// ����Ƿ�����һ����¼������н���ʵ����
			resultUser = new User();// ʵ����
			resultUser.setId(rs.getInt("id"));// ��������(�������id)
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("passWord"));
		}
		return resultUser;
	}

	// �û�ע��
	public int addUser(Connection c, User user) throws Exception {
		String sql = "insert into t_user values(null,?,?)";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());// ��ȡ���洫�������û���
		pstmt.setString(2, user.getPassWord());// ��ȡ���洫����������
		return pstmt.executeUpdate();// ִ��sql���ؽ��ֵ

	}

	// �޸�����
	public int update(Connection c, User user) throws Exception {
		String sql = "update t_user set username=? , password=? where id=?";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		pstmt.setInt(3, user.getId());
		return pstmt.executeUpdate();// ִ��sql���ؽ��ֵ
	}
}
