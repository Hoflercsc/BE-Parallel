package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class MoveEditDeleteFile extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	// MoveResourceFolderPage obj_move_resource;
	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_New_Resource_Library_Folder();
	}
	
	@Test(priority = 5, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 7, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder();
	}
	
	@Test(priority = 8, description = "user_Can_Add_File_To_2nd_Folder")
	public void user_Can_Add_File_To_2nd_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_to_2nd_Folder();
	}
	
	@Test(priority = 9, description = "user_Can_Move_File")
	public void user_Can_Move_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Move_File();
	}
	
	@Test(priority = 10, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 12, description = "verify_File_Moved")
	public void verify_File_Moved() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_File_Moved();
	}

	@Test(priority = 13, description = "user_Can_Edit_File")
	public void user_Can_Edit_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Edit_File_2();
	}
	
	@Test(priority = 14, description = "user_Can_Delete_File")
	public void user_Can_Delete_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Delete_File();
	}
	
	@Test(priority = 15, description = "user_Close_Library_Folder_4th_Time")
	public void user_Close_Library_Folder_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 17, description = "user_Delete_Both_Folders")
	public void user_Delete_Both_Folders() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Both_Folders_B();
	}

	@Test(priority = 18, description = "user_Close_Library_Folder_5th_Time")
	public void user_Close_Library_Folder_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 19, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	@Test(priority = 20, description = "verify_Both_Folders_Deleted")
	public void verify_Both_Folders_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Both_Folders_Deleted();
	}
}