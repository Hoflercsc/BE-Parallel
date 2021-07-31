package tests_general_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_general_settings.GeneralSettingsPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class DisplayDirectoryByUserCategory extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 3, description = "navigate_To_General_Look_Feel")
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 4, description = "select_Display_Columns_By_User_Catergory")
	public void select_Display_Columns_By_User_Catergory() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.select_Display_Columns_By_User_Catergory();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 6, description = "verify_User_Categories")
	public void verify_User_Categories() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.verify_User_Categories();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 8, description = "navigate_To_General_Look_Feel_Agian")
	public void navigate_To_General_Look_Feel_Agian() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.navigate_To_General_Look_Feel();
	}
	
	@Test(priority = 9, description = "disable_Display_Columns_By_User_Catergory")
	public void disable_Display_Columns_By_User_Catergory() throws InterruptedException {
		test.assignCategory("General-Settings >> Display-Directory-By-User-Category");
		
		obj_general_settings = new GeneralSettingsPage(driver);
		obj_general_settings.disable_Display_Columns_By_User_Catergory();
	}
	


	

}