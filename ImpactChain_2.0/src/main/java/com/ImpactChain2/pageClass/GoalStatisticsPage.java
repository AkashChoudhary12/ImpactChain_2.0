package com.ImpactChain2.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class GoalStatisticsPage extends FunctionLibraryESG {

	WebDriver driver;

	public GoalStatisticsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *******************WebElements******************************

	@FindBy(xpath = "//a//div[contains(text(),'Climate')]")
	WebElement Climate;

	@FindBy(xpath = "//a//div[contains(text(),'Energy')]")
	WebElement Energy;

	@FindBy(xpath = "//a//div[contains(text(),'Waste')]")
	WebElement Waste;

	@FindBy(xpath = "//a//div[contains(text(),'Freshwater')]")
	WebElement FreshWater;

	@FindBy(xpath = "//a//div[contains(text(),'Involuntary')]")
	WebElement Involuntary_Labor;

	@FindBy(xpath = "//a//div[contains(text(),'Diversity')]")
	WebElement Diversity_Inclusion;

	@FindBy(xpath = "//a//div[contains(text(),'Pay')]")
	WebElement Pay_Equality;

	@FindBy(xpath = "//a//div[contains(text(),'Ethical')]")
	WebElement Ethical_Behaviour;

	// ***********************Actions*********************

	public void clickClimate() {
		clickElement(Climate);
	}

	public void clickEnergy() {
		clickElement(Energy);
	}

	public void clickWaste() {
		clickElement(Waste);
	}

	public void clickFreshWater() {
		clickElement(FreshWater);
	}

	public void clickInvoluntary_Labor() {
		clickElement(Involuntary_Labor);
	}

	public void clickDiversity_Inclusion() {
		clickElement(Diversity_Inclusion);
	}

	public void clickPay_Equality() {
		clickElement(Pay_Equality);
	}

	public void clickEthical_Behaviour() {
		clickElement(Ethical_Behaviour);
	}

}
