package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fbDemo.LoginPage;
import fbDemo.MessengerPage;
import fbDemo.RoomPage;

public class TestNgfbDemo {
	private WebDriver driver;
	private LoginPage loginPage;
	private RoomPage roomsPage;
	private MessengerPage messangerPage;

	@BeforeClass
	public void openBroswer() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void openRoomsPage() {
		driver.get("https://www.facebook.com/");
		loginPage = new LoginPage(driver);
		loginPage.openMessengerLink();

		messangerPage = new MessengerPage(driver);
		messangerPage.openRooms();

		roomsPage = new RoomPage(driver);
	}

	@Test 
	public void verifyBackToMessengerButton() {
		roomsPage.backToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();

		if (url.equals("https://www.messenger.com/") && title.equals("Messenger")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void verifyHelpCenterButton() {
		roomsPage.openHelpCenterPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://www.messenger.com/help");
		Assert.assertEquals( title,"Messenger Help Centre");
//		if (url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre")) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Fail");
//		}
	}

	@AfterMethod
	public void logoutApp() {
		System.out.println("Logout To App");
	}
	
	@AfterClass
	public void closeBrower() {
		driver.close();
	}
}
