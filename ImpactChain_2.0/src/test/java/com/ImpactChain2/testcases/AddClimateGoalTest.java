package com.ImpactChain2.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ImpactChain2.base.TestBase;
import com.ImpactChain2.pageClass.AddNewGoalPage;
import com.ImpactChain2.pageClass.ClimateGoalListPage;
import com.ImpactChain2.pageClass.GoalStatisticsPage;
import com.ImpactChain2.pageClass.GoalsPage;
import com.ImpactChain2.pageClass.LoginPage;

public class AddClimateGoalTest extends TestBase {

	public AddClimateGoalTest() {
		// calls the constructor of extended TestBase class
		super();

	}

	@Test(description = "Verify_Add_New_Climate_Goal")
	public void verify_Add_New_Climate_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalsPage.clickClimate();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		SelectDate("17", "July", "2023");
		addnewgoalpage.enterendDate();
		SelectDate("18", "July", "2023");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		climategoallistpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	
	@Test(description = "Verify_Add_New_Energy_Goal")
	public void verify_Add_New_Energy_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickEnergy();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_EnergyGoals_Data");
		addnewgoalpage.enterstartDate();
		SelectDate("17", "July", "2023");
		addnewgoalpage.enterendDate();
		SelectDate("18", "July", "2023");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		climategoallistpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












//loginPage = new LoginPage(driver);
//loginPage.login("F1_CompanyAdmin");
//goalsPage = new GoalsPage(driver);
//goalsPage.clickPlan();
//goalsPage.clickGoal();
//goalsPage.clickClimate();
//goalsPage.clickAddNewGoal();
//addnewgoalpage = new AddNewGoalPage(driver);
//addnewgoalpage.entername(goalName);
//addnewgoalpage.enterdescription("Description 1");
//addnewgoalpage.selectType("Facility");
//addnewgoalpage.selectLevel("Country");
//addnewgoalpage.enterstartDate();
//SelectDate("15", "July", "2023");
//addnewgoalpage.enterendDate();
//SelectDate("18", "July", "2023");
//addnewgoalpage.selectOwner("State");
//addnewgoalpage.entermetric("500");
//addnewgoalpage.entertarget("600");
//addnewgoalpage.entertargetunit("mt");
//addnewgoalpage.enterbudget("900");
//addnewgoalpage.selectbaselineyear("2023");
//addnewgoalpage.enterbaseline("700");
//addnewgoalpage.selectbasis("SBTI");
//addnewgoalpage.selectmethod("Absolute Contraction Approach");
//addnewgoalpage.clickNext();
//climategoallistpage = new ClimateGoalListPage(driver);
//climategoallistpage.verifyCLimateGoal(goalName);
















