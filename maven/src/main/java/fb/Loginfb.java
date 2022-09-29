package fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginfb {

	//declaration
		@FindBy(xpath="//input[@type='text']")
		private WebElement username;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath="//button[@value='1']")
		private WebElement login;
		
		//initialization
		public Loginfb(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//use
		public void SendUserName(){
			username.sendKeys("7757834909");
		}
			
			public void Sendpassword(){
				password.sendKeys("Ajay@1234");
			}
			
			public void clickbutton() {
				login.click();
			}
			
			//or
			public void Loginpage() {
				username.sendKeys("7757834909");
				password.sendKeys("Ajay@1234");
				login.click();
}
}