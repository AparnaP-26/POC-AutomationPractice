/* 
* ClassName: TS_CheckOut_Journey
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//class definition
public class TS_CheckOut_Journey {
	public static WebDriver driver;
	public static String sAbs_Path = System.getProperty("user.dir");
	public static String AUT_URL;

	@BeforeClass
	public void setUp() throws Throwable {
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

	// Step definitions
	@Test(priority = 0)
	@Given("^the user has launched the application successfully$")
	public void the_user_has_launched_the_application_successfully() throws InterruptedException {
		driver.findElement(By.cssSelector(".logo")).isDisplayed();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	@When("^user added a product to the cart$")
	public void user_added_a_product_to_the_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#categories_block_left > div > ul > li.last > a")).click();
		Thread.sleep(1500);

		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"));
		actions.moveToElement(target).perform();

		driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	@When("^user clicks on Checkout option$")
	public void user_clicks_on_Checkout_option() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	@Then("^user is displayed with Authentication page$")
	public void user_is_displayed_with_Authentication_page() throws InterruptedException {
		String sAct_Header_Text = driver.findElement(By.xpath("//*[@id='SubmitCreate']")).getText();
		String sExp_Header_Text = "account";
		if (sAct_Header_Text.toUpperCase().contains(sExp_Header_Text.toUpperCase())) {
			Reporter.log("Checkout complete and user moved to Authentication section");
		} else {
			Reporter.log("Checkout is not complete");

		}
	}
}
