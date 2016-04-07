package backEndAutomationFramework.SetPasswordNewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareContractCC {

	public static void main(String[] args) throws InterruptedException {

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
		String user_id = driver1.findElement(By.xpath(".//*[@id='formRegister']/div[1]/label[2]")).getText();
		System.out.println(user_id);
		driver1.findElement(By.id("User_Pass")).sendKeys("1234567a");
		driver1.findElement(By.id("User_confirmPass")).sendKeys("1234567a");
		driver1.findElement(By.xpath(".//*[@id='formRegister']/div[4]/input[1]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id")));
		driver1.findElement(By.id("id")).sendKeys(user_id);
		driver1.findElement(By.id("password")).sendKeys("1234567a");
		driver1.findElement(By.xpath(".//*[@id='login-form']/div[3]/div/button")).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Contract_GroupID")));
		Select select_grade = new Select(driver1.findElement(By.id("Contract_GroupID")));
		select_grade.selectByValue("1");
		Select select_method = new Select(driver1.findElement(By.id("PaymentStyle")));
		select_method.selectByValue("2");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Contract_PaymentMethod")));
		Select select_payment = new Select(driver1.findElement(By.id("Contract_PaymentMethod")));
		select_payment.selectByValue("3");
		driver1.findElement(By.id("Contract_TermOfUse")).click();
		driver1.findElement(By.xpath(".//*[@id='formRegister']/div/div/div/div[13]/input[1]")).click();
		System.out.println("register done!!!");
		
		// input info of payment CC
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='cel02']/td/input")));
		driver1.findElement(By.xpath(".//*[@id='cel02']/td/input")).sendKeys("TranLong");
		driver1.findElement(By.xpath(".//*[@id='text01']")).sendKeys("4341210186481476");
		Select select_month = new Select(driver1.findElement(By.xpath(".//*[@id='cel04']/td/select[1]")));
		select_month.selectByValue("05");
		Select select_year = new Select(driver1.findElement(By.xpath(".//*[@id='cel04']/td/select[2]")));
		select_year.selectByValue("18");
		driver1.findElement(By.xpath(".//*[@id='cel05']/td/input")).sendKeys("123");
		Select select_code = new Select(driver1.findElement(By.xpath(".//*[@id='cel06']/td/select")));
		select_code.selectByValue("Viet Nam");
		driver1.findElement(By.xpath(".//*[@id='cel08']/input[1]")).click();
		driver1.findElement(By.xpath(".//*[@id='submit01']")).click();
//		driver1.quit();
	}

}
