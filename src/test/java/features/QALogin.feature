Feature: Login into Application


  Scenario: Positive Test for validating Login
    Given Initiate the Browser with Chrome 
    And Navigate to "QAClickAcademy" site
		And Click on Login Link in the Home Page to Land on Secure sign in page
    When user Enter "username" and "password" and logs in 
   

