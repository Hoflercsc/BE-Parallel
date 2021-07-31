package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserWorkroomMemberNoEventPermission extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "systemAdmin_Restrict_User_Access_From_Events")
	public void systemAdmin_Restrict_User_Access_From_Events() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Restrict_User_Access_From_Events();
	}

	@Test(priority = 4, description = "systemAdmin_Close_And_Logout")
	public void systemAdmin_Close_And_Logout() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 5, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 6, description = "workroom_Admin_Not_See_Event_Due_To_Permissions")
	public void workroom_Admin_Not_See_Event_Due_To_Permissions() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.workroom_Admin_Not_See_Event_Due_To_Permissions();
	}

	@Test(priority = 7, description = "workroom_User_Can_Logout")
	public void workroom_Member_Can_Logout() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 8, description = "systemAdmin_Can_Login_To_BoardEffect_2nd_Time")
	public void systemAdmin_Can_Login_To_BoardEffect_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password);
	}

	@Test(priority = 9, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 10, description = "systemAdmin_Enable_Events_For_Workroom_Member")
	public void systemAdmin_Enable_Events_For_Workroom_Member() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Enable_Events_For_Workroom_Member();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 12, description = "systemAdmin_Close_And_Logout")
	public void systemAdmin_Close_And_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 13, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 14, description = "workroom_Admin_Not_See_Event_Due_To_Permissions")
	public void workroom_Member_Sees_Event_Due_To_Permissions() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.workroom_Member_Sees_Event_Due_To_Permissions();
	}

	@Test(priority = 15, description = "workroom_User_Can_Logout")
	public void workroom_Member_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 16, description = "systemAdmin_Can_Login_To_BoardEffect_2nd_Time")
	public void systemAdmin_Can_Login_To_BoardEffect_3rd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password);
	}

	@Test(priority = 16, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	// ---------------Here add event to user as workroom member -----------
	@Test(priority = 17, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_As_Workroom_Admin();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 18, description = "systemAdmin_Close_And_Logout_2nd_Time")
	public void systemAdmin_Close_And_Logout_Agian_2nd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 19, description = "workroom_Member_Login_To_BoardEffect_3rd_Time")
	public void workroom_Member_Login_To_BoardEffect_3rd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 20, description = "workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button")
	public void workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 21, description = "workroom_Member_Can_Logout_3rd_Time")
	public void workroom_Member_Can_Logout_3rd_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 22, description = "systemAdmin_Can_Login_To_BoardEffect_4th_Time")
	public void systemAdmin_Can_Login_To_BoardEffect_4th_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password);
	}

	@Test(priority = 23, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 24, description = "systemAdmin_Set_User_As_Workroom_Member")
	public void systemAdmin_Set_User_As_Workroom_Member() throws InterruptedException {
		test.assignCategory("set_user_workroomadmin_no_event_permission");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_As_Workroom_Member();
	}
}