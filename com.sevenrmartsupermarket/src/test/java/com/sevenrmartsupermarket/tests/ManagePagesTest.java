package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataproviders.Dataproviders;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManagePagesPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	AdminUserPage adminuserpage;
	ManagePagesPage managepagespages;
	ExcelReader excelreader=new ExcelReader();
	
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
		managepagespages.searchEnteredPage("SampleTEstData");
		boolean actualText=managepagespages.checkSucessByText("Search List Pages");
		assertTrue(actualText);
	}
	
	@Test(dataProvider = "New page", dataProviderClass = Dataproviders.class)
	public void newPage(String newText, String newPage, String newDescription)
	{
		loginpage=new LoginPage(driver);
		dashBoardPage=new DashBoardPage(driver);
		managepagespages=new ManagePagesPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Manage Pages");
		managepagespages.createNewPage(newText,newPage,newDescription);
        driver.navigate().back();
		boolean actualAlertText=managepagespages.checkNewpageSucessByAlert("Page Created Successfully");
		assertTrue(actualAlertText);
		
	}
	
}
