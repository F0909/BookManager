package com.java.dao;

import java.sql.ResultSet;

import com.java.bean.BookType;
import com.java.util.StringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BookTypeDao {

	// ͼ��������Dao
	public int add(Connection c, BookType bookType) throws Exception {
		String sql = "insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());// ��ȡ���洫������ͼ���������
		pstmt.setString(2, bookType.getBookTypeDesc());// ��ȡ���洫������ͼ���������
		return pstmt.executeUpdate();
	}

	// ��ѯͼ����𼯺�
	public ResultSet list(Connection c, BookType bookType) throws Exception {
		StringBuffer sBuffer = new StringBuffer("select * from t_booktype");
		if (StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sBuffer.append(" and bookTypeName like '%" + bookType.getBookTypeName() + "%'");
		}
		PreparedStatement pstmt = (PreparedStatement) c
				.prepareStatement(sBuffer.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	// ɾ��ͼ�����
	public int delete(Connection c, String id) throws Exception {
		String sql = "delete from t_booktype where id=?";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	// ����ͼ�����
	public int update(Connection c, BookType bookType) throws Exception {
		String sql = "update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
}
