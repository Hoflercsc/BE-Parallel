package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class BoardMemberCanSeeFilesByAdmin extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 4, description = "verify_Attach_Folder_Files_Present")
	public void verify_Attach_Folder_Files_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Attach_Folder_Files_Present();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_Again")
	public void user_Can_Open_Libraries_Form_Again() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 6, description = "verify_BoardMember_Folders_Present_Again")
	public void verify_BoardMember_Folders_Present_Again() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 7, description = "verify_Large_Book_Folder_Files_Present")
	public void verify_Large_Book_Folder_Files_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-See-Files-By-Admin");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Large_Book_Folder_Files_Present();
	}
	
}