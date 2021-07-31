package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import tests_workroom_library.BaseTestWorkroomLibrary;
import static constants.ConstantsFile.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyFileLinkInWorkroomFolder extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "user_Can_Create_2nd_Resource_Library_Folder")
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		Thread.sleep(2000); // adding sleep to make automation sits under correct folder
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_20(newLibraryFolder20); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();;
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 6, description = "user_Can_Add_File_To_Folder_20")
	public void user_Can_Add_File_To_Folder_20() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_File_To_Folder_20();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_Again")
	public void user_Can_Open_Libraries_Form_Again() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 8, description = "copy_File_Link_Non_View_Only")
	public void copy_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.copy_File_Link_Non_View_Only_Folder_20();
	}
	
	@Test(priority = 9, description = "open_File_Link")
	public void open_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.open_File_Link();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 11, description = "user_Delete_Resource_Library_Folder_20")
	public void user_Delete_Resource_Library_Folder_20() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Delete_Resource_Library_Folder_20();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 13, description = "verify_Resource_Library_Folder_20_NOT_Present")
	public void verify_Resource_Library_Folder_20_NOT_Present() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-File-Link-In-Workroom-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_20_NOT_Present();
	}
}