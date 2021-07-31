package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CopySurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}
	
	@Test(priority = 3, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_Template(survey5);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "back_To_Template_Main_Page")
	public void back_To_Template_Main_Page() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.back_To_Survey_Template_Home_Page();
	}
	
	@Test(priority = 8, description = "copy_Survey_5_As_Template")
	public void copy_Survey_5_As_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.copy_Survey_5_As_Template(survey5Template);
	}
	
	@Test(priority = 9, description = "back_To_Survey_Templates")
	public void back_To_Survey_Templates() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.back_To_Survey_Template_Home_Page();
	}
	
	@Test(priority = 10, description = "verify_Survey_5_Template")
	public void verify_Survey_5_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_5_Template();
	}

	@Test(priority = 11, description = "delete_Survey_5_And_Survey_5_Templates")
	public void delete_Survey_5_And_Survey_5_Templates() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_5();
		objCreateSurvey.back_To_Survey_Template_Home_Page_Short();
		objCreateSurvey.delete_Survey_5_Template();
	}
	
	@Test(priority = 12, description = "verify_Templates_Deleted")
	public void verify_Survey_5_And_Survey_5_Template_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.back_To_Survey_Template_Home_Page_Short();
		objCreateSurvey.verify_Survey_5_And_Survey_5_Template_Deleted();
	}
	
}