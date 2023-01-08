package angel.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import angel.Constants.Constants;
import angel.Page_Objects.DirectoryPage;
import angel.Page_Objects.HomePage;
import angel.Page_Objects.LoginPage;
import angel.Page_Objects.Timesheets;
import angel_step_deinition.Common_step_Definition;
import angel_webdriver_manager.DriverManager;

public class CommonUtilities {
	
	//Implementing SingleTon Method
	
	private static CommonUtilities commonVarInstance=null;
	
	private CommonUtilities() {
		
	}
	
	public static CommonUtilities CommonGetInstance() {
		
		if (commonVarInstance== null) {
		commonVarInstance = new CommonUtilities();
		}
		return commonVarInstance;
	}
	
//Utility for loading the properties
	
	public void loadProperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.Browser = properties.getProperty("BROWSER");
		Constants.UserName = properties.getProperty("UserName");
		Constants.Password = properties.getProperty("Password");
		Constants.chrome_driver_location = properties.getProperty("chrome_driver_location");
		Constants.Firefox_driver_locatoin = properties.getProperty("Firefox_driver_locatoin");
		Constants.IE_driver_location = properties.getProperty("IE_driver_location");
		Constants.Edge_driver_location = properties.getProperty("Edge_driver_location");
	}

//Utility for setting the webElements
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.LoginGetInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.HomegetInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.DirectoryGetInstance());
		PageFactory.initElements(DriverManager.getDriver(), Timesheets.timeGetInstance());
	}

//Utility for Taking Screenshot
	public void takeScreenShot() {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
			File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);

			File destinationfile = new File("E://"+Common_step_Definition.getScnearioName()+".png");
			FileUtils.copyFile(sourcefile, destinationfile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Utility for Highlighting the Interacting WebElements
	
	public void highLightWebElement(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style', 'border: 3px solid green')", element);
	}

}
