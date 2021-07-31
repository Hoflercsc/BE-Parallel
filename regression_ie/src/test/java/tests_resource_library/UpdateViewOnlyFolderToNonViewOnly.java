package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class UpdateViewOnlyFolderToNonViewOnly extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
		driver.navigate().refresh();
	}

	@Test(priority = 6, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 7, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 9, description = "verify_View_Only_Permissions")
	public void verify_View_Only_Permissions() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_View_Only_Permissions();
	}
	
	@Test(priority = 10, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 11, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}
	
	@Test(priority = 13, description = "disable_View_Only_On_Library_Folder")
	public void disable_View_Only_On_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Disables_View_Only_On_Folder();
	}
	
	@Test(priority = 14, description = "system_Admin_Can_Logout_2nd_Time")
	public void system_Admin_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 15, description = "auto_Director_Can_Login_2nd_Time")
	public void auto_Director_Can_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form_3();
	}
	
	@Test(priority = 17, description = "verify_View_Only_Permissions_Disabled")
	public void verify_View_Only_Permissions_Disabled() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_View_Only_Permissions_Disabled();
	}
	
	@Test(priority = 18, description = "auto_Director_Can_Logout_2nd_time")
	public void auto_Director_Can_Logout_2nd_time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 19, description = "system_Admin_Can_Login_2nd_time")
	public void system_Admin_Can_Login_2nd_time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 20, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 21, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_Folder_2();
	}
	
	@Test(priority = 22, description = "user_Can_Open_Libraries_Form_7th_Time")
	public void user_Can_Open_Libraries_Form_7th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 23, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Update-View-Only-Folder-To-Non-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_Folder_Deleted_2();
	}
}