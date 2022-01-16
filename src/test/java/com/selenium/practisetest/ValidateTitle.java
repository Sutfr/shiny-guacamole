package com.selenium.practisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {

	
	 private static Logger log =LogManager.getLogger(ValidateTitle.class.getName());
	
	
	@BeforeTest
	public void initalize() throws Exception {
		driver = initializeDriver();
		log.info("Driver is initalized");
	}

	@Test
	public void basePageNavigation() throws Exception {


		driver.get(prop.getProperty("url"));
		log.info("Navigated to the URL");
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully Validated Text Message");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
