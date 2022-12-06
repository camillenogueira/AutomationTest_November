import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Scenario - Add Account")
public class AddAccountTest {

	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
		TestData.preConditionLogin();
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.close();
		//TestData.driver.quit();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("Check results on entering a valid information for all fields for Savings Account")
	public void tc013() throws InterruptedException, IOException {
		
		//Click on the Link to add a new Account
		TestData.driver.findElement(By.linkText("New Account")).click();
		//Go directly to the URL
		TestData.driver.get("https://demo.guru99.com/v4/manager/addAccount.php");
		
		
		//Enter a valid Customer ID
		//WebDriverWait wait = new WebDriverWait(null, null);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));
		//element.click();
		Thread.sleep(1000);
		String customerID = TestData.createCustomer();
		TestData.driver.findElement(By.name("cusid")).sendKeys(customerID);
		
		//Change account type to Savings
		WebElement mySelectedElement = TestData.driver.findElement(By.name("selaccount"));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByVisibleText("Savings");
		//dropdown.selectByValue("Savings");
		//dropdown.selectByIndex(0);

		//Add an initial deposit
		TestData.driver.findElement(By.name("inideposit")).sendKeys("1000");
		
		//Click on submit
		TestData.driver.findElement(By.name("button2")).click();
		
		//Check the expected Results
		String expectedResults = "Account Generated Successfully!!!";
		String actualResults = TestData.driver.findElement(By.cssSelector("#account > tbody > tr:nth-child(1) > td > p")).getText();
		assertEquals(expectedResults, actualResults);
		
		//Check CustomerID
		//Check AccountID
		// Check all the information
		
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/camillenogueira/Downloads/addAccountTC0013.jpg"));

	}
	
	
	
	
	
	
	
	
	
	
}
