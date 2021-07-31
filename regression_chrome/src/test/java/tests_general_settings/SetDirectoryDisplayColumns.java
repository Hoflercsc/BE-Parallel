package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class SetDirectoryDisplayColumns extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "set_Directory_Display_Columns")
	public void set_Directory_Display_Columns() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.set_Directory_Display_Columns();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 6, description = "verify_Role_Column")
	public void verify_Role_Column() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.verify_Role_Column();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 8, description = "navigate_To_General_Look_Feel_Agian")
	public void navigate_To_General_Look_Feel_Agian() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 9, description = "disable_Directory_Display_Columns_Option")
	public void disable_Directory_Display_Columns_Option() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.disable_Directory_Display_Columns();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Settings_3rd_Time")
	public void user_Can_Open_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 11, description = "verify_Role_Column_NOT_Present")
	public void verify_Role_Column_NOT_Present() throws InterruptedException {
		test.assignCategory("General-Settings >> Set-Directory-Display-Columns");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.verify_Role_Column_NOT_Present();
	}

	

}