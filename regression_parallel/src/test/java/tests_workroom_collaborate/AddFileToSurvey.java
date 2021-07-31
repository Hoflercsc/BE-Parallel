package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class AddFileToSurvey extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey(survey1);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}
	
	@Test(priority = 7, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 8, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 9, description = "add_File_To_Survey_1")
	public void add_File_To_Survey_1() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.add_File_To_Survey_1();
	}
	
	@Test(priority = 10, description = "verify_File_Added_To_Survey_1")
	public void verify_File_Added_To_Survey_1() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_File_Added_To_Survey_1();
	}
	
	@Test(priority = 11, description = "delete_Survey_1")
	public void delete_Survey_1() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Add-File-To-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_1();
	}

}