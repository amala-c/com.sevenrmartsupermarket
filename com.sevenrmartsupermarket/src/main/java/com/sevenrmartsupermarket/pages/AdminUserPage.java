package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	/** WebElements **/
	@FindBy(xpath = " //a[contains(text(),'New')]")
	private WebElement newUser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypedropdown;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButton;
	@FindBy(xpath = "(//a[contains(text(),'Reset')])[3]")
	private WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//a[contains(text(),' Search')]")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id=\"un\"]")
	private WebElement searchUserName;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchUsersButton;
	@FindBy(xpath="//table//tbody//tr//td[1]")
	private WebElement searchTableRow;
	@FindBy(xpath ="//h1[@class='m-0 text-dark']")
	private WebElement pageHeading;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> tableNames;

	PageUtility pageutility = new PageUtility(driver);
	GeneralUtility generalutility=new GeneralUtility();
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewButton() {
		newUser.click();
	}

	public void enterNewUsername(String newUserName) {

		userName.sendKeys(newUserName);
	}

	public void enterNewUserPassword(String newPassword) {
		password.sendKeys(newPassword);
	}

	public void selectUserType(String dropdownValue) {
		pageutility.select_Value(userTypedropdown, dropdownValue);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void createNewUser(String newUserName,String newPassword,String dropdownValue)
	{
		enterNewUsername(newUserName);
		enterNewUserPassword(newPassword);
		selectUserType(dropdownValue);
		clickOnSaveButton();
		
	}
 /**reset button operations**/
	public void resetUserDetails(String UserName ,String Password,String dropdownValue )
	{
		enterNewUsername(UserName);
		enterNewUserPassword(Password);
		selectUserType(dropdownValue);
	}
	public void resetEnteredUserDetails() {
		resetButton.click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void enterUserNameToBeSearched(String searchUserNameValue) {
		searchUserName.sendKeys(searchUserNameValue);
	}

	public void searchUserTypeSelect(String userTypeValue) {
		pageutility.select_Value(searchUserTypeDropDown, userTypeValue);
	}

	public void clickOnSearchAdminUserButton(String searchUserNameValue, String userTypeValue) {
		searchButton.click();
		enterUserNameToBeSearched(searchUserNameValue);
		searchUserTypeSelect(userTypeValue);
		searchUsersButton.click();
	}
	
	public String searchSucessCheck()
	{
		return searchTableRow.getText();
	}
	
	/**user creation success**/
	public String alertMessageChecks() {
		return alertMessage.getText();
	}

	
	/** Delete user from the Dynamic table **/
	public void deleteAUser(String userName) {
	    List<String> names = new ArrayList<String>();
	    names = generalutility.get_textOfElements(tableNames);
	    int index = 0;
	    for (index = 0; index < names.size(); index++) {
	      if (names.get(index).equals(userName)) {
	        index++;
	        break;
	      }
	    }
	    WebElement tDeleteButton = driver
	        .findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + index
	            + "]//td[5]//a[@class='btn btn-sm btn btn-danger btncss']"));
	    tDeleteButton.click();
	    driver.switchTo().alert().accept();
	  }
	
	public String getPagetagName()
	{
		return pageHeading.getText();
		
		
	}
}
