package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AddRemoveLogoAndLogoUrl extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS1, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "add_Logo_And_Logo_URL")
	public void add_Logo_And_Logo_URL() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.add_Logo_And_Logo_URL();
	}
	
	@Test(priority = 5, description = "verify_Logo_And_URL_Added")
	public void verify_Logo_And_URL_Added() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.verify_Logo_And_URL_Added();
	}

	@Test(priority = 6, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_2();
	}
	
	@Test(priority = 7, description = "navigate_To_General_Look_Feel_2nd_Time")
	public void navigate_To_General_Look_Feel_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 8, description = "disable_Logo_And_Logo_URL")
	public void disable_Logo_And_Logo_URL() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.disable_Logo_And_Logo_URL();
	}
	
	@Test(priority = 9, description = "verify_HP_Logo_Removed")
	public void verify_HP_Logo_Removed() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Remove-Logo-And-Logo-Url");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.verify_HP_Logo_Removed();
	}

}