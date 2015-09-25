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

		// ��ȡ���ڲ�Ʊ����ʱ��
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();

		// �����淨ѡ��
		if ("��ѡ��ѡһ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��ѡ��ѡ��".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("Ȥζ������".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("Ȥζ��ż��".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("Ȥζ��ֵ��˫".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("Ȥζ��ֵ��С".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("Ȥζ��ֵ��С��˫".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("��ֵ��ֵ��˫".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("��ֵ��ֵ��С".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("��ֵ��ֵ��С��˫".equals(playType)) {
			cn.hzds(be, touZhu);
		} else if ("����������".equals(playType)) {
			cn.szx(be, touZhu);
		} else if ("������ż��".equals(playType)) {
			cn.szx(be, touZhu);
		}

		// ȷ��ע�����ύע��
		return Commit.commit(be, touZhu);
	}
}
