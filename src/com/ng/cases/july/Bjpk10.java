package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Bjpk10 {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_bjpk10";

	private String caiZhongQuick = "cz_bjpk10_quick";

	private String touZhuMapUrl = "map/Touzhu_map_july.xml";

	private String lotteryId = "14";

	public Double bjpk10(BrowserEmulator be, Touzhu touZhu) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu,
				touZhuMapUrl);

		Thread.sleep(2000);

		// 获取本期彩票销售时间
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// 具体玩法选号
		if ("猜冠军猜冠军".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("猜前二猜前二".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("猜前三猜前三".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("猜前四猜前四".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("猜前五猜前五".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		}

		// 确认注单，提交注单
		return Commit.commit(be, touZhu);
	}
}
