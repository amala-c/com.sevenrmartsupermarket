package com.sevenrmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Dataproviders {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "valid login")
	public Object[][] validlogin() {
		excelreader.setExcelFile("login", "Sheet1");
		return excelreader.getMultidimentionalData(2, 3);
	}

	/** For Manage Pages **/
	@DataProvider(name = "New page")
	public Object[][] newPage() {
		excelreader.setExcelFile("Manage Pages New Page", "Sheet1");
		return excelreader.getMultidimentionalData(1, 3);

	}
}