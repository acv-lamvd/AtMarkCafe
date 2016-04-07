package backEndAutomationFramework.SetPasswordNewUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetPwNotSuccess {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=vi#identifier");
		driver1.manage().window().maximize();
		driver1.findElement(By.id("Email")).sendKeys("acvtestatmark");
		driver1.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver1, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		driver1.findElement(By.id("Passwd")).sendKeys("trang1234");
		driver1.findElement(By.id("signIn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='gbqfq']")));
		driver1.findElement(By.xpath(".//*[@id='gbqfq']")).sendKeys("[SKY PREMIUM]");
		driver1.findElement(By.xpath(".//*[@id='gbqfb']")).click();
		Thread.sleep(1500);
		driver1.findElement(By.xpath("//div[5]/div/div/table/tbody/tr/td[5]/div[2]/span")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("http://pgcafe.asia")));
		driver1.findElement(By.partialLinkText("http://pgcafe.asia")).click();
		
		for (String handle1 : driver1.getWindowHandles()){
			driver1.switchTo().window(handle1);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Pass")));
		driver1.findElement(By.id("User_Pass")).sendKeys("lam12345");
		driver1.findElement(By.id("User_confirmPass")).sendKeys("lam123456");
		driver1.findElement(By.xpath(".//*[@id='formRegister']/div[4]/input[1]")).click();
		Thread.sleep(3000);
//		driver1.close();
	}

}
