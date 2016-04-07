package backEndAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewUserMissingFirstName extends BackEndMainAction{

	protected void createNewUserMissingFirstName() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a")).click();
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/ul/li[2]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Userdetail_SVID")));
		Select svid = new Select(driver.findElement(By.id("Userdetail_SVID")));
		svid.selectByValue("13");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Userdetail_AID")));
		Select aid = new Select(driver.findElement(By.id("Userdetail_AID")));
		aid.selectByValue("19");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Userdetail_BID")));
		Select bid = new Select(driver.findElement(By.id("Userdetail_BID")));
		bid.selectByValue("306");
		driver.findElement(By.id("User_Mail")).sendKeys("avctestatmark+lam3@gmail.com");
		driver.findElement(By.id("User_Name1")).sendKeys("Huong");
		driver.findElement(By.id("User_Name3")).sendKeys("Mai");
		Select sex = new Select(driver.findElement(By.id("Userdetail_Sex")));
		sex.selectByValue("2");
		driver.findElement(By.xpath(".//*[@id='Userdetail_BirthDate']")).click();
		Select selectYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		selectYear.selectByValue("1989");
		Select selectMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		selectMonth.selectByValue("6");
		driver.findElement(By.linkText("28")).click();
		driver.findElement(By.id("Userdetail_Zip")).sendKeys("123-0214");
		Select country_code = new Select(driver.findElement(By.id("Userdetail_CountryPhoneCode")));
		country_code.selectByValue("84");
		driver.findElement(By.id("Userdetail_Tel")).sendKeys("985236541");
		driver.findElement(By.id("Userdetail_Country")).sendKeys("Vietnam");
		driver.findElement(By.id("Userdetail_City")).sendKeys("Hanoi");
		driver.findElement(By.id("Userdetail_Address1")).sendKeys("Hoang Cau- Dong Da");
		Select user_lang = new Select(driver.findElement(By.id("User_Lang")));
		user_lang.selectByValue("ja");
		driver.findElement(By.xpath(".//*[@id='send-message']")).click();
		// reset if needed
//		driver.findElement(By.xpath(".//*[@id='formRegister']/div/div[3]/div[8]/input[2]")).click();
		System.out.println("Submit to create new user OK");
	}
}
