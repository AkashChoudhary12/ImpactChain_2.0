package com.ImpactChain2.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ImpactChain2.base.TestBase;
import com.ImpactChain2.pageClass.AddNewGoalPage;
import com.ImpactChain2.pageClass.AddSubGoalPage;
import com.ImpactChain2.pageClass.GoalSettingPage;
import com.ImpactChain2.pageClass.GoalsPage;
import com.ImpactChain2.pageClass.LoginPage;

public class AddSubGoalTest extends TestBase {

	public AddSubGoalTest() {
		// calls the constructor of extended TestBase class
		super();

	}

	@Test(description = "Verify Add New Climate Sub Goal")
	public void verify_Add_New_Climate_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalsPage.clickClimate();
		goalsPage.ClickOnID("Goal3tE5reUCXhT4cl-ia");
		goalsettingpage = new  GoalSettingPage(driver);
		goalsettingpage.addSubgoal();
		addsubgoalpage = new AddSubGoalPage(driver);
		addsubgoalpage.fillCompanyData("Add_Goals_Data");
		addsubgoalpage.enterstartDate();
		addsubgoalpage.SelectDate("2023.09", "September 15");
		addsubgoalpage.enterendDate();
		addsubgoalpage.SelectDate("2023.11", "November 16");
		addsubgoalpage.SubmitForm();
	}

	
	
}

