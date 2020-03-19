package com.bank.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

import com.bank.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long IMPICIT_WAIT = 20;
	public static long PAGE_LOAD =20;
	
	//public static XSSFWorkbook workbook;
	public static Workbook workbook;
	//public static XSSFSheet sheet;
	public static Sheet sheet;
	static XSSFCell Cell;
	
	public static String TESTDATA_SHEET_PATH = 
			//"/webtesting/src/main/java/com/bank/qa/testdata/freeCrmTestData.xlsx"; 
			"D:\\FunctionalTesting\\webtesting\\src\\main\\java\\com\\bank\\qa\\testdata\\freeCrmTestData.xlsx";
	//public static String sheetName;
	
	
	public static Object[][] getTableArray(String sheetName) throws Exception{
		File file=new File(TESTDATA_SHEET_PATH);
		FileInputStream fis=new FileInputStream(file);
		workbook = WorkbookFactory.create(fis);
		// workbook= new XSSFWorkbook(fis);
		 sheet=workbook.getSheet(sheetName);
		int totalRows=sheet.getLastRowNum();
		int totalColums=sheet.getRow(0).getPhysicalNumberOfCells();
		
		// Read data from excel and store the same in the Object Array.
		Object obj[][]=new Object[totalRows][totalColums];
		for(int i=0;i<totalRows;i++)
		{
			for(int j=0;j<totalColums;j++){
			obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		/*for(int i=0;i<totalRows;i++)
		{
			obj[i][0]=sheet.getRow(i+1).getCell(0).toString();
			obj[i][1]=sheet.getRow(i+1).getCell(1).toString();
			obj[i][2]=sheet.getRow(i+1).getCell(2).toString();
			obj[i][3]=sheet.getRow(i+1).getCell(3).toString();
		}*/
		
		return obj;	
	}
			 
			
}
	

	

	
	
