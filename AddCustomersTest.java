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
import pages.AddCustomerPage;
import pages.HomePage;
import pages.AddCustomerPage;
public class AddCustomersTest {

	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
		TestData.preConditionLogin();
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.close();
		//driver.quit();
		
	}
	
	@Test
	@DisplayName("Check results on entering a valid information for all fields")
	public void tc004() throws InterruptedException {
		
		
		//click on New Customer
		TestData.driver.findElement(HomePage.leftMenuNewCustomer).click();
		TestData.driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		TestData.driver.findElement(AddCustomerPage.customerName).sendKeys(TestData.customerName);
		
		if(TestData.gender.equals("male")) {
			TestData.driver.findElement(AddCustomerPage.maleGender).click();
			
		} else if(TestData.gender.equals("female")) {
			TestData.driver.findElement(AddCustomerPage.femaleGender).click();
		}
		
		//Enter DOB
		TestData.driver.findElement(AddCustomerPage.dateOfBirth).sendKeys(TestData.dateOfbirth);
		
		//Enter address
		TestData.driver.findElement(AddCustomerPage.address).sendKeys(TestData.address);
		
		//Enter city
		TestData.driver.findElement(AddCustomerPage.city).sendKeys(TestData.city);
		
		//Enter state
		TestData.driver.findElement(AddCustomerPage.state).sendKeys(TestData.state);
		
		//Enter PIN
		TestData.driver.findElement(AddCustomerPage.pinNumber).sendKeys(TestData.pin.toString());
		
		//Enter Mobile Number
		TestData.driver.findElement(AddCustomerPage.mobileNumber).sendKeys(TestData.mobileNumber);
		
		//Enter email
		TestData.driver.findElement(AddCustomerPage.email).sendKeys(TestData.email);
		
		//Enter password
		TestData.driver.findElement(AddCustomerPage.password).sendKeys(TestData.customerPassword);
		
		//Click on submit
		TestData.driver.findElement(AddCustomerPage.submitButton).click();
		
		//Check the message: Customer created successfully 
		String actualResults = TestData.driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
		String expectedResults = "Customer Registered Successfully!!!";
		
		assertEquals(expectedResults,actualResults);
		
		//Save the Customer ID
		String customerID = TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		System.out.println(customerID);
		
		//Check Customer Name
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
		assertEquals(TestData.customerName, actualResults);
		
		//Check Gender
		assertEquals(TestData.gender, TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)")).getText());
		
		//Check DOB
		assertEquals(TestData.expectedDOB, TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText());
		
		//CheckEmail
		assertEquals(TestData.email, TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]")).getText());
		
		
	}
	
	@Test
	public void tc005() throws InterruptedException {
		
		
	}
	
	@Test 
	public void tc006() throws InterruptedException {
		
		
	}
	
	
	
}
