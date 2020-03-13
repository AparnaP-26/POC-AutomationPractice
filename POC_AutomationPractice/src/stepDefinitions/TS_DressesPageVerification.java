/* 
 * ClassName: TS_DressesPageVerification
 * Version information: Version 1.0
 * Created Month-Year: March 2020
 * Last Updated Date: March 2020
 * Created by: Aparna A
 */

//package details
package stepDefinitions;

import java.io.IOException;

//import statements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//class 
public class TS_DressesPageVerification {
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

	// step definitions
	@Test(priority = 0)
	@Given("^the user has opened the application successfully$")
	public void the_user_has_opened_the_application_successfully() throws InterruptedException {
		driver.findElement(By.cssSelector(".logo")).isDisplayed();
	}

	@Test(priority = 1)
	@When("^navigated to Summer Dresses page$")
	public void navigated_to_Summer_Dresses_page() throws InterruptedException {
		Thread.sleep(1800);
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#categories_block_left > div > ul > li.last > a")).click();
		Thread.sleep(1500);
	}

	@Test(priority = 2)
	@Then("^user is displayed with Summer Dresses page$")
	public void user_is_displayed_with_Summer_Dresses_page() throws InterruptedException {
		String sAct_PageText = driver.findElement(By.cssSelector(".page-heading")).getText();
		String sExp_PageText = "SUMMER DRESSES";
		if (sAct_PageText.toUpperCase().contains(sExp_PageText.toUpperCase())) {
			Reporter.log("User is in Summer Dresses page");
		} else {
			Reporter.log("User is not in Summer Dresses page");
		}
	}

	@Test(priority = 3)
	@When("^user clicks on Size filter$")
	public void user_clicks_on_Size_filter() throws InterruptedException {
		driver.findElement(By.cssSelector("#layered_id_attribute_group_1")).click();
		String sActPageLoad_Text = driver
				.findElement(By.cssSelector(".product_list > p:nth-child(1) > img:nth-child(1)")).getText();
		String sExpPageLoad_Text = "Loading";
		if (sActPageLoad_Text.toUpperCase().contains(sExpPageLoad_Text.toUpperCase())) {
			Reporter.log("Filter result cannot be verified as page is refreshing");
		} else {
			Reporter.log("Page refresh is not complete");
		}
	}

	@Test(priority = 4)
	@When("^user clicks on sorting with price condition$")
	public void user_clicks_on_sorting_with_price_condition() throws InterruptedException {
		Select drop_Sortvalues = new Select(driver.findElement(By.cssSelector("#selectProductSort")));
		drop_Sortvalues.selectByValue("price:asc");
		Thread.sleep(1000);
		String sActPageLoad_Text = driver
				.findElement(By.cssSelector(".product_list > p:nth-child(1) > img:nth-child(1)")).getText();
		String sExpPageLoad_Text = "Loading";
		if (sActPageLoad_Text.toUpperCase().contains(sExpPageLoad_Text.toUpperCase())) {
			Reporter.log("Sort result cannot be verified as page is refreshing");
		} else {
			Reporter.log("Page refresh is not complete");
		}
	}
}