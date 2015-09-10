package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Sd11x5 {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_sd11x5";

	private String caiZhongQuick = "cz_sd11x5_quick";

	private String touZhuMapUrl = "map/Touzhu_map_july.xml";

	private String lotteryId = "5";

	public Double sd11x5(BrowserEmulator be, Touzhu touZhu) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu,
				touZhuMapUrl);

		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// 具体玩法选号
		if ("三码前三直选复式".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("三码前三直选单式".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("三码前三组选复式".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("三码前三组选单式".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("二码前二直选复式".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码前二直选单式".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("二码前二组选复式".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二组选单式".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("定位胆定位胆".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("不定胆前三位".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("趣味型定单双".equals(playType)) {
			cn.dds(be, touZhu);
		} else if ("趣味型猜中位".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式一中一".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式二中二".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式三中三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式四中四".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式五中五".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式六中五".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式七中五".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选复式八中五".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("任选单式一中一".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式二中二".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式三中三".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式四中四".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式五中五".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式六中五".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式七中五".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("任选单式八中五".equals(playType)) {
			cn.ds11(be, touZhu);
		}

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
