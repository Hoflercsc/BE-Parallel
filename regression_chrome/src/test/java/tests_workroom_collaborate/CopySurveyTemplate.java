package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CopySurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_Template();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 5, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 6, description = "back_To_Template_Main_Page")
	public void back_To_Template_Main_Page() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.back_To_Template_Main_Page();
	}
	
	@Test(priority = 7, description = "copy_Survey_Template")
	public void copy_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.copy_Survey_Template();
	}
	
	@Test(priority = 8, description = "back_To_Survey_Templates")
	public void back_To_Survey_Templates() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.back_To_Survey_Templates();
	}
	
	@Test(priority = 9, description = "verify_Template_Copy_Exists")
	public void verify_Template_Copy_Exists() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyTemplateCopyExists();
	}

	@Test(priority = 10, description = "delete_Template_Survey")
	public void delete_Survey_Templates() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey_Templates();
		objCreateSurvey.delete_Survey_Templates();
	}
	
	@Test(priority = 11, description = "verify_Templates_Deleted")
	public void verify_Templates_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyTemplatesDeleted();
	}

}