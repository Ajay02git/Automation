package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenShot(WebDriver driver,int id) throws IOException {
		  SimpleDateFormat f=new SimpleDateFormat("dd-MM-YYYYY hh-mm-ss");
		    String date=f.format(new Date());
		    
		    TakesScreenshot ss=(TakesScreenshot)driver;
			   File src= ss.getScreenshotAs(OutputType.FILE);
			    File dest=new File("C:\\Users\\abc\\Pictures\\ test-"+id+" "+date+".jpg");
			    FileHandler.copy(src, dest);
	}
	
	public static String getDatafromExcelSheet( String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\abc\\Documents\\AutoExel.xlsx";
		FileInputStream file = new FileInputStream(path);
	    Cell cell  =WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNo).getCell(cellNo);
	
	String value;
	
		try {
			
	 value = cell.getStringCellValue();
		
		}
		catch(IllegalStateException e){
			double numvalue = cell.getNumericCellValue();
			long num = (long) numvalue;
			value = Long.toString( num);
		}
		return value;
	}
}
