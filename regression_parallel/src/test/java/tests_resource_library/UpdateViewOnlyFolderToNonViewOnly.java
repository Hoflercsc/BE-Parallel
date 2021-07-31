package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class UpdateViewOnlyFolderToNonViewOnly extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "verify_Add_Files_Disable_For_Workroom_For_User")
	public void verify_Add_Files_Disable_For_Workroom_For_User() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		// make sure manage files is disabled and add files to workroom is enabled
		//normal board member should not have to have (manage files enabled to see files in workroom)
		objPermissions = new PermissionsPage(); 
		objPermissions.disable_Add_Files_To_Workroom_For_User(); 
	}

	@Test(priority = 5, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 6, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_View_Only_Resource_Library_Folder_17(newLibraryFolder17); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 8, description = "user_Can_Add_File_To_Folder_17")
	public void user_Can_Add_File_To_Folder_17() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_To_Folder_17();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 9, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library_Verify_Search_Field();
	}
	
	@Test(priority = 12, description = "verify_View_Only_Permissions")
	public void verify_View_Only_Permissions_Folder_17() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_View_Only_Permissions_Folder_17();
	}
	
	@Test(priority = 13, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 14, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 15, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 16, description = "user_Disables_View_Only_On_Folder_17")
	public void user_Disables_View_Only_On_Folder_17() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Disables_View_Only_On_Folder_17();
	}
	
	@Test(priority = 17, description = "system_Admin_Can_Logout_2nd_Time")
	public void system_Admin_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 18, description = "auto_Director_Can_Login_2nd_Time")
	public void auto_Director_Can_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 19, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library_Verify_Search_Field();
	}
	
	@Test(priority = 20, description = "verify_View_Only_Permissions_Folder_17_Disabled")
	public void verify_View_Only_Permissions_Folder_17_Disabled() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_View_Only_Permissions_Folder_17_Disabled();
	}
	
	@Test(priority = 21, description = "auto_Director_Can_Logout_2nd_time")
	public void auto_Director_Can_Logout_2nd_time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 22, description = "system_Admin_Can_Login_2nd_time")
	public void system_Admin_Can_Login_2nd_time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 23, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 24, description = "user_Can_Delete_Library_Folder_17")
	public void user_Can_Delete_Library_Folder_17() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_Library_Folder_17();
	}
	
	@Test(priority = 25, description = "user_Can_Open_Libraries_Form_7th_Time")
	public void user_Can_Open_Libraries_Form_7th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 26, description = "verify_Folder_17_NOT_Present")
	public void verify_Folder_17_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage();
		Thread.sleep(1500);
		obj_edit_resource.verify_Folder_17_NOT_Present();
	}
}