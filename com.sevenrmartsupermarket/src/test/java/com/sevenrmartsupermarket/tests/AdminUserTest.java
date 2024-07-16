package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {

	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	AdminUserPage adminuserpage;

	@Test
	public void createAdminUser() {
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		adminuserpage.clickOnNewButton();
		String userName="Amala "+GeneralUtility.get_randomFirstName();
		adminuserpage.createNewUser(userName,"amala","admin");
		String actualAlertMessage = adminuserpage.alertMessageChecks();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage ="Alert!";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		
	}

	@Test(groups = "regression")
	public void resetAdminUserDetails() {
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		adminuserpage.clickOnNewButton();
		adminuserpage.resetUserDetails("Amala", "amala", "admin");
		adminuserpage.resetEnteredUserDetails();
		String expectedPageHeading="Admin Users";
		String actualPageHeading=adminuserpage.getPagetagName();
		System.out.println(actualPageHeading);
		Assert.assertTrue(actualPageHeading.contains(expectedPageHeading));
		
	}
	
	@Test
	public void searchAdminUser()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		adminuserpage.clickOnSearchAdminUserButton("Amala","admin");
		String actualRowText=adminuserpage.searchSucessCheck();
		System.out.println(actualRowText);
		String expectedRowText="Amala";
		Assert.assertTrue(actualRowText.contains(expectedRowText));
		
	}

	@Test
	public void deleteSelectedUser()
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		adminuserpage.deleteAUser("Amala");
		String actualAlertMessage = adminuserpage.alertMessageChecks();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage ="Alert!";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		
	}
	@Test
	public void navigateToNextpage() throws InterruptedException
	{
		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Admin Users");
		adminuserpage.navigateToNextPages();
	}
}
