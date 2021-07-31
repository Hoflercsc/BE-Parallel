package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class AddUpdateBasicInformation extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS3, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Settings")
	public void navigate_To_General_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Settings();
	}
	
	@Test(priority = 4, description = "user_Can_Fill_Out_Basic_Information")
	public void user_Can_Fill_Out_Basic_Information() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.user_Can_Fill_Out_Basic_Information();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 6, description = "navigate_To_General_Settings_2nd_Time")
	public void navigate_To_General_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.navigate_To_General_Settings();
	}
	
	@Test(priority = 7, description = "verify_Saved_Form_Data")
	public void verify_Saved_Form_Data() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.verify_Saved_Form_Data();
	}
	
	@Test(priority = 8, description = "clear_Basic_Information_Form")
	public void clear_Basic_Information_Form() throws InterruptedException {
		test.assignCategory("General-Settings >> Add-Update-Basic-Information");
		
		obj_general_settings = new GeneralSettingsPage();
		obj_general_settings.clear_Basic_Info_Form();
	}

	

}