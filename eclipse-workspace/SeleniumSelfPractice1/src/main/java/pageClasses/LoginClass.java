package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginClass {

	By userName = By.id("txtUsername");
	By password = By.id("txtPassword");
	By btnLogin = By.xpath("//input[@id='btnLogin']");
	WebDriver driver;
	
	
	public LoginClass(WebDriver chromedriver) {
				
		driver = chromedriver;
	}
	

		
	public void userLogin(String user_name, String Password) throws InterruptedException {
		
		driver.findElement(userName).sendKeys(user_name);
		
		driver.findElement(password).sendKeys(Password);
		driver.findElement(btnLogin).click();
		System.out.println("Login Successfull");
	}
	
	
	
	
	
	
}
