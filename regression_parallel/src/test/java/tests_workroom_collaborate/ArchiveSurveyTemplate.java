package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ArchiveSurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 3, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_Template(survey3);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = "create_DropdownList_Question")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "back_To_Survey_Template_Home_Page")
	public void back_To_Survey_Template_Home_Page() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_Template_3_Info_Created();
		objCreateSurvey.back_To_Survey_Template_Home_Page();
	}
	
	@Test(priority = 8, description = "archive_Survey_3_Template")
	public void archive_Survey_3_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.archive_Survey_3_Template();
	}

	@Test(priority = 9, description = "delete_Archived_Survey_3_Template")
	public void delete_Archived_Survey_3_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Archived_Survey_3_Template();
	}
	
	@Test(priority = 10, description = "user_Navigates_To_Survey")
	public void user_Navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Navigates_To_Survey();
	}
	
	@Test(priority = 11, description = "verify_Archived_Survey_3_Template_NOT_Present")
	public void verify_Archived_Survey_3_Template_NOT_Present() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Archived_Survey_3_Template_NOT_Present();
	}

}