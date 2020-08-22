package com.POMfamework.helper.excel;

// test1

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.POMfamework.helper.logger.LoggerHelper;
import com.POMfamework.helper.resource.ResourceHelper;

public class ExcelHelper 
{
	private static  Logger log = LoggerHelper.GetLogger(ExcelHelper.class);
	
	

	
	public Object[][] getExcelData(String Excellocation,String sheetname)
	{
		try
		{
			Object datasets[][]= null;
			File Fileloc = new File(Excellocation);
					
			FileInputStream  File = new FileInputStream(Fileloc);
			//create workbook instance
			System.out.println();
			 XSSFWorkbook workbook = new XSSFWorkbook(File);
			//GetSheetNamefromworkbook
		XSSFSheet sheet = workbook.getSheet(sheetname);
		//countActverows in sheets
		int totalrows= sheet.getLastRowNum();
		//countActive columns in row
		int totalcolmns = sheet.getRow(0).getLastCellNum();
		datasets= new Object[totalrows+1][totalcolmns];
		System.out.println("totalrows are"+totalrows);
		//itrate through each row
 Iterator<Row> rowiterator = sheet.iterator();
		rowiterator= sheet.iterator();
		int i=0;
		while(rowiterator.hasNext())
		{
			i++;
			//for every row need to iterate over column
			Row row = rowiterator.next();
			int j=0;
Iterator<Cell> cellierator = row.cellIterator();
			while(cellierator.hasNext())
			{
				j++;
				Cell cell = cellierator.next();
				switch(cell.getCellType())
					{
					case STRING	:				
						datasets[i-1][j-1]= cell.getStringCellValue();
						break;
					case NUMERIC:
						datasets[i][j]= cell.getNumericCellValue();
						break;
					case BOOLEAN:
					datasets[i][j]= cell.getBooleanCellValue();
					break;
				case FORMULA:
					datasets[i][j]= cell.getCellFormula();
					break;
				default:
					System.out.println("No Matching Enum type found");
					break;
					
						
					
					}
				
				}
			}
		return datasets;
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void UpdateResults(String excellocation, String sheetname, String testcasename,String Teststatus) 
	{
		try
		{
			File Fileloc = new File(excellocation);
			 FileInputStream File = new FileInputStream(Fileloc);
			 XSSFWorkbook workbook = new XSSFWorkbook(File);
			 XSSFSheet sheet = workbook.getSheet(sheetname);
			 int totalrows= sheet.getLastRowNum()+1;
			 for(int i= 1;i<totalrows;i++)
			 {
				 XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				 if(ce.contains(testcasename))
				 {
					 r.createCell(1).setCellValue(Teststatus);
					 File.close();
					 log.info("result updated...");
					 //File OutputStrem takes File as a parameter
					 FileOutputStream out = new FileOutputStream( Fileloc);
					 workbook.write(out);
					 out.close();
					 break;
				 }
			 }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		ExcelHelper excel = new ExcelHelper();
		String Excellocation = ResourceHelper.GetResourcePath("\\src\\main\\java\\com\\POMfamework\\helper\\excelData\\Data.xlsx");
		Object[][] data = excel.getExcelData(Excellocation, "Login");
		System.out.println(data);
		
		excel.UpdateResults(Excellocation, "TestResult", "Login", "PASS");
		excel.UpdateResults(Excellocation, "TestResult", "Home", "FAIL");
		excel.UpdateResults(Excellocation, "TestResult", "Cart", "PASS");
		
	}
}
