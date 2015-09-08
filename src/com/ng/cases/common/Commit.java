package com.ng.cases.common;

import java.io.IOException;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.StringUtil;
import com.ng.vo.Touzhu;

public class Commit {

	public static Double commit(BrowserEmulator be, Touzhu touZhu)
			throws InterruptedException, IOException {

		String premiumMode = "";

		String trace = "";

		Double sellAmount = 0.0000;

		Double sellNum = 1.0000;

		String sellMode = "";

		Double sellUnit = 1.0000;

		Double sellTime = 1.0000;

		Double sellPremiumMode = 1.0000;

		String stopTrace = "";

		String profitTrace = "";

		String sameTrace = "";

		String doubleTrace = "";

		String screenName = "";

		// Ͷעģʽmode
		be.click("//label[contains(.,'Ԫ')]");

		be.click("//label[contains(.,'" + touZhu.getMode() + "')]");

		// Ͷע����time
		be.type("//*[@id='lt_sel_times']", touZhu.getTime());

		// ����ģʽ
		premiumMode = StringUtil.getSubString(touZhu.getPremiumMode(), "-");

		if (!"".equals(premiumMode)) {

			if (be.isElementPresent("//label[contains(.,'" + premiumMode
					+ "')]", 500)) {
				// ������������Σ�����ѡ��
				be.click("//label[contains(.,'" + premiumMode + "')]");
				be.click("//label[contains(.,'" + premiumMode + "')]");
			}
		}

		// Thread.sleep(2000);

		/**
		 * ����ӦͶע���
		 */

		// Ͷעע��
		sellNum = StringUtil.parseDouble(be.getText("//*[@id='lt_sel_nums']"));

		// Ͷע��λ
		sellMode = touZhu.getMode();

		if ("��".equals(sellMode)) {
			sellUnit = 0.1000;
		} else if ("��".equals(sellMode)) {
			sellUnit = 0.0100;
		} else if ("��".equals(sellMode)) {
			sellUnit = 0.0010;
		}

		// Ͷע����
		sellTime = StringUtil.parseDouble(touZhu.getTime());

		// Ͷע����ֵ
		sellPremiumMode = 0.000;

		if (be.isElementPresent("//label[contains(.,'" + premiumMode + "')]",
				500)) {
			int tempStringSize = be.getText(
					"//label[contains(text(),'" + premiumMode + "')]").indexOf(
					"-") + 1;

			String tempString = StringUtil.substring(
					(be.getText("//label[contains(text(),'" + premiumMode
							+ "')]")), tempStringSize);

			sellPremiumMode = StringUtil.parseDouble(StringUtil.getSubString(
					tempString, "%"));
		}

		if (sellPremiumMode > 0) {
			sellAmount = (1 - sellPremiumMode * 0.01) * sellNum * sellUnit
					* sellTime * 2;
		} else {
			sellAmount = sellNum * sellUnit * sellTime * 2;
		}

		// Ͷע���

		// ȷ��ѡ��
		be.click("//*[@id='lt_sel_insert']");

		// ����׷��

		// ��շ���׷��
		// if (be.isElementPresent("//*[@id='lt_trace_if_button']", 30000)) {
		// be.click("//*[@id='lt_trace_if_button']");
		// }

		// �Ƿ���׷��
		trace = touZhu.getTrace();
		if ("Y".equals(trace)) {
			be.click("//*[@id='lt_trace_if_button']");

			// �н����Ƿ�ֹͣ׷��
			stopTrace = touZhu.getStopTrace();
			if ("N".equals(stopTrace)) {
				be.click("//*[@id='lt_trace_stop']");
			}

			// ������׷��
			profitTrace = touZhu.getProfitTrace();
			if ("Y".equals(profitTrace)) {
				be.click("//*[@id='button111']");
				be.type("//*[@id='lt_trace_times_margin']",
						touZhu.getProfitTime());
				be.type("//*[@id='lt_trace_margin']", touZhu.getProfitYields());
				be.type("//*[@id='lt_trace_count_input']",
						touZhu.getProfitNumber());
				be.click("//*[@id='lt_trace_ok']");
				be.click("//*[@id='confirm_yes']");
			}

			// ͬ��׷��
			sameTrace = touZhu.getSameTrace();
			if ("Y".equals(sameTrace)) {
				be.click("//*[@id='button12']");
				be.type("//*[@id='lt_trace_times_same']", touZhu.getSameTime());
				be.type("//*[@id='lt_trace_count_input']",
						touZhu.getSameNumber());
				be.click("//*[@id='lt_trace_ok']");
				be.click("//*[@id='confirm_yes']");
			}

			// ����׷��
			doubleTrace = touZhu.getDoubleTrace();
			if ("Y".equals(doubleTrace)) {
				be.click("//*[@id='button13']");
				be.type("//*[@id='lt_trace_diff']", touZhu.getDoublePeriod());
				be.type("//*[@id='lt_trace_times_diff']",
						touZhu.getDoubleTime());
				be.type("//*[@id='lt_trace_count_input']",
						touZhu.getDoubleNumber());
				be.click("//*[@id='lt_trace_ok']");
				be.click("//*[@id='confirm_yes']");
			}
		}

		// �ύע��
		be.click("//*[@id='lt_sendok']");

		// �ύע���_��
		be.click("//*[@id='confirm_yes']");

		// Ͷע�ɹ���ͼ
		// Thread.sleep(3000);
		screenName = touZhu.getCaseNo() + "-" + touZhu.getCaiZhong()
				+ touZhu.getFathertype() + touZhu.getType() + "���Խ��";

		CaptureScreen.captureScreen(be, screenName);

		// ȷ�Ϲ���ɹ�
		be.expectTextExistOrNot(true, "����ɹ�", 5000);
		be.click("//*[@id='alert_close_button']");
		return sellAmount;
	}
}
