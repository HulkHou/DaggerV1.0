package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Fc3d {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_fc3d";
	
	private String caiZhongQuick = "cz_fc3d_quick";
	
	private String touZhuMapUrl = "map/Touzhu_map_july.xml";
	
	private String lotteryId = "11";
	
	public Double fc3d(BrowserEmulator be, Touzhu touZhu) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu, touZhuMapUrl);
		
		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();
		
		// 具体玩法选号
		if ("三码直选复式（鼠标录入）".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("三码直选单式（键盘录入）".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("三码直选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("三码组三".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("三码组六".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("三码混合组选".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("三码组选和值".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二直选复式".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码后二直选单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码前二直选复式".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("二码前二直选单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码后二组选复式".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码后二组选单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("二码前二组选复式".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("二码前二组选单式".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("定位胆定位胆".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("不定胆一码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("不定胆二码不定胆".equals(playType)) {
			cn.oneGroup(be, touZhu);
		}

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
