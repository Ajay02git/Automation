package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fb.FindFriend;
import fb.Loginfb;
import fb.Messagefb;

public class TestFacebook {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    
	   driver.get("https://www.facebook.com/");
	   
	   Loginfb loginfb=new Loginfb(driver);
	   loginfb.Loginpage();
	   
	   FindFriend Findfriend=new FindFriend(driver);
	   Findfriend.findfriend();
	   
	   Messagefb message=new Messagefb(driver);
	   message.sendmsg();
}
}