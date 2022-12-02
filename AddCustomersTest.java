import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomersTest {

	//Declaration of the object webdriver
	public static WebDriver driver = null;
	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		preConditionLogin();
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.close();
		//driver.quit();
		
	}
	
	
	public static void preConditionLogin() throws InterruptedException {
		
		//Open the URL
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Closing the Iframe with GDPR Consent
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(2000);
		
		//Enter the userID
		driver.findElement(By.name("uid")).sendKeys("mngr459119");
		
		//Enter the password
		driver.findElement(By.name("password")).sendKeys("AqEnubY");
		
		//Click on login
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	@Test
	@DisplayName("Check results on entering a valid information for all fields")
	public void tc004() throws InterruptedException {
		
		
		//click on New Customer
		//driver.findElement(By.linkText("New Customer")).click();
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		driver.findElement(By.name("name")).sendKeys(TestData.customerName);
		
		if(TestData.gender.equals("male")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)")).click();
			
		} else if(TestData.gender.equals("female")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)")).click();
		}
		
		//Enter DOB
		driver.findElement(By.id("dob")).sendKeys(TestData.dateOfbirth);
		
		//Enter address
		driver.findElement(By.name("addr")).sendKeys(TestData.address);
		
		//Enter city
		driver.findElement(By.name("city")).sendKeys(TestData.city);
		
		//Enter state
		driver.findElement(By.name("state")).sendKeys(TestData.state);
		
		//Enter PIN
		driver.findElement(By.name("pinno")).sendKeys(TestData.pin.toString());
		
		//Enter Mobile Number
		driver.findElement(By.name("telephoneno")).sendKeys(TestData.mobileNumber);
		
		//Enter email
		driver.findElement(By.name("emailid")).sendKeys(TestData.email);
		
		//Enter password
		driver.findElement(By.name("password")).sendKeys(TestData.customerPassword);
		
		//Click on submit
		driver.findElement(By.name("sub")).click();
		
		//Check the message: Customer created successfully 
		String actualResults = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
		String expectedResults = "Customer Registered Successfully!!!";
		
		assertEquals(expectedResults,actualResults);
		
		//Check Customer Name
		actualResults = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
		assertEquals(TestData.customerName, actualResults);
		
		//Check Gender
		assertEquals(TestData.gender, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)")).getText());
		
		//Check DOB
		assertEquals(TestData.expectedDOB, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText());
		
		//CheckEmail
		assertEquals(TestData.email, driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]")).getText());
		
		
		
	}
	
	@Test
	public void tc005() throws InterruptedException {
		
		
	}
	
	@Test 
	public void tc006() throws InterruptedException {
		
		
	}
	
	
}
