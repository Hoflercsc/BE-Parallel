package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class BoardMemberViewWorkroomViewOnlyFile extends BaseTestBoardMemberAccess {	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 4, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 5, description = "navigate_Back_To_Workroom")
	public void navigate_Back_To_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 6, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 7, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 8, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 9, description = "navigate_Back_To_Workroom")
	public void navigate_To_Boardmember_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 10, description = "verify_Boardmember_View_Only_Permissions")
	public void verify_Boardmember_View_Only_Permissions() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Boardmember_View_Only_Permissions();
	}
	
	@Test(priority = 11, description = "boardmember_Meeting_Book_Viewer_And_Scroll")
	public void boardmember_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.boardmember_Opens_Meeting_Book_Viewer_And_Scroll();
	}
	
	@Test(priority = 12, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 13, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "navigate_To_Boardmember_Workroom_2nd_Time")
	public void navigate_To_Boardmember_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 15, description = "user_Can_Delete_Boardmember_View_Only_Folder")
	public void user_Can_Delete_Boardmember_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_Boardmember_View_Only_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 16, description = "navigate_To_Boardmember_Workroom_3rd_Time")
	public void navigate_To_Boardmember_Workroom_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> BoardMember-Workroom-Edit-Existing-Folder-To-ViewOnly");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}
}