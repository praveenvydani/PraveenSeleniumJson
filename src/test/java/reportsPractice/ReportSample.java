package reportsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportSample {
	public ExtentReports extent;
	
	@BeforeTest
	public void getReport() {
		String filepath = System.getProperty("user.dir")+"//reports//samplereport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(filepath);
		spark.config().setDocumentTitle("PraveenSampleReport");
		spark.config().setReportName("PraveenTest");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Praveen Vydani");
	}
	
	@Test
	public void sampleApplication() {
		ExtentTest test = extent.createTest("SampleTestofGoogle");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		test.fail("testFailed");
		extent.flush();
	}
}
