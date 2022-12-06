import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestData {

	//Declaration of the object webdriver
	public static WebDriver driver = null;
	
	//Incialize the Video Recorder
	public static MyScreenRecorder screenRecorder;
	
	//=====Test Data======================
	public static String customerName = "Camille";
	public static String gender = "female"; //female
	public static String dateOfbirth = "01/01/1991";
	public static String expectedDOB = "1991-01-01";
	public static String address = "47 Testing Road";
	public static String city = "Dublin";
	public static String state = "Dublin";
	public static Integer pin = 123456;
	public static String mobileNumber = "123456";
	static Random random = new Random();
	public static int numberRandom = random.nextInt(100000);  // 54266
	//System.out.println(numberRandom);
	
	public static String email = "cnmc"+numberRandom+"@guru99.com"; //cnmc54266@guru99.com
	//System.out.println(email);
	
	public static String customerPassword = "1234567";
	
	public static String customerID = "14022";
	
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
	
	public static String createCustomer() {
		
		return customerID;
	}
	
	public static String createAccount() {
		
		String accountID = "12344";
		
		return accountID;
	}
	
	
}
