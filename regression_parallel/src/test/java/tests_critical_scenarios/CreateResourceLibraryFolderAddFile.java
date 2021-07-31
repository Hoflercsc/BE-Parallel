package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AttdReportPage;
import page_critical_scenarios.LibrariesPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateResourceLibraryFolderAddFile extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.workroom_Member_Open_Resource_Library();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Resource_Library_Folder")
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.user_Can_Create_New_Resource_Library_Folder();
	}

	@Test(priority = 4, description = "user_Can_Open_Resource_Library_Folder")
	public void user_Can_Open_Resource_Library_Folder() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.user_Can_Open_Resource_Library_Folder();
	}

	@Test(priority = 5, description = "user_Can_Add_Resource_File_To_Folder")
	public void user_Can_Add_Resource_File_To_Folder() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.user_Can_Add_Resource_File_To_Folder();
	}

	@Test(priority = 6, description = "user_Can_Delete_File")
	public void user_Can_Delete_File() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.user_Can_Delete_File();
	}

	@Test(priority = 7, description = "user_Can_Delete_Folder")
	public void user_Can_Delete_Folder() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.user_Can_Delete_Folder();
	}

	@Test(priority = 8, description = "verify_Folder_Deleted")
	public void verify_Folder_Deleted() throws InterruptedException {
		test.assignCategory("CreateResourceLibraryFolderAddFile");
		
		objectLibraries = new LibrariesPage();
		objectLibraries.verify_Folder_Deleted();
	}
}