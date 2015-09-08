package com.ng.util;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.ng.dao.TouzhuDaoImpl;
import com.ng.vo.UserLotteryPoint;



public class StringUtil {

	/**
	 * ȥ���ַ������±����Ҳ�������
	 * 
	 * @param src
	 * @param begin
	 * @return
	 */

	public static String substring(String src, int begin) {
		return substring(src, begin, src.length());
	}

	/**
	 * ��base64�㷨�����ַ���
	 * 
	 * @param content
	 *            �����ַ���
	 * @return ���ؼ��ܺ���ַ���
	 */
	public static String encodeBase64(String content) {
		Base64 bs = new Base64();
		return new String(bs.encode(content.getBytes()));
	}

	/**
	 * ��base64�㷨�����ַ���
	 * 
	 * @param content
	 * @return
	 */
	public static String decodeBase64(String content) {
		Base64 bs = new Base64();
		try {
			return new String(bs.decode(content.getBytes()), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ȡ���ַ������±����Ҳ�������
	 * 
	 * @param src
	 *            �����ַ���
	 * @param begin
	 *            ��ʼλ��
	 * @param end
	 *            ����λ��
	 * @return
	 */
	public static String substring(String src, int begin, int end) {
		if (isNull(src) || src.length() < begin || begin > end) {
			return "";
		}

		if (end > src.length()) {
			return src.substring(begin);
		} else {

			return src.substring(begin, end);
		}
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�գ��ո��ַ���Ҳ��Ϊ��
	 * 
	 * @param s
	 *            �жϵ��ַ���
	 * @return Ϊ��ʱ����true
	 */
	public static boolean isNull(String s) {
		return StringUtils.isBlank(s);
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�գ��ո��ַ���Ҳ��Ϊ��
	 * 
	 * @param s
	 *            �жϵ��ַ���
	 * @return ��Ϊ��ʱ����true
	 */
	public static boolean isNotNull(String s) {
		return !isNull(s);
	}

	/**
	 * 
	 * @param o
	 * @param defaultvalue
	 * @return
	 */
	public static String nvl(String o, String defaultvalue) {
		if (StringUtil.isNull(o)) {
			o = defaultvalue;
		}
		return o;
	}

	/**
	 * ��GBKת��ΪISO-8859-1������ת��ֱ�ӷ���ԭ�ַ���
	 * 
	 * @param s
	 * @return
	 */
	public static String transStr(String s) {
		try {
			return new String(s.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
			return s;
		}
	}

	/**
	 * ת���ַ�������.
	 * 
	 * @param s
	 *            the s
	 * @param oldCharset
	 *            the old charset
	 * @param charset
	 *            the charset
	 * @return the string
	 */
	public static String transStr(String s, String oldCharset, String charset) {
		try {
			return new String(s.getBytes(oldCharset), charset);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
			return s;
		}
	}

	/**
	 * �ж������ַ�����ֵ�Ƿ����
	 * 
	 * @param s1
	 *            �ַ���1
	 * @param s2
	 *            �ַ���2
	 * @return ����򷵻�true
	 */
	public static boolean isEqual(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 != null) {
			return s1.equals(s2);
		}
		return false;
	}

	/**
	 * ���ַ����õ���������
	 * 
	 * @param str
	 *            ������ַ���
	 * @param regx
	 *            �ָ��ַ����ı��ʽ
	 * @return �������飬���Ϊ���򷵻س���Ϊ0�����飬������null
	 */
	public static Integer[] getIntArrayFromStr(String str, String regx) {
		if (StringUtil.isNull(str)) {
			return new Integer[0];
		}
		String[] days = str.split(regx);
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < days.length; i++) {
			if (!StringUtil.isNull(days[i])) {
				set.add(days[i]);
			}
		}
		Integer[] ret = new Integer[set.size()];
		int i = 0;
		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			try {
				ret[i] = Integer.parseInt(it.next());
			} catch (Exception e) {
				ret[i] = 0;
			}
			i++;
		}
		return ret;
	}

	/**
	 * ���ַ����õ��ַ�������
	 * 
	 * @param str
	 *            ������ַ���
	 * @param regx
	 *            �ָ��ַ����ı��ʽ
	 * @return �������飬���Ϊ���򷵻س���Ϊ0�����飬������null
	 */
	public static String[] getStrFromStr(String str, String regx) {
		if (StringUtil.isNull(str)) {
			return new String[0];
		}
		String[] strs = str.split(regx);

		return strs;
	}

	/**
	 * 
	 * �����ַ�����ĳ���ַ������ֵĴ���
	 * 
	 * @param source
	 *            Դ�ַ���
	 * @param str
	 *            ƥ����ַ���
	 * @return
	 */
	public static int matchTimes(String source, String str) {
		if (isNull(source)) {
			return 0;
		} else {
			int fromIndex = 0;
			int number = 0;
			int index = 0;
			while ((index = source.indexOf(str, fromIndex)) >= 0) {
				number++;
				fromIndex = index + 1;
			}
			return number;
		}
	}

	/**
	 * 
	 * �ж��ַ����Ƿ�Ϊ����������
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param true,
	 *            false
	 * @return
	 */
	public static boolean checkNum(String str) {

		boolean result = false;
		String regex = "^[0123456789]+$";
		if (str.matches(regex)) {
			result = true;// ����ֵ

		} else {
			result = false;

		}

		return result;
	}

	/**
	 * �����ַ�������ָ���ķָ����ָ�
	 * 
	 * @param array
	 * @param split
	 * @return
	 */
	public static String join(Object[] array, String split) {
		StringBuilder sb = new StringBuilder();
		if (!ArrayUtils.isEmpty(array)) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					continue;
				}
				if (i != 0) {
					sb.append(split);
				}
				sb.append(array[i]);
			}
		}
		return sb.toString();

	}

