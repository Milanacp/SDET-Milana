package Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * @author Milana
	 * To fetch the data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return data from excel sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDatafromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=wb.getSheet(sheetname);
		Row r=sh.getRow(rownum);
		Cell c=r.getCell(cellnum);
		String data=c.getStringCellValue();
		return data;
  
	}
	
	/**
	 * @author Milana
	 * To read the data from excel
	 * @param path
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafromExcel(String path,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=wb.getSheet(sheetname);
		Row r=sh.getRow(rownum);
		Cell c=r.getCell(cellnum);
		String data=c.getStringCellValue();
		return data;

	}
	
	/**
	 * @author Milana
	 * @param path
	 * @param sheetname
	 * @param rownum
	 * @return last row number
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String path, String sheetname,int rownum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getLastRowNum();
	}
	
	/**
	 * Write data in excel file
	 * @param path
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataInExcel(String path, String sheetname, int rownum, int column, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(column);
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
	}

}
