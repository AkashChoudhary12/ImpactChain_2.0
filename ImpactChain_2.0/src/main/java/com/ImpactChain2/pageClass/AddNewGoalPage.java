package com.ImpactChain2.pageClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class AddNewGoalPage extends FunctionLibraryESG {

	WebDriver driver;
	public String goalName;

	public AddNewGoalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *********************WebElements****************************

	@FindBy(xpath = "//input[@id='name']")
	WebElement Names;

	@FindBy(xpath = "//input[@id='description']")
	WebElement Description;

	@FindBy(xpath = "//select[@id='aggregate_type']")
	WebElement Type;

	@FindBy(xpath = "//select[@id='level']")
	WebElement Level;

	@FindBy(xpath = "//select[@id='owner_type_name']")
	WebElement Owner;

	@FindBy(xpath = "//input[@id='metric']")
	WebElement Metric;

	@FindBy(xpath = "//input[@id='target_value']")
	WebElement Target;

	@FindBy(xpath = "//input[@id='v-field-3']")
	WebElement TargetUnit;

	@FindBy(xpath = "(//input[@class='input' and @placeholder='MM/DD/YYYY'])[1]")
	WebElement StartDate;

	@FindBy(xpath = "(//input[@class='input' and @placeholder='MM/DD/YYYY'])[2]")
	WebElement EndDate;

	@FindBy(xpath = "//input[@id='budget']")
	WebElement Budget;

	@FindBy(xpath = "//select[@id='baselineyear']")
	WebElement Baselineyear;

	@FindBy(xpath = "//input[@id='baseline']")
	WebElement Baseline;

	@FindBy(xpath = "//select[@id='basis']")
	WebElement Basis;

	@FindBy(xpath = "//select[@id='method']")
	WebElement Method;
	
	@FindBy(xpath = "//div[@class='vc-title']")
	WebElement Month;
	
	@FindBy(xpath = "//button[@class='button button v-button is-raised is-primary']")
	WebElement Next;

	// ***********************Actions*********************

	public void fillCompanyData(String jsonObjectName) throws IOException, ParseException {

		
		String description = (String) getNewGoalJSONData(jsonObjectName).get("description");
		String type = (String) getNewGoalJSONData(jsonObjectName).get("type");
		String level = (String) getNewGoalJSONData(jsonObjectName).get("level");
		String owner = (String) getNewGoalJSONData(jsonObjectName).get("owner");
		String metric = (String) getNewGoalJSONData(jsonObjectName).get("metric");
		String target = (String) getNewGoalJSONData(jsonObjectName).get("target");
		String targetunit = (String) getNewGoalJSONData(jsonObjectName).get("targetunit");
		String budget = (String) getNewGoalJSONData(jsonObjectName).get("budget");
		String baselineyear = (String) getNewGoalJSONData(jsonObjectName).get("baselineyear");
		String baseline = (String) getNewGoalJSONData(jsonObjectName).get("baseline");
		String basis = (String) getNewGoalJSONData(jsonObjectName).get("basis");
		String method = (String) getNewGoalJSONData(jsonObjectName).get("method");

	    goalName = "Goal" + generateCommonLangPassword(10);
		sendInput(Names, goalName);
		sendInput(Description, description);
		selectDropDown(Type, type);
		selectDropDown(Level, level);
		selectDropDown(Owner, owner);
		sendInput(Metric, metric);
		sendInput(Target, target);
		sendInput(TargetUnit, targetunit);
		sendInput(Budget, budget);
		selectDropDown(Baselineyear, baselineyear);
		sendInput(Baseline, baseline);
		selectDropDown(Basis, basis);
		selectDropDown(Method, method);

	}

	public void SubmitForm() {

		clickElement(Next);

	}

	public void enterstartDate() {

		clickElement(StartDate);

	}

	public void enterendDate() {

		clickElement(EndDate);

	}
	
	public void SelectDate(String monthYear, String date) {

		clickElement(Month);
		clickElement(By.xpath("//span[@data-id='"+monthYear.trim()+"']"));
		clickElement(By.xpath("//span[contains(@aria-label,'"+date.trim()+"')]"));

	}
	
	
	

//	public void entername(String names) {
//
//		sendInput(Names, names);
//
//	}
//
//	public void enterdescription(String description) {
//
//		sendInput(Description, description);
//
//	}
//
//	public void selectType(String type) {
//
//		selectDropDown(Type, type);
//
//	}
//
//	public void selectLevel(String level) {
//
//		selectDropDown(Level, level);
//
//	}
//
//	public void enterstartDate() throws InterruptedException {
//
//		clickElement(StartDate);
//		Thread.sleep(5000);
//
//	}
//
//	public void enterendDate() throws InterruptedException {
//
////		sendInput(EndDate, enddate);
//		clickElement(EndDate);
//		Thread.sleep(5000);
//	}
//
//	public void selectOwner(String owner) {
//
//		selectDropDown(Owner, owner);
//
//	}
//
//	public void entermetric(String metric) {
//
//		sendInput(Metric, metric);
//
//	}
//
//	public void entertarget(String target) {
//
//		sendInput(Target, target);
//
//	}
//
//	public void entertargetunit(String targetunit) {
//
//		sendInput(TargetUnit, targetunit);
//
//	}
//
//	public void enterbudget(String budget) {
//
//		sendInput(Budget, budget);
//
//	}
//
//	public void selectbaselineyear(String baselineyear) {
//
//		selectDropDown(Baselineyear, baselineyear);
//
//	}
//
//	public void enterbaseline(String baseline) {
//
//		sendInput(Baseline, baseline);
//
//	}
//
//	public void selectbasis(String basis) {
//
//		selectDropDown(Basis, basis);
//
//	}
//
//	public void selectmethod(String method) {
//
//		selectDropDown(Method, method);
//
//	}
//
//	public void clickNext() {
//
//		clickElement(Next);
//
//	}

}
