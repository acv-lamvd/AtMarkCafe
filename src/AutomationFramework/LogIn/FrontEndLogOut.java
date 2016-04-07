package AutomationFramework.LogIn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FrontEndLogOut {

	public WebDriver driver;

	@Test
	public void logOut() throws InterruptedException {
		WebElement logOutbtn = driver.findElement(By.xpath(".//*[@id='menu-item-1069']/a"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOutbtn));
		logOutbtn.click();
		System.out.println("Log out button is clicked successfully");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		String URL = "http://pgcafe.asia/spmc/site/login";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		WebElement langJP = driver.findElement(By.xpath(".//*[@id='login-form']//label[@for='languageJa']"));
		langJP.click();
		WebElement username = driver.findElement(By.xpath(".//*[@id='id']"));
		username.sendKeys("123150616D");
		WebElement pass = driver.findElement(By.xpath(".//*[@id='password']"));
		pass.sendKeys("1234567a");
		WebElement savePass = driver.findElement(By.xpath(".//*[@id='login-form']/div[2]/label"));
		if (!savePass.isSelected()) {
			savePass.click();
		}
		WebElement btnLogin = driver.findElement(By.xpath(".//*[@id='login-form']/div[3]/div/button"));
		btnLogin.click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
