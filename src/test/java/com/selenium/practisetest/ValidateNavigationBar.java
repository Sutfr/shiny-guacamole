package com.selenium.practisetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base {

	@BeforeTest
	public void initialize() throws Exception {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws Exception {

		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationbar().isDisplayed());

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
