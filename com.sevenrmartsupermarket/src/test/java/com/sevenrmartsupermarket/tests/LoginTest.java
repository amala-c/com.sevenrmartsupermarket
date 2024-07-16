package com.sevenrmartsupermarket.tests;

import org.jsoup.select.Evaluator.ContainsOwnText;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataproviders.Dataproviders;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;
public class LoginTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	ExcelReader excelreader=new ExcelReader();
	
	@Test(dataProvider = "valid login", dataProviderClass = Dataproviders.class )
	//(groups = {"regression","smoke"})
	public void verifyValidLogin(String username,String password , String profileName) {

		loginpage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		loginpage.login(username, password);
		String actualProfileName = "admin";
		Assert.assertEquals(actualProfileName, profileName);
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class) 
	public void verifyInvalidLogin() {

		/** invalid credentials */
		loginpage=new LoginPage(driver);
		loginpage.login("amala", "amala");
		String actualAlertMessage = loginpage.invalidLogin();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage ="Alert!";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
	}	
	@Test(groups="smoke")
	public void verifyLogin() {
		excelreader.setExcelFile("logindata", "credentials");
		String userName = excelreader.getCellData(1,0);
		String password = excelreader.getCellData(1,1);
		System.out.println(userName);
		System.out.println(password);
		loginpage=new LoginPage(driver);
		loginpage.login(userName,password);
	}

	
}
