package StepDefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.SauceDemoPage;
import io.cucumber.java.en.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.testBase.TestBase;

public class SauceDemo {
	WebDriver driver = null;
	
	
	SauceDemoPage loginPage = new SauceDemoPage(driver);
	
	@Given("I am on the Login page URL {string}")
	public void i_am_on_the_login_page_url(String string) {
		loginPage.OpenWebpage(string);
	}
	
	@And("I should see Sign In Page username and password")
	public void i_should_see_sign_in_page_username_and_password() {
		loginPage.verifyUsernamefield();
		//loginPage.password.isDisplayed();
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
		loginPage.enterUserName(string);
	   
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		loginPage.enterPassword(string);
	}
	
	@When("click on login button")
	public void click_on_login_button() {
		loginPage.clickLoginButton();
	}
	
	@Then("I am logged in")
	public void i_am_logged_in() {
		loginPage.landingPageVerify();
		
	}
	
	@Then("I Sort the products by Price {string}")
	public void i_sort_the_products_by_price_high_to_low(String string) {
	    loginPage.sortProduct(string);
	}
	
	@Then("I add the cheapest & the 2nd costliest products to your basket")
	public void i_add_the_cheapest_the_2nd_costliest_products_to_your_basket() {
		loginPage.addCheapestProduct();
	}
	
	@Then("I Open the basket")
	public void i_open_the_basket() {
	   loginPage.addToBasket();
	}
	
	
	@Then("I proceed to checkout")
	public void i_proceed_to_checkout() {
	
		loginPage.proceedToCheckOut();
		
	}
	
	@Then("I Enter details {string},{string},{string} and Finish the purchase")
	public void i_enter_details_sauce_rg12ab_and_finish_the_purchase(String firstname,String lastname,String postcode) {
	    loginPage.filltheForm(firstname,lastname,postcode);
	    loginPage.finishPurchase();
	}
	
	@Then("I got log out from the application and land on sign in page")
	public void i_got_log_out_from_the_application_and_land_on_sign_in_page() {
		loginPage.clickLogout();
		loginPage.userCloseBrowser();
		    
	}

	
}
