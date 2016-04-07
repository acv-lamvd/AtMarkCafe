package AutomationFramework;

import org.openqa.selenium.By;

public class forgotIDwithoutDOB extends FrontEndMainAction{

	protected void forgotIDnoDOB() throws InterruptedException{
		driver.findElement(By.linkText("Forgot your ID?")).click();

		driver.findElement(By.id("ForgotIdForm_Mail")).sendKeys("abcabc.gh@gmail.com");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		System.out.println("submit forgot button click OK");
	}
}
