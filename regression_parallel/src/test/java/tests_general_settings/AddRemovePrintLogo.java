package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AddRemovePrintLogo extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS2, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "add_Print_Logo")
	public void add_Print_Logo() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.add_Print_Logo();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Library_Page_For_Workroom")
	public void admin_Open_Workroom_Constellation_Library_Page() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_Constellation_Library_Page();
	}

	@Test(priority = 6, description = "create_Book_Add_Remove_Print_Logo")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.create_Book_Add_Remove_Print_Logo();
	}

	@Test(priority = 7, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 8, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 9, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 10, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 11, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 12, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 13, description = "make_Book_Add_Remove_Print_Logo_Visible")
	public void make_Book_Add_Remove_Print_Logo_Visible() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Book_Add_Remove_Print_Logo_Visible();
	}
	
	@Test(priority = 14, description = "open_Book_Add_Remove_Print_Logo_In_Viewer")
	public void open_Book_Add_Remove_Print_Logo_In_Viewer() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.open_Book_Add_Remove_Print_Logo_In_Viewer();
	}

	@Test(priority = 15, description = "delete_Book_Add_Remove_Print_Logo")
	public void delete_Book_Add_Remove_Print_Logo() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.delete_Book_Add_Remove_Print_Logo();
	}
	
	@Test(priority = 16, description = "clean_Up_Meeting_Books_Constellation_WR")
	public void clean_Up_Meeting_Books_Constellation_WR() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_meeting_book = new BookPage();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		obj_meeting_book.clean_Up_Meeting_Books_Constellation_WR();
	}

	@Test(priority = 17, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.verify_Book_Deleted();
	}
	
	@Test(priority = 18, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 19, description = "navigate_To_General_Look_Feel_2nd_Time")
	public void navigate_To_General_Look_Feel_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 20, description = "disable_Print_Logo")
	public void disable_Print_Logo() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.disable_Print_Logo();
	}
	
	@Test(priority = 21, description = "verify_Logo_Removed")
	public void verify_Logo_Removed() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Print-Logo");
		
		objAtlasNavBar = new AtlasNavBar();
		obj_general_settings = new GeneralSettingsPage();
		
		objAtlasNavBar.admin_Opens_Site_Settings();
		obj_general_settings.navigate_To_General_Look_Feel();
		obj_general_settings.verify_Print_Logo_Removed();
	}

}