	/**
	 * �����ַ�������ָ���ķָ����ָ�
	 * 
	 * @param list
	 * @param split
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String join(List list, String split) {
		if (list == null || list.size() == 0) {
			return "";
		}
		return join(list.toArray(), split);
	}

	/**
	 * ����ַ������÷ָ����ָ�
	 * 
	 * @param src
	 * @param toAdd
	 * @param split
	 * @return
	 */
	public static String push(String src, String toAdd, String split) {
		if (StringUtil.isNull(src)) {
			if (!StringUtil.isNull(toAdd)) {
				return toAdd;
			} else {
				return "";
			}
		} else {
			if (StringUtil.isNull(toAdd)) {
				toAdd = "";
			}
			return src + split + toAdd;
		}
	}

	/**
	 * ���ش�д������
	 * 
	 * @param number
	 *            ��������
	 * @return
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public static String number2Chinese(int number) {
		String[] unit = { "", "ʮ", "��", "ǧ", "��", "ʮ��", "����", "ǧ��", "��" };
		String[] bignumber = { "", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
		int i = 0;
		List list = new ArrayList();
		while (true) {
			int tail = number % 10;

			if (tail == 1 && (i == 1)) {
				list.add(unit[i]);
			}
			if (tail == 0) {
				list.add("��");
			} else {
				list.add(bignumber[tail] + unit[i]);
			}
			number = number / 10;
			i++;
			if (number == 0) {
				break;
			}
		}
		String ret = "";
		for (int j = list.size() - 1; j >= 0; j--) {
			if (!"��".equals(list.get(j))
					|| ("��".equals(list.get(j)) && !ret.endsWith("��"))) {
				ret += list.get(j).toString();
			}

		}
		return ret;
	}

	/**
	 * ��ȡ���ַ�����β��ָ���ַ�
	 * 
	 * @param value
	 *            ԭ�ַ���
	 * @param count
	 *            ��ȡ����
	 * @param append
	 *            β���ַ�
	 * @return
	 */
	public static String getSubStr(String value, String count, String append) {
		StringBuffer sb = new StringBuffer();
		if (value.length() > Integer.parseInt(count)) {
			sb.append(value.substring(0, Integer.parseInt(count)));
			sb.append(append);
		} else {
			sb.append(value);
		}
		return sb.toString();
	}

