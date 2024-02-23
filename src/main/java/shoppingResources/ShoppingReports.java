package shoppingResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ShoppingReports {
	
	public ExtentReports getReporter() {
		String filepath = System.getProperty("user.dir")+"//reports//ShoppingReport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(filepath);
		spark.config().setDocumentTitle("ShoppingCartApplication");
		spark.config().setReportName("ShoppingReport");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Praveen Manjusha");
		return extent;
	}
}
