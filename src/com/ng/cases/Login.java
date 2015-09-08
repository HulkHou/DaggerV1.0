package com.ng.cases;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.jxc.Cqssc;
import com.ng.cases.jxc.Rbffc;
import com.ng.cases.july.Xg5fc;
import com.ng.cases.july.Xgffc;
import com.ng.util.ImportExcel;
import com.ng.util.ImportLoginUserExcel;
import com.ng.util.UpdateExcel;
import com.ng.vo.LoginUser;
import com.ng.vo.Touzhu;

public class Login {

	private String loginUserfilePath = "data/LoginUser_data.xls";

	private String loginMapUrl = "map/Login_map.xml";

	private String filePath = "data/Touzhu_data.xls";

	private BrowserEmulator be;

	private StringBuffer verificationErrors = new StringBuffer();

	private ArrayList<LoginUser> loginUserList;

	private String caiZhong = "";

	private String caseFlag = "";

	private Touzhu touZhu;

	@Before
	public void init() throws Exception {

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

			if (caseFlag.equals("Y")) {
				if ("����ʱʱ��".equals(caiZhong)) {
					Cqssc cqssc = new Cqssc();
					sellAmount = cqssc.cqssc(be, touZhu);
					UpdateExcel.updateExcel(filePath, 0, 28, i + 1, sellAmount);
				}
				if ("�ձ��ֲַ�".equals(caiZhong)) {
					Rbffc rbssc = new Rbffc();
					sellAmount = rbssc.rbssc(be, touZhu);
					UpdateExcel.updateExcel(filePath, 0, 28, i + 1, sellAmount);
				}
				if ("�����ֲַ�".equals(caiZhong)) {
					Xgffc xgffc = new Xgffc();
					sellAmount = xgffc.xgffc(be, touZhu);
					UpdateExcel.updateExcel(filePath, 0, 28, i + 1, sellAmount);
				}
				if ("����5�ֲ�".equals(caiZhong)) {
					Xg5fc xg5fc = new Xg5fc();
					sellAmount = xg5fc.xg5fc(be, touZhu);
					UpdateExcel.updateExcel(filePath, 0, 28, i + 1, sellAmount);
				}
			}
		}
	}

	@After
	public void destroy() throws Exception {
		be.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
