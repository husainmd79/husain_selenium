package com.utilityFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLData {
	public FileInputStream file;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path=null;
	 
	public XLData(String path)
	{
		this.path=path;
	}
	public int getRowCount(String sheetName) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int numberOfRow=sheet.getLastRowNum();
		file.close();
		workbook.close();
		return numberOfRow;
				
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int numberOfCell=row.getLastCellNum();
		workbook.close();
		file.close();
		return numberOfCell;
	}
	public String getCellData(String sheetName,int rownum,int column) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		DataFormatter format=new DataFormatter();
		String data;
		 try
		 {
			 data=format.formatCellValue(cell);
		 }
		 catch(Exception e)
		 {
			 data="";
		 }
		 workbook.close();
		 file.close();
		return data;
	}
	public void setCellData(String sheetName,int rownum,int column,String Data) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.createCell(column);
		cell.setCellValue(Data);
		 
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		file.close();
		fo.close();
	}
	public void fillGreenColor(String sheetName,int rownum,int column) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.close();
		file.close();
		fo.close();
	}

}


































