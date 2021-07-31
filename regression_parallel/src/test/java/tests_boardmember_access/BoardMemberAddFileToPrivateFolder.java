package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class BoardMemberAddFileToPrivateFolder extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Library();
	}

	@Test(priority = 3, description = "Board-Member-Access >> Add-File-To-Private-Folder")
	public void add_File_To_Private_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_File_To_Private_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Library();
	}
	
	@Test(priority = 6, description = "user_Can_Delete_Private_Folder_File")
	public void user_Can_Delete_Private_Folder_File() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_Private_Folder_File();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Library();
	}
	
	@Test(priority = 9, description = "verify_Word_1_Docx_NOT_Present")
	public void verify_Word_1_Docx_NOT_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Add-File-To-Private-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.click_Your_Private_Folder();
		Thread.sleep(2000);
		obj_move_resource.verify_Word_1_Docx_NOT_Present();
	}


}