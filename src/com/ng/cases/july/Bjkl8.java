package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Bjkl8 {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_bjkl8";

	private String caiZhongQuick = "cz_bjkl8_quick";

	private String lotteryId = "9";

	public Double bjkl8(BrowserEmulator be, Touzhu touZhu, String touZhuMapUrl) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu,
				touZhuMapUrl);

		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// 具体玩法选号
		if ("任选任选一".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选二".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选四".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选五".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选任选七".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("趣味上下盘".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("趣味奇偶盘".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("趣味和值单双".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("趣味和值大小".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("趣味和值大小单双".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("和值和值单双".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("和值和值大小".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("和值和值大小单双".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("盘面上下盘".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("盘面奇偶盘".equals(playType)) {
			cn.szx(be, touZhu);
		}

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
