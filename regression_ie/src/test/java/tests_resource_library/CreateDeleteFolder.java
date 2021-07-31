package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class CreateDeleteFolder extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder();
	}
	
	@Test(priority = 5, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 7, description = "user_Delete_Folder_2")
	public void user_Delete_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Folder_2();
	}

	@Test(priority = 8, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	@Test(priority = 10, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folder2_NOT_Present();
	}
}