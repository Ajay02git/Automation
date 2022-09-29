package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fpkt.AddTocartfpkt;
import fpkt.HomePagefpkt;
import fpkt.Loginfpkt;

public class TestNgfpkt {
private WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.flipkart.com/");
	}
	    @Test
	    public void loginflipkart() throws InterruptedException  {
	    	  Loginfpkt loginfpkt=new Loginfpkt(driver);
	    	  
	    
	  		
	  	    loginfpkt.Loginpage();
	  	    
	  	    Thread.sleep(3000);
	  	     HomePagefpkt homepage=new   HomePagefpkt (driver);
	  	    homepage.sendDataInSearchBar();
	  	    homepage.searchmobile();
	  	    homepage.clickOnMobile();
	  	    Thread.sleep(3000);
	  	    ArrayList<String>addr=new  ArrayList<String>(driver.getWindowHandles());
	  		  driver.switchTo().window(addr.get(1));
	  		  
	  		  
	  	  	    
	  	    AddTocartfpkt addtocart =new AddTocartfpkt (driver);
	  	    Thread.sleep(3000);
	  	    addtocart.addtocart();
	  	    addtocart.orderplace();
	    }
		@AfterClass
		public void closebrowser() {
			driver.close();
		}
	}

