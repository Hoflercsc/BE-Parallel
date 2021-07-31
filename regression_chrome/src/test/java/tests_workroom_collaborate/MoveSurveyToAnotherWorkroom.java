package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class MoveSurveyToAnotherWorkroom extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 5, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}
	
	@Test(priority = 6, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 7, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 8, description = "move_Survey_To_Another_Workroom")
	public void move_Survey_To_Another_Workroom() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.move_Survey_To_Another_Workroom();
	}
	
	@Test(priority = 9, description = "verify_Move_Workroom_AutoAttend")
	public void verify_Move_Workroom_AutoAttend() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verify_Move_Workroom_AutoAttend();
	}
	
	@Test(priority = 10, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Survey-To-Another-Workroom");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}

}