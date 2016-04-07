package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logOutSuccessfully extends FrontEndMainAction {

	protected void logOut(){
		WebElement logOutbtn = driver.findElement(By.xpath(".//*[@id='menu-item-1069']/a"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOutbtn));
		logOutbtn.click();
		System.out.println("Log out button is clicked successfully");
	}
}
