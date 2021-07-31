package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;

public class BoardMemberCanAddFilesToWorkroom extends BaseTestBoardMemberAccess {
	
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 3, description = "verify_BoardMember_Folders_Present")
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 4, description = "add_File_To_Attach_Folder")
	public void add_File_To_Attach_Folder() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.add_File_To_Attach_Folder();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_Again")
	public void user_Can_Open_Libraries_Form_Again() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 6, description = "verify_BoardMember_Folders_Present_Again")
	public void verify_BoardMember_Folders_Present_Again() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 7, description = "verify_Created_File_And_Delete_Created_File")
	public void verify_Created_File_And_Delete_Created_File() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Created_File();
		obj_move_resource.user_Can_Delete_File_RL();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 9, description = "verify_BoardMember_Folders_Present_3rd_Time")
	public void verify_BoardMember_Folders_Present_3rd_Time() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_BoardMember_Folders_Present();
	}
	
	@Test(priority = 10, description = "verify_File_Deleted")
	public void verify_File_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-Add-Files-To-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_File_Deleted();
	}
	
	
}