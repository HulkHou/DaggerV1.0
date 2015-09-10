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

		// ��ȡ���ڲ�Ʊ����ʱ��
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// �����淨ѡ��
		if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��λ����λ��".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("������ǰ��λ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("Ȥζ�Ͷ���˫".equals(playType)) {
			cn.dds(be, touZhu);
		} else if ("Ȥζ�Ͳ���λ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽһ��һ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ���ж�".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ʽһ��һ".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ���ж�".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		} else if ("��ѡ��ʽ������".equals(playType)) {
			cn.ds11(be, touZhu);
		}

		// ȷ��ע�����ύע��
		return Commit.commit(be, touZhu);
	}
}
