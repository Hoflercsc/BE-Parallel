package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateSurveyFromSurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_Template();
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "back_To_Template_Main_Page")
	public void back_To_Template_Main_Page() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.back_To_Template_Main_Page();
	}
	
	@Test(priority = 8, description = "create_Survey_From_Survey_Template")
	public void create_Survey_From_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_From_Survey_Template(surveyTitle2);
	}
	
	@Test(priority = 10, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Template_Make_Visible();
	}
	
	@Test(priority = 11, description = "verify_New_Survey_From_Template_Created")
	public void verify_New_Survey_From_Template_Created() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyNewSurveyFromTemplate();
	}
	
	@Test(priority = 12, description = "delete_New_Survey")
	public void delete_New_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_New_Survey_From_Template();
	}
	
	@Test(priority = 13, description = "delete_Template_Survey")
	public void delete_Template_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Template_Survey();
	}
	
	@Test(priority = 14, description = "delete_Template_Survey")
	public void verify_Survey_Template_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Survey-From-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifySurveyTemplateDeleted();
	}

}