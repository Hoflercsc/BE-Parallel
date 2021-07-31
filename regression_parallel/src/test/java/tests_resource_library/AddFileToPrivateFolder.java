package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddFileToPrivateFolder extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "Resource-Library >> Add-File-To-Private-Folder")
	public void add_File_To_Private_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_File_To_Private_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 5, description = "user_Can_Delete_Private_Folder_File")
	public void user_Can_Delete_Private_Folder_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_Private_Folder_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 7, description = "verify_File_Not_Present")
	public void verify_File_Not_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.click_Your_Private_Folder();
		Thread.sleep(1500);
		obj_move_resource.verify_File_Not_Present_In_Library_Folder();
	}


}