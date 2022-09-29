package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import utilis.Utility;

public class ExcelDataFetch {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String value=Utility.getDatafromExcelSheet("Sheet1",7,0);
	System.out.println(value);
}
}
