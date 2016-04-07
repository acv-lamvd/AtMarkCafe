package backEndAutomationFramework.SetPasswordNewUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareContractBankTransfer {

//	@SuppressWarnings("deprecation")
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
		select_payment.selectByValue("2");
		driver1.findElement(By.id("Contract_TermOfUse")).click();
		driver1.findElement(By.xpath(".//*[@id='formRegister']/div/div/div/div[14]/input[1]")).click();
		System.out.println("register done!!!");
		
		// save value of each field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td")));
		String status = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td")).getText();
		String grade = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td")).getText();
		String payment_method = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[3]/td")).getText();
		String register_date = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[4]/td")).getText();
		String start_date = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[5]/td")).getText();
		String next_update_date = driver1.findElement(By.xpath(".//*[@id='ajax-content-wrap']/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[6]/td")).getText();
		driver1.quit();
		
		// check contract at backend
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("http://pgcafe.asia/spmc/admin/default/login");
		driver2.manage().window().maximize();
		driver2.findElement(By.id("AdminLogin_username")).sendKeys("admin");
		driver2.findElement(By.id("AdminLogin_password")).sendKeys("abeshima");
		Select selectLanguage = new Select(driver2.findElement(By.id("AdminLogin_language")));
		selectLanguage.selectByValue("en");
		driver2.findElement(By.xpath(".//*[@type='submit']")).click();
		driver2.findElement(By.xpath(".//*[@id='sidebar']/ul/li[4]/a")).click();
//		WebDriverWait wait1 = new WebDriverWait(driver2, 5000);
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")));
//		driver2.findElement(By.xpath(".//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")).click();
		driver2.findElement(By.linkText("List Contracts")).click();
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("Contract[userID]")));
		WebElement search_id = driver2.findElement(By.name("Contract[userID]"));
		search_id.sendKeys(user_id);
		search_id.sendKeys(Keys.ENTER);
		driver2.findElement(By.xpath(".//*[@id='contract-index-grid']/div[2]/table/tbody/tr[1]/td[21]/a[1]/i")).click();
		
		// save value of each field in admin site
		String status_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[1]/td")).getText();
		String grade_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[2]/td")).getText();
		String payment_method_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[3]/td")).getText();
		String register_date_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[4]/td")).getText();
		String start_date_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[5]/td")).getText();
		String next_update_date_admin = driver2.findElement(By.xpath(".//*[@id='view-contract-info']/tbody/tr[6]/td")).getText();
		
		// Compare and print result
		System.out.println("--------------------------------------");
		System.out.println("Status in Axes: " + status);
		System.out.println("Status in Admin: " + status_admin);
		if(status.equals(status_admin)){
			System.out.println("Status is same!");
		}else
			System.out.println("Error! Status is not same!!!!!!");
		System.out.println("Grade in Axes: " + grade);
		System.out.println("Grade in Admin: " + grade_admin);
		if(grade.contains(grade_admin))				{
			System.out.println("Grade (Group) is the same!");
		}else
			System.out.println("Error! Grade (Group) is not same");
		System.out.println("Payment method in Axes: " + payment_method);
		System.out.println("Payment method in Admin: " + payment_method_admin);
		if(payment_method.equals(payment_method_admin)){
			System.out.println("Payment method is the same!");
		}else 
			System.out.println("Error! Payment method is not same");
		System.out.println("Registered date in Axes: " + register_date);
		System.out.println("Registered date in Admin: "+ register_date_admin);
		if(register_date.equals(register_date_admin)){
			System.out.println("Registered date is the same!");
		}else
			System.out.println("Error! Registered date is not same");
		System.out.println("Start date in Axes: " + start_date);
		System.out.println("Start date in Admin: " + start_date_admin);
		if(start_date_admin.contains(start_date)){
			System.out.println("Start date is the same!");
		}else
			System.out.println("Error! Start date is not same");
		System.out.println("Next update in Axes: " + next_update_date);
		System.out.println("Next update in Admin: " + next_update_date_admin);
		if(next_update_date.equals(next_update_date_admin)){
			System.out.println("Next update date is the same!");
		}else
			System.out.println("Error! Next update date is not same");
		
		driver1.quit();
		driver2.quit();
	}

}
