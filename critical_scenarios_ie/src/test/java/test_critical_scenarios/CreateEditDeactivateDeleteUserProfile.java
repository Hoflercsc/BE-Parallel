package test_critical_scenarios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PollPage;
import page_critical_scenarios.SurveyPage;
import page_critical_scenarios.UserProfilePage;
import static constants.ConstantsFile.*;

public class CreateEditDeactivateDeleteUserProfile extends BaseTestCriticalScenarios {
	
	@Test(priority = 1, description = "Scenario Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "systemAdmin_Search_For_User")
	public void systemAdmin_Open_Directory_Search_For_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_Directory_Search_For_User();
	}

	@Test(priority = 3, description = "systemAdmin_Create_Old_User_1")
	public void systemAdmin_Create_Old_User_1() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Create_Old_User_1();
	}

	@Test(priority = 4, description = "systemAdmin_Create_Old_User_2")
	public void systemAdmin_Create_Old_User_2() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Create_Old_User_2();
	}

	@Test(priority = 5, description = "verify_Old_Users_Created")
	public void verify_Old_Users_Created() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.verify_Old_Users_Created();
	}

	@Test(priority = 6, description = "systemAdmin_Deactivate_Old_Users_Close_Directory()")
	public void systemAdmin_Deactivate_Old_Users_Close_Directory() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Deactivate_Old_Users_Close_Directory();
	}

	@Test(priority = 7, description = "systemAdmin_Open_Settings_Open_ManageUsers()")
	public void systemAdmin_Open_Settings_Open_ManageUsers() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_Settings_Open_ManageUsers();
	}

	@Test(priority = 8, description = "systemAdmin_Open_InactiveUsersTab_Delete_Old_Users()")
	public void systemAdmin_Open_InactiveUsersTab_Delete_Old_Users() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_InactiveUsersTab_Delete_Old_Users();
	}

	@Test(priority = 9, description = "systemAdmin_Create_Save_New_User()")
	public void systemAdmin_Create_Save_New_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Create_Save_New_User();
	}

	@Test(priority = 10, description = "systemAdmin_Open_WorkroomTab_Add_Workroom_2_User")
	public void systemAdmin_Open_WorkroomTab_Add_Workroom_2_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_WorkroomTab_Add_Workroom_2_User();
	}

	@Test(priority = 11, description = "systemAdmin_Search_For_User_Open_Profile()")
	public void systemAdmin_Search_For_User_Open_Profile() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Search_For_User_Open_Profile();
	}

	@Test(priority = 12, description = "systemAdmin_Edit_Save_User_Profile()")
	public void systemAdmin_Edit_Save_User_Profile() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Edit_Save_User_Profile();
	}

	@Test(priority = 13, description = "systemAdmin_Close_Profile_Form_Searh_4_Updated_User()")
	public void systemAdmin_Close_Profile_Form_Searh_4_Updated_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Close_Profile_Form_Searh_4_Updated_User();
	}

	@Test(priority = 14, description = "systemAdmin_Deactivate_Updated_User()")
	public void systemAdmin_Deactivate_Updated_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Deactivate_Updated_User();
	}

	@Test(priority = 15, description = "systemAdmin_Close_Access_Permissions_and_Directory_Form")
	public void systemAdmin_Close_Access_Permissions_and_Directory_Form() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Close_Access_Permissions_and_Directory_Form();
	}

	@Test(priority = 16, description = "systemAdmin_Open_Settings_Manage_Users_Then_Inactive_Users_Tab")
	public void systemAdmin_Open_Settings_Manage_Users_Then_Inactive_Users_Tab() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_Settings_Manage_Users_Then_Inactive_Users_Tab();
	}

	@Test(priority = 17, description = "systemAdmin_Can_Delete_Updated_User")
	public void systemAdmin_Can_Delete_Updated_User() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Can_Delete_Updated_User();
	}

	@Test(priority = 18, description = "systemAdmin_Open_Directory_Search_Updated_User_NOT_To_Be_Present")
	public void systemAdmin_Open_Directory_Search_Updated_User_NOT_To_Be_Present() throws InterruptedException {
		test.assignCategory("CreateEditDeactivateDeleteUserProfile");
		
		objUserProfile = new UserProfilePage(driver);
		objUserProfile.systemAdmin_Open_Directory_Search_Updated_User_NOT_To_Be_Present();
	}
}