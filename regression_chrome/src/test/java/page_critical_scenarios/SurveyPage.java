package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.naming.ldap.ExtendedRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class SurveyPage {
	
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;
	String surveyTitle = "This is a Survey Title";
	String Question1 = "what happened to the good old days?";
	String Question2 = "what happened to Gilbert Grape?";
	String Question3 = "what happened to Micheal Jordan?";
	String Question4 = "what happened to Daffy Duck?";
	String Question5 = "Jack and Jill ran up the hill searching to fetch a pail of water. It was the best of times and he worst of times";
	String Question6 = "pick highest number between 1 and 10";
	String Option1 = "Relocated";
	String Option2 = "Got Sick";
	String Option3 = "Retired";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By surveysSubMenu = By.xpath("//span[@class='label label-default']//a[contains(text(),'Surveys')]");
	By newSurveyBtn = By.xpath("//a[@class='btn btn-success']");
	By surveyTitleInputField = By.xpath("//input[@id='survey_title']");
	By surveyDueDate = By.xpath("//input[@id='survey_expiration_date']");
	By surveyReminderDate = By.xpath("//input[@id='survey_reminder_date']");
	By saveBtn = By.xpath("//*[@id=\"new_survey\"]/button");
	By surveySucessMessage = By
			.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully created This is a Survey Title')]");
	// ---Text Field Question ----------
	By newQuestionOne = By.xpath("(//a[contains(text(),'Add Question')])[1]");
	By newQuestionBox = By.xpath("//h4[contains(text(),'New Question')]");
	By textFieldBtn = By.xpath("//a[contains(text(),'Text Field')]");
	By textArea = By.xpath("//textarea[@id='survey_question_question_name']");
	By saveBtnbox = By.xpath("//div[@id='questionModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	// By question = By.xpath("//*[contains(text(),'what happen to the good old
	// days?')]");
	// ---Check Box Question ----------
	By newQuestionBox2 = By.xpath("//h4[contains(text(),'New Question')]");
	By checkBoxes = By.xpath("//a[contains(text(),'Checkboxes')]");
	By textArea2 = By.xpath("//textarea[@id='survey_question_question_name']");
	By textArea3 = By.xpath("//textarea[@id='poll-question-name']");
	By checkBoxOne = By.xpath("//input[@id='survey_question_default_option_1']");
	By checkBoxOneInput = By.xpath("//input[@id='survey_question_values_1_value']");
	By checkBoxTwo = By.xpath("//input[@id='survey_question_default_option_2']");
	By checkBoxTwoInput = By.xpath("//input[@id='survey_question_values_2_value']");
	By checkBoxThree = By.xpath("//input[@id='survey_question_default_option_3']");
	By checkBoxThreeInput = By.xpath("//input[@id='survey_question_values_3_value']");
	// ---DropDown List Question ----------
	By dropDownList = By.xpath("//a[contains(text(),'Dropdown List')]");
	By radioOne = By.xpath("//input[@id='survey_question_values_default_option_1']");
	By radioOneInput = By.xpath("//input[@id='survey_question_values_1_value']");
	By radioTwo = By.xpath("//input[@id='survey_question_values_default_option_2']");
	By radioTwoInput = By.xpath("//input[@id='survey_question_values_2_value']");
	By radioThree = By.xpath("//input[@id='survey_question_values_default_option_3']");
	By radioThreeInput = By.xpath("//input[@id='survey_question_values_3_value']");
	// ---Radio Button Question------
	By radioButton = By.xpath("//a[contains(text(),'Radio Buttons')]");
	// ----Paragraph Question ---------
	By paragraph = By.xpath("//a[contains(text(),'Paragraph')]");
	// ----Heaidng Question ---------
	By heading = By.xpath("//a[contains(text(),'Heading')]");
	By description = By.xpath("//textarea[@id='survey_question_question_subtext']");
	String title = "Title";
	String info = "This is a description";
	// ----Linear Scale -------------
	By linearscale = By.xpath("//a[contains(text(),'Linear Scale')]");
	// ------------------------------------------------
	By manageRespondents = By.xpath("//a[contains(text(),'Manage Respondents')]");
	By respondents = By.xpath("//a[contains(text(),'Respondents')]");
	By survey_Title = By.xpath("//h1[contains(text(),'This is a Survey Title')]");
	By survey_Title_2 = By.xpath("(//a[contains(text(),'This is a Survey Title')])[1]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By surveyBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By surveySucessResponseMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully responded to survey: This is a Survey Title')]");
	By breadCrumbWorkroom = By.xpath("//a[contains(text(),'Workroom Surveys')]");
	// ------------------------------------------------------------------------------

	public SurveyPage(WebDriver driver) {
		this.driver = driver;
	}

	// ------------------ Expected Conditions ---------------------
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
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveysSubMenu)));
	}

	public void verifyNewSurveyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyBtn)));
	}

	public void verifySurveyTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveyTitleInputField)));
	}

	public void verifySurveySucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveySucessMessage)));
	}

	public void verifyAddQuestionOne() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionOne)));
	}

	public void verifyNewQuestionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionBox)));
	}

	public void verifyTextArea() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		WebElement textAreaBody = driver.findElement(By.tagName("body"));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(textAreaBody)));
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}

	// ------------------ General Elements ---------------------
	public void clickAutoBEWorkRoom() {
		driver.findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		driver.findElement(collaborateActiveOff).click();
	}

	public void clickSurveys() {
		driver.findElement(surveysSubMenu).click();
	}

	public void clickNewSurveyBtn() {
		driver.findElement(newSurveyBtn).click();
	}

	public void clickandTypeSurveyTitleInputField() throws InterruptedException {
		driver.findElement(surveyTitleInputField).click();
		driver.findElement(surveyTitleInputField).sendKeys(surveyTitle);
	}

	public void clickSaveBtn() throws InterruptedException {
		driver.findElement(saveBtn).click();
	}

	public void clickSaveBtnBox() throws InterruptedException {
		driver.findElement(saveBtnbox).click();
	}

	// --------Text Field Scenario Elements/Functions ----------------------------
	public void clickQuestionOne() {
		driver.findElement(newQuestionOne).click();
	}

	public void clickTextFieldBtn() {
		driver.findElement(textFieldBtn).click();
	}

	public void clickTextAreaSendKeysandSave() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question1);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		driver.findElement(saveBtnbox).click();
	}

	public void verifyQuestionCreated1() throws InterruptedException {
		String question1 = "//*[contains(text(),'what happened to the good old days?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question1)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Check Boxes Scenario Elements/Functions --------------------------
	public void clickCheckBoxBtn() {
		driver.findElement(checkBoxes).click();
	}

	public void clickTextAreaSendKeys2() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question2);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void clickCheckBoxOneAndInput1() throws InterruptedException {
		driver.findElement(checkBoxOne).click();
		Thread.sleep(500);
		driver.findElement(checkBoxOneInput).click();
		Thread.sleep(500);
		driver.findElement(checkBoxOneInput).sendKeys(Option1);
	}

	public void clickCheckBoxTwoAndInput2() throws InterruptedException {
		driver.findElement(checkBoxTwo).click();
		Thread.sleep(500);
		driver.findElement(checkBoxTwoInput).click();
		Thread.sleep(500);
		driver.findElement(checkBoxTwoInput).sendKeys(Option2);
	}

	public void clickCheckBoxThreeAndInput3() throws InterruptedException {
		driver.findElement(checkBoxThree).click();
		Thread.sleep(500);
		driver.findElement(checkBoxThreeInput).click();
		Thread.sleep(500);
		driver.findElement(checkBoxThreeInput).sendKeys(Option3);
	}

	public void verifyQuestionCreated2() throws InterruptedException {
		String question2 = "//*[contains(text(),'what happened to Gilbert Grape?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question2)).size() != 0);
		Thread.sleep(3000);
	}
	// -------- Dropdown List Scenario Elements/Functions --------------------------

	public void clickDropDownList() {
		driver.findElement(dropDownList).click();
	}

	public void clickTextAreaSendKeys3() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question3);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void clickRadioOneAndInput1() throws InterruptedException {
		driver.findElement(radioOne).click();
		Thread.sleep(500);
		driver.findElement(radioOneInput).click();
		Thread.sleep(500);
		driver.findElement(radioOneInput).sendKeys(Option1);
	}

	public void clickRadioTwoAndInput2() throws InterruptedException {
		driver.findElement(radioTwo).click();
		Thread.sleep(500);
		driver.findElement(radioTwoInput).click();
		Thread.sleep(500);
		driver.findElement(radioTwoInput).sendKeys(Option2);
	}

	public void clickRadioThreeAndInput3() throws InterruptedException {
		driver.findElement(radioThree).click();
		Thread.sleep(500);
		driver.findElement(radioThreeInput).click();
		Thread.sleep(500);
		driver.findElement(radioThreeInput).sendKeys(Option3);
	}

	public void verifyQuestionCreated3() throws InterruptedException {
		String question3 = "//*[contains(text(),'what happened to Micheal Jordan?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question3)).size() != 0);
		Thread.sleep(3000);
	}
	// -------- Radio Button Scenario Elements/Functions --------------------------

	public void clickRadioButtons() {
		driver.findElement(radioButton).click();
	}

	public void clickTextArea3() {
		driver.findElement(textArea3).click();
	}

	public void clickTextAreaSendKeys4() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question4);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void verifyQuestionCreated4() throws InterruptedException {
		String question4 = "//*[contains(text(),'what happened to Daffy Duck?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question4)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Paragraph Scenario Elements/Functions --------------------------
	public void clickParagraph() {
		driver.findElement(paragraph).click();
	}

	public void clickTextAreaSendKeys5() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question5);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void verifyQuestionCreated5() throws InterruptedException {
		String question5 = "//*[contains(text(),'Jack and Jill ran up the hill searching to fetch a pail of water. It was the best of times and he worst of times')]";
		Assert.assertTrue(driver.findElements(By.xpath(question5)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Heading Scenario Elements/Functions --------------------------
	public void clickHeading() {
		driver.findElement(heading).click();
	}

	public void clickTextAreaSendKeys6() throws InterruptedException {
		//--switch to iframe---
		WebElement textBoxOne = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]"));
		driver.switchTo().frame(textBoxOne);
		//--send keys to iframe body-----
		WebElement textBoxOneIframe = driver.findElement(By.tagName("body"));
		textBoxOneIframe.click();
		Thread.sleep(500);
		textBoxOneIframe.sendKeys(title);
		Thread.sleep(500);
		driver.switchTo().defaultContent();

		//--switch to iframe---
		WebElement textBoxTwo = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[2]"));
		driver.switchTo().frame(textBoxTwo);
		//--send keys to iframe body-----
		WebElement textBoxTwoIframe = driver.findElement(By.tagName("body"));
		textBoxTwoIframe.click();
		Thread.sleep(500);
		textBoxTwoIframe.sendKeys(info);
		driver.switchTo().defaultContent();
	}

	public void verifyTitleAndDescription() throws InterruptedException {
		String info = "//*[contains(text(),'This is a description')]";
		Assert.assertTrue(driver.findElements(By.xpath(info)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Linear Scale Scenario Elements/Functions --------------------------
	public void clickLinearScale() {
		driver.findElement(linearscale).click();
	}

	public void clickTextAreaSendKeysSelectChoices() throws InterruptedException {
		By tenDelete = By.xpath("//div[@id='choice_10']//a[@class='remove-opt btn btn-sm btn-danger'][contains(text(),'Delete')]");
		By radioBtn8 = By.xpath("//input[@id='survey_question_values_default_option_8']");
		By contnueBtn = By.xpath("//button[@class='btn commit btn-danger']");
		
		//--switch to iframe---
		WebElement textBoxOne = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]"));
		driver.switchTo().frame(textBoxOne);
		//--send keys to iframe body-----
		WebElement textBoxOneIframe = driver.findElement(By.tagName("body"));
		textBoxOneIframe.click();
		Thread.sleep(500);
		textBoxOneIframe.sendKeys(Question6);
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.findElement(tenDelete).click();
		Thread.sleep(2000);
		driver.findElement(contnueBtn).click();
		Thread.sleep(2000);
		driver.findElement(radioBtn8).click();
	}

	public void verifyLinearScaleTitle() throws InterruptedException {
		String question6 = "//*[contains(text(),'pick highest number between 1 and 10')]";
		Assert.assertTrue(driver.findElements(By.xpath(question6)).size() != 0);
		Thread.sleep(3000);
	}

	// ------------------ Calendar Functions ---------------------
	public void surveyDueDateCalendar() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(surveyDueDate);
		action.doubleClick(element).perform();
		String day = "5";
		// WebElement dropdownlist =
		// driver.findElement(By.xpath("//div[@class='bootstrap-datetimepicker-widget
		// dropdown-menu top picker-open']"));
		WebElement calendar = driver.findElement(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top picker-open']//div[@class='datepicker-days']//tbody"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		for (WebElement option : opt) {
			if (option.getText().equals(day)) {
				option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-md-8']")).click();
	}

	public void surveyReminderCalendar() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(surveyReminderDate);
		action.doubleClick(element).perform();
		String day = "20";
		// WebElement dropdownlist =
		// driver.findElement(By.xpath("//div[@class='bootstrap-datetimepicker-widget
		// dropdown-menu top picker-open']"));
		WebElement dropdownlist = driver.findElement(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top picker-open']//div[@class='datepicker-days']//tbody"));
		List<WebElement> options = dropdownlist.findElements(By.tagName("td"));
		for (WebElement option : options) {
			if (option.getText().equals(day)) {
				option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-md-8']")).click();
	}

	// ------------------ Iframe Text Box Send Keys ---------------------
	public void surveyDescriptionTextBox() throws InterruptedException {
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

	// ------------------------2nd Phase ------------------------------------------
	public void verifyRespondents() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents)));
	}

	public void verifyPollTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title)));
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

	public void verifySurveySucessResponseMessage() throws InterruptedException {
		Thread.sleep(3000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveySucessResponseMessage)));
	}

	public void verifySurveyTitle_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title_2)));
	}

	public void clickSubmitBtn() throws InterruptedException {
		WebElement submit = driver.findElement(By.xpath("//button[@id='survey-submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		driver.findElement(submitBtn).click();
		Thread.sleep(2000);
	}

	public void clickBuildBtn() throws InterruptedException {
		driver.findElement(buildBtn).click();
		Thread.sleep(1000);
	}

	public void clickSurveyBtnOn() throws InterruptedException {
		driver.findElement(surveyBtnOn).click();
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

	public void verifySurveyTitleAndQuestionExist() throws InterruptedException {
		String surveyTitle = "//h1[contains(text(),'This is a Survey Title')]";
		String question1 = "//p[contains(text(),'what happened to the good old days?')]";
		String question2 = "//p[contains(text(),'what happened to Gilbert Grape?')]";
		String question3 = "//p[contains(text(),'what happened to Micheal Jordan?')]";
		String question4 = "//p[contains(text(),'what happened to Daffy Duck?')]";
		String question5 = "//p[contains(text(),'Jack and Jill ran up the hill searching to fetch a')]";
		String question6 = "//p[contains(text(),'pick highest number between 1 and 10')]";
		Assert.assertTrue(driver.findElements(By.xpath(surveyTitle)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question1)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question2)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question3)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question4)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question5)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question6)).size() != 0);
	}

	public void clickManageRespondentsAddUser() throws InterruptedException {
		// click Manage Respondents
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

	// ------------------ Functions ----------------------
	public void create_Survey() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField();
		Thread.sleep(2000);
		// this.surveyDueDateCalendar();
		// this.surveyReminderCalendar();
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Survey() -----------");
	}

	public void create_TextField_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickTextFieldBtn();
		this.verifyTextArea();
		this.clickTextAreaSendKeysandSave();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated1();
		System.out.println("------- Completed --> create_TextField_Question() -----------");
	}

	public void create_CheckBox_Question() throws InterruptedException {
		// ---Text CheckBox Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickCheckBoxBtn();
		this.verifyTextArea();
		this.clickTextAreaSendKeys2();
		this.clickCheckBoxOneAndInput1();
		this.clickCheckBoxTwoAndInput2();
		this.clickCheckBoxThreeAndInput3();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated2();
		System.out.println("------- Completed --> create_CheckBox_Question() -----------");
	}

	public void create_Dropdown_List_Question() throws InterruptedException {
		// ---DropDown List Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickDropDownList();
		this.verifyTextArea();
		this.clickTextAreaSendKeys3();
		this.clickRadioOneAndInput1();
		this.clickRadioTwoAndInput2();
		this.clickRadioThreeAndInput3();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated3();
		System.out.println("------- Completed --> create_Dropdown_List_Question() -----------");
	}

	public void create_RadioButtons_Question() throws InterruptedException {
		// ---Radio Button Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickRadioButtons();
		this.verifyTextArea();
		this.clickTextAreaSendKeys4();
		this.clickRadioOneAndInput1();
		this.clickRadioTwoAndInput2();
		this.clickRadioThreeAndInput3();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated4();
		System.out.println("------- Completed --> create_RadioButtons_Question() -----------");
	}

	public void create_Paragraph_Question() throws InterruptedException {
		// ---Paragraph Creation------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickParagraph();
		this.verifyTextArea();
		this.clickTextAreaSendKeys5();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated5();
		System.out.println("------- Completed --> create_Paragraph_Question() -----------");
	}

	public void create_Heading_Question() throws InterruptedException {
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickHeading();
		this.verifyTextArea();
		this.clickTextAreaSendKeys6();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyTitleAndDescription();
		System.out.println("------- Completed --> create_Heading_Question() -----------");
	}

	public void create_Linear_Scale() throws InterruptedException {
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickLinearScale();
		this.verifyTextArea();
		this.clickTextAreaSendKeysSelectChoices();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyLinearScaleTitle();
		System.out.println("------- Completed --> create_Linear_Scale() -----------");
	}

	// -------------------------------------------------------------------
	public void manage_Respondents() throws InterruptedException {
		this.clickManageRespondentsAddUser();
		this.verifyBuildBtn();
		System.out.println("------- Completed --> manage_Respondents() -----------");
	}

	public void build_Survey_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickSurveyBtnOn();
//		this.verifyContinueBtn();
//		this.clickContinueBtn();
		this.clickSubmitBtn();
		this.verifySurveySucessResponseMessage();
		this.verifySurveyTitleAndQuestionExist();
		this.clickBreadCrumbWorkroom();
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> build_Survey_Make_Visible() -----------");
	}
	By survey_Title_Dropdown = By.xpath("(//a[contains(text(),'This is a Survey Title')]/following::div[@class='dropdown header-actions'])[1]");
	By deleteOption = By.xpath("//div[@class='dropdown header-actions open']//a[contains(text(),'Delete')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteOption)));
	}

	public void click_Survey_Title_Dropdown() throws InterruptedException {
		driver.findElement(survey_Title_Dropdown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(deleteOption).click();
	}

	public void verify_Survey_NOT_Exist() throws InterruptedException {
		Thread.sleep(2000);
		String poll = "(//a[contains(text(),'This is a Survey Title')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(poll)).size() < 1);
	}

	public void delete_Survey() throws InterruptedException {
		this.click_Survey_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Survey() -----------");
	}
}
