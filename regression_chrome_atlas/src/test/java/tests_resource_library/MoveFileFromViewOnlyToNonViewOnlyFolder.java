package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class MoveFileFromViewOnlyToNonViewOnlyFolder extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 7, description = "create_Non_View_Only_Resource_Library_Folder")
	public void create_Non_View_Only_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_Non_View_Only_Resource_Library_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 9, description = "move_File_From_View_Only_To_Non_View_Only")
	public void move_File_From_View_Only_To_Non_View_Only() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.move_File_From_View_Only_To_Non_View_Only();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 11, description = "verify_File_Moved")
	public void verify_File_Moved() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_File_Moved_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 13, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_View_Only_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 15, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_Folder_3();
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_7th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_NOT_Present();
		obj_edit_resource.verify_Folder_NOT_Present_3();
	}
}