package fpkt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginfpkt {

	//declaration
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement login;
	
	//initialization
	public Loginfpkt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//use
	public void SendUserName(String user){
	//	username.sendKeys("7757834909");
		username.sendKeys(user);
	}
		
		public void Sendpassword(String pass){
			//password.sendKeys("Ajay@123");
			password.sendKeys(pass);
		}
		
		public void clickbutton() {
			login.click();
		}
		
		//or
		public void Loginpage() {
			username.sendKeys("7757834909");
			password.sendKeys("Ajay@123");
			login.click();
		}
		
		
	
}
