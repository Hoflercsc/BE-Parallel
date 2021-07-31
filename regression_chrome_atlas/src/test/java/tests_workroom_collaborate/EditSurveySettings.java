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
import extentreports.ExtentFactory;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class EditSurveySettings extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = " Scenario Create Workroom Survey.")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey();
	}

	@Test(priority = 4, description = " Scenario Create Workroom Survey All Questions.")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = " Scenario Create Workroom Survey All Questions.")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = "Scenario - Add Workroom Survey Respondents.")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 8, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 9, description = "Scenario - Build Survey and Make Visible.")
	public void edit_Survey_Settings() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.edit_Survey_Settings();
	}

	@Test(priority = 10, description = "Scenario - Build Survey and Make Visible.")
	public void view_Survey_Settings() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.view_Survey_Settings();
	}

	@Test(priority = 11, description = "Scenario - Build Survey and Make Visible.")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Survey-Settings");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}
	
}