package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class SetDirectoryDisplayColumnsForPDF extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS7, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "set_Directory_Display_Columns_For_PDF")
	public void set_Directory_Display_Columns_For_PDF() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.set_Directory_Display_Columns_For_PDF();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 6, description = "navigate_To_General_Look_Feel_Agian")
	public void navigate_To_General_Look_Feel_Agian() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 7, description = "disable_Directory_Display_Columns_For_PDF")
	public void disable_Directory_Display_Columns_For_PDF() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.disable_Directory_Display_Columns_For_PDF();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Settings_3rd_Time")
	public void user_Can_Open_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 9, description = "navigate_To_General_Look_Feel_3rd_Time")
	public void navigate_To_General_Look_Feel_3rd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 10, description = "verify_Role_Tag_2_Disabled")
	public void verify_Role_Tag_2_Disabled() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns-For-PDF");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.scroll_To_Display_Columns();
		obj_general_settings.verify_Role_Tag_2_Disabled();
	}

	

}