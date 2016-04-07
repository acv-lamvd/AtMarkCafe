package AutomationFramework.AddToCart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AddToCart {
	public WebDriver driver;

	@Test
	public void addToCart() {
		driver.findElement(By.className("icon-shopping-cart")).click();
		String old_quantity = driver.findElement(By.className("ajax_cart_quantity")).getText();
		System.out.println("Old Quantity: " + old_quantity);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("サービスリスト")));
		WebElement service_link = driver.findElement(By.linkText("サービスリスト"));

		Actions action = new Actions(driver);
		action.moveToElement(service_link).build().perform();
		driver.findElement(By.xpath(".//*[@id='menu-item-1402']/a")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='blocknewproducts']/li[1]/div/div[1]/div/a[1]/img")));
		WebElement product = driver.findElement(By.xpath(".//*[@id='blocknewproducts']/li[1]/div/div[1]/div/a[1]/img"));
		action.moveToElement(product).build().perform();
		driver.findElement(By.xpath(".//*[@id='blocknewproducts']/li[1]/div/div[2]/div[2]/a/span")).click();
		WebElement quantity = driver.findElement(By.id("quantity_wanted"));
		quantity.clear();
		quantity.sendKeys("4");
		driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).click();
		driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		String new_quantity = driver.findElement(By.className("ajax_cart_quantity")).getText();
		System.out.println("New quantity: " + new_quantity);
		try {
			int old_quantity1 = Integer.parseInt(old_quantity);
			int new_quantity1 = Integer.parseInt(new_quantity);
			if (new_quantity1 == old_quantity1 + 4) {
				System.out.println("Test case add to cart is PASSED!");
				System.out.println("===================");
			} else {
				System.out.println("FAILED! Testcase add to cart is Failed!");
				System.out.println("===================");
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
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
