package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class EditExistingFolderToViewOnly extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
	}
	
	@Test(priority = 4, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}
	
	@Test(priority = 7, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
	}
	
	@Test(priority = 8, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 9, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 10, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 12, description = "verify_View_Only_Permissions")
	public void verify_View_Only_Permissions() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_View_Only_Permissions();
	}
	
	@Test(priority = 13, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 14, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 15, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 16, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_View_Only_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 17, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 18, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Existing-Folder-To-View-Only");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}
}