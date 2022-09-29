package fpkt;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTocartfpkt {
	//declaration
	WebDriver driver;
					
			@FindBy(xpath="//button[text()='GO TO CART']")
			
			private WebElement addtocart ;
			
			@FindBy(xpath="//span[text()='Place Order']")
			private WebElement orderplace ;
			
			
			//initialization
			public AddTocartfpkt(WebDriver driver) {
				PageFactory.initElements(driver, this);
				this.driver=driver;
			}
			
			
			//use
				public void addtocart() throws InterruptedException {
					Thread.sleep(3000);
					JavascriptExecutor js=(JavascriptExecutor)driver;
					  js.executeScript("arguments[0].scrollIntoView(true);",addtocart);
				    addtocart.click();
				}
				public void orderplace() {
					
					orderplace.click();
				}
				
				
			
		}



