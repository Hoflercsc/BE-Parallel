package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import static constants.ConstantsFile.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyLinkViewWorkroomFileViewOnlyFolder extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "create_View_Only_New_Resource_Library_Folder")
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		Thread.sleep(2000); // adding sleep to make automation sits under correct folder
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.create_View_Only_New_Resource_Library_Folder();
		driver.navigate().refresh();
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 5, description = "user_Can_Add_File_Folder")
	public void user_Can_Add_File_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Add_File_Folder_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 7, description = "copy_File_Link")
	public void copy_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.copy_File_Link();
	}
	
	@Test(priority = 8, description = "open_File_Link")
	public void open_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.open_File_Link();
	}
	
	@Test(priority = 9, description = "switch_Tab_Verify_Viewer_Element")
	public void switch_Tab_Verify_Viewer_Element() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.switch_Tab_Verify_Viewer_Element();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 11, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.user_Can_Delete_View_Only_Folder();
		driver.navigate().refresh();
	}
	
	@Test(priority = 12, description = "verify_View_Only_Folder_Deleted")
	public void verify_View_Only_Folder_Deleted() throws InterruptedException {
		test.assignCategory("Other-Files >> Copy-Link-View-Workroom-File-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage(driver);
		obj_edit_resource.verify_View_Only_Folder_Deleted();
	}

}