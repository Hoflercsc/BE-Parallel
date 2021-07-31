package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class EditExistingFolderToViewOnly extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "verify_Add_Files_Disable_For_Workroom_For_User")
	public void verify_Add_Files_Disable_For_Workroom_For_User() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		// make sure manage files is disabled and add files to workroom is enabled
		//normal board member should not have to have (manage files enabled to see files in workroom)
		objPermissions = new PermissionsPage(driver); 
		objPermissions.disable_Add_Files_To_Workroom_For_User(); 
	}

	@Test(priority = 4, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");

		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 5, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
	}
	
	@Test(priority = 6, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 8, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
	}
	
	@Test(priority = 9, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 10, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library_2();
	}
	
	@Test(priority = 13, description = "verify_View_Only_Permissions")
	public void verify_View_Only_Permissions() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_View_Only_Permissions();
	}
	
	@Test(priority = 14, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 15, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 17, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_View_Only_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 18, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 19, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}
}