package com.genericUtility;

 

 
 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * its developed using Apache POi libraries ,which is used to handle Microsoft Excel sheet
 * @author Anusha M
 *
 */

public class GetDataFromExcel {
	/**
	 * its used read the data from excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable 
	 */
	  
	
	private Workbook workbook;
	private FileInputStream fis;
	private FileOutputStream fos;
	private DataFormatter df;
    /** 
     * This method is used to open the excel
     * @param excelPath
     */
	public void openExcel(String excelPath) {
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook =WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		df=new DataFormatter();
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String excelData( String sheetName, int rowNumber, int cellNumber) {

		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}
	/**
	 * @throws IOException 
	 * @throws IOException 
	 * 
	 */
	public void setExcelData(String excelPath,String sheetname,int rowNumber,int cellNumber,String message){
		workbook.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).setCellValue(message);
		try {
			fos=new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
  /**
   * used to getLastRowNumber
   * @param excelPath
   * @param sheetName
   * @return
   * @throws EncryptedDocumentException
   * @throws IOException
   */
	public int getLastRowNumber( String sheetName) 
	{
		
		int LastRowNumber = workbook.getSheet(sheetName).getLastRowNum();
		return LastRowNumber;
	}

/**
 * used to close the excel
 * @return 
 * @throws IOException
 */
	
	public String[][] getDataExcel(String sheetName) {
		
		Sheet sheet = workbook.getSheet(sheetName);
		int lastrownum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		String[][] arr=new String[lastrownum][lastCellNum];
		
		for(int i=0;i<lastrownum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
			}
			}
		
		return arr;
		
	}
	public void closeExcel()  {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}