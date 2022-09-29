package fb;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFriend {
	//declaration
		
			
			@FindBy(xpath="(//div[@aria-hidden='false'])[1]")
			private WebElement search;
			
			@FindBy(xpath="//input[@dir='ltr']")
			private WebElement friend;
			
			@FindBy(xpath="//span[text()='Dnyaneshwar Avhade (Dnyanu)']")
			private WebElement clickfriend;
			
			//initialization
		       public FindFriend(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//use
				public void findfriend() throws InterruptedException {
					search.click();
					Thread.sleep(3000);
					friend.sendKeys("dnyaneshwar avhade");
					friend.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					clickfriend.click();
	

				}			
	
}
