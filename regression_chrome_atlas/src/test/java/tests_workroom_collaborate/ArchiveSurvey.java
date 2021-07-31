package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ArchiveSurvey extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Survey")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 5, description = "create_DropdownList_Question")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 6, description = "Scenario - Add Workroom Survey Respondents.")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 7, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 8, description = "archive_Survey")
	public void archive_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.archive_Survey();
	}

	@Test(priority = 9, description = "delete_Archived_Survey")
	public void delete_Archived_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Archived_Survey();
	}
	
	@Test(priority = 10, description = "verifyArchivesDeleted")
	public void verify_Archives_NOT_Present() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Survey");
		
		objCreateSurvey = new SurveyPage(driver);
		driver.navigate().refresh();
		Thread.sleep(3000);
		objCreateSurvey.verifyArchivesNOTPresent();
	}

}