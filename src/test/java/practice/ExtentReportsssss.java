package practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsssss{
	public static void main(String[] args) {
		
		
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./Reports/extentHtmlre.html");
		sparkReport.config().setDocumentTitle("project extent report");
		sparkReport.config().setReportName("report 1");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		ExtentReports eReports=new ExtentReports();
		eReports.attachReporter(sparkReport);
		
		
		ExtentTest test = eReports.createTest("test1");
		
		test.pass("pass");
		
		test.fail("fails");
		
		test.skip("skipped");
		
		eReports.flush();
				
	}
}

