package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class CreateDeleteFolder extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Create_Resource_Library_Folder_8")
	public void user_Create_Resource_Library_Folder_8() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_8(newLibraryFolder8); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 6, description = "delete_Resource_Library_Folder_8")
	public void delete_Resource_Library_Folder_8() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.delete_Resource_Library_Folder_8();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 9, description = "verify_Resource_Library_Folder_8_NOT_Present")
	public void verify_Resource_Library_Folder_8_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-Delete-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_8_NOT_Present();
	}
}