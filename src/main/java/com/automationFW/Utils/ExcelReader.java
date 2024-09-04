package com.automationFW.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.automationFW.Context.Constants;

public class ExcelReader {
	
	@Test
	public void incorrectLoginDatafromExcel() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workbook =  new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRow  = sheet.getLastRowNum();
		for(int row = 1; row<= lastRow ; row ++)
		{
			Row rowlist = sheet.getRow(row);
			String email = rowlist.getCell(0).getStringCellValue();
			String password = rowlist.getCell(1).getStringCellValue();
			System.out.println(email + " " + password);
		}
	}

}
