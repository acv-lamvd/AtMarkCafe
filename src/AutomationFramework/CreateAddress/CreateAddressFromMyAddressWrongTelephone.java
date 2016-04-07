package AutomationFramework.CreateAddress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CreateAddressFromMyAddressWrongTelephone {
	public WebDriver driver;
  @Test
  public void createAddressFromMyAddressWrongTelephone() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("サービスリスト")));
		WebElement service_link = driver.findElement(By.linkText("サービスリスト"));
		Actions action = new Actions(driver);
		action.moveToElement(service_link).build().perform();
		driver.findElement(By.xpath(".//*[@id='menu-item-1402']/a")).click();
		driver.findElement(By.linkText("住所")).click();
		driver.findElement(By.linkText("新規住所を追加")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alias")));
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Cech8");
		Thread.sleep(2000);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Hung");
		Thread.sleep(2000);
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Cuong");
		Thread.sleep(2000);
		driver.findElement(By.id("company")).clear();
		driver.findElement(By.id("company")).sendKeys("AtmarkCafe");
		Thread.sleep(2000);
		driver.findElement(By.id("postcode")).clear();
		driver.findElement(By.id("postcode")).sendKeys("123-6567");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("279");
		Thread.sleep(2000);
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("Hoang Cau stadium");
		Thread.sleep(2000);
		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys("Mai Anh Tuan street");
		Thread.sleep(2000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Nagoya");
		Thread.sleep(2000);
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("0123456789asda");
		Thread.sleep(2000);
		driver.findElement(By.id("other")).clear();
		driver.findElement(By.id("other")).sendKeys("somewhere in this place");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitAddress")));
		driver.findElement(By.id("submitAddress")).click();
		WebElement errorTelephone = driver.findElement(By.xpath(".//*[@id='center_column']/div/div/ul/li"));
		if(errorTelephone.getText().equals("電話番号 無効です")){
			System.out.println("Test case check number telephone wrong format is PASSED!");
			System.out.println("===============");
		}else{
			System.out.println("FAILED! Test case check number telephone format is Failed!");
			System.out.println("================");
		}
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
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
