package com.ng.dao;

import java.sql.SQLException;

import com.ng.vo.UserLotteryPoint;


public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TouzhuDaoImpl t = new TouzhuDaoImpl();
		UserLotteryPoint ulp = t.findUserId("JXCT001");
		System.out.println(t.findUserPremium(ulp,"五星复式","重庆时时彩").getPremium());
	}

}
