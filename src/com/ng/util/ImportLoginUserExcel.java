package com.ng.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import com.ng.vo.LoginUser;
import com.ng.vo.Touzhu;

/**
 * <p>
 * ImportExcell类主要用于-读取Excel.
 * </p>
 * <p>
 * 创建时间 2014-12-28 - 下午19:45:33
 * </p>
 * 
 * @author 侯祥
 */
public class ImportLoginUserExcel {
	private static final Log log = LogFactory
			.getLog(ImportLoginUserExcel.class);

	/**
	 * <p>
	 * readExcel方法-读取excel，行为list，列为Map.
	 * </p>
	 * <p>
	 * 创建时间 2014-12-28 - 下午19:45:33
	 * </p>
	 * 
	 * @author 侯祥
	 * @param file
	 *            excel文件
	 * @return excel表数据集合-行为list，列为Map
	 */
	public List<Map<String, String>> readExcel(File file) {
		log.info("读取excel开始...");
		List<Map<String, String>> dataset = new ArrayList<Map<String, String>>();
		try {
			// 将传入的File构造为FileInputStream;
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(file));
			// HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
			// XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
			// 得到工作表
			HSSFWorkbook book = new HSSFWorkbook(inputStream);
			// 得到第一页
			HSSFSheet sheet = book.getSheetAt(0);
			// 得到第一面的所有行
			Iterator<Row> rowIterator = sheet.rowIterator();

			// 得到第一行，也就是标题行
			@SuppressWarnings("unused")
			Row titleRow = rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Map<String, String> map = this.creatObjectByRow(row);
				dataset.add(map);
			}
			book.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		log.info("读取excel结束...");
		return dataset;
	}

	/**
	 * <p>
	 * creatObjectByRow方法-将每行的数据装载Map中.
	 * </p>
	 * <p>
	 * 创建人 IT山人 创建时间 2011-4-21 - 下午09:48:17
	 * </p>
	 * 
	 * @param row
	 * @return
	 */
	private Map<String, String> creatObjectByRow(Row row) {

		// 遍历一行的列
		int col = 1;
		Map<String, String> map = new HashMap<String, String>();

		// 行的最大列数
		int maxCellNum = row.getLastCellNum();

		for (int i = 0; i < maxCellNum; i++) {

			String field = String.valueOf(col++);
			Cell cell = row.getCell(i);
			if (cell != null) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: // 字符
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_BOOLEAN: // 布尔
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_NUMERIC: // 数字
					if (DateUtil.isCellDateFormatted(cell)) {// 是否为日期格式
						map.put(field, String.valueOf(cell.getDateCellValue()));
					} else {
						Double cellValue_dob = cell.getNumericCellValue();// 读取cell内数据
						if (String.valueOf(cellValue_dob).length() > 11) { // 如果读取到的是手机号码,需要匹配数字格式
							DecimalFormat format = (DecimalFormat) NumberFormat
									.getInstance();
							// format.applyPattern("00000000000");
							map.put(field, format.format(cellValue_dob));
						} else { // 如果读取到的是比较短的数字，则去掉尾数（.0）后显示,解决浮点数和整数的读取的问题

							String a = cellValue_dob.toString().substring(
									cellValue_dob.toString().length() - 2,
									cellValue_dob.toString().length());
							if (".0".equals(a)) {
								map.put(field,
										cellValue_dob.toString().substring(
												0,
												cellValue_dob.toString()
														.length() - 2));
							} else {
								map.put(field, cellValue_dob.toString());
							}
						}
					}
					break;
				case Cell.CELL_TYPE_FORMULA: // 公式
					map.put(field, String.valueOf(cell.getNumericCellValue()));
					break;
				case Cell.CELL_TYPE_BLANK: // 空
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_ERROR: // 异常
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				default:
//					System.out.println("default");
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				}
			} else {
				map.put(field, "null");
			}
		}
		return map;
	}

	public ArrayList<LoginUser> getLoginUser(String loginUserfilePath) {

		ImportLoginUserExcel inport = new ImportLoginUserExcel();
		File file = new File(loginUserfilePath);
		List<Map<String, String>> mapList = inport.readExcel(file);
		ArrayList<LoginUser> loginUserList = new ArrayList<LoginUser>();
		int switchKey;
		for (Map<String, String> map : mapList) {
			Iterator<Entry<String, String>> iterator = map.entrySet()
					.iterator();
			Map.Entry<String, String> entry;
			LoginUser loginUser = new LoginUser();
			while (iterator.hasNext()) {
				entry = iterator.next();
				String key = entry.getKey();
				String value = entry.getValue();
//				System.out.println("key:" + key + "\tvalue:" + value);
				switchKey = Integer.parseInt(key);
				switch (switchKey) {
				case 1:
					loginUser.setCaseFlag(value);
					break;
				case 2:
					loginUser.setBaseUrl(value);
					break;
				case 3:
					loginUser.setUserName(value);
					break;
				case 4:
					loginUser.setPassword(value);
					break;
				case 5:
					loginUser.setPlatform(value);
					break;					
				}
			}
			loginUserList.add(loginUser);
		}

		return loginUserList;
	}

	public static void main(String[] args) {

//		ImportLoginUserExcel inport = new ImportLoginUserExcel();
//		File file = new File("src/data/LoginUser_data.xls");
//		List<Map<String, String>> mapList = inport.readExcel(file);
//		ArrayList<LoginUser> loginUserList = new ArrayList<LoginUser>();
//		int switchKey;
//		for (Map<String, String> map : mapList) {
//			Iterator<Entry<String, String>> iterator = map.entrySet()
//					.iterator();
//			Map.Entry<String, String> entry;
//			LoginUser loginUser = new LoginUser();
//			while (iterator.hasNext()) {
//				entry = iterator.next();
//				String key = entry.getKey();
//				String value = entry.getValue();
//				System.out.println("key:" + key + "\tvalue:" + value);
//				switchKey = Integer.parseInt(key);
//
//				switch (switchKey) {
//				case 1:
//					loginUser.setCaseFlag(value);
//					break;
//				case 2:
//					loginUser.setBaseUrl(value);
//					break;
//				case 3:
//					loginUser.setUserName(value);
//					break;
//				case 4:
//					loginUser.setPassword(value);
//					break;
//				}
//			}
//			loginUserList.add(loginUser);
//		}

	}
}
