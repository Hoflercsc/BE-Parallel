package tests_critical_scenarios;

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
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PollPage;
import page_critical_scenarios.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateSurveyQuestionsAndDelete extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = " Scenario Create Workroom Survey.")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey();
	}

	@Test(priority = 4, description = " Scenario Create Workroom Survey All Questions.")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 5, description = " Scenario Create Workroom Survey All Questions.")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}

	@Test(priority = 6, description = " Scenario Create Workroom Survey All Questions.")
	public void create_DropdownList_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Dropdown_List_Question();
	}

	@Test(priority = 7, description = " Scenario Create Workroom Survey All Questions.")
	public void create_RadioButtons_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_RadioButtons_Question();
	}

	@Test(priority = 8, description = " Scenario Create Workroom Survey All Questions.")
	public void create_Paragraph_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Paragraph_Question();
	}

	@Test(priority = 9, description = " Scenario Create Workroom Survey All Questions.")
	public void create_Heading_Question() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Heading_Question();
	}

	@Test(priority = 10, description = " Scenario Create Workroom Survey All Questions.")
	public void create_Linear_Scale() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Linear_Scale();
	}

	@Test(priority = 11, description = "Scenario - Add Workroom Survey Respondents.")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents_CS();
	}

	@Test(priority = 12, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}

	@Test(priority = 13, description = "Scenario - Build Survey and Make Visible.")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("CreateSurveyQuestionsAndDelete");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey();
	}
}