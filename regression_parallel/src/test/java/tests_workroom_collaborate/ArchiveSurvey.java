package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class ArchiveSurvey extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}
	
	@Test(priority = 3, description = "create_Survey")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey(survey2);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = "create_DropdownList_Question")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "Scenario - Add Workroom Survey Respondents.")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 8, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 9, description = "archive_Survey_2")
	public void archive_Survey_2() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.archive_Survey_2();
	}

	@Test(priority = 10, description = "delete_Archived_Survey_2")
	public void delete_Archived_Survey_2() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Archived_Survey_2();
	}
	
	@Test(priority = 11, description = "verify_Survey_2_NOT_Present")
	public void verify_Survey_2_NOT_Present() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_2_NOT_Present();
	}

}