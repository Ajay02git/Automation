package fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messagefb {
	//declaration

	
	@FindBy(xpath="//span[text()='Message']")
    private WebElement chat;	
    
    @FindBy(xpath="//p[@class='m8h3af8h kjdc1dyq']")
    private WebElement msg;	
    
    @FindBy(xpath="//div[@aria-label='Press enter to send']")
    private WebElement clickmsg;
    
	//initialization
	public Messagefb(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//use

		public void sendmsg() throws InterruptedException {
			
			chat.click();
			msg.sendKeys("hello");
			clickmsg.click();


		}			

}


