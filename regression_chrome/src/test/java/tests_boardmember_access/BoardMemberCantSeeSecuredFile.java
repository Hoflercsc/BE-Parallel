package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class BoardMemberCantSeeSecuredFile extends BaseTestBoardMemberAccess {

	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}

	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 4, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder(); // create folder
		driver.navigate().refresh();
	}
	
	@Test(priority = 5, description = "navigate_Back_To_Workroom")
	public void navigate_Back_To_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 6, description = "add_Security_BoardMember_Folder")
	public void add_Security_BoardMember_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_to_2nd_Folder();
	}
	
	@Test(priority = 7, description = "add_Security_To_File_Board_member")
	public void add_Security_To_File_Board_member() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.add_Security_To_File_Board_member();
		driver.navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 9, description = "autoDirector_Login")
	public void autoDirector_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 10, description = "navigate_Back_To_Workroom_BoardMember")
	public void navigate_Back_To_Workroom_BoardMember() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 11, description = "verify_File_Not_Present_in_Folder")
	public void verify_File_Not_Present_in_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_File_Not_Present_in_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Logout")
	public void user_Can_Logout_() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 13, description = "systemAdmin_Login")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 15, description = "user_Delete_Folder")
	public void user_Delete_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Folder_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 16, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}
	@Test(priority = 17, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Cant-See-Secured-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folder2_NOT_Present();
	}
}