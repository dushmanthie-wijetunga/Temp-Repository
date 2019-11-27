package seleniumTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import Reporting.TestReportingClass;
import dataDriven.ReadExcel;
import pageClasses.LoginClass;

public class LoginTest {
	WebDriver chrome_driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
	 		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\dri\\chromedriver.exe");
		chrome_driver = new ChromeDriver();
		chrome_driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		chrome_driver.manage().window().maximize();
		System.out.println("Welldone Dushmanthie !!");
				
	}
	
	@Test
	public void loginAction() throws InterruptedException, IOException {
		
		LoginClass login = new LoginClass(chrome_driver);
		ReadExcel read_excel = new ReadExcel();
		String username  = read_excel.ExcelRead(0, 0, "dush.xlsx", "Sheet1");
		String password  = read_excel.ExcelRead(0, 1, "dush.xlsx", "Sheet1");
		System.out.println("success1");
		TestReportingClass report = new TestReportingClass();
		report.TestReporting();
		System.out.println("success2");
		report.startTest("loginAction");
		System.out.println("success3");
		try {
			login.userLogin(username,password);
			System.out.println("success4");
			
			report.LogPass();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			report.LogFail();
		}
		
		report.ReportGeneration();
	}
	

}
