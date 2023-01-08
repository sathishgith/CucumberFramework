package angel_step_deinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import angel.Page_Objects.HomePage;
import angel.Page_Objects.Timesheets;
import angel.Utilities.CommonUtilities;
import angel_webdriver_manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPendingTimesheet_Step_Def {
	static Logger logger = Logger.getLogger(Common_step_Definition.class);

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {

		try {

			HomePage.HomegetInstance().getDashboard().click();

			String dashBoardUrl = DriverManager.getDriver().getCurrentUrl();

			if (dashBoardUrl.contains("dashboard")) {
				logger.info("User is on the homepage and verified successfully");

			}

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@When("the user clicks on the time option from  the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		try {

			HomePage.HomegetInstance().getTimesheet().click();

		} catch (Exception e) {
			logger.info(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}

	}

	@And("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String name) {

		try {

			Timesheets.timeGetInstance().getEmpEditBox().click();
			Timesheets.timeGetInstance().getEnterText().sendKeys(name);

			Actions actions = new Actions(DriverManager.getDriver());
			actions.keyDown(Keys.ARROW_DOWN).click(Timesheets.timeGetInstance().getDdList()).build().perform();

			logger.info("User has selected the search name from the emp Name dropdown");

		} catch (Exception e) {
			logger.info(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@And("clicks on the view button")
	public void clicks_on_the_view_button() {

		try {

			Timesheets.timeGetInstance().getViewButton().click();
			logger.info("User has clicked the view button sucessfully");
		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {

		try {

			String actualMessage = Timesheets.timeGetInstance().getActMessage().getText();

			if (actualMessage.equalsIgnoreCase(expectedMessage)) {
				logger.info("User should see the message as No timesheets found");
			}

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

}
