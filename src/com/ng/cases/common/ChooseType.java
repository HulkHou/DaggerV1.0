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

		// ���淨
		String fathertype = "";

		// ���淨
		String type = "";

		// Ͷעǰ�ͻ����ܽ��
		String totalAmount = "";

		// JUlyϵͳ��ɫ���˲��������ص�ҳ�涥��������ѡ����ָ����޷�ѡ������
		if (be.isElementPresent("//a[@class='logo']", 500)) {
			be.click("//a[@class='logo']");
		}

		// ѡ�����
		if (be.isElementPresent(caiZhongQuick, touZhuMapUrl, 500)) {
			be.clickElement(caiZhongQuick, touZhuMapUrl);
		} else {
			be.clickElement("caizhong", touZhuMapUrl);
			be.clickElement(caiZhong, touZhuMapUrl);
		}

		fathertype = touZhu.getFathertype();

		type = touZhu.getType();

		playType = fathertype + type;

		// ��ȡͶעǰ�ܽ��
		be.click("//a[@id='newrefreshmoney']");
		totalAmount = be.getText("//span[@id='refff']");

		logger.info("�ͻ����ܶ�" + totalAmount);

		// ѡ���淨����

		playStyle = touZhu.getPlayStyle();

		if ("��ѡ�淨".equals(playStyle)) {
			be.click("//*[@id='changeLotteryType']/a");
		}

		// ѡ���淨fathertype
		be.click("//span[contains(.,'" + fathertype + "')]");

		// ѡ�����淨type
		if ("����".equals(fathertype)) {
			if (StringUtil.substring(type, 0, 4).equals("����ֱѡ")) {
				be.click("//label[contains(.,'" + StringUtil.substring(type, 4)
						+ "')][1]");
			} else if ("������ѡ���(��ʽ)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_0')]");
			} else if ("������ѡ���(��ʽ)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_1')]");
			} else if ("������ѡǰ��(��ʽ)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_2')]");
			} else if ("������ѡǰ��(��ʽ)".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_3')]");
			} else if ("������ѡ�����ֵ".equals(type)) {
				be.click("//label[contains(@for,'smalllabel_1_4')]");
			} else if ("������ѡǰ����ֵ".equals(type)) {
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
