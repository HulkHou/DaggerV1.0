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

		fis.close();// 关闭文件输入流

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();// 关闭文件输出流
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

		// 下面改成你自己的xls文件进行测试，2003格式的，不能2007
		String filePath = "src/data/Touzhu_data.xls";

		// 下面尝试更改第一行第一列的单元格的值
		UpdateExcel.updateExcel(filePath, 0, 26, 1, 9999.0000);
	}
}