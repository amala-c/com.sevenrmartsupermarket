package com.sevenrmartsupermarket.tests;

import org.jsoup.select.Evaluator.ContainsOwnText;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	ExcelReader excelreader=new ExcelReader();
	@Test(groups = {"regression","smoke"})
	public void verifyLogin() {

		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		// param are properties files values
		loginpage.login();

		loginpage.login("annamol", "12434");
		String expectedProfileName = dashBoardPage.getProfileName();
		// System.out.println(expectedProfileName);
		String actualProfileName = "Annamol";
		Assert.assertEquals(actualProfileName, expectedProfileName);


	}
	
	@Test(groups="smoke") 
	public void verifyInvalidLogin() {

		/** invalid credentials */
		loginpage=new LoginPage(driver);
		loginpage.login("amala", "12434");
		String actualAlertMessage = loginpage.invalidLogin();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage ="Alert!";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
	}

	
	@Test(groups="smoke")
	public void readFromExcel() {
		excelreader.setExcelFile("logindata", "credentials");
		String userName = excelreader.getCellData(1,0);
		String password = excelreader.getCellData(1,1);
		System.out.println(userName);
		System.out.println(password);
		loginpage=new LoginPage(driver);
		loginpage.login(userName,password);
	}
	

	@Test(groups = "regression")
	public void takeScreeshotOnfailure()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("amala", "12434");
		String actualAlertMessage = loginpage.invalidLogin();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage ="Alert!wrong wrong!";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		
	}
	
}
