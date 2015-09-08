package com.ng.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class UpdateExcel {

	public static void updateExcel(String filePath, int sheetIndex, int col,
			int row, Double value) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		// workbook.
		HSSFSheet sheet = workbook.getSheetAt(sheetIndex);

		HSSFRow r = sheet.getRow(row);
		r.createCell(col);
		HSSFCell cell = r.getCell(col);
		
		cell.setCellValue(value);

		fis.close();// �ر��ļ�������

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();// �ر��ļ������
		workbook.close();
	}

	private String getCellValue(HSSFCell cell) {
		String cellValue = "";
		DecimalFormat df = new DecimalFormat("#");
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getRichStringCellValue().getString().trim();
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			cellValue = df.format(cell.getNumericCellValue()).toString();
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
			break;
		case XSSFCell.CELL_TYPE_FORMULA:
			cellValue = cell.getCellFormula();
			break;
		default:
			cellValue = "";
		}
		return cellValue;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����ĳ����Լ���xls�ļ����в��ԣ�2003��ʽ�ģ�����2007
		String filePath = "src/data/Touzhu_data.xls";

		// ���波�Ը��ĵ�һ�е�һ�еĵ�Ԫ���ֵ
		UpdateExcel.updateExcel(filePath, 0, 26, 1, 9999.0000);
	}
}