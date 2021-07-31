package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddApproversToFile extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_4(newLibraryFolder4); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 8, description = "user_Can_Add_File_Folder_4")
	public void user_Can_Add_File_Folder_4() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_Folder_4();
	}
	
	@Test(priority = 9, description = "user_Can_Add_Security_To_File")
	public void user_Can_Add_Security_To_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Approvers_To_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 12, description = "user_Can_Verify_Approvers_Added_To_New_Folder_4")
	public void user_Can_Verify_Approvers_Added_To_New_Folder_4() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Verify_Approvers_Added_To_New_Folder_4();
	}
	
	@Test(priority = 13, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 14, description = "user_Delete_Folder_4")
	public void user_Delete_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Folder_4();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Approvers-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_4_NOT_Present();
	}
}