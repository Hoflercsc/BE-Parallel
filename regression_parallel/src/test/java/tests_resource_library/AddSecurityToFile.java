package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddSecurityToFile extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Create_Resource_Library_Folder_6")
	public void user_Create_Resource_Library_Folder_6() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_6(newLibraryFolder6); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 6, description = "user_Can_Add_File_Folder_6")
	public void user_Can_Add_File_Folder_6() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_Folder_6();
	}
	
	@Test(priority = 7, description = "user_Can_Add_Security_To_File")
	public void user_Can_Add_Security_To_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Security_To_File();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "autodirector_login")
	public void autoDirector_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser2, password);
	}
	
	@Test(priority = 10, description = "user_Open_Resource_Library_Verify_Search_Field")
	public void user_Open_Resource_Library_Verify_Search_Field() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library_Verify_Search_Field();
	}
	
	@Test(priority = 11, description = "verify_File_Not_In_Library_Folder_6")
	public void verify_File_Not_In_Library_Folder_6() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_File_Not_In_Library_Folder_6();
	}
	
	@Test(priority = 12, description = "user_Can_Logout_AutoDirector")
	public void user_Can_Logout_AutoDirector() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 13, description = "systemAdmin_Login_Again")
	public void systemAdmin_Login_Again() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 15, description = "user_Delete_Resource_Library_Folder_6")
	public void user_Delete_Resource_Library_Folder_6() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Resource_Library_Folder_6();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 17, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 18, description = "verify_Resource_Library_Folder_6_NOT_Present")
	public void verify_Resource_Library_Folder_6_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_6_NOT_Present();
	}
}