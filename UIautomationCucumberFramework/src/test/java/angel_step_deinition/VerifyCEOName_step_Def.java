package angel_step_deinition;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;

import angel.Constants.Constants;
import angel.Page_Objects.DirectoryPage;
import angel.Page_Objects.HomePage;
import angel.Page_Objects.LoginPage;
import angel.Utilities.CommonUtilities;
import angel_webdriver_manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEOName_step_Def {

	static Logger logger = Logger.getLogger(Common_step_Definition.class);

	@Given("the user is logged in successfully and is on Home Page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {

		try {
			String homePageUrl = DriverManager.getDriver().getCurrentUrl();

			if (homePageUrl.contains("dashboard")) {
				logger.info("User is logged on the Home Page successfully ");
			}

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}

	}

	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {

		try {

			HomePage.HomegetInstance().getDirectory().click();
			logger.info("user clicks on the directory option from the Menu Bar");

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@And("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String role) {
		try {

			DriverManager.getDriver().manage().window().maximize();
			DirectoryPage.DirectoryGetInstance().getJob_Title().click();

			List<WebElement> dLists = DriverManager.getDriver()
					.findElements(By.xpath("//div[contains(@class,'oxd-select-dropdown')]/*"));
			for (WebElement dropdownLists : dLists) {

				if (dropdownLists.getText().contains(role)) {
					dropdownLists.click();
					return;

				}
			}

			logger.info("the user selects the job title as chief executive officer  from the drop down");

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@And("clicks the search button")
	public void clicks_the_search_button() {

		try {

			DirectoryPage.DirectoryGetInstance().getSearch_button().click();

			logger.info("user clicks the search button");

		} catch (Exception e) {
			logger.error(e);
			CommonUtilities.CommonGetInstance().takeScreenShot();
		}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) {

		try {

			String actualName = DirectoryPage.DirectoryGetInstance().getCEO_NAME().getText();

			if (actualName.equalsIgnoreCase(expectedName)) {
				logger.info("the user should see the CEO name as John Smith");
				System.out.println("the user should see the CEO name as John Smith");

			} else
				logger.info("User has not seen he expected name ");
		}

		catch (NoSuchElementException e) {
			CommonUtilities.CommonGetInstance().takeScreenShot();
			DriverManager.getDriver().close();

		}

	}

}
