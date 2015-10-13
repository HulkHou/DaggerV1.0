package com.ng.cases.common;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.StringUtil;
import com.ng.vo.Touzhu;

public class ChooseNumbers {

	private Integer[] myriabit = null;

	private Integer[] kilobit = null;

	private Integer[] hundreds = null;

	private Integer[] tens = null;

	private Integer[] unit = null;

	private Integer[] single = null;

	private String[] first = null;

	private String[] second = null;

	private String[] third = null;

	public void oneGroup(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��λmyriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}
	}

	public void twoGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��λmyriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// ǧλkilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}
	}

	public void threeGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��λmyriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// ǧλkilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// ��λhundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}
	}

	public void fourGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��λmyriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// ǧλkilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// ��λhundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}

		// ʮλtens
		tens = StringUtil.getIntArrayFromStr(touZhu.getTens(), ",");

		for (int i = 0; i < tens.length; i++) {
			String m = String.valueOf(tens[i] + 1);
			be.click("//li[@name='lt_place_3'][" + m + "]");
		}
	}

	public void fiveGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��λmyriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// ǧλkilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// ��λhundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}

		// ʮλtens
		tens = StringUtil.getIntArrayFromStr(touZhu.getTens(), ",");

		for (int i = 0; i < tens.length; i++) {
			String m = String.valueOf(tens[i] + 1);
			be.click("//li[@name='lt_place_3'][" + m + "]");
		}

		// ��λunit
		unit = StringUtil.getIntArrayFromStr(touZhu.getUnit(), ",");

		for (int i = 0; i < unit.length; i++) {
			String m = String.valueOf(unit[i] + 1);
			be.click("//li[@name='lt_place_4'][" + m + "]");
		}
	}

	/**
	 * ��ʽ
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void ds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��ʽ����single
		single = StringUtil.getIntArrayFromStr(touZhu.getSingle(), ",");
		String m = "";

		for (int i = 0; i < single.length; i++) {
			m = m + String.valueOf(single[i]);
		}
		be.type("//*[@id='lt_write_box']", m);
	}

	/**
	 * 11ѡ5��ʽ
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void ds11(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��ʽ����single
		single = StringUtil.getIntArrayFromStr(touZhu.getSingle(), ",");
		String m = "";

		for (int i = 0; i < single.length; i++) {
			if ("10".equals(String.valueOf(single[i])) || "11".equals(String.valueOf(single[i]))) {
				m = m + String.valueOf(single[i]) + " ";
			} else {
				m = m + "0" + String.valueOf(single[i]) + " ";
			}

		}
		be.type("//*[@id='lt_write_box']", m);
	}

	/**
	 * ��С��˫
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void dxds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��һλfirst
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("��".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("С".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("��".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			}
		}

		// �ڶ�λsecond
		second = StringUtil.getStrFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < second.length; i++) {
			String m = String.valueOf(second[i]);
			if ("��".equals(m)) {
				be.click("//li[@name='lt_place_1'][1]");
			} else if ("С".equals(m)) {
				be.click("//li[@name='lt_place_1'][2]");
			} else if ("��".equals(m)) {
				be.click("//li[@name='lt_place_1'][3]");
			} else if ("˫".equals(m)) {
				be.click("//li[@name='lt_place_1'][4]");
			}
		}

	}

	/**
	 * ������-��ż��-С�ʹ�
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void szx(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��һλfirst
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("��".equals(m) || "��".equals(m) || "С".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[1]");
			} else if ("��".equals(m) || "��".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[2]");
			} else if ("��".equals(m) || "ż".equals(m) || "��".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[3]");
			}
		}
	}

	/**
	 * ��ֵ��˫
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void hzds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��һλfirst
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("��".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("��".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("��˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("С��".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("С˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			}
		}
	}

	/**
	 * ʮһѡ��-Ȥζ��-����˫
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void dds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// ѡ��
		// ��һλfirst
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("5��0˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("4��1˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("3��2˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("2��3˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			} else if ("1��4˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][5]");
			} else if ("0��5˫".equals(m)) {
				be.click("//li[@name='lt_place_0'][6]");
			}
		}
	}
	
	/**
	 * ��ѡ��
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void rx2(BrowserEmulator be, Touzhu touZhu) throws Exception {

		be.click("//*[@id='poschoose_2']/label[2]/input");
		be.click("//*[@id='poschoose_2']/label[3]/input");
	}
	
	/**
	 * ��ѡ��
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void rx3(BrowserEmulator be, Touzhu touZhu) throws Exception {

		be.click("//*[@id='poschoose_2']/label[2]/input");
		be.click("//*[@id='poschoose_2']/label[3]/input");
		be.click("//*[@id='poschoose_2']/label[4]/input");
	}

}
