package backEndAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackEndCheckContract extends BackEndMainAction{

	protected void backEndCheckContract(){
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[4]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")));
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")).click();
		WebElement search_email = driver.findElement(By.name("Contract[email]"));
		search_email.sendKeys("acvtestatmark+lam12@gmail.com");
		search_email.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='contract-index-grid']/div[2]/table/tbody/tr/td[21]/a[1]/i")).click();
	}
}
