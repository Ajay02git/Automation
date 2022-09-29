package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fpkt.AddTocartfpkt;
import fpkt.HomePagefpkt;
import fpkt.Loginfpkt;
import setup.Base;
import utilis.Utility;

public class TestNgfkpt1  extends Base{
	private WebDriver driver;
	private Loginfpkt loginfpkt;
	private HomePagefpkt homepage;
	private AddTocartfpkt addtocart ;
	private int testId;
	 @Parameters("browser")
	@BeforeTest
	public void openBrowser(String browsername) {
		
		 if(browsername.equals("Chrome")) {
			 driver=openChromeBrowser();
		}
			
			if(browsername.equals("Firefox")) {
			driver=openFirefoxBrowser();
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	@BeforeMethod
		public void createObject() {
		driver.get("https://www.flipkart.com");
		
		loginfpkt=new Loginfpkt(driver);
		homepage=new   HomePagefpkt (driver);
		addtocart =new AddTocartfpkt (driver);
	}
	
	    @Test
	    public void loginflipkart() throws EncryptedDocumentException, IOException, InterruptedException  {
	    	 
               String user=Utility.getDatafromExcelSheet("sheet1",7 ,0 );

	    	  loginfpkt.SendUserName(user);
	    	  
	    	  String pass=Utility.getDatafromExcelSheet("sheet1",7 ,1 );
	    	  loginfpkt.Sendpassword(pass);
	    	  Thread.sleep(2000);
	    	  loginfpkt.clickbutton();
	    	  String url = driver.getCurrentUrl();
		  		String title = driver.getTitle();
		 // 		Assert.assertEquals(url, "https://www.flipkart.com/");
		//		Assert.assertEquals( title,"xyz");
				testId=234;
	  	    
	  	    
	  	    Thread.sleep(3000);
	  	     
	  	    homepage.sendDataInSearchBar();
	  	    homepage.searchmobile();
	  	  Thread.sleep(3000);
	  	    homepage.clickOnMobile();
	  	    Thread.sleep(3000);
	  	    ArrayList<String>addr=new  ArrayList<String>(driver.getWindowHandles());
	  		  driver.switchTo().window(addr.get(1));
	  		  
	  		  
	  	  	    
	  	    
	  	    Thread.sleep(3000);
	  	    addtocart.addtocart();
	  	    addtocart.orderplace();
	    }
	    
	    @AfterMethod
	    public void logoutApp(ITestResult result) throws IOException {
			if(ITestResult.FAILURE==result.getStatus())
			{
				Utility.captureScreenShot(driver, testId);
			}
			System.out.println("Logout To App");
		}
	    
	    @AfterClass
		public void clearObject() {
	    	loginfpkt=null;
			homepage=null;
			addtocart =null;
	    }
		@AfterClass
		public void closeBrower() {
			System.out.println("Afterclass");
			driver.close();
			driver=null;
			System.gc();     //garbeg collector
		}
				
	}



