package fbDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomPage {
	@FindBy (xpath="//a[text()=' Return to messenger.com ']")
	private WebElement returnToMessenger;
	
	@FindBy (xpath="//a[text()=' Visit our help center ']")
	private WebElement helpCenterPage;
	
	
	public RoomPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void backToMessenger() {
		returnToMessenger.click();
	}
	
	public void openHelpCenterPage() {
		helpCenterPage.click();
	}
}
