package com.ng.dao;

import java.sql.SQLException;
import java.util.List;

import com.ng.vo.Touzhu;


public interface TouzhuDao {

	// ��ӷ���
	public void add(Touzhu touZhu) throws SQLException;

	// ���·���
	public void update(Touzhu touZhu) throws SQLException;

	// ɾ������
	public void delete(int id) throws SQLException;

	// ���ҷ���
	public Touzhu findById(int id) throws SQLException;

	// ��������
	public List<Touzhu> findAll() throws SQLException;

}
