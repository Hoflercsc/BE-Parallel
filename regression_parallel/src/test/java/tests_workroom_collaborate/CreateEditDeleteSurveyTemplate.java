package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteSurveyTemplate extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}
	
	@Test(priority = 4, description = "create_Survey_Template")
	public void create_Survey_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_Template(survey7);
	}

	@Test(priority = 5, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 6, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 7, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 8, description = "back_To_Survey_Template_Home_Page")
	public void back_To_Survey_Template_Home_Page() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.back_To_Survey_Template_Home_Page();
	}
	
	@Test(priority = 9, description = "edit_Survey_Template_Title_7")
	public void edit_Survey_7_Template() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Survey_7_Template(survey7TemplateEdited);
	}

	@Test(priority = 10, description = "delete_Template_Survey")
	public void delete_Template_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_7_Template_Edited();
	}
	
	@Test(priority = 11, description = "verify_Survey_7_Survey_7_Template_Edited_Deleted")
	public void verify_Survey_7_Survey_7_Template_Edited_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Copy-Edit-Delete-Survey-Template");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_7_Survey_7_Template_Edited_Deleted();

	}
	
}