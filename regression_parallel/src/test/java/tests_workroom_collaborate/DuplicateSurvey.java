package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class DuplicateSurvey extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 3, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey(survey10);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}
	
	@Test(priority = 7, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 8, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 9, description = "duplicate_Survey_10")
	public void duplicate_Survey_10() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.duplicate_Survey_10(survey11);
	}
	
	@Test(priority = 10, description = "build_Survey_Make_Visible_Agian")
	public void build_Survey_Make_Visible_Agian() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 11, description = "delete_Surveys_10_And_Survey_11")
	public void delete_Surveys_10_And_Survey_11() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_10();
		objCreateSurvey.delete_Survey_11();
	}
	
	@Test(priority = 12, description = "verify_Survey_10_Survey_11_Deleted")
	public void verify_Survey_10_Survey_11_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_10_Survey_11_Deleted();
	}

}