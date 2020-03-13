/* 
 * ClassName: TS_VerifyFooter
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

//class definition
public class TS_VerifyFooter {
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

	// Step Definitions
	@Test(priority = 0)
	@Given("^user is in the home page of the application$")
	public void user_is_in_the_home_page_of_the_application() throws InterruptedException {
		driver.findElement(By.cssSelector(".logo")).isDisplayed();
	}

	@Test(priority = 1)
	@Then("^social media section is displayed in the footer$")
	public void social_media_section_is_displayed_in_the_footer() throws InterruptedException {
		String sAct_Footer_1 = driver.findElement(By.cssSelector("#social_block")).getText();
		Thread.sleep(2000);
		String sExp_Footer_1 = "Follow us";
		if (sAct_Footer_1.toUpperCase().contains(sExp_Footer_1.toUpperCase())) {
			Reporter.log("Footer contains Follow us section");
		} else {
			Reporter.log("Footer does not contain Follow us section");
		}
	}

	@Test(priority = 2)
	@Then("^copyright section is displayed in the footer$")
	public void copyright_section_is_displayed_in_the_footer() throws InterruptedException {
		String sAct_Footer_2 = driver.findElement(By.cssSelector(".bottom-footer > div:nth-child(1)")).getText();
		Thread.sleep(2000);
		String sExp_Footer_2 = "© 2014 Ecommerce software";
		if (sAct_Footer_2.toUpperCase().contains(sExp_Footer_2.toUpperCase())) {
			Reporter.log("Copyright message is displayed");
		} else {
			Reporter.log("Copyright message is not displayed");
		}

	}

	@Test(priority = 3)
	@Then("^call us now section is displayed in the footer$")
	public void call_us_now_section_is_displayed_in_the_footer() throws InterruptedException {
		String sAct_Footer_3 = driver
				.findElement(
						By.cssSelector("#block_contact_infos > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2)"))
				.getText();
		Thread.sleep(2000);
		String sExp_Footer_3 = "Call us now:";
		if (sAct_Footer_3.toUpperCase().contains(sExp_Footer_3.toUpperCase())) {
			Reporter.log("Contact Info is displayed");
		} else {
			Reporter.log("Contact Info is not displayed");

		}
	}
}