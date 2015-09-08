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

		// 投注模式mode
		be.click("//label[contains(.,'元')]");

		be.click("//label[contains(.,'" + touZhu.getMode() + "')]");

		// 投注倍数time
		be.type("//*[@id='lt_sel_times']", touZhu.getTime());

		// 奖金模式
		premiumMode = StringUtil.getSubString(touZhu.getPremiumMode(), "-");

		if (!"".equals(premiumMode)) {

			if (be.isElementPresent("//label[contains(.,'" + premiumMode
					+ "')]", 500)) {
				// 这里必须点击两次，才能选中
				be.click("//label[contains(.,'" + premiumMode + "')]");
				be.click("//label[contains(.,'" + premiumMode + "')]");
			}
		}

		// Thread.sleep(2000);

		/**
		 * 计算应投注金额
		 */

		// 投注注数
		sellNum = StringUtil.parseDouble(be.getText("//*[@id='lt_sel_nums']"));

		// 投注单位
		sellMode = touZhu.getMode();

		if ("角".equals(sellMode)) {
			sellUnit = 0.1000;
		} else if ("分".equals(sellMode)) {
			sellUnit = 0.0100;
		} else if ("厘".equals(sellMode)) {
			sellUnit = 0.0010;
		}

		// 投注倍数
		sellTime = StringUtil.parseDouble(touZhu.getTime());

		// 投注返点值
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

		// 投注金额

		// 确认选号
		be.click("//*[@id='lt_sel_insert']");

		// 发起追号

		// 清空发起追号
		// if (be.isElementPresent("//*[@id='lt_trace_if_button']", 30000)) {
		// be.click("//*[@id='lt_trace_if_button']");
		// }

		// 是否发起追号
		trace = touZhu.getTrace();
		if ("Y".equals(trace)) {
			be.click("//*[@id='lt_trace_if_button']");

			// 中奖后是否停止追号
			stopTrace = touZhu.getStopTrace();
			if ("N".equals(stopTrace)) {
				be.click("//*[@id='lt_trace_stop']");
			}

			// 利润率追号
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

			// 同倍追号
			sameTrace = touZhu.getSameTrace();
			if ("Y".equals(sameTrace)) {
				be.click("//*[@id='button12']");
				be.type("//*[@id='lt_trace_times_same']", touZhu.getSameTime());
				be.type("//*[@id='lt_trace_count_input']",
						touZhu.getSameNumber());
				be.click("//*[@id='lt_trace_ok']");
				be.click("//*[@id='confirm_yes']");
			}

			// 翻倍追号
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

		// 提交注单
		be.click("//*[@id='lt_sendok']");

		// 提交注单確定
		be.click("//*[@id='confirm_yes']");

		// 投注成功截图
		// Thread.sleep(3000);
		screenName = touZhu.getCaseNo() + "-" + touZhu.getCaiZhong()
				+ touZhu.getFathertype() + touZhu.getType() + "测试结果";

		CaptureScreen.captureScreen(be, screenName);

		// 确认购买成功
		be.expectTextExistOrNot(true, "购买成功", 5000);
		be.click("//*[@id='alert_close_button']");
		return sellAmount;
	}
}
