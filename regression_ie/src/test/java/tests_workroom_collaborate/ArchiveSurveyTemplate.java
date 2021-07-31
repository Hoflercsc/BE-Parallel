package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ArchiveSurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_Template();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 5, description = "create_DropdownList_Question")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 6, description = "back_To_Template_Main_Page")
	public void back_To_Template_Main_Page() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.back_To_Template_Main_Page();
	}
	
	@Test(priority = 7, description = "archive_Survey_Template")
	public void archive_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.archive_Survey_Template();
	}

	@Test(priority = 8, description = "delete_Archived_Template_Survey")
	public void delete_Archived_Template_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Archived_Template_Survey();
	}
	
	@Test(priority = 9, description = "user_Navigates_To_Survey")
	public void user_Navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_navigates_To_Survey_2();
	}
	
	@Test(priority = 10, description = "verifyArchivesDeleted")
	public void verify_Archives_NOT_Present() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Archive-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyArchivesNOTPresent();
	}

}