package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingArray {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("createTourPackageData");
		int lastrownum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		String[][] arr=new String[lastrownum][lastCellNum];
		for(int i=0;i<lastrownum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				arr[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(j);
			}
			}
		
		System.out.println(arr.length);
		
			for(int i=0;i<arr.length;i++)
				for(int j=0;j<arr[i].length;j++){
					System.out.println(arr[i][j]);
				}
			{
		}
				


	}

}