	/**
	 * ������ת����ʽ���
	 * 
	 * @param digit
	 * @return
	 */
	public static String getdigitalview(int digit) {
		String view = "###,##0.";
		if (digit < 1) {
			return view + "00";
		}
		for (int i = 1; i <= digit; i++) {
			view = view + "0";
		}
		return view;
	}

	/**
	 * ��ʽ��������
	 * 
	 * @param format
	 *            ��ʽ ��"##.##"
	 * @param f
	 *            Ҫ��ʽ���ĸ�����
	 * @return
	 */
	public static String formatFloat(String format, double f) {
		StringBuffer formatString = new StringBuffer(format);
		java.text.DecimalFormat df = new java.text.DecimalFormat(formatString
				.toString());
		return df.format(f);
	}

	/**
	 * ��Сд�����е��ַ����滻����
	 * 
	 * @param source
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replaceStringCaseInsensitive(String source,
			String regex, String replacement) {
		StringBuffer result = new StringBuffer();
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(source);
		while (m.find()) {
			m.appendReplacement(result, replacement);
		}
		m.appendTail(result);
		return result.toString();
	}

	/**
	 * ��Сд�����е��ַ������Һ���
	 * 
	 * @param source
	 * @param regex
	 * @return pos 0..length-1
	 */
	public static int findStringCaseInsensitive(String source, String regex) {
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(source);
		if (m.find()) {
			return m.start();
		}
		return -1;
	}

	/**
	 * ��������ת��Ϊ�ַ�������
	 * 
	 * @param objectvalue
	 * @param toType
	 * @return
	 */
	public static String[] objectToOtherArray(Object[] objectvalue,
			String toType) {
		// Object[] ת�� String[]
		// �����������͵Ļ�ת
		String[] object = null;
		if (objectvalue != null) {
			object = new String[objectvalue.length];
		}
		for (int i = 0; objectvalue != null && i < objectvalue.length; i++) {
			if (toType.equals("s")) {
				object[i] = (String) objectvalue[i];
			}
		}
		return object;
	}

	/**
	 * �ļ���С��ʽ�ַ���ת�� 123->123Bytes 1234->1.2K 12345->12.3K 123456->123.5K
	 * 1234567->1.2M 12345678->12.3M 123456789->123.5M
	 * 
	 * @param inputvalue
	 *            �����ֽ���Bytes
	 * @return
	 */
	public static String getFileSizeFormat(double inputvalue) {
		String outputvalue = "0";
		if (inputvalue >= 1024 * 1024) {
			outputvalue = formatFloat("###,##0.0", inputvalue / (1024 * 1024))
					+ "M";
		} else if (inputvalue >= 1024) {
			outputvalue = formatFloat("###,##0.0", inputvalue / 1024) + "K";
		} else {
			outputvalue = formatFloat("###,##0", inputvalue) + "Bytes";
		}
		return outputvalue;
	}

