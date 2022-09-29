package fbDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
			@FindBy (xpath="//input[@type='text']")
			private WebElement userName;
			
			@FindBy (xpath="//input[@type='password']")
			private WebElement password;
			
			@FindBy (xpath="//button[@value='1']")
			private WebElement logInButton;
			
			@FindBy (xpath="//a[text()='Messenger']")
			private WebElement messengerLink;
			
			//Initialisation
			public LoginPage(WebDriver driver) {//driven122=driver==new ChromeDriver()
				
				PageFactory.initElements(driver, this);
			}
			
			//use
			
			
			public void sendUserName() {
				userName.sendKeys("7757834909");
			}
			
			public void sendPassword() {
				password.sendKeys("Ajay@123");
			}
			
			public void clickOnLogInButton() {
				logInButton.click();
			}
			
			public void openMessengerLink() {
				messengerLink.click();
			}
			
			//Or
			public void completeLogin() {
				userName.sendKeys("7757834909");
				password.sendKeys("Ajay@123");
				logInButton.click();
			}
}
