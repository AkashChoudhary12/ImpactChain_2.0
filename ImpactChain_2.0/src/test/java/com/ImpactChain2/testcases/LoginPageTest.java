package com.ImpactChain2.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ImpactChain2.base.TestBase;
import com.ImpactChain2.pageClass.LoginPage;



public class LoginPageTest extends TestBase {


	public LoginPageTest() {
		//calls the constructor of extended TestBase class
		super();

	}

	@Test(description="Verify F1_FacilityUser login and logout")
	public void verify_F1_FacilityUser_Login() throws IOException, ParseException {
		
		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin");
//		
//		dashboardPage = new DashboardPage(driver);
//		dashboardPage.verityTitle();
//		dashboardPage.clickUserIcon();
//		dashboardPage.clickLogOut();
		
		loginPage.verifyLoginText();
	}
	

	
	
	
	
	
	
	

}
