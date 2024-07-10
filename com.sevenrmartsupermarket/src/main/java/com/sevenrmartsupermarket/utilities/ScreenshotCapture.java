package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.constants;

public class ScreenshotCapture {
	TakesScreenshot takesscreenshot;

	public void takeScreenshot(WebDriver driver, String imageName) {
		try {
			takesscreenshot = (TakesScreenshot) driver;
			File screenshot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination = constants.SCREENSHOT_FILE_PATH + imageName + "_" + timeStamp + ".png";
			File filpath = new File(destination);
			FileHandler.copy(screenshot, filpath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
