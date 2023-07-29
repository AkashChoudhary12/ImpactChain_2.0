package com.ImpactChain2.pageClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;



public class LoginPage extends FunctionLibraryESG {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//*******************WebElements******************************

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//span[normalize-space()='Sign In']")
	WebElement SignInBtn;

	@FindBy(xpath = "//div[@class='notyf__message']")
	WebElement errorMsg;

	//***********************Actions*********************	

	// Actions:Get login page title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Action:login
	public void login(String jsonfileName) throws IOException, ParseException {

		String userName = (String) getUserJSONData(jsonfileName).get("userName");
		String passWord = (String) getUserJSONData(jsonfileName).get("passWord");
		String site_url = (String) getUserJSONData(jsonfileName).get("site_url");

		driver.get(site_url);

		sendInput(username, userName);
		sendInput(password, passWord);

		clickElement(SignInBtn);
		info("Successfully logged in ");
	}

	
	//Action verify login 
	public void verifyLoginText() {

		verify(getText(SignInBtn), "Sign In");
		info("logged out successfully");
	}
	
	
	public void verifyErrorMsg() {

		verify(getText(errorMsg),"Incorrect Email or Password.");
		info("error msg is verified");
	}

	
	
	
	
	
	
	
	
	

}
