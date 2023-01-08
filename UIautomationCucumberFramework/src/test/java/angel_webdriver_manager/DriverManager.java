package angel_webdriver_manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import angel.Constants.Constants;
import angel_step_deinition.Common_step_Definition;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver=null;

	
	static Logger logger = Logger.getLogger(Common_step_Definition.class);
	public static void launchbroser() {
		// TODO Auto-generated method stub

		try {

			switch (Constants.Browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
			    logger.info("Launching" + Constants.Browser);
				driver = new ChromeDriver();

				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching" + Constants.Browser);
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				logger.info("Launching" + Constants.Browser);
				driver = new InternetExplorerDriver();
				break;

			default:
				WebDriverManager.edgedriver().setup();
				logger.info("Launching" + Constants.Browser);
				driver = new EdgeDriver();
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	

}
	public static WebDriver getDriver() {
		return driver;
	}
}