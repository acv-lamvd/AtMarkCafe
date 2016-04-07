package backEndAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoginBackEndSuccessfully extends BackEndMainAction{

	 	protected void logInBackEndOK(){
		driver.findElement(By.id("AdminLogin_username")).sendKeys("admin");
		driver.findElement(By.id("AdminLogin_password")).sendKeys("abeshima");
		Select selectLanguage = new Select(driver.findElement(By.id("AdminLogin_language")));
		selectLanguage.selectByValue("en");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		System.out.println("Login successfully");
	}
}
