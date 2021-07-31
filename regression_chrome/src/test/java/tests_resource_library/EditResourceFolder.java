package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import static constants.ConstantsFile.*;

public class EditResourceFolder extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Create_New_Resource_Library_Folder();
	}

	@Test(priority = 4, description = "user_Can_Open_Resource_Library_Folder")
	public void user_Can_Attempt_To_Edit_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Attempts_Edit_Of_Library_Folder();
	}

	@Test(priority = 5, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 6, description = "user_Can_Add_Resource_File_To_Folder")
	public void user_Actually_Edits_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Actually_Edits_Library_Folder();
	}

	@Test(priority = 7, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 8, description = "user_Can_Delete_File")
	public void user_Verifies_New_Folder_Name() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Verifies_New_Folder_Name();
	}

	@Test(priority = 9, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 11, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Edit-Resource-Library-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_Folder_Deleted();
	}
}