package com.ng.cases;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.july.Bjkl8;
import com.ng.cases.july.Bjpk10;
import com.ng.cases.july.Fc3d;
import com.ng.cases.july.Gd11x5;
import com.ng.cases.july.Jx11x5;
import com.ng.cases.july.Jxssc;
import com.ng.cases.july.Rbffc;
import com.ng.cases.july.Sd11x5;
import com.ng.cases.july.Tcp3;
import com.ng.cases.july.Xg5fc;
import com.ng.cases.july.Xgffc;
import com.ng.cases.july.Xjssc;
import com.ng.cases.jxc.Cqssc;
import com.ng.cases.jxc.Pl3;
import com.ng.cases.jxc.Rbssc;
import com.ng.util.ImportExcel;
import com.ng.util.ImportLoginUserExcel;
import com.ng.util.UpdateExcel;
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

	private String platform = "";

	private String touZhuMapUrl = "";

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

				platform = loginUserList.get(i).getPlatform();

			}
		}
	}

	@Test
	public void play() throws Exception {

		// ��ȡͶע��Ϣ
		ImportExcel importExcel = new ImportExcel();
		ArrayList<Touzhu> touzhuList = importExcel.getTouzhu(filePath);

		if (platform.equals("july")) {
			touZhuMapUrl = "map/Touzhu_map_july.xml";
		} else if (platform.equals("jxc")) {
			touZhuMapUrl = "map/Touzhu_map_jxc.xml";
		}

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
					sellAmount = cqssc.cqssc(be, touZhu, touZhuMapUrl);
				} else if ("�ձ�ʱʱ��".equals(caiZhong)) {
					Rbssc rbssc = new Rbssc();
					sellAmount = rbssc.rbssc(be, touZhu, touZhuMapUrl);
				} else if ("�ձ��ֲַ�".equals(caiZhong)) {
					Rbffc rbssc = new Rbffc();
					sellAmount = rbssc.rbssc(be, touZhu, touZhuMapUrl);
				} else if ("�����ֲַ�".equals(caiZhong)) {
					Xgffc xgffc = new Xgffc();
					sellAmount = xgffc.xgffc(be, touZhu, touZhuMapUrl);
				} else if ("����5�ֲ�".equals(caiZhong)) {
					Xg5fc xg5fc = new Xg5fc();
					sellAmount = xg5fc.xg5fc(be, touZhu, touZhuMapUrl);
				} else if ("����ʱʱ��".equals(caiZhong)) {
					Jxssc jxssc = new Jxssc();
					sellAmount = jxssc.jxssc(be, touZhu, touZhuMapUrl);
				} else if ("�½�ʱʱ��".equals(caiZhong)) {
					Xjssc xjssc = new Xjssc();
					sellAmount = xjssc.xjssc(be, touZhu, touZhuMapUrl);
				} else if ("��������8".equals(caiZhong)) {
					Bjkl8 bjkl8 = new Bjkl8();
					sellAmount = bjkl8.bjkl8(be, touZhu, touZhuMapUrl);
				} else if ("����PK10".equals(caiZhong)) {
					Bjpk10 bjpk10 = new Bjpk10();
					sellAmount = bjpk10.bjpk10(be, touZhu, touZhuMapUrl);
				} else if ("�㶫11ѡ5".equals(caiZhong)) {
					Gd11x5 gd11x5 = new Gd11x5();
					sellAmount = gd11x5.gd11x5(be, touZhu, touZhuMapUrl);
				} else if ("ɽ��11ѡ5".equals(caiZhong)) {
					Sd11x5 sd11x5 = new Sd11x5();
					sellAmount = sd11x5.sd11x5(be, touZhu, touZhuMapUrl);
				} else if ("����11ѡ5".equals(caiZhong)) {
					Jx11x5 jx11x5 = new Jx11x5();
					sellAmount = jx11x5.jx11x5(be, touZhu, touZhuMapUrl);
				} else if ("����3D".equals(caiZhong)) {
					Fc3d fc3d = new Fc3d();
					sellAmount = fc3d.fc3d(be, touZhu, touZhuMapUrl);
				} else if ("���P3".equals(caiZhong)) {
					Tcp3 tcp3 = new Tcp3();
					sellAmount = tcp3.tcp3(be, touZhu, touZhuMapUrl);
				} else if ("������".equals(caiZhong)) {
					Pl3 pl3 = new Pl3();
					sellAmount = pl3.pl3(be, touZhu, touZhuMapUrl);
				}
				UpdateExcel.updateExcel(filePath, 0, 28, i + 1,
						sellAmount.toString());
				UpdateExcel.updateExcel(filePath, 0, 0, i + 1, "N");
			}
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
