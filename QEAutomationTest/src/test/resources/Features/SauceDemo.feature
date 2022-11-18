Feature: As a SwagLabs user I should be able to login,purchase and logout with valid credentials

  Scenario: Login into the application with valid credentials
  	Given I am on the Login page URL "https://www.saucedemo.com/"
  	And I should see Sign In Page username and password
    When I enter username as "standard_user" 
    And I enter password as "secret_sauce"
    And click on login button
    Then I am logged in
    And I Sort the products by Price "<sortOption>"
    Then I add the cheapest & the 2nd costliest products to your basket
    Then I Open the basket
    Then I proceed to checkout
    And I Enter details "<firstname>","<lastname>","<zipcode>" and Finish the purchase
		Then I got log out from the application and land on sign in page
   
    
    Examples:
	 | sortOption | firstname | lastname | zipcode |
	 | hilo | sauce | lab | RG12AB |