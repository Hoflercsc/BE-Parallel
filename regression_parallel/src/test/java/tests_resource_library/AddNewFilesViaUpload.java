package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_resource_library.MoveResourceFolderPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddNewFilesViaUpload extends BaseTestResourceLibrary {
	
	@Test(priority = 0, description = "url_Redirect_Jhofler_Staging")
	public void url_Redirect_Jhofler_Staging() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		// redirect due to test due to parrellel testing causing miss behavior 
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Libraries_Form")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Create_Resource_Library_Folder_5(newLibraryFolder5); // create folder
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 4, description = "user_Can_Open_Libraries_Form_2nd_Time")
	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 5, description = "user_Can_Add_Multiple_Files_To_Folder_5")
	public void user_Can_Add_Multiple_Files_To_Folder_5() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Add_Multiple_Files_To_Folder_5();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Open_Libraries_Form_3rd_Time")
	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 7, description = "user_Can_Delete_Resource_Library_Folder_5")
	public void user_Can_Delete_Resource_Library_Folder_5() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Delete_Resource_Library_Folder_5();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_4th_Time")
	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoAttend_WR();
	}
	
	@Test(priority = 9, description = "verify_Resource_Library_Folder_5_NOT_Present")
	public void verify_Resource_Library_Folder_5_NOT_Present() throws InterruptedException {
		test.assignCategory("Resource-Library >> Add-New-Files-Via-Upload");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Resource_Library_Folder_5_NOT_Present();
	}
	
}