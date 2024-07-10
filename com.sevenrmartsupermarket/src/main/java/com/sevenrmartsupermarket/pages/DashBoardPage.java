package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
public class DashBoardPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileName;
	@FindBy(xpath="//section//div[@class='container-fluid']//a")
	List<WebElement> dashBoardCards;
	@FindBy(xpath="//section//div[@class='container-fluid']//div//p")
	List<WebElement> cardNames;
 
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getProfileName() {
		return profileName.getText();

	}
	
	public void navigateToCard(String name) {
		int index=0;
		for(index=0;index<cardNames.size();index++)
		{
			String infoname=cardNames.get(index).getText();
			if(infoname.equalsIgnoreCase(name))
			{
				break;
			}
		}
		dashBoardCards.get(index).click();
	}

}
