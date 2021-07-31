package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class AddNewFilesViaUpload extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_New_Resource_Library_Folder();
	}
	
	@Test(priority = 4, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 6, description = "user_Can_Add_Multiple_Files_To_Folder")
	public void user_Can_Add_Multiple_Files_To_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_Multiple_Files_To_Folder();
	}
	
	@Test(priority = 7, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 9, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Delete_Folder_B();
	}
	
	@Test(priority = 10, description = "user_Close_Library_Folder_3rd_Time")
	public void user_Close_Library_Folder_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 12, description = "verify_Resource_Library_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Resource_Library_Folder_Deleted();
	}
	
}