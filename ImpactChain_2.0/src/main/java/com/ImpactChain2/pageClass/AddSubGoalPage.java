package com.ImpactChain2.pageClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class AddSubGoalPage extends FunctionLibraryESG {

	WebDriver driver;

	String description;
	String type;
	String level;
	String owner;
	String metric;
	String target;
	String targetunit;
	String budget;
	String baselineyear;
	String baseline;
	String basis;
	String method;
	String subtopic;
	String activity;

	public String goalName;

	public AddSubGoalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************************************

	@FindBy(xpath = "(//input[@id='name'])[2]")
	WebElement Names;

	@FindBy(xpath = "(//input[@id='description'])[2]")
	WebElement Description;

	@FindBy(xpath = "(//select[@id='aggregate_type'])[2]")
	WebElement Type;

	@FindBy(xpath = "(//select[@id='level'])[2]")
	WebElement Level;

	@FindBy(xpath = "(//select[@id='owner_type_name'])[2]")
	WebElement Owner;

	@FindBy(xpath = "(//input[@id='metric'])[2]")
	WebElement Metric;

	@FindBy(xpath = "(//input[@id='target_value'])[2]")
	WebElement Target;

	@FindBy(xpath = "//input[@id='v-field-3']")
	WebElement TargetUnit;

	@FindBy(xpath = "(//input[@class='input' and @placeholder='MM/DD/YYYY'])[1]")
	WebElement StartDate;

	@FindBy(xpath = "(//input[@class='input' and @placeholder='MM/DD/YYYY'])[2]")
	WebElement EndDate;

	@FindBy(xpath = "//div[@class='is-active is-large modal v-modal']//input[@id='currency']")
	WebElement Budget;

	@FindBy(xpath = "(//select[@id='baselineyear'])[2]")
	WebElement Baselineyear;

	@FindBy(xpath = "(//input[@id='baseline'])[2]")
	WebElement Baseline;

	@FindBy(xpath = "(//select[@id='basis'])[2]")
	WebElement Basis;

	@FindBy(xpath = "(//select[@id='method'])[2]")
	WebElement Method;

	@FindBy(xpath = "//*[@id='subtopic']")
	WebElement Subtopic;

	@FindBy(xpath = "//*[@id='activity']")
	WebElement Activity;

	@FindBy(xpath = "//div[@class='vc-title']")
	WebElement Month;

	@FindBy(xpath = "(//button[@class='button button v-button is-raised is-primary'])[2]")
	WebElement SaveBtn;

	// ***********************Actions*********************

	public void fillCompanyData(String jsonObjectName) throws IOException, ParseException {

		description = (String) getNewGoalJSONData(jsonObjectName).get("description");
		type = (String) getNewGoalJSONData(jsonObjectName).get("type");
		level = (String) getNewGoalJSONData(jsonObjectName).get("level");
		owner = (String) getNewGoalJSONData(jsonObjectName).get("owner");
		metric = (String) getNewGoalJSONData(jsonObjectName).get("metric");
		target = (String) getNewGoalJSONData(jsonObjectName).get("target");
		targetunit = (String) getNewGoalJSONData(jsonObjectName).get("targetunit");
		budget = (String) getNewGoalJSONData(jsonObjectName).get("budget");
		baselineyear = (String) getNewGoalJSONData(jsonObjectName).get("baselineyear");
		baseline = (String) getNewGoalJSONData(jsonObjectName).get("baseline");
		basis = (String) getNewGoalJSONData(jsonObjectName).get("basis");
		method = (String) getNewGoalJSONData(jsonObjectName).get("method");
		
		subtopic = (String) getNewGoalJSONData(jsonObjectName).get("subtopic");
		activity = (String) getNewGoalJSONData(jsonObjectName).get("activity");
		

		goalName = "Goal" + generateCommonLangPassword(10).replace("'", "");
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
		selectDropDown(Subtopic,subtopic);
		selectDropDown(Activity,  activity);
		
		
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
	
	
	
	public void SubmitForm() {

		clickElement(SaveBtn);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
