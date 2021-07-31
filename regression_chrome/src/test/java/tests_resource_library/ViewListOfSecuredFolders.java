package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class ViewListOfSecuredFolders extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_New_Resource_Library_Folder();
	}
	
	@Test(priority = 4, description = "user_Close_Library_Folder")
	public void user_Close_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 6, description = "user_Can_Add_Security_To_Folder")
	public void user_Can_Add_Security_To_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_Security_To_Folder_1();
	}
	
	@Test(priority = 7, description = "user_Close_Library_Folder_2nd_Time")
	public void user_Close_Library_Folder_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 9, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder();
	}
	
	@Test(priority = 10, description = "user_Close_Library_Folder_3rd_Time")
	public void user_Close_Library_Folder_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}

	@Test(priority = 11, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 12, description = "user_Can_Add_Security_To_Folder_2")
	public void user_Can_Add_Security_To_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_Security_To_Folder_2();
	}
	
	@Test(priority = 13, description = "user_Close_Library_Folder_4th_Time")
	public void user_Close_Library_Folder_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Close_Library_Folder();
	}
	
	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Open_Libraries_Form_2();
	}
	
	@Test(priority = 15, description = "verify_Folders_In_Secured_Folders_Catergory")
	public void verify_Folders_In_Secured_Folders_Catergory() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folders_In_Secured_Folders_Catergory();
	}
	
	@Test(priority = 16, description = "user_Delete_Both_Folders")
	public void user_Delete_Both_Folders() throws InterruptedException {
		test.assignCategory("Resource-Library >> View-List-Of-Secured-Folders");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Both_Folders();
	}

}