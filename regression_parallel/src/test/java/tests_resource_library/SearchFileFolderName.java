package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SearchFileFolderName extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_16(newLibraryFolder16); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 5, description = "user_Can_Add_File_To_Folder_16")
	public void user_Can_Add_File_To_Folder_16() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_To_Folder_16();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 7, description = "user_Can_Search_For_File")
	public void user_Can_Search_For_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Search_For_Folder_File_Name(fileNameWord1);
	}
	
	@Test(priority = 8, description = "user_Can_Search_For_Folder")
	public void user_Can_Search_For_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Search_For_Folder_File_Name(newLibraryFolder16);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 10, description = "user_Delete_Resource_Library_Folder_16")
	public void user_Delete_Resource_Library_Folder_16() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Resource_Library_Folder_16();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 12, description = "verify_Folder_Deleted")
	public void verify_Resource_Library_Folder_16_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Search-For-File-Folder-Name");
		
		obj_move_resource = new MoveResourceFolderPage();
		Thread.sleep(1500);
		obj_move_resource.verify_Resource_Library_Folder_16_NOT_Present();
	}
}