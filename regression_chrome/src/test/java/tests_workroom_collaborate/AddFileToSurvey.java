package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class AddFileToSurvey extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey();
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}
	
	@Test(priority = 7, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 8, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 9, description = "add_File_To_Survey")
	public void add_File_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.add_File_To_Survey();
	}
	
	@Test(priority = 10, description = "add_File_To_Survey")
	public void verify_Survey_File_Added() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verify_Survey_File_Added();
	}
	
	
	@Test(priority = 11, description = "delete_Surveys")
	public void delete_Surveys() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}

}