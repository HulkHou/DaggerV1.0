package com.ng.cases.common;

import org.apache.log4j.Logger;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.StringUtil;
import com.ng.vo.Touzhu;

public class ChooseType {

	private static Logger logger = Logger.getLogger(ChooseType.class.getName());

	public static String chooseType(BrowserEmulator be, String caiZhong,
			String caiZhongQuick, Touzhu touZhu, String touZhuMapUrl)
			throws InterruptedException {

		String playStyle = "";

		// fatherType+type
		String playType = "";

		// 父玩法
		String fathertype = "";

		// 子玩法
		String type = "";

		// 投注前客户账总金额
		String totalAmount = "";

		// JUly系统特色，此操作用来回到页面顶部，避免选择彩种浮窗无法选择问题
		if (be.isElementPresent("//a[@class='logo']", 500)) {
			be.click("//a[@class='logo']");
		}

		// 选择彩种
		if (be.isElementPresent(caiZhongQuick, touZhuMapUrl, 500)) {
			be.clickElement(caiZhongQuick, touZhuMapUrl);
		} else {
			be.clickElement("caizhong", touZhuMapUrl);
			be.clickElement(caiZhong, touZhuMapUrl);
		}

		fathertype = touZhu.getFathertype();

		type = touZhu.getType();

		playType = fathertype + type;

		// 获取投注前总金额
		be.click("//a[@id='newrefreshmoney']");
		totalAmount = be.getText("//span[@id='refff']");

		logger.info("客户账总额" + totalAmount);

		// 选择玩法类型

		playStyle = touZhu.getPlayStyle();

		if ("任选玩法".equals(playStyle)) {
			be.click("//*[@id='changeLotteryType']/a");
		}

		// 选择父玩法fathertype
		be.click("//span[contains(.,'" + fathertype + "')]");

		// 选择子玩法type
		if ("二码".equals(fathertype)) {
			if (StringUtil.substring(type, 0, 4).equals("二星直选")) {
				be.click("//label[contains(.,'" + StringUtil.substring(type, 4)
						+ "')][1]");
			} else if ("二星组选后二(复式)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_0')]");
			} else if ("二星组选后二(单式)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_1')]");
			} else if ("二星组选前二(复式)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_2')]");
			} else if ("二星组选前二(单式)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_3')]");
			} else if ("二星组选后二和值".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_4')]");
			} else if ("二星组选前二和值".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_5')]");
			} else {
				be.click("//label[contains(.,'" + type + "')]");
			}
		} else {
			be.click("//label[contains(.,'" + type + "')]");

		}

		return playType;
	}
}
