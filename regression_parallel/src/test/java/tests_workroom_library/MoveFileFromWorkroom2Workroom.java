package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class MoveFileFromWorkroom2Workroom extends BaseTestWorkroomLibrary {	
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING); //redirect from staging to lab to execute test
	}
	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 3, description = "move_File_From_AutoBE_To_AgendaTab")
	public void move_File_From_AutoBE_To_AgendaTab() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.move_File_From_AutoBE_To_AgendaTab();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AgendaTab_WR();
	}

	@Test(priority = 5, description = "verify_File_Moved")
	public void verify_File_Moved() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_File_Moved_WR_2_WR();
	}
	
	@Test(priority = 6, description = "move_File_Back_To_AutoBE")
	public void move_File_Back_To_AutoBE() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.move_File_Back_To_AutoBE();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_5th_Time")
	public void user_Can_Open_Libraries_Form_6th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 15, description = "verify_File_Back_In_Workroom")
	public void verify_File_Back_In_Workroom() throws InterruptedException {
		test.assignCategory("Other-Files >> Move-File-From-Workroom-2-Workroom");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_File_Back_In_Workroom();
		Thread.sleep(1000);
	}
	
	
}