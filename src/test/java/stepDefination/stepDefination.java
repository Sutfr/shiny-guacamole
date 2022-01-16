package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class stepDefination extends Base {

	@Given("^Initiate the Browser with Chrome$")
	public void initiate_the_Browser_with_Chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"(.*?)\" site$")
	public void navigate_to_site(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(prop.getProperty("url"));
	 
	}

	@Given("^Click on Login Link in the Home Page to Land on Secure sign in page$")
	public void click_on_Login_Link_in_the_Home_Page_to_Land_on_Secure_sign_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		l.getLogin().click();

	 
	}

	@When("^user Enter \"(.*?)\" and \"(.*?)\" and logs in$")
	public void user_Enter_and_and_logs_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(arg1);
		lp.getPassword().sendKeys(arg2);
		
		lp.getLogin().click();
	 
	}
	
	
	
}
