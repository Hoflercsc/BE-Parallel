package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class ViewListOfSecuredFolders extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_18(newLibraryFolder18); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 6, description = "user_Can_Add_Security_To_Folder_18")
	public void user_Can_Add_Security_To_Folder_18() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Security_To_Folder_18();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 9, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_19(newLibraryFolder19); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 12, description = "user_Can_Add_Security_To_Folder_2")
	public void user_Can_Add_Security_To_Folder_19() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Security_To_Folder_19();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 15, description = "verify_Folders_18_19_In_Secured_Folders_Catergory")
	public void verify_Folders_18_19_In_Secured_Folders_Catergory() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Folders_18_19_In_Secured_Folders_Catergory();
	}
	
	@Test(priority = 16, description = "user_Delete_Both_18_19_Folders")
	public void user_Delete_Both_18_19_Folders() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Both_18_19_Folders();
	}

}