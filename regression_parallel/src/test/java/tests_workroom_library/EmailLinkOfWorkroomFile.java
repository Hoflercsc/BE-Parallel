package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class EmailLinkOfWorkroomFile extends BaseTestWorkroomLibrary {	
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING); //redirect from ozzie to staging
	}
	
	@Test(priority = 1, description = "systemAdmin_login")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
	}
	
	@Test(priority = 3, description = "move_File_From_AutoBE_To_AgendaTab")
	public void move_File_From_AutoBE_To_AgendaTab() throws InterruptedException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		
		Thread.sleep(1500);
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.go_To_Resource_Library_Email_Link();
	}
	
	@Test(priority = 4, description = "message_Users_Via_Email_Link")
	public void message_Users_Via_Email_Link() throws InterruptedException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		
		obj_directory = new DirectoryPage();
		obj_directory.message_Users_Via_Email_Link();
	}
	
	@Test(priority = 5, description = "verify_Email_Link_Message_Sent")
	public void verify_Email_Link_Message_Sent() throws InterruptedException, AWTException {
		test.assignCategory("Other-Files >> Email-Link-Of-Workroom-File");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Email_Link_Message_Sent();
	}

	
	
	
}