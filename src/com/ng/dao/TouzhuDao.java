package com.ng.dao;

import java.sql.SQLException;
import java.util.List;

import com.ng.vo.Touzhu;


public interface TouzhuDao {

	// 添加方法
	public void add(Touzhu touZhu) throws SQLException;

	// 更新方法
	public void update(Touzhu touZhu) throws SQLException;

	// 删除方法
	public void delete(int id) throws SQLException;

	// 查找方法
	public Touzhu findById(int id) throws SQLException;

	// 查找所有
	public List<Touzhu> findAll() throws SQLException;

}
