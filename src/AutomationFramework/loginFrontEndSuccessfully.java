package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginFrontEndSuccessfully extends FrontEndMainAction{

	public void loginFrontEndOK () throws InterruptedException{
		
		WebElement langJP = driver.findElement(By.xpath(".//*[@id='login-form']//label[@for='languageJa']"));
		langJP.click();

		WebElement langEN = driver.findElement(By.xpath(".//*[@id='login-form']//label[@for='languageEn']"));
		langEN.click();
		
		// enter username
		WebElement username = driver.findElement(By.xpath(".//*[@id='id']"));
		username.sendKeys("123150616D");

		// enter password
		WebElement pass = driver.findElement(By.xpath(".//*[@id='password']"));
		pass.sendKeys("1234567a");

		// select save password
		WebElement savePass = driver.findElement(By.xpath(".//*[@id='login-form']/div[2]/label"));
		if (!savePass.isSelected()) {
			savePass.click();
		}

		// login
		WebElement btnLogin = driver.findElement(By.xpath(".//*[@id='login-form']/div[3]/div/button"));
		btnLogin.click();
		System.out.println("Login button is clicked successfully");
	}
}
