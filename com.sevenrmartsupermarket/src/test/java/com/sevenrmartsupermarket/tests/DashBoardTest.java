package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base{
	
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	
	@Test
	public void verifyText()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login();
		String actualProfileName=dashBoardPage.getProfileName();
		System.out.println(actualProfileName);
		String expectedProfileName="Admin";
		Assert.assertEquals(expectedProfileName, actualProfileName);
	}
	
	@Test(groups = "regression")
	public void verifyManagePagesCardClickable()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		String expectedText="Admin Users";
		String actualText=dashBoardPage.checkSucessNavigation();
		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void navigateToManageContentPage()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToManageContent();
		
	}
}
