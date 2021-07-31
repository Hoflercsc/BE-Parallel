package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class MoveEditDeleteFile extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_DC();
	}

	@Test(priority = 3, description = "user_Create_Resource_Library_Folder_11")
	public void user_Create_Resource_Library_Folder_11() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_11(newLibraryFolder11); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_DC();
	}
	
	@Test(priority = 5, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_12(newLibraryFolder12); // create folder
	}
	
	@Test(priority = 6, description = "user_Can_Add_File_Folder_12")
	public void user_Can_Add_File_Folder_12() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_Folder_12();
	}
	
	@Test(priority = 7, description = "user_Can_Move_File_Folder_11")
	public void user_Can_Move_File_Folder_11() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Move_File_Folder_11();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_DC();
	}
	
	@Test(priority = 9, description = "verify_File_Moved_To_Folder_11")
	public void verify_File_Moved_To_Folder_11() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_File_Moved_To_Folder_11();
	}

	@Test(priority = 10, description = "user_Can_Edit_File_In_Folder_11")
	public void user_Can_Edit_File_In_Folder_11() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Edit_File_In_Folder_11();
	}
	
	@Test(priority = 11, description = "user_Can_Delete_File")
	public void user_Can_Delete_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_DC();
	}
	
	@Test(priority = 13, description = "user_Delete_Folders_11_And_12")
	public void user_Delete_Folders_11_And_12() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Folders_11_And_12();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_DC();
	}
	@Test(priority = 15, description = "verify_Folders_11_And_12_Deleted")
	public void verify_Folders_11_And_12_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-Edit-Delete-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Folders_11_And_12_Deleted();
	}
}