package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader
{	@DataProvider(name="testdata", parallel = true)
	public static String[][]excelreader() throws IOException
	{		
		String path = "./src/test/resources/config/LoginTestData.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		DataFormatter df = new DataFormatter();
		int numberofrows = sh.getLastRowNum();		
		System.out.println("total number of row are :"+numberofrows);				
		int totalcolumncount = sh.getRow(0).getLastCellNum();		
		System.out.println("Total number of column are :"+totalcolumncount);		
		String [][] data = new String [numberofrows+1][totalcolumncount];
		
		for(int i=0; i<=numberofrows; i++)
		{
			for(int j=0; j<totalcolumncount; j++ )
			{
				data [i][j]	= df.formatCellValue(sh.getRow(i).getCell(j));
			}
		}		
		return data;				
	}
}