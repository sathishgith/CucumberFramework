package angel.Page_Objects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import angel.Constants.Constants;
import angel_step_deinition.Common_step_Definition;
import angel_webdriver_manager.DriverManager;


public class LoginPage {
	
private static LoginPage LoginVarInstance;

private LoginPage() {
	
}
public static LoginPage LoginGetInstance() {
	
	if (LoginVarInstance==null) {
		LoginVarInstance = new LoginPage();

	}
	return LoginVarInstance;
	
	
}
static Logger logger = Logger.getLogger(Common_step_Definition.class);
WebDriver driver = DriverManager.getDriver();
	/*
	 * //Using PageObjects
	 * 
	 * @FindBy(xpath="//input[@name='username']") private WebElement USERNAME;
	 * 
	 * @FindBy(name = "password") private WebElement PASSWORD;
	 * 
	 * @FindBy(xpath = "//button[@type='submit']") private WebElement LOGIN_BUTTON
	 */;
	
	/*
	 * public WebElement getUSERNAME() { return USERNAME; }
	 * 
	 * public WebElement getPASSWORD() { return PASSWORD; } public WebElement
	 * getLOGIN_BUTTON() { return LOGIN_BUTTON; }
	 */
	 
	 //Using By Locator
	public By  USERNAME = By.xpath("//input[@name='username']");
		
		public void enterUsername(String UserName) {
			try {
				driver.findElement(USERNAME).sendKeys(UserName);
				
			} catch (Exception e) {
	logger.info("element has not found , so excpetion handling in the next step");
	try {
	

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(USERNAME));
	} 
	catch (Exception e2) {
		logger.info("Locator is still not identified");
	}
			}
			
			
		}
		
		
		

}