	/**
	 * �����ʽ��ת��
	 * 
	 * @param inputvalue
	 *            ����ֵ
	 * @param viewtype
	 *            ��ʾ�ֶ�����
	 * @return
	 */
	public static String getOutputvalue(String inputvalue, String viewtype) {
		String outputvalue = null;
		// ��ֵ��ʾΪ0
		if (StringUtils.isBlank(inputvalue)) {
			inputvalue = "0";
		}
		if (viewtype.trim().equals("I")) {
			outputvalue = formatFloat("###,##0", Double.parseDouble(inputvalue));
		} else if (viewtype.trim().equals("F")) {
			outputvalue = formatFloat("###,##0.00", Double
					.parseDouble(inputvalue));
		} else if (viewtype.trim().equals("FK")) { // ����һǧ
			outputvalue = formatFloat("###,##0.00000", Double
					.parseDouble(inputvalue) / 1000);
		} else if (viewtype.trim().equals("FW")) { // ����һ��
			outputvalue = formatFloat("###,##0.000000", Double
					.parseDouble(inputvalue) / 10000);
		} else if (viewtype.trim().equals("FM")) { // ����һ����
			outputvalue = formatFloat("###,##0.00000000", Double
					.parseDouble(inputvalue) / 1000000);
		} else if (viewtype.trim().equals("FY")) { // ����һ��
			outputvalue = formatFloat("###,##0.0000000000", Double
					.parseDouble(inputvalue) / 100000000);
		} else {
			// λ����ʾ��4λ����С����ͳ��(����ֵ����ͳ��)
			int digit = Integer.parseInt(viewtype.trim().substring(1, 2));
			outputvalue = formatFloat(getdigitalview(digit), Double
					.parseDouble(inputvalue));
		}
		return outputvalue;
	}

	/**
	 * <p>
	 * �ڳ��ַ���ָ���ĳ��ȼ�����������ַ���.
	 * </p>
	 * 
	 * @param value
	 * @param length
	 * @param str
	 * @return
	 */
	public static String getConvertStr(String value, int length, String str) {
		StringBuilder sb = new StringBuilder();
		if (value.length() <= length) {
			return value;
		}
		for (int i = 0, n = value.length(); i < n; i = i + length) {
			if (i + length >= n) {
				sb.append(value.substring(i));
			} else {
				sb.append(value.substring(i, i + length)).append(str);
			}
		}
		return sb.toString();
	}

	/**
	 * ��ȡ���ַ���
	 * 
	 * @param value
	 *            ԭ�ַ���
	 * @param length
	 *            ָ���ֽڳ���
	 * @return
	 */
	public static String getSubString(String value, String regx) {
		return value.split(regx)[0];
	}

