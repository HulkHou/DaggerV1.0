package com.ng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * ���ݿ����������
 * 
 * @author hulk
 * 
 */
public class DBUtils {

	// ���ݿ����ӵ�ַ
	public static String URLPASSPORT;
	// ���ݿ����ӵ�ַ
	public static String URLHGAME;	
	// �û���
	public static String USERNAME;
	// ����
	public static String PASSWORD;
	// mysql��������
	public static String DRIVER;

	private static ResourceBundle rb = ResourceBundle
			.getBundle("map.db-config");

	private DBUtils() {
	}

	// ʹ�þ�̬�������������
	static {
		URLPASSPORT = rb.getString("jdbc.url.passport_online");
		URLHGAME = rb.getString("jdbc.url.hgame_online");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ����һ����ȡ���ݿ����ӵķ���
	public static Connection getPassportConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URLPASSPORT, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ����ʧ��");
		}
		return conn;
	}
	
	// ����һ����ȡ���ݿ����ӵķ���
	public static Connection getHgameConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URLHGAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ����ʧ��");
		}
		return conn;
	}	

	/**
	 * �ر����ݿ�����
	 * 
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
