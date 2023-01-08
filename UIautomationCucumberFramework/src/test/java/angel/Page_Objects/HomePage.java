package angel.Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private static HomePage HomeVarInstance;

	private HomePage() {

	}

	public static HomePage HomegetInstance() {
		if (HomeVarInstance == null) {
			HomeVarInstance = new HomePage();
		}

		return HomeVarInstance;

	}

	@FindBy(xpath = "//a[contains(@href,'directory')]")
	private WebElement Directory;

	@FindBy(xpath = "//a[contains(@href,'dashboard')]")
	private WebElement Dashboard;

	@FindBy(xpath = "//a[contains(@href,'time')]")
	private WebElement Timesheet;

	public WebElement getDashboard() {
		return Dashboard;
	}

	public WebElement getDirectory() {
		return Directory;
	}

	public WebElement getTimesheet() {
		return Timesheet;
	}

}
