package tests_workroom_collaborate;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class EditSurveyQuestions extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Duplicate-Survey");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 3, description = " Scenario Create Workroom Survey.")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey(survey12);
	}

	@Test(priority = 4, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 6, description = "create_Dropdown_List_Question")
	public void create_Dropdown_List_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "Scenario - Add Workroom Survey Respondents.")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 8, description = "navigate_To_Edit_Survey")
	public void navigate_To_Edit_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.navigate_To_Edit_Survey();
	}
	
	@Test(priority = 9, description = "edit_Text_Field_Question")
	public void edit_Text_Field_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Text_Field_Question();
	}
	
	@Test(priority = 10, description = "edit_Check_Box_Question")
	public void edit_Check_Box_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Check_Box_Question();
	}
	
	@Test(priority = 11, description = "edit_Dropdown_List_Question")
	public void edit_Dropdown_List_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Dropdown_List_Question();
	}

	@Test(priority = 12, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}

	@Test(priority = 13, description = "delete_Survey_12")
	public void delete_Survey_12() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_12();
	}
	
	@Test(priority = 14, description = "verify_Survey_12_Deleted")
	public void verify_Survey_12_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_12_Deleted();
	}
	
	
}