package fbDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {
	@FindBy (xpath="//a[text()='Rooms']")
	private WebElement roomsLink;
	
	@FindBy (xpath="//a[text()='Desktop app']")
	private WebElement desktopApplLimk;
	
	
	public MessengerPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void openRooms() {
		roomsLink.click();
	}
	
	public void openDesktopApp() {
		desktopApplLimk.click();
	}
}
