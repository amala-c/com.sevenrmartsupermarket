package com.sevenrmartsupermarket.tests;

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
		
	}
	
	@Test(groups = "regression")
	public void verifyManagePagesCardClickable()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
	}

}
