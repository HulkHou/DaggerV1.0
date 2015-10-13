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

		// 选号
		// 万位myriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}
	}

	public void twoGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 万位myriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// 千位kilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}
	}

	public void threeGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 万位myriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// 千位kilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// 百位hundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}
	}

	public void fourGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 万位myriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// 千位kilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// 百位hundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}

		// 十位tens
		tens = StringUtil.getIntArrayFromStr(touZhu.getTens(), ",");

		for (int i = 0; i < tens.length; i++) {
			String m = String.valueOf(tens[i] + 1);
			be.click("//li[@name='lt_place_3'][" + m + "]");
		}
	}

	public void fiveGroups(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 万位myriabit
		myriabit = StringUtil.getIntArrayFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < myriabit.length; i++) {
			String m = String.valueOf(myriabit[i] + 1);
			be.click("//li[@name='lt_place_0'][" + m + "]");
		}

		// 千位kilobit
		kilobit = StringUtil.getIntArrayFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < kilobit.length; i++) {
			String m = String.valueOf(kilobit[i] + 1);
			be.click("//li[@name='lt_place_1'][" + m + "]");
		}

		// 百位hundreds
		hundreds = StringUtil.getIntArrayFromStr(touZhu.getHundreds(), ",");

		for (int i = 0; i < hundreds.length; i++) {
			String m = String.valueOf(hundreds[i] + 1);
			be.click("//li[@name='lt_place_2'][" + m + "]");
		}

		// 十位tens
		tens = StringUtil.getIntArrayFromStr(touZhu.getTens(), ",");

		for (int i = 0; i < tens.length; i++) {
			String m = String.valueOf(tens[i] + 1);
			be.click("//li[@name='lt_place_3'][" + m + "]");
		}

		// 个位unit
		unit = StringUtil.getIntArrayFromStr(touZhu.getUnit(), ",");

		for (int i = 0; i < unit.length; i++) {
			String m = String.valueOf(unit[i] + 1);
			be.click("//li[@name='lt_place_4'][" + m + "]");
		}
	}

	/**
	 * 单式
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void ds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 单式输入single
		single = StringUtil.getIntArrayFromStr(touZhu.getSingle(), ",");
		String m = "";

		for (int i = 0; i < single.length; i++) {
			m = m + String.valueOf(single[i]);
		}
		be.type("//*[@id='lt_write_box']", m);
	}

	/**
	 * 11选5单式
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void ds11(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 单式输入single
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
	 * 大小单双
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void dxds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 第一位first
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("大".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("小".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("单".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("双".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			}
		}

		// 第二位second
		second = StringUtil.getStrFromStr(touZhu.getKilobit(), ",");

		for (int i = 0; i < second.length; i++) {
			String m = String.valueOf(second[i]);
			if ("大".equals(m)) {
				be.click("//li[@name='lt_place_1'][1]");
			} else if ("小".equals(m)) {
				be.click("//li[@name='lt_place_1'][2]");
			} else if ("单".equals(m)) {
				be.click("//li[@name='lt_place_1'][3]");
			} else if ("双".equals(m)) {
				be.click("//li[@name='lt_place_1'][4]");
			}
		}

	}

	/**
	 * 上中下-奇偶和-小和大
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void szx(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 第一位first
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("上".equals(m) || "奇".equals(m) || "小".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[1]");
			} else if ("中".equals(m) || "和".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[2]");
			} else if ("下".equals(m) || "偶".equals(m) || "大".equals(m)) {
				be.click("//*[@id='right_05']/div/ul[1]/li[3]");
			}
		}
	}

	/**
	 * 和值单双
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void hzds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 第一位first
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("单".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("双".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("大单".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("大双".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("小单".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("小双".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			}
		}
	}

	/**
	 * 十一选五-趣味型-定单双
	 * 
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void dds(BrowserEmulator be, Touzhu touZhu) throws Exception {

		// 选号
		// 第一位first
		first = StringUtil.getStrFromStr(touZhu.getMyriabit(), ",");

		for (int i = 0; i < first.length; i++) {
			String m = String.valueOf(first[i]);
			if ("5单0双".equals(m)) {
				be.click("//li[@name='lt_place_0'][1]");
			} else if ("4单1双".equals(m)) {
				be.click("//li[@name='lt_place_0'][2]");
			} else if ("3单2双".equals(m)) {
				be.click("//li[@name='lt_place_0'][3]");
			} else if ("2单3双".equals(m)) {
				be.click("//li[@name='lt_place_0'][4]");
			} else if ("1单4双".equals(m)) {
				be.click("//li[@name='lt_place_0'][5]");
			} else if ("0单5双".equals(m)) {
				be.click("//li[@name='lt_place_0'][6]");
			}
		}
	}
	
	/**
	 * 任选二
	 * @param be
	 * @param touZhu
	 * @throws Exception
	 */
	public void rx2(BrowserEmulator be, Touzhu touZhu) throws Exception {

		be.click("//*[@id='poschoose_2']/label[2]/input");
		be.click("//*[@id='poschoose_2']/label[3]/input");
	}
	
	/**
	 * 任选三
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
