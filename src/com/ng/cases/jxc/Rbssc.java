package com.ng.cases.jxc;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Rbssc {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_rbssc";
	
	private String caiZhongQuick = "cz_rbssc_quick";
	
	private String lotteryId = "15";
	
	public Double rbssc(BrowserEmulator be, Touzhu touZhu, String touZhuMapUrl) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu, touZhuMapUrl);
		
		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// 具体玩法选号
		if ("五星复式".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("五星单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("五星组合".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("五星组选120".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("五星组选60".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("五星组选30".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("五星组选20".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("五星组选10".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("五星组选5".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("四星复式".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("四星单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("四星组合".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("四星组选24".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("四星组选12".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("四星组选6".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("四星组选4".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("后三码复式".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("后三码单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("后三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("后三码混合".equals(playType)) {
			cn.ds(be, touZhu);
		}else if ("后三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码复式".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("前三码单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("前三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("前三码混合".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("前三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("中三码复式".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("中三码单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("中三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("中三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("中三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("中三码混合".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("中三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("中三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星直选后二(复式)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码二星直选后二(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码二星直选前二(复式)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码二星直选前二(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码二星直选后二和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星直选前二和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星组选后二(复式)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星组选后二(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码二星组选前二(复式)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星组选前二(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码二星组选后二和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码二星组选前二和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二直选(复式)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码前二直选(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码前二直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二直选(复式)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码后二直选(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码后二直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二组选(复式)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二组选(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码前二组选(复式)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二组选(单式)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码后二组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("定位胆定位胆".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("不定胆后三一码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("不定胆后三二码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("不定胆前三一码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("不定胆前三二码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("大小单双后二大小单双".equals(playType)) {
			cn.dxds(be, touZhu);
		} else if ("大小单双前二大小单双".equals(playType)) {
			cn.dxds(be, touZhu);
		} else if ("趣味一帆风顺".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("趣味好事成双".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("趣味三星报喜".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("趣味四季发财".equals(playType)) {
			cn.oneGroup(be, touZhu);
		}

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
