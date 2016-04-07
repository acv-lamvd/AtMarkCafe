package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class forgotIDWrongEmailFormat extends FrontEndMainAction{

	protected void forgotIDWithWrongemailFormat() throws InterruptedException{
		driver.findElement(By.linkText("Forgot your ID?")).click();
		driver.findElement(By.id("ForgotIdForm_Mail")).sendKeys("abcabc!@432.gh.vvv@.com");
		driver.findElement(By.id("ForgotIdForm_BirthDate")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[2]"));
		Select selectYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		selectYear.selectByValue("1989");
		Select selectMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		selectMonth.selectByValue("6");
		driver.findElement(By.linkText("24")).click();
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		System.out.println("submit forgot button click OK");
	}
}
