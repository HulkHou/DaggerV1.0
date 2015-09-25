package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Jxssc {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_jxssc";
	
	private String caiZhongQuick = "cz_jxssc_quick";
	
	private String lotteryId = "3";
	
	public Double jxssc(BrowserEmulator be, Touzhu touZhu, String touZhuMapUrl) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu, touZhuMapUrl);
		
		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();
		
		// 具体玩法选号
		if ("后三码直选复式（鼠标录入）".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("后三码直选单式（键盘录入）".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("后三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("后三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("后三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码直选复式（鼠标录入）".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("前三码直选单式（键盘录入）".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("前三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("前三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("前三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二直选".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码前二直选".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码后二组选".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二组选".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("定位胆定位胆".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("不定胆一码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("不定胆二码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("大小单双后二大小单双".equals(playType)) {
			cn.dxds(be, touZhu);
		} else if ("大小单双前二大小单双".equals(playType)) {
			cn.dxds(be, touZhu);
		} 

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
