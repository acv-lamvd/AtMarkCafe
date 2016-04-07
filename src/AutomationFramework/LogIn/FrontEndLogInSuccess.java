package AutomationFramework.LogIn;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontEndLogInSuccess {
	public WebDriver driver;

	@Test
	public void frontEndLoginOK() throws IOException{
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
		System.out.println("Login button is clicked successfully");
		File capture = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(capture, new File("screenshoot.png"));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		String URL = "http://pgcafe.asia/spmc/site/login";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
