import java.util.Random;

public class TestData {

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
	
	
	
}
