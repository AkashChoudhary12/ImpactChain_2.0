package com.ImpactChain2.pageClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class GoalSettingPage extends FunctionLibraryESG {

	WebDriver driver;
	public String goalName;

	public GoalSettingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************************************

	@FindBy(xpath = "//div[@class='content-box']//div[1]/span")
	WebElement Names;

	@FindBy(xpath = "//div[@class='content-box']//div[2]")
	WebElement Description;

	@FindBy(xpath = "//div[@class='content-box']//div[3]")
	WebElement CreatedDate;

	@FindBy(xpath = "//a[normalize-space()='CG-ab6f']")
	WebElement Xpath;

	@FindBy(xpath = "//button[@class='button button v-button is-bold is-primary plusBtn']//span//*[name()='svg']")
	WebElement Add_SubGoalBtn;

	// ***********************Actions*********************

	public void verifyNames() {

		System.out.println(getText(Names));

	}

	public void addSubgoal() {

		clickElement(Add_SubGoalBtn);

	}

}
