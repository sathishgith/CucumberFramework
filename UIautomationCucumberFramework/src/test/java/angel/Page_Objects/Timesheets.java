package angel.Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Timesheets {

	private static Timesheets timeVarInstance;

	private Timesheets() {

	}

	public static Timesheets timeGetInstance() {

		if (timeVarInstance == null) {
			timeVarInstance = new Timesheets();
		}
		return timeVarInstance;
	}

	@FindBy(xpath = "//div[contains(@class,'text-input ')]")
	private WebElement empEditBox;

	@FindBy(xpath = "//input[contains(@placeholder,'Type for hints')]")
	private WebElement enterText;
	
	@FindBy(xpath="//div[@role='listbox']")
	private WebElement ddList;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement viewButton;
	
	@FindBy(xpath="//p[text()='No Timesheets Found']")
	private WebElement actMessage;

	public WebElement getEmpEditBox() {
		return empEditBox;
	}

	public WebElement getEnterText() {
		return enterText;
	}

	public WebElement getViewButton() {
		return viewButton;
	}

	public WebElement getActMessage() {
		return actMessage;
	}

	public WebElement getDdList() {
		return ddList;
	}

}
