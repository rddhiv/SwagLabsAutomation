package com.cucumberFramework.pageObjects;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberFramework.helper.WaitHelper;

public class SauceDemoPage{

	private WebDriver driver;

	WaitHelper waitHelper;

	public List<WebElement> col;

	public List<WebElement> rows;

	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@id='shopping_cart_container']")
	public WebElement landingPage;
	
	@FindBy(xpath="//div[@class='inventory_list']/div[@class='inventory_item'][2]//button")
	WebElement addToCartCostlyItem;
	
	@FindBy(xpath="//div[@class='inventory_list']/div[@class='inventory_item'][6]//button")
	WebElement addToCartCheapestItem;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']")
	WebElement addToBasket;
	
	@FindBy(xpath="//div[@id='checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//input[@id='first-name']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@type='last-name']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@type='postal-code']")
	public WebElement postalCode;
	
	@FindBy(xpath="//div[@id='continue']")
	public WebElement continueButton;
	
	@FindBy(xpath="//div[@id='finish']")
	public WebElement finishButton;
	
	@FindBy(xpath="//div[@id='menu_button_container']//button")
	public WebElement menuButton;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	public WebElement logoutButton;
	
	public void landingPageVerify()
	{
	
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).isDisplayed();
	}
	
	
	public void enterUserName(String userName){
		
	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
	}
	
	public void enterPassword(String password){
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	}
	
	public void clickLoginButton(){
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	
	public void verifyUsernamefield(){
		WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.isDisplayed();
		driver.findElement(By.xpath("//input[@type='password']")).isDisplayed();
	}

	public SauceDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}

	public void OpenWebpage(String arg1) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(arg1);
		System.out.println("User entering the WebPage");
	}
	

	public void sortProduct(String arg1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select producthighToLow = new Select(driver.findElement(By.className("product_sort_container")));
		producthighToLow.selectByValue(arg1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("User click sort button to sort the product high to low");
	}

	

	public void addCheapestProduct()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][2]//button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='inventory_list']"))).size());
		driver.findElement(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][6]//button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	public void addToBasket(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void proceedToCheckOut() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		System.out.println("User can able to proceed for checkout");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void filltheForm(String firstname,String lastName,String postCode) 
	{
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postCode);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public void finishPurchase() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		System.out.println("User can able to finish purchase");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickLogout() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='menu_button_container']//button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("User can able to click logout and go to main page");
	}
	
	
	public void userCloseBrowser()
	{
		
		driver.quit();
		System.out.println("User close the Browser");
	}


}
