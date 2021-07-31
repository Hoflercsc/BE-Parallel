package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AttemptToEditFileInViewOnlyFolder extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 3, description = "create_View_Only_Resource_Library_Folder2")
	public void create_View_Only_Resource_Library_Folder2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.create_View_Only_Resource_Library_Folder2(newViewOnlyFolder2);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_View_Only_Folder_2")
	public void user_Can_Add_File_View_Only_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_View_Only_Folder();
	}
	
	@Test(priority = 6, description = "user_Can_Edit_File")
	public void user_Can_Edit_File() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Edit_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}
	
	@Test(priority = 8, description = "verify_Resource_File_Edited")
	public void verify_Resource_File_Edited() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_File_Edited();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 10, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_View_Only_Folder_2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_7th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 12, description = "verify_View_Only_Folder_2_Deleted")
	public void verify_View_Only_Folder_2_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Attempt-To-Edit-File-In-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.verify_View_Only_Folder_2_Deleted();
	}
}