package com.ImpactChain2.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.While;
import org.testng.Assert;

public class FunctionLibraryESG extends LogUtil {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public FunctionLibraryESG(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getConfigProperty("timeOut_duration"))));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	protected WebElement sendInput(WebElement locator, String input) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		element.sendKeys(input);
		return element;
		// info("sent input successfully");

	}

	protected WebElement sendInput(By locator, String input) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		scrollToElement(element);
		HighlightElement(element);
		element.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		element.sendKeys(input);
		return element;
		// info("sent input successfully");

	}

	protected void timeDelay() {
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	protected void clickElement(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.click();
		// info("clicked element successfully "+locator.toString());

	}

	protected void clickElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.click();
		// info("clicked element successfully");

	}

	protected boolean isElementEnabled(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		scrollToElement(element);
		HighlightElement(element);
		// info("element enabled "+element.isEnabled());
		return element.isEnabled();
	}

	protected List<WebElement> getWebElements(By locator) {
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		// info("returned element successfully");
		return element;

	}

	protected String getText(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		scrollToElement(element);
		HighlightElement(element);
		// info("get Text success");
		return element.getText().trim();

	}

	protected String getText(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		scrollToElement(element);
		HighlightElement(element);
		// info("get Text success");
		return element.getText().trim();

	}

	protected String getAttribute(WebElement locator, String attribute) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		scrollToElement(element);
		HighlightElement(element);
		// info("attribute is : "+element.getAttribute(attribute));
		return element.getAttribute(attribute);
	}

	protected void selectDropDown(WebElement element1, String DropDownName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(element1));
		Select select = new Select(element);
		select.selectByVisibleText(DropDownName);
		scrollToElement(element);
		HighlightElement(element);

		// info("Dropdown Selected successfully");

	}

	protected void HighlightElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
			timeDelay();
		} catch (Exception e) {
			info("Failed to HighLight");
		}
	}

	protected void scrollToElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].scrollIntoView(false);", element);
		} catch (Exception e) {
			info("Failed to scroll");
		}
	}

	protected void verify(Object obj1, Object obj2) {
		Assert.assertEquals(obj1, obj2);
		// info("verified successfully");
	}

	protected void verifyNotSame(Object obj1, Object obj2) {
		Assert.assertNotSame(obj1, obj2);
		// info("verified successfully");
	}

	protected String getConfigProperty(String propertyName) {

		try {
			FileReader fr = new FileReader("src\\main\\resources\\config.properties");
			Properties props = new Properties();
			props.load(fr);
			return props.getProperty(propertyName);
		} catch (Exception e) {

			error("Failed to getConfigProperty");

		}
		return null;
	}

	protected JSONObject getUserJSONData(String objectName) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\src\\test\\resources\\testDataWithJSON\\Users.json");

		Object obj = jsonparser.parse(reader);

		JSONObject empJsonObject = (JSONObject) obj;

		JSONArray jarray1 = (JSONArray) empJsonObject.get(objectName);

		return (JSONObject) jarray1.get(0);
	}

	@SuppressWarnings("unchecked")
	protected void writeToJSONField(String jsonFilePath, String ObjectName, String fieldName, String fieldValue)
			throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(jsonFilePath);
		Object obj = jsonparser.parse(reader);

		JSONObject empJsonObject = (JSONObject) obj;
		JSONArray jarray1 = (JSONArray) empJsonObject.get(ObjectName);

		JSONObject jobject = (JSONObject) jarray1.get(0);
		jobject.remove(fieldName);
		jobject.put(fieldName, fieldValue);

		File file = new File(jsonFilePath);
		DataOutputStream outstream = new DataOutputStream(new FileOutputStream(file, false));
		outstream.write(obj.toString().getBytes());
		outstream.close();
		reader.close();
	}

	protected JSONObject getCompanyJSONData(String objectName) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\src\\test\\resources\\testDataWithJSON\\CompanyData.json");

		Object obj = jsonparser.parse(reader);

		JSONObject empJsonObject = (JSONObject) obj;

		JSONArray jarray1 = (JSONArray) empJsonObject.get(objectName);

		return (JSONObject) jarray1.get(0);
	}

	protected JSONObject getNewGoalJSONData(String objectName) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\src\\test\\resources\\testDataWithJSON\\Add_Goals_Data.json");

		Object obj = jsonparser.parse(reader);

		JSONObject empJsonObject = (JSONObject) obj;

		JSONArray jarray1 = (JSONArray) empJsonObject.get(objectName);

		return (JSONObject) jarray1.get(0);
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

	protected void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String getFieldText(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		scrollToElement(element);
		HighlightElement(element);
		pause(5000);
		return jse.executeScript("return arguments[0].lastChild.textContent;",
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).toString().trim();
	}

}
