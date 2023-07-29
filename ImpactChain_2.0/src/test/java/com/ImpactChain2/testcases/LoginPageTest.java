package com.ImpactChain2.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ImpactChain2.base.TestBase;
import com.ImpactChain2.pageClass.HomePage;
import com.ImpactChain2.pageClass.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPageTest() {
		// calls the constructor of extended TestBase class
		super();
	}

	@Test(description = "Verify company admin is able to login and Logout with valid Credential")
	public void verify_F1_CompanyAdmin_Login() throws IOException, ParseException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		homepage = new HomePage(driver);
		homepage.verifyHomePage();
		homepage.clickProfileIcon();
		homepage.clickLogoutBtn();
		loginPage.verifyLoginText();
	}
	
	@Test(description = "Verify company admin is able to login  with invalid Credential")
	public void verify_F1_CompanyAdmin_Login_with_InvalidCredential() throws IOException, ParseException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_InvalidCredential");
		homepage = new HomePage(driver);
		loginPage.verifyErrorMsg();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
