package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddSecurityToFolder extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Create_Resource_Library_Folder_7")
	public void user_Create_Resource_Library_Folder_7() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_7(newLibraryFolder7); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 5, description = "user_Can_Add_Security_To_Folder_7")
	public void user_Can_Add_Security_To_Folder_7() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Security_To_Folder_7();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "autodirector_login")
	public void autoDirector_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser1, password);
	}
	
	@Test(priority = 8, description = "user_Open_Resource_Library_Verify_Search_Field")
	public void user_Open_Resource_Library_Verify_Search_Field() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library_Verify_Search_Field();
	}
	
	@Test(priority = 9, description = "verify_Folder_Not_Present")
	public void verify_Resource_Library_Folder_7_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_7_NOT_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 10, description = "user_Can_Logout_AutoDirector")
	public void user_Can_Logout_AutoDirector() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "systemAdmin_Login_Again")
	public void systemAdmin_Login_Again() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 13, description = "user_Delete_Folder_2")
	public void user_Delete_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.delete_Resource_Library_Folder_7();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 15, description = "verify_Resource_Library_Folder_7_NOT_Present_Again")
	public void verify_Resource_Library_Folder_7_NOT_Present_Again() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-Security-To-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_7_NOT_Present();
	}
}