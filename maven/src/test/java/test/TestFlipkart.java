package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fpkt.AddTocartfpkt;
import fpkt.HomePagefpkt;
import fpkt.Loginfpkt;

public class TestFlipkart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.flipkart.com/");
	    
	    Loginfpkt loginfpkt=new Loginfpkt(driver);
	    loginfpkt.Loginpage();
	    
	    Thread.sleep(3000);
	     HomePagefpkt homepage=new   HomePagefpkt (driver);
	    homepage.sendDataInSearchBar();
	    homepage.searchmobile();
	    homepage.clickOnMobile();
	    
	    ArrayList<String>addr=new  ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(addr.get(1));
		  
		  
	  	  
	    AddTocartfpkt addtocart =new AddTocartfpkt (driver);
	    addtocart.addtocart();
	    addtocart.orderplace();
}
}