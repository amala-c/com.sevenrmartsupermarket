package com.sevenrmartsupermarket.pages;

import org.checkerframework.framework.qual.FieldInvariant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManagePagesPage {
	WebDriver driver;
	public ManagePagesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtility generalUtility=new GeneralUtility();
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonTobBar;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement titleText;
	@FindBy(xpath="//h4[@class='card-title']")
	WebElement pageTitleText; 
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath="//input[@id='page']")
	WebElement pageField;
	@FindBy(xpath="//div[@role='textbox']//p//br")
	WebElement descriptionField;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	public void expandSearchTab() 
	{
		searchButtonTobBar.click();
	}
	 public void enterTextFieldValue(String TitletextField)
	 {
		 titleText.sendKeys(TitletextField);
	 }
	 public void clickOnSearchButton()
	 {
		 searchButton.click();
	 }
	 public void searchEnteredPage(String TtextField) {
		 expandSearchTab();
		 enterTextFieldValue(TtextField);
		 clickOnSearchButton(); 
	 }
	
	 public boolean checkSucessByText(String expectedText)
	 {
		 return generalUtility.is_TextPresent(pageTitleText, expectedText);
	 }
	 
	 public void clickOnNewButton()
	 {
		 newButton.click();
	 }
	 public void enterTitleFieldValue(String TitleFieldValue)
	 {
		 titleField.sendKeys(TitleFieldValue);
	 }
	 public void enterDescriptionvalue(String descriptionFieldValue)
	 {
		 descriptionField.sendKeys(descriptionFieldValue);
	 }
	 
	 public void enterPageFieldValue(String pageFieldValue)
	 {
		 pageField.sendKeys(pageFieldValue);
	 }
	 public void  clickOnSaveButton()
	 {
		 saveButton.click();
	 }
	 
	public void createNewPage(String TitleNewFieldValue ,String pageNewFieldValue , String descriptionNewFieldValue )
	{
		clickOnNewButton();
		enterTextFieldValue(TitleNewFieldValue);
		enterDescriptionvalue(descriptionNewFieldValue);
		enterPageFieldValue(pageNewFieldValue);
		clickOnSaveButton();
	}
	
	 public boolean checkNewpageSucessByAlert(String expectedAlertMessage)
	 {
		 return generalUtility.is_TextPresent(alertText, expectedAlertMessage);
	 }
}
