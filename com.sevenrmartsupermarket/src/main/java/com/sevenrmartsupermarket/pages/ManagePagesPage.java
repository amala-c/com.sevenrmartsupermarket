package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.framework.qual.FieldInvariant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManagePagesPage {
	WebDriver driver;
	JavascriptExecutor js;

	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtility generalUtility = new GeneralUtility();
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonTobBar;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement titleText;
	@FindBy(xpath = "//h4[@class='card-title']")
	private WebElement pageTitleText;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleField;
	@FindBy(xpath = "//input[@id='page']")
	private WebElement pageField;
	@FindBy(xpath = "//div[@role='textbox']//p//br")
	private WebElement descriptionField;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUpload;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertText;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> pageTable;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlertText;

	public void expandSearchTab() {
		searchButtonTobBar.click();
	}

	public void enterTextFieldValue(String TitletextField) {
		titleText.sendKeys(TitletextField);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void searchEnteredPage(String TtextField) {
		expandSearchTab();
		enterTextFieldValue(TtextField);
		clickOnSearchButton();
	}

	public boolean checkSucessByText(String expectedText) {
		return generalUtility.is_TextPresent(pageTitleText, expectedText);
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterTitleFieldValue(String TitleFieldValue) {
		titleField.sendKeys(TitleFieldValue);
	}

	public void enterDescriptionvalue(String descriptionFieldValue) {
		descriptionField.sendKeys(descriptionFieldValue);
	}

	public void enterPageFieldValue(String pageFieldValue) {
		pageField.sendKeys(pageFieldValue);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void uploadimage() {
		//String path=constants.IMAGE_FILE_PATH;
		String path = "C:\\Users\\Amala Chellappan\\git\\com.sevenrmartsupermarket\\com.sevenrmartsupermarket\\src\\main\\resources\\FileUploadImages\\Screenshot 123.jpg";
		File fileobj = new File(path);
		imageUpload.sendKeys(fileobj.getAbsolutePath());
	}

	public void createNewPage(String TitleNewFieldValue, String pageNewFieldValue, String descriptionNewFieldValue)
			throws InterruptedException {
		clickOnNewButton();
		enterTextFieldValue(TitleNewFieldValue);
		enterDescriptionvalue(descriptionNewFieldValue);
		enterPageFieldValue(pageNewFieldValue);
		uploadimage();
		js.executeScript("arguments[0].scrollIntoView();", saveButton);
		Thread.sleep(5000);
		clickOnSaveButton();
	}

	public boolean checkNewpageSucessByAlert(String expectedAlertMessage) {
		return generalUtility.is_TextPresent(alertText, expectedAlertMessage);
	}

	/** Delete user from the Dynamic table **/
	public void deleteAPage(String pageName) {
		List<String> pages = new ArrayList<String>();
		pages = generalUtility.get_textOfElements(pageTable);
		// pages = generalUtility.get_textOfElements(pageTable);
		int index = 0;
		for (index = 0; index < pages.size(); index++) {
			if (pages.get(index).equals(pageName)) {
				index++;
				break;
			}
		}
		WebElement pageDeleteButton = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + index
						+ "]//td[5]//a[@class='btn btn-sm btn btn-danger btncss']"));
		pageDeleteButton.click();
		driver.switchTo().alert().accept();
	}

	public boolean checkDeletepageSucessByAlert(String expectedDeleteAlertMessage) {
		return generalUtility.is_TextPresent(deleteAlertText, expectedDeleteAlertMessage);
	}

}
