package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrontEndMainAction {

	static protected WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// open front end site
		String URL = "http://pgcafe.asia/spmc/site/login";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		// login successfully
		loginFrontEndSuccessfully loginOK = new loginFrontEndSuccessfully();
		loginOK.loginFrontEndOK();

		// logout
		logOutSuccessfully logOutOK = new logOutSuccessfully();
		logOutOK.logOut();
		
		// forgotPassword OK
//		forgotPasswordSuccessfully forgotPass = new forgotPasswordSuccessfully();
//		forgotPass.forgotPasswordOK();
		
		// forgotPasswordWithoutID
//		forgotPasswordWithoutID forgotPass = new forgotPasswordWithoutID();
//		forgotPass.forgotPassWithoutID();
		
		// forgotPasswordWithoutEmail
//		forgotPasswordWithoutEmail forgotPass = new forgotPasswordWithoutEmail();
//		forgotPass.forgotPassWithoutEmail();
		
		// forgotPassword input wrong email format
//		forgotPasswordWrongEmailFormat forgotPass = new forgotPasswordWrongEmailFormat();
//		forgotPass.forgotPassWrongEmailFormat();
		
		// forgotPassword input wrong ID
//		forgotPasswordWrongID forgotPass = new forgotPasswordWrongID();
//		forgotPass.forgotPassWrongID();
		
		// forgotPassword input wrong Email
//		forgotPasswordWrongEmail forgotPass = new forgotPasswordWrongEmail();
//		forgotPass.forgotPassWrongEmail();
		
		// forgotID without Email
//		forgotIDwithoutEmail forgotID = new forgotIDwithoutEmail();
//		forgotID.forgotIDnoEmail();
		
		// forgotID without DOB
//		forgotIDwithoutDOB forgotID = new forgotIDwithoutDOB();
//		forgotID.forgotIDnoDOB();
		
		// forgotID with wrong Email format
//		forgotIDWrongEmailFormat forgotID = new forgotIDWrongEmailFormat();
//		forgotID.forgotIDWithWrongemailFormat();
		
		// forgotID with wrong email
//		forgotIDwrongEmail forgotID = new forgotIDwrongEmail();
//		forgotID.forgotIDWithWrongEmail();
		
		// forgotID with wrong DOB
//		forgotIDwrongDOB forgotID = new forgotIDwrongDOB();
//		forgotID.forgotIDWithWrongDOB();
		
		
		// quit browser
		System.out.println("Bye bye! I'm gonna quit!!!");
		driver.quit();
	}

}
