package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import fbDemo.LoginPage;
import fbDemo.MessengerPage;
import fbDemo.RoomPage;
import setup.Base;
import utilis.Utility;

public class TestNgfbDemo1 extends Base{
	private WebDriver driver;
	private LoginPage loginPage;
	private RoomPage roomsPage;
	private MessengerPage messangerPage;
	private SoftAssert soft;
	private int testId;
	
    @Parameters("browser")
	@BeforeTest
	public void openBroswer(String browsername) {
		
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
	public void createPOMobject() {
		loginPage = new LoginPage(driver);
		messangerPage = new MessengerPage(driver);
		roomsPage = new RoomPage(driver);
        soft=new SoftAssert();
	}
	@BeforeMethod
	public void openRoomsPage() {
		driver.get("https://www.facebook.com/");
		loginPage.openMessengerLink();
		messangerPage.openRooms();	
	}

	@Test 
	public void verifyBackToMessengerButton() throws IOException {
		roomsPage.backToMessenger();
		 String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		testId=123;
		
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertEquals( title,"Messenger");
        soft.assertAll();
        

	}
	
	@Test
	public void verifyHelpCenterButton() {
		roomsPage.openHelpCenterPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertEquals( title,"Messenger Help Centre");
         soft.assertAll();
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
		loginPage = null;
		messangerPage = null;
		roomsPage = null;
	}
	
	@AfterTest
	public void closeBrower() {
		System.out.println("Afterclass");
		driver.close();
		driver=null;
		System.gc();     //garbeg collector
	}
}


