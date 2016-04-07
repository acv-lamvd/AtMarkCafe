package backEndAutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BackEndMainAction {

	static protected WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String URL = "http://pgcafe.asia/spmc/admin/default/login";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		// login 
		LoginBackEndSuccessfully login = new LoginBackEndSuccessfully();
		login.logInBackEndOK();
		
		// create new user successfully
		CreateNewUser create_user = new CreateNewUser();
		create_user.createNewUser();
		
		// create new user missing Agency
//		CreateNewUserMissingAgency create_user = new CreateNewUserMissingAgency();
//		create_user.createNewUserMissingAgencty();
		
		// create new user missing Bussinessman
//		CreateNewUserMissingBussiness create_user = new CreateNewUserMissingBussiness();
//		create_user.createNewUserMissingBussinessman();
		
		// create new user missing email
//		CreateNewUserMissingEmail create_user = new CreateNewUserMissingEmail();
//		create_user.createNewUserMissingEmail();
		
		// create new user missing last name
//		CreateNewUserMissingLastName create_user = new CreateNewUserMissingLastName();
//		create_user.createNewUserMissingLastName();
		
		// create new user missing first name
//		CreateNewUserMissingFirstName create_user = new CreateNewUserMissingFirstName();
//		create_user.createNewUserMissingFirstName();
		
		// create new user missing DOB
//		CreateNewUserMissingDOB create_user = new CreateNewUserMissingDOB();
//		create_user.createNewUserMissingDOB();
		
		// create new user missing Postal code
//		CreateNewUserMissingPostalCode create_user = new CreateNewUserMissingPostalCode();
//		create_user.createNewUserMissingPostalCode();
		
		// create new user missing country code
//		CreateNewUserMissingCountryCode create_user = new CreateNewUserMissingCountryCode();
//		create_user.createNewUserMissingCountryCode();
		
		// create new user missing telephone
//		CreateNewUserMissingTelephone create_user = new CreateNewUserMissingTelephone();
//		create_user.createNewUserMissingTelephone();
		
		// create new user missing country
//		CreateNewUserMissingCountry create_user = new CreateNewUserMissingCountry();
//		create_user.createNewUserMissingCountry();
		
		// create new user missing city
//		CreateNewUserMissingCity create_user = new CreateNewUserMissingCity();
//		create_user.createNewUserMissingCity();		
		
		// create new user missing address
//		CreateNewUserMissingAddress create_user = new CreateNewUserMissingAddress();
//		create_user.createNewUserMissingAddress();
		
		// create new user with existed email
//		CreateNewUserWithExistedEmail create_user = new CreateNewUserWithExistedEmail();
//		create_user.createNewUserWithExistedEmail();
		
		// create new user with all fields blank
//		CreateNewUserAllBlank create_user = new CreateNewUserAllBlank();
//		create_user.createNewUserAllBlank();
		
		// check contract
//		BackEndCheckContract contract = new BackEndCheckContract();
//		contract.backEndCheckContract();
		
		// close driver
		Thread.sleep(3000);
		driver.quit();
	}

}
