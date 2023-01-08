package angel_step_deinition;

import org.apache.log4j.Logger;

import angel.Constants.Constants;
import angel.Page_Objects.LoginPage;
import angel.Utilities.CommonUtilities;
import angel_webdriver_manager.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_step_Definition {
	
	private static String scnearioName=null;
	
	public static String getScnearioName() {
		return scnearioName;
	}

	static Logger logger = Logger.getLogger(Common_step_Definition.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		logger.info("Execution Statred");

		try {
			 scnearioName =scenario.getName();
			logger.info("Instantiation the CommonUtils");
			logger.info("Loading the Properties file");
			CommonUtilities.CommonGetInstance().loadProperties();
			logger.info("Checking whether driver is null");
			if (DriverManager.getDriver() == null) {
				DriverManager.launchbroser();
				CommonUtilities.CommonGetInstance().initWebElements();
				login();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void login() {

		DriverManager.getDriver().get(Constants.APP_URL);

		
       // CommonUtilities.CommonGetInstance().highLightWebElement(LoginPage.LoginGetInstance().getUSERNAME());
		//DriverManager.getDriver().findElement(LoginPage.LoginGetInstance().USERNAME);
		LoginPage.LoginGetInstance().enterUsername(Constants.UserName);
		//getUSERNAME().sendKeys(Constants.UserName);
		
		/*LoginPage.LoginGetInstance().getPASSWORD().sendKeys(Constants.Password);
		LoginPage.LoginGetInstance().getLOGIN_BUTTON().click();
	}*/

	}
	}
