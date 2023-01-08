package angel.Page_Objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {
	
	private static DirectoryPage DirectoryVarInstance;
	
	private DirectoryPage() {
		
	}

	public static DirectoryPage DirectoryGetInstance() {
		if(DirectoryVarInstance==null) {
			DirectoryVarInstance= new DirectoryPage();
		}
		return DirectoryVarInstance;
	}
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement Job_Title;
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-dropdown')]/*")
	private WebElement Job_Dropdown_list;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Search_button;
	

	@FindBy(xpath = "//p[text()='John  Smith ']")
	private WebElement CEO_NAME;


	public WebElement getJob_Title() {
		return Job_Title;
	}


	public WebElement getJob_Dropdown_list() {
		return Job_Dropdown_list;
	}


	public WebElement getSearch_button() {
		return Search_button;
	}


	public WebElement getCEO_NAME() {
		return CEO_NAME;
	}
	
	
	
	

	


}
