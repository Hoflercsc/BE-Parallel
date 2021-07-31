package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteSurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_Template();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 5, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 6, description = "back_To_Template_Main_Page")
	public void back_To_Template_Main_Page() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.back_To_Template_Main_Page();
	}
	
	@Test(priority = 7, description = "edit_Survey_Template_Title")
	public void edit_Survey_Template_Title() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.edit_Survey_Template_Title();
	}

	@Test(priority = 8, description = "delete_Template_Survey")
	public void delete_Template_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Edited_Template_Survey();
	}
	
	@Test(priority = 9, description = "verify_edited_Template_Survey_Deleted")
	public void verify_edited_Template_Survey_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyEditedTemplateSurveyDeleted();

	}
	
}