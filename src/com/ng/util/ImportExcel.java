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

import com.ng.vo.Touzhu;

/**
 * <p>
 * ImportExcell����Ҫ����-��ȡExcel.
 * </p>
 * <p>
 * ����ʱ�� 2014-12-28 - ����19:45:33
 * </p>
 * 
 * @author ����
 */
public class ImportExcel {
	private static final Log log = LogFactory.getLog(ImportExcel.class);

	/**
	 * <p>
	 * readExcel����-��ȡexcel����Ϊlist����ΪMap.
	 * </p>
	 * <p>
	 * ����ʱ�� 2014-12-28 - ����19:45:33
	 * </p>
	 * 
	 * @author ����
	 * @param file
	 *            excel�ļ�
	 * @return excel�����ݼ���-��Ϊlist����ΪMap
	 */
	public List<Map<String, String>> readExcel(File file) {
		log.info("��ȡexcel��ʼ...");
		List<Map<String, String>> dataset = new ArrayList<Map<String, String>>();
		try {
			// �������File����ΪFileInputStream;
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(file));
			// HSSFWorkbook:�ǲ���Excel2003��ǰ������2003���İ汾����չ����.xls
			// XSSFWorkbook:�ǲ���Excel2007�İ汾����չ����.xlsx
			// �õ�������
			HSSFWorkbook book = new HSSFWorkbook(inputStream);
			// �õ���һҳ
			HSSFSheet sheet = book.getSheetAt(0);
			// �õ���һ���������
			Iterator<Row> rowIterator = sheet.rowIterator();

			// �õ���һ�У�Ҳ���Ǳ�����
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
		log.info("��ȡexcel����...");
		return dataset;
	}

