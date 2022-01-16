package com.selenium.practisetest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	@BeforeTest
	public void initalize() throws Exception {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws Exception {

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		l.getLogin().click();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		lp.getLogin().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different datatypes should run
		// column stand for how many values for each test
		Object[][] data = new Object[2][3];
		data[0][0] = "devchakraborty724@gmail.com";
		data[0][1] = "Dev@1686";
		data[0][2] = "restricteduser";

		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "457688";
		data[1][2] = "Non restricted user";
		return data;
	}

}
