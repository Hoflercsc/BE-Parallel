package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class MoveFileFromViewOnlyToNonViewOnlyFolder extends BaseTestResourceLibrary {	
	
	@Test(priority = 0, description = "url_Redirect_JhoflerStaging")
	public void url_Redirect_JhoflerStaging() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		// redirect due to test due to parrellel testing causing miss behavior 
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Resource_Library_Space")
	public void user_Open_Resource_Library_Space() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}

	@Test(priority = 3, description = "user_Create_View_Only_Resource_Library_Folder_13")
	public void user_Create_View_Only_Resource_Library_Folder_13() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Create_View_Only_Resource_Library_Folder_13(newLibraryFolder13);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Open_Resource_Library_Space_2nd_Time")
	public void user_Open_Resource_Library_Space_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_To_View_Only_Folder_13")
	public void user_Can_Add_File_To_View_Only_Folder_13() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_To_View_Only_Folder_13();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Open_Resource_Library_Space_3rd_Time")
	public void user_Open_Resource_Library_Space_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}
	
	@Test(priority = 7, description = "create_Non_View_Only_Resource_Library_Folder_14")
	public void create_Non_View_Only_Resource_Library_Folder_14() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.create_Non_View_Only_Resource_Library_Folder_14(newLibraryFolder14);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Open_Resource_Library_Space_4th_Time")
	public void user_Open_Resource_Library_Space_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}
	
	@Test(priority = 9, description = "move_File_From_View_Only_Folder_13_To_Non_View_Only_Folder_14")
	public void move_File_From_View_Only_Folder_13_To_Non_View_Only_Folder_14() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.move_File_From_View_Only_Folder_13_To_Non_View_Only_Folder_14();
	}
	
	@Test(priority = 10, description = "user_Open_Resource_Library_Space_5th_Time")
	public void user_Open_Resource_Library_Space_5th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}

	@Test(priority = 11, description = "verify_File_Moved_To_Library_Folder_14")
	public void verify_File_Moved_To_Library_Folder_14() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_File_Moved_To_Library_Folder_14();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Open_Resource_Library_Space_6th_Time")
	public void user_Open_Resource_Library_Space_6th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}
	
	@Test(priority = 13, description = "user_Can_Delete_View_Only_Library_Folder_13")
	public void user_Can_Delete_View_Only_Library_Folder_13() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_View_Only_Library_Folder_13();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 14, description = "user_Open_Resource_Library_Space_7th_Time")
	public void user_Open_Resource_Library_Space_7th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}
	
	@Test(priority = 15, description = "user_Can_Delete_Library_Folder_14")
	public void user_Can_Delete_Library_Folder_14() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_Library_Folder_14();
	}
	
	@Test(priority = 16, description = "user_Open_Resource_Library_Space_8th_Time")
	public void user_Open_Resource_Library_Space_8th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Space_WR();
	}

	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Move-File-From-View-Only-To-Non-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		Thread.sleep(1500);// wait to make sure in workroom
		obj_edit_resource.verify_View_Only_Folder_13_NOT_Present();
		obj_edit_resource.verify_Folder_14_NOT_Present();
	}
}