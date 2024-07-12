package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManagePagesPage;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	AdminUserPage adminuserpage;
	ManagePagesPage managepagespages;
	
	@Test
	public void navigate() {
		loginpage=new LoginPage(driver);
		dashBoardPage=new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Manage Pages");
	}
	
	@Test
	public void searchTitle()
	{
		loginpage=new LoginPage(driver);
		dashBoardPage=new DashBoardPage(driver);
		managepagespages=new ManagePagesPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Manage Pages");
		managepagespages.searchEnteredPage("Preethi");
		boolean actualText=managepagespages.checkSucessByText("Search List Pages");
		assertTrue(actualText);
	}
	
	
	
}
