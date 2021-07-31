package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class BoardMemberViewWorkroomViewOnlyFile extends BaseTestBoardMemberAccess {	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 4, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.create_View_Only_Resource_Library_Folder(newViewOnlyFolder);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "navigate_Back_To_Workroom")
	public void navigate_Back_To_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
				
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 6, description = "can_Add_File_View_Only_Folder")
	public void can_Add_File_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.can_Add_File_View_Only_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 7, description = "system_Admin_Can_Logout")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser2Staging, password);
	}
	
	@Test(priority = 9, description = "navigate_Back_To_Workroom")
	public void navigate_To_Boardmember_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 10, description = "verify_Boardmember_View_Only_Permissions")
	public void verify_Boardmember_View_Only_Permissions() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Boardmember_View_Only_Permissions();
	}
	
	@Test(priority = 11, description = "boardmember_Meeting_Book_Viewer_And_Scroll")
	public void boardmember_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.boardmember_Opens_Meeting_Book_Viewer_And_Scroll();
	}
	
	@Test(priority = 12, description = "auto_Director_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 13, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "navigate_To_Boardmember_Workroom_2nd_Time")
	public void navigate_To_Boardmember_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 15, description = "user_Can_Delete_Boardmember_View_Only_Folder")
	public void user_Can_Delete_Boardmember_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.user_Can_Delete_Boardmember_View_Only_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 16, description = "navigate_To_Boardmember_Workroom_3rd_Time")
	public void navigate_To_Boardmember_Workroom_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-View-Workroom-View-Only-File");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}
}