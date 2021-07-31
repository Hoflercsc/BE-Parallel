package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SortPrivateFolderHeaders extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "add_File_To_Private_Folder_For_Sorting_1")
	public void add_File_To_Private_Folder_For_Sorting_1() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_File_To_Private_Folder_For_Sorting_1();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 6, description = "add_File_To_Private_Folder_For_Sorting_2")
	public void add_File_To_Private_Folder_For_Sorting_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_File_To_Private_Folder_For_Sorting_2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 9, description = "Resource-Library >> Sort-Private-Folder-Headers")
	public void verify_Sort_For_Private_Folder_Headers() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Sort_For_Private_Folder_Headers();
	}
	
	@Test(priority = 10, description = "user_Can_Delete_Private_Folder_File")
	public void user_Can_Delete_Private_Folder_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_Private_Folder_Word_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 13, description = "user_Can_Delete_Private_Folder_File_JPG")
	public void user_Can_Delete_Private_Folder_File_JPG() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_Private_Folder_File_JPG();
	}
	
	@Test(priority = 14, description = "verify_Both_Files_Word_JPG_Not_Present")
	public void verify_Both_Files_Word_JPG_Not_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.click_Your_Private_Folder();
		Thread.sleep(1500);
		obj_move_resource.verify_Both_Files_Word_JPG_Not_Present();
	}


}