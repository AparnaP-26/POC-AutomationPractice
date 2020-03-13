/* 
 * ClassName: TS_NL_Subscription
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

//class for Newsletter subscription
public class TS_NL_Subscription {
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
	@Given("^the user has launched the AUT application successfully$")
	public void the_user_has_launched_the_AUT_application_successfully() throws Throwable {
		driver.findElement(By.id("newsletter-input")).isEnabled();
	}

	@Test(priority = 1)
	@When("^user provides the email in the subscription field$")
	public void user_provides_the_email_in_the_subscription_field() throws Throwable {
		driver.findElement(By.id("newsletter-input")).sendKeys("enjoyhardin@gmail.com");
	}

	@Test(priority = 2)
	@When("^user clicks on the Subscribe button$")
	public void user_clicks_on_the_Subscribe_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(@name,'submitNewsletter')]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	@Then("^verify the user subscription is successful$")
	public void verify_the_user_subscription_is_successful() throws Throwable {
		String sExp_MessageText1 = "You have successfully subscribed to this newsletter.";
		String sExp_MessageText2 = "This email address is already registered.";
		String sAct_MessageText = driver.getPageSource();
		if (sAct_MessageText.toUpperCase().contains(sExp_MessageText1.toUpperCase())) {
			Reporter.log("Newletter subscritpion is successful!");
		} else {
			if (sAct_MessageText.toUpperCase().contains(sExp_MessageText2.toUpperCase())) {
				Reporter.log("Newsletter is already subscribed!");
			}
		}
	}
}