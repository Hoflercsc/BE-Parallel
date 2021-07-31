package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class CreateNewSurveyUsingSurveyTemplate extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "url_Redirect_JhoflerStaging")
	public void url_Redirect_JhoflerStaging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		// redirect due to test due to parrellel testing causing miss behavior 
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 3, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_Template(survey8);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "back_To_Survey_Template_Home_Page")
	public void back_To_Survey_Template_Home_Page() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.back_To_Survey_Template_Home_Page();
	}
	
	@Test(priority = 8, description = "create_Survey_From_Survey_Template")
	public void create_Survey_From_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_From_Survey_Template(survey9);
	}
	
	@Test(priority = 10, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Template_Make_Visible();
	}
	
	@Test(priority = 12, description = "delete_Survey_9_From_Template")
	public void delete_Survey_9_From_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_9_From_Template();
	}
	
	@Test(priority = 13, description = "delete_Survey_8_Template")
	public void delete_Survey_8_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_8_Template();
	}
	
	@Test(priority = 14, description = "verify_Survey_8_Template_Deleted")
	public void verify_Survey_8_Template_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-New-Survey-Using-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_8_Template_Deleted();
	}

}