package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class EditResourceFolder extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Create_View_Only_Resource_Library_Folder_10(newLibraryFolder10);
	}

	@Test(priority = 4, description = "user_Attempts_Edit_Resource_Library_Folder_10")
	public void user_Attempts_Edit_Resource_Library_Folder_10() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Attempts_Edit_Resource_Library_Folder_10();
	}

	@Test(priority = 5, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 6, description = "user_Actually_Edits_Library_Folder_10")
	public void user_Actually_Edits_Library_Folder_10() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Actually_Edits_Library_Folder_10();
	}

	@Test(priority = 7, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 8, description = "verify_Edited_Folder_Name")
	public void verify_Edited_Folder_10() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.verify_Edited_Folder_10();
	}

	@Test(priority = 9, description = "user_Can_Delete_Edited_Folder_10")
	public void user_Can_Delete_Edited_Folder_10() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_Edited_Folder_10();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 11, description = "verify_Edited_Folder_10_NOT_Present")
	public void verify_Edited_Folder_10_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.verify_Edited_Folder_10_NOT_Present();
	}
}