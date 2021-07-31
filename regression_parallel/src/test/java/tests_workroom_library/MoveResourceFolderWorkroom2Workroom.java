package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class MoveResourceFolderWorkroom2Workroom extends BaseTestWorkroomLibrary {
	
	@Test(priority = 0, description = "url_Redirect_JhoflerStaging")
	public void url_Redirect_JhoflerStaging() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		// redirect due to test due to parrellel testing causing miss behavior 
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Settings_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_21(newLibraryFolder21); 
	}

	@Test(priority = 4, description = "user_Moves_Folder_21_To_AutoBE_Workroom")
	public void user_Moves_Folder_21_To_AutoBE_Workroom() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Moves_Folder_21_To_AutoBE_Workroom_Based_On_Site();
	}

	@Test(priority = 5, description = "workroom_Member_Open_Resource_Library_AutoBE_WR")
	public void workroom_Member_Open_Resource_Library_AutoBE_WR() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 6, description = "user_Delete_Resource_Library_Folder_21")
	public void user_Delete_Resource_Library_Folder_21() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Resource_Library_Folder_21();
	}

	@Test(priority = 7, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Open_Resource_Library();
	}

	@Test(priority = 8, description = "verify_Resource_Library_Folder_21_NOT_Present")
	public void verify_Resource_Library_Folder_21_NOT_Present() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-Resource-Folder-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_21_NOT_Present();
	}
	
	
}