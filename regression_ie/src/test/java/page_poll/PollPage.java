package page_poll;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.Select;

public class PollPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public PollPage(WebDriver driver) {
		this.driver = driver;
	}
	String pollTitle = "This is a Poll Title";
	String pollQuestion = "what is your favorite food?";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By pollsSubMenu = By.xpath("//a[contains(text(),'Polls')]");
	By newPollsBtn = By.xpath("//a[@class='btn btn-success pull-right']");
	By pollTitleInputField = By.xpath("//input[@id='survey_title']");
	By saveBtn = By.xpath("//*[@id=\"new_survey\"]/button");
	By pollSucessMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully created This is a Poll Title')]");
	By newQuestionOne = By.xpath("(//a[contains(text(),'New Question')])[1]");
	By newQuestionBox = By.xpath("//h4[contains(text(),'New Question')]");
	By pollTextBox = By.xpath("//textarea[@id='poll-question-name']");
	By radioButtonOne = By.xpath("//input[@id='survey_question_values_default_option_1']");
	By radioTextOne = By.xpath("//input[@id='survey_question_values_1_value']");
	By radioButtonTwo = By.xpath("//input[@id='survey_question_values_default_option_2']");
	By radioTextTwo = By.xpath("//input[@id='survey_question_values_2_value']");
	By radioButtonThree = By.xpath("//input[@id='survey_question_values_default_option_3']");
	By radioTextThree = By.xpath("//input[@id='survey_question_values_3_value']");
	By manageRespondents = By.xpath("//a[contains(text(),'Manage Respondents')]");
	By saveBtnbox = By.xpath("//div[@id='questionModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By respondents = By.xpath("//a[contains(text(),'Respondents')]");
	By poll_Title = By.xpath("//h1[contains(text(),'This is a Poll Title')]");
	By poll_Title_2 = By.xpath("(//a[contains(text(),'This is a Poll Title')])[1]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By pollBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By pollSucessResponseMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully responded to poll: This is a Poll Tit')]");
	By breadCrumbWorkroom = By.xpath("//a[contains(text(),'Workroom Polls')]");

	// ------------------ Methods ---------------------
	public void verifyWelcomeHeader() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(WelcomeHeader)));
	}

	public void verifyCollaborateActiveOff() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(collaborateActiveOff)));
	}

	public void verifyworkroomSubnav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomSubnav)));
	}

	public void verifyNewPollBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newPollsBtn)));
	}

	public void verifyPollInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(8)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollTitleInputField)));
	}

	public void verifyPollSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollSucessMessage)));
	}

	public void verifyNewQuestionOne() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionOne)));
	}

	public void verifyNewQuestionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionBox)));
	}

	public void verifyRespondents() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents)));
	}

	public void verifyPollTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title)));
	}

	public void verifySubmitBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(submitBtn)));
	}

	public void verifyBuildBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(buildBtn)));
	}

	public void verifyContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verifyPollisVisiable() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollVisibleGreen)));
	}

	public void verifyPollSucessResponseMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollSucessResponseMessage)));
	}

	public void verifyPollTitle_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title_2)));
	}

	// ------------------ Elements ---------------------
	public void clickAutoBEWorkRoom() {
		driver.findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		driver.findElement(collaborateActiveOff).click();
	}

	public void clickPolls() {
		driver.findElement(pollsSubMenu).click();
	}

	public void clickNewPollBtn() {
		driver.findElement(newPollsBtn).click();
	}

	public void clickNewQuestionOne() {
		driver.findElement(newQuestionOne).click();
	}

	public void clickandTypePollTitleInputField() throws InterruptedException {
		driver.findElement(pollTitleInputField).click();
		driver.findElement(pollTitleInputField).sendKeys(pollTitle);
	}

	public void clickSaveBtn() throws InterruptedException {
		driver.findElement(saveBtn).click();
	}

	public void clickSubmitBtn() throws InterruptedException {
		driver.findElement(submitBtn).click();
		Thread.sleep(2000);
	}

	public void clickBuildBtn() throws InterruptedException {
		driver.findElement(buildBtn).click();
		Thread.sleep(1000);
	}

	public void clickPollBtnOn() throws InterruptedException {
		driver.findElement(pollBtnOn).click();
		Thread.sleep(1000);
	}

	public void clickContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
		Thread.sleep(1000);
	}

	public void clickBreadCrumbWorkroom() throws InterruptedException {
		driver.findElement(breadCrumbWorkroom).click();
		Thread.sleep(1000);
	}

	public void clickPollTextBoxSendKeysSave() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(pollQuestion);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		driver.findElement(radioButtonOne).click();
		driver.findElement(radioTextOne).sendKeys("apple pie");
		driver.findElement(radioButtonTwo).click();
		driver.findElement(radioTextTwo).sendKeys("ice cream");
		driver.findElement(radioButtonThree).click();
		driver.findElement(radioTextThree).sendKeys("pudding");
		driver.findElement(saveBtnbox).click();
	}

	public void verifyPollQuestionExist() throws InterruptedException {
		String pollquestion = "//*[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(driver.findElements(By.xpath(pollquestion)).size() != 0);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean question = driver.findElements(By.xpath(pollquestion)).size() > 0;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void clickManageRespondentsAddUser() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		driver.findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = driver.findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement automationTester2 = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		automationTester2.click();
		Thread.sleep(2000);
		String automationTester3 = "(//*[contains(text(),'Automation Tester')])[3]";
		Assert.assertTrue(driver.findElements(By.xpath(automationTester3)).size() != 0);
		Thread.sleep(1000);
		WebElement saveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}

	public void verifyPollTitleAndQuestionExist() throws InterruptedException {
		String pollTitle = "//h1[contains(text(),'This is a Poll Title')]";
		String pollQuestion = "//p[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(driver.findElements(By.xpath(pollTitle)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(pollQuestion)).size() != 0);
	}

	// ------------------ Iframe Text Box Send Keys ---------------------
	public void pollDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		driver.switchTo().defaultContent();
	}

	// ------------------ Functions ----------------------
	public void create_Poll() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		this.verifyNewPollBtn();
		this.clickNewPollBtn();
		this.verifyPollInputField();
		this.clickandTypePollTitleInputField();
		this.pollDescriptionTextBox();
		this.clickSaveBtn();
		this.verifyPollSucessMessage();
		System.out.println("------- Completed --> create_Poll() -----------");
	}
	
	// ------------------ Functions ----------------------
	public void user_navigates_To_Poll() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		this.verifyNewPollBtn();
		System.out.println("------- Completed --> user_navigates_To_Poll() -----------");
	}

	// ------------------ Functions ----------------------
	public void creating_Poll_For_Event() throws InterruptedException {
		this.verifyPollInputField();
		this.clickandTypePollTitleInputField();
		this.pollDescriptionTextBox();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifyPollSucessMessage();
		System.out.println("------- Completed --> creating_Poll_For_Event() -----------");
	}
		
	public void create_Poll_Question() throws InterruptedException {
		this.verifyNewQuestionOne();
		this.clickNewQuestionOne();
		Thread.sleep(1000);
		this.verifyNewQuestionBox();
		this.clickPollTextBoxSendKeysSave();
		Thread.sleep(1000);
		this.verifyPollSucessMessage();
		Thread.sleep(1000);
		this.verifyPollQuestionExist();
		System.out.println("------- Completed --> create_Poll_Question() -----------");
	}

	public void manageRespondents() throws InterruptedException {
		this.clickManageRespondentsAddUser();
		this.verifyBuildBtn();
	}

	public void build_Poll_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickPollBtnOn();
