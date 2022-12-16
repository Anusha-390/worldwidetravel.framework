package practice;

//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromEXcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		@SuppressWarnings("deprecation")
		Workbook workbook = WorkbookFactory.create("fis");
     try { Sheet sheet = workbook.getSheet("BOOKING ID");
      Row row = sheet.getRow(2);
      Cell cell = row.getCell(2);
      String data = cell.getStringCellValue();
      
      System.out.println(data);
     }finally {
    	 workbook.close();
    	 System.out.println("workbook closed");
    	 
     }
		
	}

}
