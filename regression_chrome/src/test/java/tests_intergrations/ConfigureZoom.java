package tests_intergrations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_intergrations.ZoomPage;
import static constants.ConstantsFile.*;

public class ConfigureZoom extends BaseTestIntergations {
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}

	@Test(priority = 3, description = "navigate_To_Video_Conferencing")
	public void navigate_To_Video_Conferencing() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_zoom = new ZoomPage(driver);
		obj_zoom.navigate_To_Video_Conferencing();
	}

	@Test(priority = 4, description = "configure_Zoom")
	public void configure_Zoom() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_zoom = new ZoomPage(driver);
		obj_zoom.configure_Zoom();
	}

	@Test(priority = 5, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}

	@Test(priority = 6, description = "navigate_To_Video_Conferencing")
	public void navigate_To_Video_Conferencing_2nd_time() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_zoom = new ZoomPage(driver);
		obj_zoom.navigate_To_Video_Conferencing();
	}

	@Test(priority = 7, description = "clear_Zoom_Form")
	public void clear_Zoom_Form() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_zoom = new ZoomPage(driver);
		obj_zoom.clear_Zoom_Form();
	}

	@Test(priority = 8, description = "verify_Zoom_Deactivation")
	public void verify_Zoom_Deactivation() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-Zoom");
		
		obj_zoom = new ZoomPage(driver);
		obj_zoom.verify_Zoom_Deactivation();
	}
}
