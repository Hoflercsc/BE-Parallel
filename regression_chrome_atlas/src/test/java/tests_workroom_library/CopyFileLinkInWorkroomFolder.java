package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyFileLinkInWorkroomFolder extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		Thread.sleep(2000); // adding sleep to make automation sits under correct folder
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Create_2nd_Resource_Library_Folder();
		driver.navigate().refresh();
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 6, description = "user_Can_Add_File_Folder_Non_Read_Only")
	public void user_Can_Add_File_Folder_Non_Read_Only() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_Non_Read_Only();
		driver.navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_Again")
	public void user_Can_Open_Libraries_Form_Again() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 8, description = "copy_File_Link_Non_View_Only")
	public void copy_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.copy_File_Link_Non_View_Only();
	}
	
	@Test(priority = 9, description = "open_File_Link")
	public void open_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_File_Link();
		driver.navigate().refresh();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 11, description = "user_Delete_Folder_2")
	public void user_Delete_Folder_2() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Delete_Folder_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 13, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Folder2_NOT_Present();
	}
}