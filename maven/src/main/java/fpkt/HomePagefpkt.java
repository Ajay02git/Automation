package fpkt;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagefpkt{
	WebDriver driver;
	//declaration
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement login;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchbar ;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchbutton ;
	
	@FindBy(xpath="//div[text()='realme C35 (Glowing Black, 64 GB)']")
	private WebElement mobile;
	
	
	//initialization
	public HomePagefpkt(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
//use
	public void sendDataInSearchBar() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchbar));
		
		searchbar.sendKeys("realme mobile");
		
	}
		public void searchmobile() {
			
			
			WebDriverWait wait1=new WebDriverWait(driver,10);
			wait1.until(ExpectedConditions.visibilityOf(searchbutton));
			searchbutton.click();
			  
		//	mobile.click();
		}
		
		public void clickOnMobile() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click(true);",mobile);
		}
	}

