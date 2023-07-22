package com.ImpactChain2.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class GoalsPage extends FunctionLibraryESG {

	WebDriver driver;

	public GoalsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************************************

	@FindBy(xpath = "(//a[contains(text(),\"Plan\")])[2]")
	WebElement Plan;

	@FindBy(xpath = "//span[contains(text(),'Goals')]")
	WebElement Goals;

	@FindBy(xpath = "//span[normalize-space()='Add New Goal']")
	WebElement Add_New_Goal;

	@FindBy(xpath = "//a//div[contains(text(),\"Climate\")]")
	WebElement Climate;

	// ***********************Actions*********************

	public void clickPlan() {
		clickElement(Plan);
	}

	public void clickGoal() {
		clickElement(Goals);
	}

	public void clickClimate() {
		clickElement(Climate);
	}

	public void clickAddNewGoal() {
		clickElement(Add_New_Goal);
	}

}
