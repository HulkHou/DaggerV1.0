package com.ng.cases.july;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Tcp3 {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_tcp3";
	
	private String caiZhongQuick = "cz_tcp3_quick";
	
	private String lotteryId = "12";
	
	public Double tcp3(BrowserEmulator be, Touzhu touZhu, String touZhuMapUrl) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu, touZhuMapUrl);
		
		Thread.sleep(2000);

		// ��ȡ���ڲ�Ʊ����ʱ��
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be, lotteryId);

		ChooseNumbers cn = new ChooseNumbers();
		
		// �����淨ѡ��
		if ("����ֱѡ��ʽ�����¼�룩".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("����ֱѡ��ʽ������¼�룩".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("����ֱѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��������ѡ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("������ѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ֱѡ��ʽ".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ֱѡ��ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("����ǰ��ֱѡ��ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("��������ѡ��ʽ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��������ѡ��ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����ǰ����ѡ��ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("��λ����λ��".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("������һ�벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("���������벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		}

		// ȷ��ע�����ύע��
		return Commit.commit(be, touZhu);
	}
}
