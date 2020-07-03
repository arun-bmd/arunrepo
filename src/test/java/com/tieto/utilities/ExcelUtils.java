package com.tieto.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoObject(String fileDetail, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(fileDetail); // to read the excel or all type of
																					// file// file not found exception
		XSSFWorkbook book = new XSSFWorkbook(file); // to open the excel // if file is not openable/no permission to
													// open - IO exception
		XSSFSheet sheet = book.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows(); // getting total row used
		System.out.println(rowCount);

		XSSFRow rowCheck = sheet.getRow(0);
		int cellCount = rowCheck.getPhysicalNumberOfCells();
		System.out.println(rowCheck);

		Object[][] main = new Object[rowCount - 1][cellCount];

		// main[0][0] = "username";
		// main[0][2] = "username";
		for (int r = 1; r < rowCount; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < cellCount; c++) {

				XSSFCell cell = row.getCell(c);

				DataFormatter format = new DataFormatter();
				String cellValue = format.formatCellValue(cell); // formatting cell value into string
				System.out.println(cellValue);

				main[r - 1][c] = cellValue;

			}

		}

		book.close();
		file.close();
		
		return main;
	}

}
