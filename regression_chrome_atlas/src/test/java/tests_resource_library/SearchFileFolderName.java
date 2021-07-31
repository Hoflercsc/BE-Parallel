package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class SearchFileFolderName extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_New_Resource_Library_Folder();
	}
	
	@Test(priority = 4, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 6, description = "user_Can_Add_File_To_2nd_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder();
	}
	
	@Test(priority = 7, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 12, description = "user_Can_Search_For_File")
	public void user_Can_Search_For_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Search_For_Folder_File_Name(fileName);
	}
	
	@Test(priority = 13, description = "user_Can_Search_For_Folder")
	public void user_Can_Search_For_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Search_For_Folder_File_Name(folder1);
	}
	
	@Test(priority = 14, description = "user_Close_Library_Folder_4th_Time")
	public void user_Close_Library_Folder_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 15, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 16, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Delete_Folder_B();
	}

	@Test(priority = 17, description = "user_Close_Library_Folder_5th_Time")
	public void user_Close_Library_Folder_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 18, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 19, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folder_Deleted_B();
	}
}