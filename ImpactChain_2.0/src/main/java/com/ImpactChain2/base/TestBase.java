package com.ImpactChain2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ImpactChain2.pageClass.AddNewGoalPage;
import com.ImpactChain2.pageClass.ClimateGoalListPage;
import com.ImpactChain2.pageClass.GoalStatisticsPage;
import com.ImpactChain2.pageClass.GoalsPage;
import com.ImpactChain2.pageClass.LoginPage;
import com.ImpactChain2.utils.LogUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends LogUtil {

	public static WebDriver driver;
	Properties prop;
	DateTime localDate = DateTime.now();

	protected LoginPage loginPage;
	protected GoalsPage goalsPage;
	protected AddNewGoalPage addnewgoalpage;
	protected GoalStatisticsPage goalstatisticsPage;
	protected ClimateGoalListPage climategoallistpage;


	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(ip);
			info("Property file loaded");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			error("Failed to locate property file");
		} catch (IOException e) {
			e.printStackTrace();
			error("Failed to read/write property file");
		}
	}

	@BeforeMethod
	@Parameters("browser")
	protected void initialization(@Optional("") String browser) {

		String browserName = null;
		if (browser.contains("")) {
			browser = prop.getProperty("browser");
			browserName = browser;
		} else
			browserName = browser;

		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browserName.equals("FF")) {
			// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
			// "/drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		info("Driver launched");
	}

	protected String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	

	public static String[] getMonthYear(String MonthYear) {

		return MonthYear.split(" ");

	}
	
	
	protected String generateCommonLangPassword(int length) {
		String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
		String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
		String numbers = RandomStringUtils.randomNumeric(2);
		String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
		String totalChars = RandomStringUtils.randomAlphanumeric(length);
		String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar)
				.concat(totalChars);
		List<Character> pwdChars = combinedChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(pwdChars);
		String password = pwdChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		return password;
	}
	
	
	public static void SelectDate(String exDay, String exMonth, String exYear) {

		String MonthYear = driver.findElement(By.className("vc-title")).getText();

		while (!getMonthYear(MonthYear)[0].equals(exMonth) && getMonthYear(MonthYear)[1].equals(exYear)) {
			MonthYear = driver.findElement(By.className("vc-title")).getText();
		}
		driver.findElement(By.xpath("//span[text()='" + exDay.trim() + "']")).click();

	}
	
	
	
	protected void cleanUpOldFiles() {
		File targetDir = new File(prop.getProperty("old_files_path"));
		int expirationPeriod = Integer.parseInt(prop.getProperty("expirationPeriod"));
		if (!targetDir.exists()) {
			throw new RuntimeException(String.format("Log files directory '%s' " + "does not exist in the environment",
					prop.getProperty("old_files_path")));
		}

		File[] files = targetDir.listFiles();
		for (File file : files) {
			long diff = new Date().getTime() - file.lastModified();

			// Granularity = DAYS;
			long desiredLifespan = TimeUnit.DAYS.toMillis(expirationPeriod);

			if (diff > desiredLifespan) {
				info("Expiration Period : " + expirationPeriod);
				info("DELETING ---> " + file.getName());
				file.delete();
			}
		}
	}

}
