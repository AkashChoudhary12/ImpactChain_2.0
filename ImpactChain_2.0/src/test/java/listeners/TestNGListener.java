package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.ImpactChain2.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGListener extends TestBase implements ITestListener{

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		htmlReporter.config().setDocumentTitle("Test Automation Report ");
		// Name of the report
		htmlReporter.config().setReportName("TestReport");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Parameters("browser")
	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getMethod().getDescription());
		startTestCase(result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		info("Test Case PASSED : "+result.getMethod().getDescription());
		endTestCase(result.getMethod().getDescription());
		driver.quit();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable().getMessage()
						+ " - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable().getStackTrace()
						+ " - Test Case Failed", ExtentColor.RED));
		String screenshotPath;
		try {
			screenshotPath = getScreenShot(driver, result.getName());
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {

			driver.quit();
		}
		error("Test Case FAILED : "+result.getMethod().getDescription());
		endTestCase(result.getMethod().getDescription());
		driver.quit();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		error("Test Case SKIPPED : "+result.getMethod().getDescription());
		endTestCase(result.getMethod().getDescription());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	@Override
	public void onStart(ITestContext context) {
		cleanUpOldFiles();
		setExtent();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
