package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class BoardMemberCantSeeSecuredFolder extends BaseTestBoardMemberAccess {

	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 4, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_3(newLibraryFolder3); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "navigate_Back_To_Workroom")
	public void navigate_Back_To_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 6, description = "add_Security_BoardMember_Folder")
	public void add_Security_BoardMember_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_Security_BoardMember_Folder(); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "autoUser1Stagingr_Login")
	public void autoUser1Staging_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser1Staging, password);
	}
	
	@Test(priority = 9, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 10, description = "verify_BoardMember_Folders_Present_2nd_Time")
	public void verify_BoardMember_Folders_Present_2nd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}

	@Test(priority = 11, description = "verify_Secured_Folder_Not_Present")
	public void verify_Secured_Folder_Not_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_3_NOT_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Logout")
	public void user_Can_Logout_() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 13, description = "systemAdmin_Login")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 15, description = "user_Delete_Resource_Library_Folder_3")
	public void user_Delete_Resource_Library_Folder_3() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Resource_Library_Folder_3();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 17, description = "verify_Resource_Library_Folder_3_NOT_Present")
	public void verify_Resource_Library_Folder_3_NOT_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_3_NOT_Present();
	}
}