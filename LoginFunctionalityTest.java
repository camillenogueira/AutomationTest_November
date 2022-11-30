import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Test Scenario - Login Functionality")
public class LoginFunctionalityTest {

	//Declaration of the object webdriver
	public static WebDriver driver = null;
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.close();
		driver.quit();
		
	}
	
	@Test
	@DisplayName("Login Test - Happy Path")
	public void tc001() throws InterruptedException {
		//Open the URL of Guru99
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Closing the Iframe with GDPR Consent
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(2000);
		
		//Typing UserID
		driver.findElement(By.name("uid")).sendKeys("mngr459119");
		
		//Type the Password
		driver.findElement(By.name("password")).sendKeys("AqEnubY");
		
		//Click on the button LOGIN
		driver.findElement(By.name("btnLogin")).click();
		
		//Check the expected results
		String expectedResults = "Welcome To Manager's Page of Guru99 Bank";
		String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")).getText();
		
		//assertTrue will return true or false
		//assertTrue(actualResults.equals(expectedResults));
		//assertFalse(     );
		
		//assertEquals will compare two variables
		assertEquals(expectedResults,actualResults);
		
		
		
	}
	
	@Test
	@DisplayName("Check results on entering Invalid User ID & Password")
	public void tc002() {
		
		
	}
	
	@Test
	@DisplayName("Check response when a User ID is Empty & Login Button is pressed, and many more")
	public void tc003() {
		
		
	}
	
}
