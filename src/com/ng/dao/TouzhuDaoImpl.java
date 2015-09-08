package com.ng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ng.util.StringUtil;
import com.ng.vo.Touzhu;
import com.ng.vo.UserLotteryPoint;


/**
 * PersonDao的具体实现类
 * @author hulk
 *
 */

public class TouzhuDaoImpl implements TouzhuDao {

	private static ResourceBundle rb = ResourceBundle
			.getBundle("map.MethodPremiumMode");

	/**
	 * 查询用户奖金返点
	 */
	public UserLotteryPoint findUserLotteryPoint(UserLotteryPoint ulp, String caiZhong)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT userpoint, methodid, prizegroupid FROM usermethodset WHERE userid = ? AND methodid = (SELECT lotteryid FROM lottery WHERE cnname = ?);";
		try {
			conn = DBUtils.getHgameConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ulp.getUserId());
			ps.setString(2, caiZhong);
			rs = ps.executeQuery();
			while (rs.next()) {
				ulp.setUserPoint(rs.getString(1));
				ulp.setLotteryId(rs.getString(2));
				ulp.setPrizeGroupId(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询用户奖金返点失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return ulp;
	}
	
	/**
	 * 查询用户奖金及基准奖金
	 */
	public UserLotteryPoint findUserPremium(UserLotteryPoint ulp, String type, String caiZhong)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TouzhuDaoImpl t = new TouzhuDaoImpl();
		String userPoint = null;
		String sql = "SELECT nfdprize FROM nofdprize WHERE pid = ?;";
		try {
			t.findUserLotteryPoint(ulp, caiZhong);
			userPoint = ulp.getUserPoint();
			System.out.println(userPoint);
			conn = DBUtils.getHgameConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rb.getString(type));
			rs = ps.executeQuery();
			while (rs.next()) {
				ulp.setPremium(StringUtil.getPremiumString1(rs.getString(1), userPoint));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询用户奖金及基准奖金失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return ulp;
	}

	/**
	 * 根据userName查询userId
	 */
	public UserLotteryPoint findUserId(String userName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserLotteryPoint ulp = null;
		String sql = "SELECT userid FROM users WHERE username = ?;";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				ulp = new UserLotteryPoint();
				ulp.setUserName(userName);
				ulp.setUserId(rs.getString(1));
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("根据userName查询userId数据失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return ulp;
	}

	/**
	 * 实现添加方法
	 */
	public void add(Touzhu touzhu) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into person(name,age,description)values(?,?,?)";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 更新方法
	 */
	public void update(Touzhu p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update person set name=?,age=?,description=? where id=?";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 删除方法
	 */
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from person where id=?";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(" 删除数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 根据ID查询一个对象
	 */
	public Touzhu findById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Touzhu p = null;
		String sql = "select name,age,description from person where id=?";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				p = new Touzhu();

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("根据ID查询数据失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	/**
	 * 查询所有数据
	 */
	public List<Touzhu> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Touzhu> persons = new ArrayList<Touzhu>();
		String sql = "select * from bankinfo";
		try {
			conn = DBUtils.getPassportConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return persons;
	}

}