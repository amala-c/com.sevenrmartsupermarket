package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
		public String get_attribute(WebElement element, String attribute) {
			return element.getAttribute(attribute);

		}

		public String get_cssValue(WebElement element, String attribute) {
			return element.getCssValue(attribute);
		}

		public List<String> get_textOfElements(List<WebElement> elements) {
			List<String> data = new ArrayList<String>();
			for (WebElement element : elements) {
				data.add(element.getText());
			}
			return data;
		}
		public static String get_randomFirstName()
		{
			Faker faker=new Faker();
			return faker.name().firstName();
		}
		
		public boolean is_TextPresent(WebElement element, String expectedData)
		{
			return element.getText().contains(expectedData);
		}
}
