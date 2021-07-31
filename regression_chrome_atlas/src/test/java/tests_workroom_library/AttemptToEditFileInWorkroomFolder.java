package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class AttemptToEditFileInWorkroomFolder extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "create_New_Resource_Library_Folder")
	public void create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		Thread.sleep(2000); // adding sleep to make automation sits under correct folder
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_New_Resource_Library_Folder();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_To_Workroom_Folder")
	public void user_Can_Add_File_To_Workroom_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_To_Workroom_Folder();
	}
	
	@Test(priority = 6, description = "user_Can_Edit_File")
	public void user_Can_Edit_File() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Edit_File_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
		Thread.sleep(1500);
	}

	@Test(priority = 8, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_Folder_2();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 10, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Other-Files >> Attempt-To-Edit-File-In-Workroom-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}
}