package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyLinkViewFileFromViewOnlyFolder extends BaseTestResourceLibrary {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Comics_WR();
	}

	@Test(priority = 3, description = "create_View_Only_Resource_Library_Folder_Copy_File_Link_Folder_2")
	public void create_View_Only_Resource_Library_Folder_Copy_File_Link_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_edit_resource = new EditResourceFolderPage();
		obj_edit_resource.create_View_Only_Resource_Library_Folder_Copy_File_Link_Folder_2(copyFileLinkFolder2);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Comics_WR();
	}
	
	@Test(priority = 6, description = "add_File_To_Folder_Copy_Link_Folder_2_View_Only")
	public void add_File_To_Folder_Copy_Link_Folder_2_View_Only() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.add_File_To_Folder_Copy_Link_Folder_2_View_Only();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Comics_WR();
	}
	
	@Test(priority = 9, description = "copy_File_Link_In_Copy_File_View_Only_Folder_2")
	public void copy_File_Link_In_Copy_File_View_Only_Folder_2() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.copy_File_Link_In_Copy_File_View_Only_Folder_2();
	}
	
	@Test(priority = 10, description = "open_File_Link")
	public void open_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.open_File_Link();
	}
	
	@Test(priority = 11, description = "switch_Tab_Verify_Viewer_Element")
	public void switch_Tab_Verify_Viewer_Element() throws InterruptedException, UnsupportedFlavorException, IOException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.switch_Tab_Verify_Viewer_Element();
	}
	
	@Test(priority = 12, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_Comics_WR();
	}
	
	@Test(priority = 13, description = "user_Can_Delete_View_Only_Folder")
	public void user_Can_Delete_View_Only_Folder_2() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.delete_Resource_Library_Folder_Copy_File_Link_Folder_2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 14, description = "verify_Copy_Link_Folder_2_NOT_Present")
	public void verify_Copy_Link_Folder_2_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Link-On-File-From-View-Only-Folder");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Copy_Link_Folder_2_NOT_Present();
	}

}