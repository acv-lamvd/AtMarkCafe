package AutomationFramework;

import org.openqa.selenium.By;

public class forgotPasswordWrongEmailFormat extends FrontEndMainAction {

	protected void forgotPassWrongEmailFormat () throws InterruptedException{
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.id("ForgotPassForm_ID")).sendKeys("123150616D");
		driver.findElement(By.id("ForgotPassForm_Mail")).sendKeys("abc#$%%ˆ&abc.gh@gmail");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		System.out.println("submit forgot password button click OK");
	}
}
