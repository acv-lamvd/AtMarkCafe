package AutomationFramework;

import org.openqa.selenium.By;

public class forgotPasswordWrongID extends FrontEndMainAction{
	
	protected void forgotPassWrongID() throws InterruptedException{
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.id("ForgotPassForm_ID")).sendKeys("123150616Daaaa");
		driver.findElement(By.id("ForgotPassForm_Mail")).sendKeys("abcabc.gh@gmail.com");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		System.out.println("submit forgot password button click OK");
	}

}
