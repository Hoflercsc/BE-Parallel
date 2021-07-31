package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class SortPrivateFolderHeaders extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}

	@Test(priority = 3, description = "add_File_To_Private_Folder")
	public void add_File_To_Private_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.add_File_To_Private_Folder();
	}
	
	@Test(priority = 4, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}

	@Test(priority = 6, description = "Resource-Library >> Sort-Private-Folder-Headers")
	public void add_2nd_File_To_Private_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.add_2nd_File_To_Private_Folder();
	}
	
	@Test(priority = 7, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 9, description = "Resource-Library >> Sort-Private-Folder-Headers")
	public void verify_Sort_For_Private_Folder_Headers() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Sort_For_Private_Folder_Headers();
	}
	
	
	@Test(priority = 10, description = "user_Can_Delete_Private_Folder_File")
	public void user_Can_Delete_Private_Folder_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Delete_Private_Folder_File();
	}
	
	@Test(priority = 11, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 13, description = "user_Can_Delete_Private_Folder_File_2")
	public void user_Can_Delete_Private_Folder_File_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Delete_Private_Folder_File_2();
	}
	
	@Test(priority = 14, description = "verify_File_Not_Present")
	public void verify_Both_Files_Not_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Sort-Private-Folder-Headers");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.click_Your_Private_Folder();
		Thread.sleep(1000);
		obj_move_resource.click_Your_Private_Folder();
		Thread.sleep(1000);
		obj_move_resource.verify_Both_Files_Not_Present();
	}


}