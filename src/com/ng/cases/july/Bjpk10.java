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

		// ��ȡ���ڲ�Ʊ����ʱ��
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// �����淨ѡ��
		if ("�¹ھ��¹ھ�".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ǰ����ǰ��".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("��ǰ����ǰ��".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("��ǰ�Ĳ�ǰ��".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("��ǰ���ǰ��".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		}

		// ȷ��ע�����ύע��
		return Commit.commit(be, touZhu);
	}
}
