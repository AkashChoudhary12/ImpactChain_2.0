package com.ImpactChain2.pageClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class HomePage extends FunctionLibraryESG {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *******************WebElements******************************

	@FindBy(xpath = "//div[@class='page-title has-text-centered']//a[@class='is-trigger dropdown-trigger']//img[@class='avatar']")
	WebElement profileIcon;

	@FindBy(xpath = "//div[@class='is-right is-spaced dropdown user-dropdown profile-dropdown is-active']//span[contains(text(),'Logout')]")
	WebElement logoutBtn;

	// ***********************Actions*********************

	// Action verify login
	public void verifyHomePage() {

		String urlToVerify = "http://fu1.cw3.biz/#/login";
		String currentURL = driver.getCurrentUrl();
		verify(urlToVerify, currentURL);
		info("Login successfully");

	}

	public void clickProfileIcon() {

		clickElement(profileIcon);

	}

	public void clickLogoutBtn() {

		clickElement(logoutBtn);

	}

}
