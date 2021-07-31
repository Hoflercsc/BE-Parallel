package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class EnableDisableDirectoryExcelExport extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	//----------------------------------
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "Disable_Directory_Excel_Export")
	public void Disable_Directory_Excel_Export() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.Disable_Directory_Excel_Export();
	}
	//----------------------------------
	
	@Test(priority = 5, description = "System_Admin_Logout")
	public void System_Admin_Logout() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 6, description = "Auto_Director_Login")
	public void auto_Director_Login() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	//----------------------------------
	@Test(priority = 7, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 8, description = "verify_Download_As_Excel_Disabled")
	public void verify_Download_As_Excel_Disabled() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.verify_Download_As_Excel_Disabled();
	}
	//----------------------------------
	
	@Test(priority = 9, description = "auto_Director_Logout")
	public void auto_Director_Logout() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 10, description = "system_Admin_Login")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Settings_Again")
	public void user_Can_Open_Settings_Again() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	//------------------------------------
	@Test(priority = 12, description = "navigate_To_General_Look_Feel_Again")
	public void navigate_To_General_Look_Feel_Again() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 13, description = "Enable_Directory_Excel_Export")
	public void Enable_Directory_Excel_Export() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.Enable_Directory_Excel_Export();
	}
	//-------------------------------------
	
	@Test(priority = 14, description = "System_Admin_Logout_Again")
	public void System_Admin_Logout_Again() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 15, description = "system_Admin_Login")
	public void auto_Director_Login_Again() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	//----------------------------------
	@Test(priority = 16, description = "user_Can_Open_Directory_Again")
	public void user_Can_Open_Directory_Again() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 17, description = "verify_Download_As_Excel_Enabled")
	public void verify_Download_As_Excel_Enabled() throws InterruptedException {
		test.assignCategory("General-Settings >> Enable-Disable-Directory-Excel-Export");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.verify_Download_As_Excel_Enabled();
	}
	//----------------------------------
}