//		this.verifyContinueBtn();
//		this.clickContinueBtn();
		this.clickSubmitBtn();
		this.verifyPollSucessResponseMessage();
		this.verifyPollTitleAndQuestionExist();
		this.clickBreadCrumbWorkroom();
		this.verifyPollTitle_2();
		System.out.println("------- Completed --> build_Poll_Make_Visible() -----------");
	}
	
	// ------------------ archive_Poll ----------------------
	By archive = By.xpath("//a[contains(text(),'Archive')]");
	By archive_Header = By.xpath("//h1[contains(text(),'Archived')]");
	By archiveBtn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");


	public void verify_Archive_Header() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archive_Header)));
	}
	
	public void verify_Poll_Title_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title_Dropdown)));
	}
	
	public void verify_Archive_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveBtn)));
	}
	
	public void click_Archive() throws InterruptedException {
		driver.findElement(archive).click();
	}
	
	public void click_Archive_Btn() throws InterruptedException {
		driver.findElement(archiveBtn).click();
	}
	
	public void archive_Poll() throws InterruptedException {
		this.click_Poll_Title_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Archive();
		Thread.sleep(1500);
		this.verify_Archive_Header();
		this.verify_Poll_Title_Dropdown();
		System.out.println("------- Completed --> archive_Poll() -----------");
	}
	
	public void veirfy_Poll_Archive() throws InterruptedException {
		this.clickPolls();
		Thread.sleep(1500);
		this.verify_Archive_Btn();
		this.click_Archive_Btn();
		Thread.sleep(1500);
		this.verify_Archive_Header();
		this.verify_Poll_Title_Dropdown();
		System.out.println("------- Completed --> veirfy_Poll_Archive() -----------");
	}
	
	// ------------------ move_Poll_To_Another_Workroom ----------------------
	By move_To_Dropdown = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By autoAttend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By move_Here = By.xpath("//button[@class='btn-sidebar move-btn btn-success']");
	By autoAttend_Workroom = By.xpath("//a[contains(text(),'AutoAttend')]");
	By autoAttend_2 = By.xpath("//a[contains(text(),'AutoAttend')]");

	public void verify_Move_To_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_To_Dropdown)));
	}
	
	public void verify_AutoAttend() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend)));
	}
	
	public void verify_Move_Here() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Here)));
	}
	
	public void verify_AutoAttend_Workroom() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend_Workroom)));
	}
	
	public void scroll_Move_To_Dropdown() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//span[@class='filter-option pull-left']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	

	public void click_Poll_Title() throws InterruptedException {
		driver.findElement(poll_Title_2).click();
	}
	
	public void click_Move_To_Dropdown() throws InterruptedException {
		driver.findElement(move_To_Dropdown).click();
	}
	
	public void click_AutoAttend() throws InterruptedException {
		driver.findElement(autoAttend).click();
	}
	
	public void click_Move_Here() throws InterruptedException {
		driver.findElement(move_Here).click();
	}
	
	public void click_AutoAttend_2() {
		driver.findElement(autoAttend_2).click();
	}
	
	public void move_Poll_To_Another_Workroom() throws InterruptedException {
		this.click_Poll_Title();
		Thread.sleep(1000);
		this.verify_Move_To_Dropdown();
		this.scroll_Move_To_Dropdown();
		this.click_Move_To_Dropdown();
		Thread.sleep(1000);
		this.verify_AutoAttend();
		this.click_AutoAttend();
		Thread.sleep(1000);
		this.verify_Move_Here();
		this.click_Move_Here();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		System.out.println("------- Completed --> move_Poll_To_Another_Workroom() -----------");
	}
	
	public void verify_Move_Workroom_AutoAttend() throws InterruptedException {
		this.verify_AutoAttend_Workroom();
		this.click_AutoAttend_2();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		System.out.println("------- Completed --> verify_Move_Workroom_AutoAttend() -----------");
	}
	
	
	//-----------------------------------------------------
	By edit_Poll_Questions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Poll Questions')]");
	By edit_Question_Arrow = By.xpath("(//p[contains(text(),'what is your favorite food?')]/following::div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By edit_Question_Box = By.xpath("//h4[contains(text(),'Edit Question')]");

	public void verify_Edit_Poll_Questions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Poll_Questions)));
	}
	
	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}
	
	public void verify_Edit_Question_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Question_Box)));
	}
	
	public void wait_For_Invisibility_Of_Edit_Question_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(edit_Question_Box)));
	}
	
	public void click_Edit_Poll_Questions() throws InterruptedException {
		driver.findElement(edit_Poll_Questions).click();
	}
	
	public void click_Edit_Question_Arrow() throws InterruptedException {
		driver.findElement(edit_Question_Arrow).click();
	}
	
	public void click_Edit_Option() throws InterruptedException {
		driver.findElement(edit_Option).click();
	}
	
	public void editPollTextBoxSendKeysSave() throws InterruptedException {
		String editedPollQuestion = "who is your favorite person?";
		
		By radioButtonOne = By.xpath("//input[@id='survey_question_values_default_option_0']");
		By radioTextOne = By.xpath("( //input[starts-with (@id,'survey_question_values_1')])[1]");
		By radioButtonTwo = By.xpath("//input[@id='survey_question_values_default_option_1']");
		By radioTextTwo = By.xpath("( //input[starts-with (@id,'survey_question_values_1')])[2]");
		By radioButtonThree = By.xpath("//input[@id='survey_question_values_default_option_2']");
		By radioTextThree = By.xpath("( //input[starts-with (@id,'survey_question_values_1')])[3]");

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(1000);
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(editedPollQuestion);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(radioButtonOne).click();
		
		driver.findElement(radioTextOne).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioTextOne).clear();
		driver.findElement(radioTextOne).sendKeys("son");
		
		driver.findElement(radioButtonTwo).click();
		
		driver.findElement(radioTextTwo).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioTextTwo).clear();
		driver.findElement(radioTextTwo).sendKeys("daughter");
		
		driver.findElement(radioButtonThree).click();

		driver.findElement(radioTextThree).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioTextThree).clear();
		driver.findElement(radioTextThree).sendKeys("wife");
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(saveBtnbox).click();
	}
	
	public void verify_Edited_Question_Exist() throws InterruptedException {
		String pollquestion = "//*[contains(text(),'who is your favorite person?')]";
		Assert.assertTrue(driver.findElements(By.xpath(pollquestion)).size() > 0);
	}
	
	public void navigate_To_Edit_Poll() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(500);
		this.verify_Edit_Poll_Questions();
        this.click_Edit_Poll_Questions();
		Thread.sleep(500);
	}
	
	public void edit_Poll_Question() throws InterruptedException {
		this.verifyBuildBtn();
		this.click_Edit_Question_Arrow();
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.editPollTextBoxSendKeysSave();
		Thread.sleep(500);
		this.wait_For_Invisibility_Of_Edit_Question_Box();
		this.verify_Edited_Question_Exist();
		System.out.println("------- Completed --> edit_Poll_Question() -----------");
	}
	
	public void build_Poll_Make_Visible_3() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(500);
		this.verifySubmitBtn();
		this.clickPollBtnOn();
		Thread.sleep(500);
		this.clickSubmitBtn();
		Thread.sleep(500);
		this.clickBreadCrumbWorkroom();
		Thread.sleep(500);
		this.verifyPollTitle_2();
		System.out.println("------- Completed --> build_Poll_Make_Visible_3() -----------");
	}

	//----------------------------------------
	By poll_Title_Dropdown = By.xpath("(//a[contains(text(),'This is a Poll Title')]/following::div[@class='dropdown header-actions'])[1]");
	By deleteOption = By.xpath("//div[@class='dropdown header-actions open']//a[contains(text(),'Delete')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteOption)));
	}

	public void click_Poll_Title_Dropdown() throws InterruptedException {
		driver.findElement(poll_Title_Dropdown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(deleteOption).click();
	}

	public void verify_Poll_NOT_Exist() throws InterruptedException {
		Thread.sleep(2000);
		String poll = "(//li[@class='active']/following::text()[contains(., 'This is a Poll Title')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(poll)).size() < 1);
	}

	public void delete_Poll() throws InterruptedException {
		this.click_Poll_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Poll() -----------");
	}

	public void verify_Poll_Deletion() throws InterruptedException {
		this.verify_Poll_NOT_Exist();
		System.out.println("------- Completed --> verify_Poll_Deletion() -----------");
	}
}
