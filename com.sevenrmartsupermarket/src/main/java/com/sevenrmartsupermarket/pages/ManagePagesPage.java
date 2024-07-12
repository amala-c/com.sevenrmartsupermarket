package com.sevenrmartsupermarket.pages;

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
}
