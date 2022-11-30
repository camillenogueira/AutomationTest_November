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
		
		//=====Test Data======================
		String customerName = "Adam";
		String gender = "male";
		String dateOfbirth = "01/01/1991";
		String address = "47 Testing Road";
		String city = "Dublin";
		String state = "Dublin";
		Integer pin = 123456;
		String mobileNumber = "123456";
		String email = "cnmc1234@guru99.com";
		String customerPassword = "1234567";
		//====================================
		
		//click on New Customer
		//driver.findElement(By.linkText("New Customer")).click();
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		driver.findElement(By.name("name")).sendKeys(customerName);
		
		//Enter DOB
		driver.findElement(By.id("dob")).sendKeys(dateOfbirth);
		
		//Enter address
		driver.findElement(By.name("addr")).sendKeys(address);
		
		//Enter city
		driver.findElement(By.name("city")).sendKeys(city);
		
		//Enter state
		driver.findElement(By.name("state")).sendKeys(state);
		
		//Enter PIN
		driver.findElement(By.name("pinno")).sendKeys(pin.toString());
		
		//Enter Mobile Number
		driver.findElement(By.name("telephoneno")).sendKeys(mobileNumber);
		
		//Enter email
		driver.findElement(By.name("emailid")).sendKeys(email);
		
		//Enter password
		driver.findElement(By.name("password")).sendKeys(customerPassword);
		
		//Click on submit
		driver.findElement(By.name("sub")).click();
		
		//You should validate using asserts if the actual results is the same of the expected results.
		
		
	}
	
	@Test
	public void tc005() throws InterruptedException {
		
		
	}
	
	@Test 
	public void tc006() throws InterruptedException {
		
		
	}
	
	
}
