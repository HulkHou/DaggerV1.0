package com.ng.cases.jxc;

import com.netease.dagger.BrowserEmulator;
import com.ng.cases.common.ChooseNumbers;
import com.ng.cases.common.ChooseType;
import com.ng.cases.common.Commit;
import com.ng.cases.common.GameTimer;
import com.ng.vo.Touzhu;

public class Cqssc {

	// fatherType+type
	private String playType = "";

	private String caiZhong = "cz_cqssc";
	
	private String caiZhongQuick = "";

	private String touZhuMapUrl = "map/Touzhu_map_jxc.xml";

	public Double cqssc(BrowserEmulator be, Touzhu touZhu) throws Exception {

		playType = ChooseType.chooseType(be, caiZhong, caiZhongQuick, touZhu, touZhuMapUrl);

		// ��ȡ���ڲ�Ʊ����ʱ��
		GameTimer gt = new GameTimer();
		gt.GetGameTimer(be);

		ChooseNumbers cn = new ChooseNumbers();

		// �����淨ѡ��
		if ("���Ǹ�ʽ".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("���ǵ�ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("�������".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("������ѡ120".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ѡ60".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ѡ30".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ѡ20".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ѡ10".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ѡ5".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("���Ǹ�ʽ".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("���ǵ�ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("�������".equals(playType)) {
			cn.fourGroups(be, touZhu);
		} else if ("������ѡ24".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ѡ12".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("������ѡ6".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ѡ4".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("�����븴ʽ".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("�����뵥ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("������ֱѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����������ѡ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("��������ѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("ǰ���븴ʽ".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("ǰ���뵥ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("ǰ����ֱѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("ǰ��������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("ǰ��������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("ǰ��������ѡ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("ǰ������ѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("�����븴ʽ".equals(playType)) {
			cn.threeGroups(be, touZhu);
		} else if ("�����뵥ʽ".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("������ֱѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("����������".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��������".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("��������ѡ��ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("�������ֱѡ���(��ʽ)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("�������ֱѡ���(��ʽ)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("�������ֱѡǰ��(��ʽ)".equals(playType)) {
			cn.twoGroups(be, touZhu);
		} else if ("�������ֱѡǰ��(��ʽ)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("�������ֱѡ�����ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("�������ֱѡǰ����ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("���������ѡ���(��ʽ)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("���������ѡ���(��ʽ)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("���������ѡǰ��(��ʽ)".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("���������ѡǰ��(��ʽ)".equals(playType)) {
			cn.ds(be, touZhu);
		} else if ("���������ѡ�����ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("���������ѡǰ����ֵ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��λ����λ��".equals(playType)) {
			cn.fiveGroups(be, touZhu);
		} else if ("����������һ�벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("�������������벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ǰ��һ�벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("������ǰ�����벻����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("��С��˫�����С��˫".equals(playType)) {
			cn.dxds(be, touZhu);
		} else if ("��С��˫ǰ����С��˫".equals(playType)) {
			cn.dxds(be, touZhu);
		} else if ("Ȥζһ����˳".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("Ȥζ���³�˫".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("Ȥζ���Ǳ�ϲ".equals(playType)) {
			cn.oneGroup(be, touZhu);
		} else if ("Ȥζ�ļ�����".equals(playType)) {
			cn.oneGroup(be, touZhu);
		}

		// ȷ��ע�����ύע��
		return Commit.commit(be, touZhu);
	}
}