	/**
	 * ��ȡ���ַ�������ʡ�Ժ��
	 * 
	 * @param value
	 *            ԭ�ַ���
	 * @param length
	 *            ָ���ֽڳ���
	 * @return
	 */
	public static String getSubString(String value, int length) {
		try {
			if (getStringBytes(value) <= length) {
				return value;
			}
			char[] temp;
			char ch;
			int i, n = 0;
			for (i = 0; i < value.length(); i++) {
				ch = value.charAt(i);
				temp = new char[] { ch };
				byte[] uniCode = new String(temp).getBytes("GBK");
				if (uniCode[0] > 0) // �ж��Ƿ�Ϊ����
					n++;
				else
					n += 2; // ����ȡ���ֽ�
				if (n == length)
					break;
				else if (n > length) {
					i--;
					break;
				} // ������ְ������
			}
			return value.substring(0, i + 1) + "...";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * ȡ�ַ������ֽڳ���
	 * 
	 * @param value
	 * @return
	 */
	public static int getStringBytes(String value) {
		try {
			return value.getBytes().length;
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * �� Unicode ��ת���ɱ���ǰ�������ַ�����
	 * 
	 * @param in
	 *            Unicode������ַ����顣
	 * @param off
	 *            ת������ʼƫ������
	 * @param len
	 *            ת�����ַ����ȡ�
	 * @param convtBuf
	 *            ת���Ļ����ַ����顣
	 * @return ���ת�������ر���ǰ�������ַ�����
	 */
	public static String fromUnicode(char[] in, int off, int len) {

		char aChar;
		char[] out = new char[len * 2];
		int outLen = 0;
		int end = off + len;

		while (off < end) {
			aChar = in[off++];
			if (aChar == '\\') {
				aChar = in[off++];
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = in[off++];
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed \\uxxxx encoding.");
						}
					}
					out[outLen++] = (char) value;
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					out[outLen++] = aChar;
				}
			} else {
				out[outLen++] = aChar;
			}
		}
		return new String(out, 0, outLen);
	}

	/**
	 * ��������
	 * 
	 * @param curseq
	 * @return
	 */
	public static String adgustLength(String curseq, int length) {
		while (curseq.length() < length - 1) {
			curseq = "0" + curseq;
		}
		curseq = "1" + curseq;
		return curseq;
	}

	/**
	 * Checks if is chinese str.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is chinese str
	 */
	public static boolean isChineseStr(String value) {
		if (isNull(value)) {
			return false;
		}
		for (int i = 0, n = value.length(); i < n; i++) {
			if ((int) value.charAt(i) > 256) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		try {
			Double.valueOf(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * �ַ���תbool����
	 * 
	 * @param value
	 *            ֵ
	 * @return ��value����1ʱ�������棬���򷵻ؼ�
	 */
	public static boolean str2boolean(String value) {
		return str2boolean(value, "1");

	}

	/**
	 * �ַ���תbool����
	 * 
	 * @param value
	 *            ֵ
	 * @param truevalue
	 *            ��ʾ����ַ���ֵ
	 * @return ��value����truevalueʱ�������棬���򷵻ؼ�
	 */
	public static boolean str2boolean(String value, String truevalue) {
		if (StringUtil.isNull(truevalue)) {
			truevalue = "1";
		}
		if (truevalue.equalsIgnoreCase(value)) {
			return true;
		}
		return false;
	}

	/**
	 * ���ز�Ϊnull���ַ���
	 * 
	 * @param s
	 * @return
	 */
	public static String getEmpty(String s) {
		if (s == null) {
			s = "";
		}
		return s;
	}

	/**
	 * �ַ���ת���ͣ����׳��쳣
	 * 
	 * @param s
	 * @return
	 */
	public static Integer parseInt(String s) {
		Integer i = 0;
		if (StringUtil.isNotNull(s)) {
			try {
				i = Integer.valueOf(s);
			} catch (Exception e) {

			}
		}
		return i;
	}

	/**
	 * �ַ���ת���ͣ����׳��쳣
	 * 
	 * @param s
	 * @return
	 */
	public static Double parseDouble(String s) {
		Double i = null;
		if (StringUtil.isNotNull(s)) {
			try {
				i = Double.valueOf(s);
			} catch (Exception e) {

			}
		}
		return i;
	}

	/**
	 * ��ȡ���ַ���,premium
	 * 
	 * @param value
	 *            ԭ�ַ���
	 * @param userPoint
	 *            ָ���ַ���
	 * @return
	 */
	public static String getPremiumString(String value, String userPoint) {
		Double userPointDouble = parseDouble(userPoint) * 10 * 10;
		System.out.println(value);
		System.out.println("s:3:\"" + userPointDouble.toString());
		int starindex = value.indexOf("s:3:\"" + userPointDouble.toString()) + 10;
		System.out.println(starindex);
		return value.substring(0).split(";")[0];

	}

	/**
	 * ��ȡ���ַ���,premium
	 * 
	 * @param value
	 *            ԭ�ַ���
	 * @param userPoint
	 *            ָ���ַ���
	 * @return
	 */
	public static String getPremiumString1(String value, String userPoint) {
		System.out.println(value);
		String[] tempValue = value.split(";");
		String s = "1";
		for (int i = 0; i < tempValue.length; i++) {
			
			System.out.println(tempValue[i]);
			System.out.println(tempValue[i].split("\"")[0]);
			if (tempValue[i].split("\"")[0]!=null){
				 s = tempValue[i].substring(tempValue[i].length()-4, tempValue[i].length()-1);
				 System.out.println(s);
			} else {
				System.out.println(tempValue[i]);
				s = tempValue[i].substring(2,3);
			}
			i++;
		}

		return s;

	}

	public static void main(String[] args) throws SQLException {

		TouzhuDaoImpl t = new TouzhuDaoImpl();
		UserLotteryPoint ulp = t.findUserId("test001");
		System.out.println(t.findUserPremium(ulp, "���Ǹ�ʽ", "����ʱʱ��").getPremium());
	}
}
