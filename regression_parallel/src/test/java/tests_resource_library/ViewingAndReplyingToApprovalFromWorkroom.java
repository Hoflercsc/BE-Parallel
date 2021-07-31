//package tests_resource_library;
//
//import org.testng.annotations.Test;
//import page_common_functions.AtlasNavBar;
//import page_common_functions.LoginLogoutPage;
//import page_critical_scenarios.PermissionPage;
//import page_resource_library.MoveResourceFolderPage;
//import parallel.DriverFactory;
//import static constants.ConstantsFile.*;
//
////*****Skipped/not ran test cases doesnt work issue with file conversion *******
//
//public class ViewingAndReplyingToApprovalFromWorkroom extends BaseTestResourceLibrary {
//	@Test(priority = 1, description = "Login System Admin UserName Password.")
//	public void systemAdmin_login() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objBELogin = new LoginLogoutPage();
//		objBELogin.login_BE(systemAdmin, password);
//	}
//
//	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
//	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
//	}
//	
//	@Test(priority = 3, description = "user_Can_Create_Folder_Named_Approvals_Folder")
//	public void user_Can_Create_Folder_Named_Approvals_Folder() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Create_Folder_Named_Approvals_Folder();
//	}
//
//	@Test(priority = 5, description = "user_Can_Open_Libraries_Form_2nd_Time")
//	public void user_Can_Open_Libraries_Form_2nd_Time() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
//	}
//	
//	@Test(priority = 6, description = "user_Can_Add_File_To_Approvals_Folder")
//	public void user_Can_Add_File_To_Approvals_Folder() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Add_File_To_Approvals_Folder();
//	}
//	
//	@Test(priority = 7, description = "user_Can_Add_Approvers_To_File")
//	public void user_Can_Add_Approvers_To_File() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Add_Approvers_To_File_2b();
//	}
//	
//	@Test(priority = 8, description = "user_Can_Open_Libraries_Form_3rd_Time")
//	public void user_Can_Open_Libraries_Form_3rd_Time() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
//	}
//	
//	@Test(priority = 9, description = "user_Can_Verify_Approvers_Added")
//	public void user_Can_Verify_Approvers_Added() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Verify_Approvers_Added_3();
//	}
//	
//	@Test(priority = 10, description = "system_Admin_Logout")
//	public void system_Admin_Logout() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.user_Can_Sign_Out();
//	}
//
//	@Test(priority = 11, description = "auto_Director_Login")
//	public void auto_Director_Login() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objBELogin = new LoginLogoutPage();
//		objBELogin.login_BE(autoDirector,password);
//	}
//		
//	@Test(priority = 12, description = "user_Can_Open_Actions_Menu_And_Respond")
//	public void autoDirector_Can_Open_Actions_Menu_And_Respond() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Open_Actions_Menu_And_Respond();
//	}
//	
//	@Test(priority = 13, description = "system_Admin_Logout")
//	public void system_Admin_Logout_Agian() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.user_Can_Sign_Out();
//	}
//
//	@Test(priority = 14, description = "steve_System_Login")
//	public void steve_System_Login() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objBELogin = new LoginLogoutPage();
//		objBELogin.login_BE(systemAdmin,password);
//	}
//	
//	@Test(priority = 15, description = "systemAdmin_Can_Open_Actions_Menu_And_Respond")
//	public void systemAdmin_Can_Open_Actions_Menu_And_Respond() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Open_Actions_Menu_And_Respond_2();
//		DriverFactory.getInstance().getDriver().navigate().refresh();
//	}
//	
//	@Test(priority = 16, description = "systemAdmin_Can_Open_Actions_Menu_View_Response")
//	public void systemAdmin_Can_Open_Actions_Menu_View_Response() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Can_Open_Actions_Menu_View_Response();
//	}
//	
//	@Test(priority = 17, description = "user_Can_Open_Libraries_Form_4th_Time")
//	public void user_Can_Open_Libraries_Form_4th_Time() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
//	}
//	
//	@Test(priority = 18, description = "user_Delete_Folder_2")
//	public void user_Delete_Folder_2() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.user_Delete_Approvals_Folder();
//		DriverFactory.getInstance().getDriver().navigate().refresh();
//	}
//	
//	@Test(priority = 19, description = "user_Can_Open_Libraries_Form_5th_Time")
//	public void user_Can_Open_Libraries_Form_5th_Time() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		objAtlasNavBar = new AtlasNavBar();
//		objAtlasNavBar.workroom_Member_Open_Resource_Library_AutoBE_WR();
//	}
//	
//	@Test(priority = 20, description = "verify_Folder_Deleted")
//	public void verify_Folder_Deleted() throws InterruptedException {
//		test.assignCategory("Other-Files >> Viewing-And-Replying-To-Approval-From_Workroom");
//		
//		obj_move_resource = new MoveResourceFolderPage();
//		obj_move_resource.verify_Folder_NOT_Present();
//	}
//}