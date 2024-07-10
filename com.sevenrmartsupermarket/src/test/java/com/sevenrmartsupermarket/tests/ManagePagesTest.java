package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	AdminUserPage adminuserpage;
	ManagePagesTest managepagestest;
	
	@Test
	public void navigate() {
		loginpage=new LoginPage(driver);
		dashBoardPage=new DashBoardPage(driver);
		loginpage.login();
		dashBoardPage.navigateToCard("Manage Pages");
	}
	
	
}
