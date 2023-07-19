package com.ImpactChain2.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain2.utils.FunctionLibraryESG;

public class ClimateGoalListPage extends FunctionLibraryESG {

	WebDriver driver;

	public ClimateGoalListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************************************

//	@FindBy(xpath = "//td[normalize-space()='Description 1']")
//	WebElement GoalName;

	// table/tbody/tr[*]/td[2][text()='Climate Goal 1']

	// ***********************Actions*********************

	public void verifyCLimateGoal(String expectedgoalname) {

		String GoalName = getText(By.xpath("//table/tbody/tr[*]/td[2][text()='" + expectedgoalname + "']"));
		verify(expectedgoalname.trim(), GoalName.trim());

	}

}
