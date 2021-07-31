package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class AddSecurityToFile extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder();
	}
	
	@Test(priority = 5, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 8, description = "user_Can_Add_File_To_2nd_Folder")
	public void user_Can_Add_File_To_2nd_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_to_2nd_Folder();
	}
	
	@Test(priority = 9, description = "user_Can_Add_Security_To_File")
	public void user_Can_Add_Security_To_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_Security_To_File();
	}
	
	@Test(priority = 11, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 12, description = "autodirector_login")
	public void autoDirector_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_In_AutoDirector")
	public void user_Can_Open_Libraries_In_AutoDirector() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 13, description = "user_Can_Add_File_To_2nd_Folder")
	public void verify_File_Not_Present_in_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_File_Not_Present_in_Folder();
	}
	
	@Test(priority = 14, description = "user_Can_Logout_AutoDirector")
	public void user_Can_Logout_AutoDirector() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 15, description = "systemAdmin_Login_Again")
	public void systemAdmin_Login_Again() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 17, description = "user_Delete_Folder_2")
	public void user_Delete_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Folder_2();
	}

	@Test(priority = 18, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 19, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	@Test(priority = 20, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folder2_NOT_Present();
	}
}