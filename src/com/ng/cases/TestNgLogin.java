package com.ng.cases;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.ImportExcel;
import com.ng.util.ImportLoginUserExcel;
import com.ng.vo.LoginUser;
import com.ng.vo.Touzhu;

public class TestNgLogin {

	private String loginUserfilePath = "data/LoginUser_data.xls";

	private String loginMapUrl = "map/Login_map.xml";

	private String filePath = "data/Touzhu_data.xls";

	private BrowserEmulator be;

	private StringBuffer verificationErrors = new StringBuffer();

	private ArrayList<LoginUser> loginUserList;

	private String caiZhong = "";

	private String caseFlag = "";

	private Touzhu touZhu;

	@BeforeTest
	public void beforeTest() {
		// ��ȡ��¼�û���Ϣ
		ImportLoginUserExcel importLoginUserExcel = new ImportLoginUserExcel();
		loginUserList = importLoginUserExcel.getLoginUser(loginUserfilePath);

		// ��½ϵͳ
		be = new BrowserEmulator();

		for (int i = 0; i < loginUserList.size(); i++) {

			if (loginUserList.get(i).getCaseFlag().equals("Y")) {

				be.open(loginUserList.get(i).getBaseUrl());

				be.typeElement("userName", loginMapUrl, loginUserList.get(i)
						.getUserName());

				be.typeElement("password", loginMapUrl, loginUserList.get(i)
						.getPassword());

				be.clickElement("submit", loginMapUrl);

			}
		}
	}

	@Test
	public void play() throws Exception {

		// ��ȡͶע��Ϣ
		ImportExcel importExcel = new ImportExcel();
		ArrayList<Touzhu> touzhuList = importExcel.getTouzhu(filePath);

		for (int i = 0; i < touzhuList.size(); i++) {

			// ����Excel���԰���ÿһ������ѡ������淨
			// �����淨
			touZhu = touzhuList.get(i);
			caiZhong = touZhu.getCaiZhong();
			Double sellAmount = 0.0000;

			caseFlag = touZhu.getCaseFlag();

		}
	}

	@AfterTest
	public void afterTest() {
		be.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
