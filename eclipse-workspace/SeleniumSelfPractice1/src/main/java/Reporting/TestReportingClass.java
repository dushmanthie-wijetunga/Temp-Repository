package Reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

public class TestReportingClass {
	ExtentTest extent_test;
	ExtentReports extent;
	
	public void TestReporting() {
		 extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/ExecutionReport.html", true);
		//ExtentHtmlReporter reporter = new ExtentHtmlReporter("report.html");
		
			}
	
	public void startTest(String testName) {
		extent_test =  extent.startTest(testName);
	}
	
	public void LogPass() {
		extent_test.log(LogStatus.PASS, "Testcase passed");
		
	}
	
	public void LogFail() {
		extent_test.log(LogStatus.FAIL, "Testcase failed");
		
	}
		
		public void ReportGeneration() {
			extent.flush();
		
	}
		
}
