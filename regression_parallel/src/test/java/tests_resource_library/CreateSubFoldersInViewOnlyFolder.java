package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class CreateSubFoldersInViewOnlyFolder extends BaseTestResourceLibrary {	
	
	@Test(priority = 0, description = "url_Redirect_Jhofler_Staging")
	public void url_Redirect_Jhofler_Staging() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		// redirect due to test due to parrellel testing causing miss behavior 
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 3, description = "create_View_Only_Resource_Library_SubFolders_In_View_Only_Folder")
	public void create_View_Only_Resource_Library_SubFolders_In_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.create_View_Only_Resource_Library_SubFolders_In_View_Only_Folder(subFoldersInViewOnly);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}
	
	@Test(priority = 7, description = "user_Can_Create_SubFolder1_In_Folder")
	public void user_Can_Create_SubFolder1_In_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.create_Sub_Folder1(subFolder1);
	}
	
	@Test(priority = 8, description = "verify_Sub_Folder_Created")
	public void verify_Sub_Folder1_Created() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Sub_Folder1_Created();
	}
	
	@Test(priority = 9, description = "user_Can_Create_SubFolder2_In_Folder")
	public void user_Can_Create_SubFolder2_In_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.create_Sub_Folder2(subFolder2);
	}
	
	@Test(priority = 10, description = "verify_Sub_Folder2_Created")
	public void verify_Sub_Folder2_Created() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Sub_Folder2_Created();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 13, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.delete_Folder_Sub_Folders_In_ViewOnly_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_6th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Marvel_WR();
	}

	@Test(priority = 15, description = "verify_Folder_Sub_Folders_In_View_Only_NOT_Present")
	public void verify_Folder_Sub_Folders_In_View_Only_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Create-SubFolders-In-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.verify_Folder_Sub_Folders_In_View_Only_NOT_Present();
	}
}