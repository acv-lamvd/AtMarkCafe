package backEndAutomationFramework;

import org.openqa.selenium.By;

public class CreateNewUserAllBlank extends BackEndMainAction{

	protected void createNewUserAllBlank(){
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/a")).click();
		driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='send-message']")).click();
		System.out.println("Submit to create new user OK");
	}
}
