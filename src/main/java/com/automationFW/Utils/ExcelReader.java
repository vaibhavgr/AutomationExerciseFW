package com.automationFW.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.automationFW.Context.Constants;
import com.automationFW.models.LoginData;

public class ExcelReader {
	
	@Test
	public static List<LoginData>  incorrectLoginDatafromExcel() throws IOException
	{
		List<LoginData> dataLoginList = new ArrayList<LoginData>();
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workbook =  new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRow  = sheet.getLastRowNum();
		for(int row = 1; row< lastRow ; row++ )
		{
			Row rowlist = sheet.getRow(row);
			if (rowlist != null) {
			String email = rowlist.getCell(0).getStringCellValue();
			String password = rowlist.getCell(1).getStringCellValue();
			System.out.println(email + " " + password);
			
			LoginData dataLogin = new LoginData(email , password);
			dataLoginList.add(dataLogin);
		}}
			
		return dataLoginList;
	}

}
