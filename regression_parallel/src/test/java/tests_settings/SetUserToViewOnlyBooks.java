package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserToViewOnlyBooks extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Auto_User_20_Profile")
	public void open_Auto_User_20_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_20(autoUser20);
	}

	@Test(priority = 4, description = "enable_User_To_View_Only_Books")
	public void enable_User_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objPermissions = new PermissionsPage();
		objPermissions.enable_User_To_View_Only_Books();
	}
	
	@Test(priority = 5, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 6, description = "user_Create_Book")
	public void user_Create_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBookCS = new BookScannedPDFPage();
		objBookCS.user_Creates_New_Meeting_Book(meetingBook1);
		objBookCS.user_Can_Add_CoverPage();
		objBookCS.user_Add_Agenda_To_Template();
		objBookCS.user_Can_Save_Scanned_Book();
		objBookCS.user_Add_First_Catagory_To_Scanned_Book();
		objBookCS.user_Add_Scanned_Book_To_New_Catagory();
		objBookCS.user_Can_Build_Book();
		objBookCS.make_Meeting_Book_Visible();
		objBookCS.verify_Meeting_Book_1();
	}
	
	@Test(priority = 7, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "user_Can_Login")
	public void user_AutoUser20_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser20, password);
	}
	
	@Test(priority = 9, description = "Auto_Director_Opens_Library_Page_For_Workroom")
	public void Auto_Director_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 10, description = "verify_Meeting_Book_1_Meeting_Book_Viewer_Shown")
	public void verify_Meeting_Book_1_Meeting_Book_Viewer_Shown() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Meeting_Book_1_Meeting_Book_Viewer_Shown();
	}
	
	@Test(priority = 11, description = "click_Meeting_Book_Viewer_And_Scroll")
	public void click_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBookCS = new BookScannedPDFPage();		
		objBookCS.click_Meeting_Book_Viewer_And_Scroll();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "Auto_Director_Can_Logout")
	public void Auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 13, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 15, description = "open_Auto_User_20_Profile_2nd_Time")
	public void open_Auto_User_20_Profile_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_20(autoUser20);
	}
	
	@Test(priority = 16, description = "disable_User_To_View_Only_Books")
	public void disable_User_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objPermissions = new PermissionsPage();
		objPermissions.disable_User_To_View_Only_Books();
	}
	
	@Test(priority = 17, description = "system_Admin_Open_Library_Page_For_Workroom_2nd_Time")
	public void system_Admin_Open_Library_Page_For_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 18, description = "delete_Meeting_Book_1")
	public void delete_Meeting_Book_1() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBookCS = new BookScannedPDFPage();		
		objBookCS.delete_Meeting_Book_1();
	}
	
	@Test(priority = 19, description = "verify_Meeting_Book_1_Deleted")
	public void verify_Meeting_Book_1_Deleted() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-View-Only-Books");
		
		objBookCS = new BookScannedPDFPage();		
		objBookCS.verify_Meeting_Book_1_Deleted();
	}
	
}