	/**
	 * <p>
	 * creatObjectByRow����-��ÿ�е�����װ��Map��.
	 * </p>
	 * <p>
	 * ������ ITɽ�� ����ʱ�� 2011-4-21 - ����09:48:17
	 * </p>
	 * 
	 * @param row
	 * @return
	 */
	private Map<String, String> creatObjectByRow(Row row) {

		// ����һ�е���
		int col = 1;
		Map<String, String> map = new HashMap<String, String>();

		// �е��������
		int maxCellNum = row.getLastCellNum();

		for (int i = 0; i < maxCellNum; i++) {

			String field = String.valueOf(col++);
			Cell cell = row.getCell(i);
			if (cell != null) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: // �ַ�
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_BOOLEAN: // ����
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_NUMERIC: // ����
					if (DateUtil.isCellDateFormatted(cell)) {// �Ƿ�Ϊ���ڸ�ʽ
						map.put(field, String.valueOf(cell.getDateCellValue()));
					} else {
						Double cellValue_dob = cell.getNumericCellValue();// ��ȡcell������
						if (String.valueOf(cellValue_dob).length() > 11) { // �����ȡ�������ֻ�����,��Ҫƥ�����ָ�ʽ
							DecimalFormat format = (DecimalFormat) NumberFormat
									.getInstance();
							// format.applyPattern("00000000000");
							map.put(field, format.format(cellValue_dob));
						} else { // �����ȡ�����ǱȽ϶̵����֣���ȥ��β����.0������ʾ,����������������Ķ�ȡ������

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
				case Cell.CELL_TYPE_FORMULA: // ��ʽ
					map.put(field, String.valueOf(cell.getNumericCellValue()));
					break;
				case Cell.CELL_TYPE_BLANK: // ��
					map.put(field, StringUtils.trim(cell.getStringCellValue()));
					break;
				case Cell.CELL_TYPE_ERROR: // �쳣
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

	public ArrayList<Touzhu> getTouzhu(String filePath) {

		ImportExcel inport = new ImportExcel();
		File file = new File(filePath);
		List<Map<String, String>> mapList = inport.readExcel(file);
		ArrayList<Touzhu> touzhuList = new ArrayList<Touzhu>();
		int switchKey;
		for (Map<String, String> map : mapList) {
			Iterator<Entry<String, String>> iterator = map.entrySet()
					.iterator();
			Map.Entry<String, String> entry;
			Touzhu touzhu = new Touzhu();
			while (iterator.hasNext()) {
				entry = iterator.next();
				String key = entry.getKey();
				String value = entry.getValue();
//				System.out.println("key:" + key + "\tvalue:" + value);
				switchKey = Integer.parseInt(key);
				switch (switchKey) {
				case 1:
					touzhu.setCaseFlag(value);
					break;
				case 2:
					touzhu.setCaseNo(value);
					break;
				case 3:
					touzhu.setCaiZhong(value);
					break;
				case 4:
					touzhu.setPlayStyle(value);
					break;
				case 5:
					touzhu.setFathertype(value);
					break;
				case 6:
					touzhu.setType(value);
					break;
				case 7:
					touzhu.setMyriabit(value);
					break;
				case 8:
					touzhu.setKilobit(value);
					break;
				case 9:
					touzhu.setHundreds(value);
					break;
				case 10:
					touzhu.setTens(value);
					break;
				case 11:
					touzhu.setUnit(value);
					break;
				case 12:
					touzhu.setSingle(value);
					break;
				case 13:
					touzhu.setMode(value);
					break;
				case 14:
					touzhu.setTime(value);
					break;
				case 15:
					touzhu.setPremiumMode(value);
					break;
				case 16:
					touzhu.setTrace(value);
					break;
				case 17:
					touzhu.setStopTrace(value);
					break;
				case 18:
					touzhu.setProfitTrace(value);
					break;
				case 19:
					touzhu.setProfitTime(value);
					break;
				case 20:
					touzhu.setProfitYields(value);
					break;
				case 21:
					touzhu.setProfitNumber(value);
					break;
				case 22:
					touzhu.setSameTrace(value);
					break;
				case 23:
					touzhu.setSameTime(value);
					break;
				case 24:
					touzhu.setSameNumber(value);
					break;
				case 25:
					touzhu.setDoubleTrace(value);
					break;
				case 26:
					touzhu.setDoublePeriod(value);
					break;
				case 27:
					touzhu.setDoubleTime(value);
					break;
				case 28:
					touzhu.setDoubleNumber(value);
					break;
				case 29:
					touzhu.setAmount(value);
					break;
				}

			}
			touzhuList.add(touzhu);
		}

		return touzhuList;
	}

	public static void main(String[] args) {

		ImportExcel inport = new ImportExcel();
		File file = new File("src/data/Touzhu_data.xls");
		List<Map<String, String>> mapList = inport.readExcel(file);
		ArrayList<Touzhu> touzhuList = new ArrayList<Touzhu>();
		int switchKey;
		for (Map<String, String> map : mapList) {
			Iterator<Entry<String, String>> iterator = map.entrySet()
					.iterator();
			Map.Entry<String, String> entry;
			Touzhu touzhu = new Touzhu();
			while (iterator.hasNext()) {
				entry = iterator.next();
				String key = entry.getKey();
				String value = entry.getValue();
//				System.out.println("key:" + key + "\tvalue:" + value);
				switchKey = Integer.parseInt(key);

				switch (switchKey) {
				case 1:
					touzhu.setPlayStyle(value);
					break;
				case 2:
					touzhu.setFathertype(value);
					break;
				case 3:
					touzhu.setType(value);
					break;
				case 4:
					touzhu.setMyriabit(value);
					break;
				case 5:
					touzhu.setKilobit(value);
					break;
				case 6:
					touzhu.setHundreds(value);
					break;
				case 7:
					touzhu.setTens(value);
					break;
				case 8:
					touzhu.setUnit(value);
					break;
				case 9:
					touzhu.setMode(value);
					break;
				case 10:
					touzhu.setTime(value);
					break;
				case 11:
					touzhu.setPremiumMode(value);
					break;
				case 12:
					touzhu.setTrace(value);
					break;
				case 13:
					touzhu.setStopTrace(value);
					break;
				case 14:
					touzhu.setProfitTrace(value);
					break;
				case 15:
					touzhu.setProfitTime(value);
					break;
				case 16:
					touzhu.setProfitYields(value);
					break;
				case 17:
					touzhu.setProfitNumber(value);
					break;
				case 18:
					touzhu.setSameTrace(value);
					break;
				case 19:
					touzhu.setSameTime(value);
					break;
				case 20:
					touzhu.setSameNumber(value);
					break;
				case 21:
					touzhu.setDoubleTrace(value);
					break;
				case 22:
					touzhu.setDoublePeriod(value);
					break;
				case 23:
					touzhu.setDoubleTime(value);
					break;
				case 24:
					touzhu.setDoubleNumber(value);
					break;
				case 25:
					touzhu.setAmount(value);
					break;
				}
			}
			touzhuList.add(touzhu);
		}

	}
}
