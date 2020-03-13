/* 
 * ClassName: TS_VerifyHeader
 * Version information: Version 1.0
 * Created Month-Year: March 2020
 * Last Updated Date: March 2020
 * Created by: Aparna A
 */

//package details
package stepDefinitions;

//import statements
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//class for header verification
public class TS_VerifyHeader {
	public static WebDriver driver;
	public static String sAbs_Path = System.getProperty("user.dir");
	public static String AUT_URL;

	@BeforeClass
	public void SetUp() throws Throwable {
		System.setProperty("webdriver.chrome.driver", sAbs_Path + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		AUT_URL = "http://automationpractice.com/index.php";
		driver.get(AUT_URL);
		Thread.sleep(1500);
	}

	@AfterClass
	public void cleanUp() throws IOException {
		driver.close();
	}

	// Steps Definitions
	@Test(priority = 0)
	@Given("^the user logs into the application$")
	public void the_user_logs_into_the_application() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")).isDisplayed();
	}

	@Test(priority = 1)
	@When("^user navigates to Women tab$")
	public void user_navigates_to_Women_tab() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	@Then("^verify the header of the page is Women$")
	public void verify_the_header_of_the_page_is_Women() {
		String sAct_Header_text1 = driver.findElement(By.cssSelector(".content_scene_cat_bg")).getText();
		String sExp_Header_Text1 = "Women";
		if (sAct_Header_text1.toUpperCase().contains(sExp_Header_Text1.toUpperCase())) {
			Reporter.log("The header of the navigated page is WOMEN");
		} else {
			Reporter.log("The header of the navigated page is not WOMEN");

		}
	}

	@Test(priority = 3)
	@When("^user navigates to Dresses tab$")
	public void user_navigates_to_Dresses_tab() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	@Then("^verify the header of the page is DRESSES$")
	public void verify_the_header_of_the_page_is_DRESSES() {
		String sAct_Header_text2 = driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/h2")).getText();
		String sExp_Header_Text2 = "DRESSES";
		if (sAct_Header_text2.toUpperCase().contains(sExp_Header_Text2.toUpperCase())) {
			Reporter.log("The header of the navigated page is DRESSES");
		} else {
			Reporter.log("The header of the navigated page is not DRESSES");
		}
	}

	@Test(priority = 5)
	@When("^user navigates to shopping cart$")
	public void user_navigates_to_shopping_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	@Then("^verify the header of the page is cart$")
	public void verify_the_header_of_the_page_is_cart() {
		String sAct_Header_text3 = driver.findElement(By.cssSelector("#cart_title")).getText();
		String sExp_Header_Text3 = "SHOPPING-CART";
		if (sAct_Header_text3.toUpperCase().contains(sExp_Header_Text3.toUpperCase())) {
			Reporter.log("The header of the navigated page is Shopping Cart");
		} else {
			Reporter.log("The header of the navigated page is not Shopping Cart");
		}
	}
}