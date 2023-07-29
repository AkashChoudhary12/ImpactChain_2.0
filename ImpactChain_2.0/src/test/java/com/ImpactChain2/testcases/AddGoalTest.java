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

public class AddGoalTest extends TestBase {

	public AddGoalTest() {
		// calls the constructor of extended TestBase class
		super();

	}

	@Test(description = "Verify Add New Climate Goal")
	public void verify_Add_New_Climate_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalsPage.clickClimate();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 15");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
//		goalsPage.ClickOnID(addnewgoalpage.goalName);
//		goalsettingpage = new GoalSettingPage(driver);
//		goalsettingpage.verifyNames();	
	}

	@Test(description = "Verify Add New Energy Goal")
	public void verify_Add_New_Energy_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickEnergy();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 17");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 18");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	


	@Test(description = "Verify Add New Waste Goal")
	public void verify_Add_New_Waste_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickWaste();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}

	
	@Test(description = "Verify Add New FreshWater Goal")
	public void verify_Add_New_FreshWater_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickFreshWater();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}

	
	
	@Test(description = "Verify Add New Involuntary Labor Goal")
	public void verify_Add_New_Involuntary_Labor_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickInvoluntary_Labor();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	
	
	@Test(description = "Verify Add New Diversity and Inclusion Labor Goal")
	public void verify_Add_New_Diversity_and_Inclusion_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickDiversity_Inclusion();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	
	
	
	@Test(description = "Verify Add New Pay Equaility Labor Goal")
	public void verify_Add_New_Pay_Equaility_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickPay_Equality();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	
	
	@Test(description = "Verify Add New Ethical Behaviour Labor Goal")
	public void verify_Add_New_Ethical_Behaviour_Goal() throws IOException, ParseException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login("F1_CompanyAdmin_validCredential");
		goalsPage = new GoalsPage(driver);
		goalsPage.clickPlan();
		goalsPage.clickGoal();
		goalstatisticsPage = new GoalStatisticsPage(driver);
		goalstatisticsPage.clickEthical_Behaviour();
		goalsPage.clickAddNewGoal();
		addnewgoalpage = new AddNewGoalPage(driver);
		addnewgoalpage.fillCompanyData("Add_Goals_Data");
		addnewgoalpage.enterstartDate();
		addnewgoalpage.SelectDate("2023.09", "September 13");
		addnewgoalpage.enterendDate();
		addnewgoalpage.SelectDate("2023.11", "November 16");	
		addnewgoalpage.SubmitForm();
		climategoallistpage = new ClimateGoalListPage(driver);
		addnewgoalpage.verifyCLimateGoal(addnewgoalpage.goalName);
		
	}
	
}

