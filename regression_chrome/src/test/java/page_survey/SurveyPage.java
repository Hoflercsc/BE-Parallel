package page_survey;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.naming.ldap.ExtendedRequest;
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
	By surveySucessMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully created')]");
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
	By respondents_2 = By.xpath("//*[contains(text(),'Respondents')]");
	By survey_Title = By.xpath("//h1[contains(text(),'This is a Survey Title')]");
	By survey_Title_2 = By.xpath("(//a[contains(text(),'This is a Survey Title')])[1]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By surveyBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By surveySucessResponseMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully responded to survey:')]");
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
	
	public void verifyAutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(AutoBE)));
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
		Assert.assertTrue(driver.findElements(By.xpath(question2)).size() > 0);
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
		Thread.sleep(500);
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
	
	public void verifyRespondents_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents_2)));
	}

	public void verifyPollTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title)));
	}
	
	public void verifySurveyTitle() {
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
		Thread.sleep(3000);
//		String automationTester3 = "//*[contains(text(),'Automation Tester')]";
//		Assert.assertTrue(driver.findElements(By.xpath(automationTester3)).size() != 0);
//		Thread.sleep(1000);
		WebElement saveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserB() throws InterruptedException {
		// click Manage Respondents
		driver.findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = driver.findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1500);
		WebElement autoDirector = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(1500);
		WebElement saveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserC() throws InterruptedException {
		// click Manage Respondents
		//driver.findElement(manageRespondents).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manage Respondents')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(1000);
		// verify respondents on page
		this.verifyRespondents_2();
		// scroll down to respondents
		WebElement Respondents = driver.findElement(By.xpath("//*[contains(text(),'Respondents')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1500);
		//----------
		WebElement autodirector = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", autodirector);
		Thread.sleep(1500);
		WebElement autoDirector = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(2000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserE() throws InterruptedException {
		// click Manage Respondents
		driver.findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = driver.findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1500);
		WebElement autoDirector = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(1500);
		
		WebElement steveSystem = driver.findElement(By.xpath("//*[@class='person-name'][contains(text(),'steve System')]"));
		steveSystem.click();
		Thread.sleep(1500);
		
		WebElement saveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2500);
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
	
	public void create_Survey_Condensed() throws InterruptedException {
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField();
		Thread.sleep(2000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Survey() -----------");
	}
	
	// ------------------ Functions ----------------------
	public void user_navigates_To_Survey() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> user_navigates_To_Survey() -----------");
	}
	
	public void user_navigates_To_Survey_2() throws InterruptedException {
		driver.navigate().refresh();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> user_navigates_To_Survey_2() -----------");
	}
	
	// --------------View/Respond_To_Survey ----------------------
	By allow_Edit = By.xpath("//input[@id='survey_allow_answer_editing']");
	By allow_Comments = By.xpath("//input[@id='survey_comments']");
	By survey_Input_Field = By.xpath("(//input[starts-with(@id,'survey_answers_')])[1]");
	By results = By.xpath("//a[contains(text(),'Results')]");
	By results_Summary = By.xpath("//div[@class='result-summary']");
	By individual_Results_Circle = By.xpath("//p[contains(text(),'Individual Results')]");
	By individual_Results_Button = By.xpath("//*[@id='wrap']/main//div/a[contains(.,'Individual Results')]");

	By question = By.xpath("//p[contains(text(),'what happened to the good old days?')]");
	
	public void verifiy_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results)));
	}
	
	public void verify_Results_Summary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results_Summary)));
	}
	
	public void verify_Question() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(question)));
	}
	
	public void verify_Submit() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(submitBtn)));
	}
	
	public void verify_Individual_Results_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(individual_Results_Button)));
	}
	
	public void scroll_Click_Input_Boxes() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//input[@id='survey_allow_answer_editing']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(allow_Edit).click();
		Thread.sleep(1000);
		driver.findElement(allow_Comments).click();
		Thread.sleep(1000);
	}
	
	public void click_Results() throws InterruptedException {
		driver.findElement(results).click();
	}
	
	public void click_Results_Summary() throws InterruptedException {
		driver.findElement(results_Summary).click();
	}
	
	public void click_Individual_Results() throws InterruptedException {
		driver.findElement(individual_Results_Circle).click();
	}
	
	public void verify_User_Reponse() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'Automation Tester')]";
		Assert.assertTrue(driver.findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(driver.findElements(By.xpath(user)).size() > 0);	
	}
	
	public void verify_User_Reponse_Non_Admin() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'Auto Director')]";
		Assert.assertTrue(driver.findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(driver.findElements(By.xpath(user)).size() > 0);	
	}
	
	// ------------------ Functions ----------------------
	public void create_Survey_Additional_Options() throws InterruptedException {
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
		this.surveyDescriptionTextBox();
		this.scroll_Click_Input_Boxes();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Survey() -----------");
	}
	
	public void user_Goes_To_Survey() throws InterruptedException {
		Thread.sleep(1000);
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		this.verifySurveyTitle_2();
		this.clickSurveyTitle();
		System.out.println("------- Completed --> user_Goes_To_Survey() -----------");
	}
	
	public void user_Goes_To_Survey_Non_Admin() throws InterruptedException {
		Thread.sleep(1000);
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifySurveyTitle_2();
		this.clickSurveyTitle();
		System.out.println("------- Completed --> user_Goes_To_Survey_Non_Admin() -----------");
	}
	
	public void user_Goes_To_Survey_2() throws InterruptedException {
		Thread.sleep(1000);
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> user_Goes_To_Survey_Results() -----------");
	}
	
	public void verify_Survey_Invited_And_Response() throws InterruptedException {
		String totalInvited = "//p[contains(text(),'Total Invited to survey: 2')]";
		String totalFinished = "//p[contains(text(),'Total Finished survey: 2')]";
		String systemSteve = "//p[contains(text(),'they past')]";
		String autoDirector = "//p[contains(text(),\"i don't know\")]";
		
		Assert.assertTrue(driver.findElements(By.xpath(totalInvited)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(totalFinished)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(systemSteve)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(autoDirector)).size() > 0);
	}
	
	public void respond_To_Survey() throws InterruptedException {
		Thread.sleep(1000);
		String answer = "They are gone";
		driver.findElement(survey_Input_Field).sendKeys(answer);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.RETURN);
		this.verify_Submit();
		driver.findElement(submitBtn).click();;
		System.out.println("------- Completed --> respond_To_Survey() -----------");
	}
	
	public void view_Survey_Responses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Question();
		this.verify_User_Reponse();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Survey_Reponses() -----------");
	}
	
	public void view_Survey_Responses_2() throws InterruptedException {
		this.click_Survey_Title_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Survey_Invited_And_Response();
		System.out.println("------- Completed --> view_Survey_Responses_2() -----------");
	}
	
	public void view_Survey_Reponses_Non_Admin() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Question();
		this.verify_User_Reponse_Non_Admin();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Survey_Reponses() -----------");
	}
	
	
	//-----------------------------------------------------
	// ------------------ Functions ----------------------
	public void creating_Survey_For_Event() throws InterruptedException {
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField();
		Thread.sleep(1000);
		// this.surveyDueDateCalendar();
		// this.surveyReminderCalendar();
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> creating_Poll_For_Event() -----------");
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
		Thread.sleep(1000);
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
	
	public void manage_Respondents_B() throws InterruptedException {
		this.clickManageRespondentsAddUserB();
		this.verifyBuildBtn();
		System.out.println("------- Completed --> manage_Respondents() -----------");
	}
	
	public void manage_Respondents_C() throws InterruptedException {
		this.clickManageRespondentsAddUserE();
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
	
	public void build_Survey_Make_Visible_3() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickSurveyBtnOn();
		this.clickSubmitBtn();
		this.verifySurveySucessResponseMessage();
		this.clickBreadCrumbWorkroom();
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> build_Survey_Make_Visible() -----------");
	}
	
	public void verify_Survey_Is_Visible() {
		By surveyVisible = By.xpath("//a[@class='be-positive btn btn-default']");
		WebElement survey = driver.findElement(surveyVisible);
		Assert.assertEquals(true, survey.isEnabled());
	}
	
	//-----------------------------------------------------
	By edit_Survey_Questions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Survey Questions')]");
	
	public void verify_Edit_Survey_Questions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Survey_Questions)));
	}
	
	public void click_Edit_Survey_Questions() throws InterruptedException {
		driver.findElement(edit_Survey_Questions).click();
	}
	
	public void navigate_To_Edit_Survey() throws InterruptedException {
		this.clickBuildBtn();
		this.verify_Edit_Survey_Questions();
        this.click_Edit_Survey_Questions();
		Thread.sleep(500);
	}
	
	//--------------------
	By question_One_Arrow = By.xpath("(//span[contains(text(),'1.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By question_Two_Arrow = By.xpath("(//span[contains(text(),'2.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By question_Three_Arrow = By.xpath("(//span[contains(text(),'3.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Option = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]");
	By edit_Question_Box = By.xpath("//h4[contains(text(),'Edit Question')]");
	
	String editOption1 = "home";
	String editOption2 = "store";
	String editOption3 = "work";
	
	String editRadio1 = "promotion";
	String editRadio2 = "congress";
	String editRadio3 = "fishing";

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

	public void click_Question_One_Arrow() throws InterruptedException {
		driver.findElement(question_One_Arrow).click();
	}
	
	public void click_Question_Two_Arrow() throws InterruptedException {
		driver.findElement(question_Two_Arrow).click();
	}
	
	public void click_Question_Three_Arrow() throws InterruptedException {
		driver.findElement(question_Three_Arrow).click();
	}
	
	public void click_Edit_Option() throws InterruptedException {
		driver.findElement(edit_Option).click();
	}
	
	public void edit_Question_Box_Text_Field() throws InterruptedException {
		String editedQuestion1 = "what happened to the good?";
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(editedQuestion1);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		driver.findElement(saveBtnbox).click();
	}
	
	public void verify_Edited_Text_Field_Question_Created() throws InterruptedException {
		String question1 = "//*[contains(text(),'what happened to the good?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question1)).size() > 0);
		Thread.sleep(3000);
	}
	
	public void edit_Check_Box_Question_Field() throws InterruptedException {
		String checkBoxQuestion = "what happened to Gilbert?";
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(checkBoxQuestion);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}
	
	public void verify_Edited_Check_Box_Question() throws InterruptedException {
		String question2 = "//*[contains(text(),'what happened to Gilbert?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question2)).size() > 0);
		Thread.sleep(3000);
	}
		
	public void editCheckBoxOneAndInputs() throws InterruptedException {
		By checkBoxOneInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[1]");
		By checkBoxTwoInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[2]");
		By checkBoxThreeInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[3]");

		Thread.sleep(500);
		driver.findElement(checkBoxOneInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(checkBoxOneInput).clear();
		driver.findElement(checkBoxOneInput).sendKeys(editOption1);
		
		Thread.sleep(500);
		driver.findElement(checkBoxTwoInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(checkBoxTwoInput).clear();
		driver.findElement(checkBoxTwoInput).sendKeys(editOption2);
		
		Thread.sleep(500);
		driver.findElement(checkBoxThreeInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(checkBoxThreeInput).clear();
		driver.findElement(checkBoxThreeInput).sendKeys(editOption3);
		
	}

	public void edit_Dropdown_List_Question_Field() throws InterruptedException {
		String dropdownBoxQuestion = "what happened to Micheal?";
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(dropdownBoxQuestion);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
	}
	
	public void verify_Edited_Drop_Down_Question() throws InterruptedException {
		String question3 = "//*[contains(text(),'what happened to Micheal?')]";
		Assert.assertTrue(driver.findElements(By.xpath(question3)).size() > 0);
		Thread.sleep(3000);
	}
	
	public void editRadioOneAndInputs() throws InterruptedException {
		By radioOneInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[1]");
		By radioTwoInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[2]");
		By radioThreeInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[3]");

		Thread.sleep(500);
		driver.findElement(radioOneInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioOneInput).clear();
		driver.findElement(radioOneInput).sendKeys(editRadio1);
		
		Thread.sleep(500);
		driver.findElement(radioTwoInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioTwoInput).clear();
		Thread.sleep(500);
		driver.findElement(radioTwoInput).sendKeys(editRadio2);
		
		Thread.sleep(500);
		driver.findElement(radioThreeInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(radioThreeInput).clear();
		driver.findElement(radioThreeInput).sendKeys(editRadio3);
		
	}
	
	public void edit_Text_Field_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_One_Arrow();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Question_Box_Text_Field();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Text_Field_Question_Created();
		System.out.println("------- Completed --> edit_Create_TextField_Question() -----------");
	}
	
	// finish making changes
	public void edit_Check_Box_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_Two_Arrow();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Check_Box_Question_Field();
		this.editCheckBoxOneAndInputs();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Check_Box_Question();
		System.out.println("------- Completed --> edit_Check_Box_Question() -----------");
	}
	
	public void edit_Dropdown_List_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_Three_Arrow();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Dropdown_List_Question_Field();
		this.editRadioOneAndInputs();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Drop_Down_Question();
		System.out.println("------- Completed --> edit_Dropdown_List_Question() -----------");
	}

	//-----------------attach_Event_To_Survey-----------------------------
	By attach_Create_Meeting = By.xpath("//a[@class='btn-sidebar secondary-action-btn left'][contains(text(),' Attach/Create Meeting')]");
	By attach_Create_Modal = By.xpath("//div[@id='attach']//div[@class='modal-content']");
	By event_Title_Snippet = By.xpath("//span[contains(text(),'This is a New Event Title')]");
	By doneBtn = By.xpath("//button[@id='attached_event'][contains(text(),'Done')]");
	By event_Container = By.xpath("//div[@class='event_container']");
	By new_Event = By.partialLinkText("This is a New Ev.");
	By new_Event_Title = By.xpath("//h1[contains(text(),'This is a New Event Title')]");

	public void verify_Attach_Create_Meeting() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Meeting)));
	}
	
	public void verify_Attach_Create_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Modal)));
	}
	
	public void verify_Event_Container() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Container)));
	}
	
	public void verify_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void click_Event_Title_Snippet() throws InterruptedException {
		driver.findElement(event_Title_Snippet).click();
	}
	
	public void click_Attach_Create_Meeting() throws InterruptedException {
		driver.findElement(attach_Create_Meeting).click();
	}
	
	public void click_DoneBtn() throws InterruptedException {
		driver.findElement(doneBtn).click();
	}
	
	public void click_New_Event() throws InterruptedException {
		driver.findElement(new_Event).click();
	}
	
	public void verify_Event_Info() throws InterruptedException {
		String info1 = "//h4[@class='heading-surveys'][contains(text(),'Surveys & Polls')]";
		String info2 = "//li[starts-with(@class,'survey-')]//a[contains(text(),'This is a Survey Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(info1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(info2)).size() > 0);
	}

	public void attach_Event_To_Survey() throws InterruptedException {
		this.clickSurveyTitle();
		Thread.sleep(1000);
		this.verify_Attach_Create_Meeting();
		this.click_Attach_Create_Meeting();
		Thread.sleep(1000);
		this.verify_Attach_Create_Modal();
		this.click_Event_Title_Snippet();
		Thread.sleep(1000);
		this.click_DoneBtn();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> attach_Event_To_Survey() -----------");
	}
	
	public void verify_Event_Attached_To_Survey() throws InterruptedException {
		this.verify_Event_Container();
		this.click_New_Event();
		Thread.sleep(1000);
		this.verify_Event_Title();
		this.verify_Event_Info();
		System.out.println("------- Completed --> verify_Event_Attached_To_Survey() -----------");
	}
	
	//--------------duplicate_Survey----------------------------------------
	By duplicate_Survey = By.xpath("//a[contains(text(),'Duplicate Survey')]");
	String surveyCopy = "This is a Survey Title - Duplicate";

	public void verifyDuplicateSurveyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(duplicate_Survey)));
	}
	
	public void verifyBreadCrumbWorkroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbWorkroom)));
	}
	
	public void clickSurveyTitle() throws InterruptedException {
		driver.findElement(survey_Title_2).click();
	}
	
	public void clickDuplicateSurveyBtn() throws InterruptedException {
		driver.findElement(duplicate_Survey).click();
	}
	
	public void enterSurveyTitle() throws InterruptedException {
		driver.findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(surveyTitleInputField).clear();
		driver.findElement(surveyTitleInputField).sendKeys(surveyCopy);
	}
	
	public void build_Survey_Make_Visible_2() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1500);
		this.verifyEditSurveyQuestions();
		this.clickSurveyBtnOn();
		Thread.sleep(1500);
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> build_Survey_Make_Visible_2() -----------");
	}
	
	public void duplicate_Survey() throws InterruptedException {
		this.clickSurveyTitle();
		Thread.sleep(1000);
		this.verifyDuplicateSurveyBtn();
		this.clickDuplicateSurveyBtn();
		this.verifySurveyTitleInputField();
		this.enterSurveyTitle();
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> duplicate_Survey() -----------");
	}
	
	//--------------move_Survey_To_Another_Workroom----------------------------------------
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
	
	
	public void move_Survey_To_Another_Workroom() throws InterruptedException {
		this.clickSurveyTitle();
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
		System.out.println("------- Completed --> move_Survey_To_Another_Workroom() -----------");
	}
	
	public void verify_Move_Workroom_AutoAttend() throws InterruptedException {
		this.verify_AutoAttend_Workroom();
		this.click_AutoAttend_2();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		System.out.println("------- Completed --> verify_Move_Workroom_AutoAttend() -----------");
	}
	
	// ------------------add_File_To_Survey----------------------
	By addFile = By.xpath("//a[contains(text(),'Add a File')]");
	By addFileInputField = By.xpath("//a[contains(text(),'Add a File')]");
	By saveFileBtn = By.xpath("//div[@id='newSurveyFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By surveyFile = By.xpath("//a[contains(text(),'survey file')]");
	String filetitle = "survey file";
	
	public void verifyAddFileBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addFile)));
	}
	
	public void verifyAddFileInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addFileInputField)));
	}
	
	public void verifySurveyFileAdded() {
		String surveyFile = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(surveyFile)).size() > 0);
	}
	
	public void clickAddFileBtn() throws InterruptedException {
		driver.findElement(addFile).click();
	}
	
	public void fileTitleSendKeys() throws InterruptedException {
		driver.findElement(addFileInputField).sendKeys(filetitle);
	}
	

	public void clickSaveFileBtn() throws InterruptedException {
		driver.findElement(saveFileBtn).click();
	}
	
	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_To_Survey() throws InterruptedException {
		this.clickSurveyTitle();
		Thread.sleep(1000);
		this.verifyAddFileBtn();
		this.clickAddFileBtn();
		Thread.sleep(1000);
		this.verifyAddFileInputField();
		this.fileTitleSendKeys();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveFileBtn();
		Thread.sleep(1500);
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_File_To_Survey() -----------");
	}
	
	public void verify_Survey_File_Added() throws InterruptedException {
		this.clickSurveyTitle();
		Thread.sleep(1000);
		this.verifySurveyTitle();
		this.verifySurveyFileAdded();
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> verify_Survey_File_Added() -----------");
	}
	
	// ------------------Survey_Not_Visible----------------------
	By surveyNotVisible = By.xpath("(//div[starts-with  (@id,'survey-card-')]//span[@class='icon icon_mbm-notvisible active-off'])[1]");
	By notVisibleSurveys = By.xpath("//a[contains(text(),'Not Visible Surveys')]");

	public void click_Survey_Not_Visible() throws InterruptedException {
		driver.findElement(surveyNotVisible).click();
	}
	
	public void click_Not_Visible_Surveys() throws InterruptedException {
		driver.findElement(notVisibleSurveys).click();
	}
	
	public void verify_Survey_Is_NOT_Visible() {
		By surveyNotVisible = By.xpath("(//div[ starts-with (@id,'survey-card-')]//a[@class='btn btn-default be-negative'])[1]");
		WebElement survey = driver.findElement(surveyNotVisible);
		Assert.assertEquals(true, survey.isEnabled());
	}
	
	public void verify_Survey_NOT_Exist_By_Value() {
		String survey = "//h3//a[normalize-space(text())='This is a Survey Title']";
		Assert.assertTrue(driver.findElements(By.xpath(survey)).size() < 1);
	}
	
	public void disable_Survey_Visiblility() throws InterruptedException {
		this.click_Survey_Not_Visible();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.click_Not_Visible_Surveys();
		Thread.sleep(2000);
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> disable_Survey_Visiblility() -----------");
	}
	
	// ------------------edit/view_Survey_Settings----------------------
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	By content = By.xpath("//div[@class='content']");
	By edit = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Edit')]");
	By signature_Required = By.xpath("//input[@id='survey_signature_required']");
	By edit_Survey_Settings = By.xpath("//a[@class='primary-action-btn btn btn-default btn-sidebar secondary-action-btn left'][contains(text(),' Edit Survey Settings')]");

	public void verify_Settings_Page() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(content)));
	}
	
	public void verify_Edit_Survey_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Survey_Settings)));
	}
	
	public void verify_Settings_Content() {
		String title = "//label[contains(text(),'Title')]";
		String expDate = "//label[contains(text(),'Expiration Date')]";
		String reminderDate = "//label[contains(text(),'Reminder Date')]";
		String description = "//label[contains(text(),'Description')]";
		String notify = "//label[contains(text(),'Notify')]";
		String box2 = "//span[contains(text(),'Cannot be changed')]";
		String box9 = "//span[contains(text(),'Automatically number questions')]";
		
		Assert.assertTrue(driver.findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(expDate)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(reminderDate)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(description)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(notify)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(box2)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(box9)).size() > 0);
	}
	
	public void click_Settings() throws InterruptedException {
		driver.findElement(settings).click();
	}
	
	public void click_Edit() throws InterruptedException {
		driver.findElement(edit).click();
	}
	
	public void click_Allow_Comments() throws InterruptedException {
		driver.findElement(allow_Comments).click();
	}
	
	public void click_Allow_Edits() throws InterruptedException {
		driver.findElement(allow_Edit).click();
	}
	
	public void click_Edit_Survey_Settings() throws InterruptedException {
		driver.findElement(edit_Survey_Settings).click();
	}
	
	public void scroll_To_Signature_Reguired() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//input[@id='survey_signature_required']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}

	public void view_Survey_Settings() throws InterruptedException {
		this.click_Survey_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Settings();
		this.verify_Settings_Page();
		this.verify_Settings_Content();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> view_Survey_Settings() -----------");
	}
		
	public void edit_Survey_Settings() throws InterruptedException {
		this.clickSurveyTitle();
		Thread.sleep(1000);
        this.verify_Edit_Survey_Settings();
        this.click_Edit_Survey_Settings();
		Thread.sleep(1000);
		this.verifySurveyTitleInputField();
		this.scroll_To_Signature_Reguired();
		this.click_Allow_Comments();
		Thread.sleep(1000);
        this.click_Allow_Edits();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);;
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifySurveyTitle_2();
		System.out.println("------- Completed --> edit_Survey_Settings() -----------");
	}
	
	public void verifyArchivedSurveyTitle() throws InterruptedException {
		String element = "(//a[contains(text(),'This is a Survey Title')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void archive_Survey() throws InterruptedException {
		this.click_Survey_Title_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.clickArchive();
		Thread.sleep(1500);
		this.verifyArchiveCard();
		this.verifyArchivedSurveyTitle();
		System.out.println("------- Completed --> archive_Survey() -----------");
	}
	
	// ------------------delete_Survey----------------------
	By survey_Title_Dropdown = By.xpath("(//a[contains(text(),'This is a Survey Title')]/following::div[@class='dropdown header-actions'])[1]");
	By survey_title = By.xpath("//a[contains(text(),'This is a Survey Title')]");
	By deleteOption = By.xpath("//div[@class='dropdown header-actions open']//a[contains(text(),'Delete')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteOption)));
	}
	
	public void verify_Survey_Title_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title_Dropdown)));
	}

	public void click_Survey_Title_Dropdown() throws InterruptedException {
		driver.findElement(survey_Title_Dropdown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(deleteOption).click();
	}

	public void verify_Survey_NOT_Exist() throws InterruptedException {
		Thread.sleep(1000);
		String survey = "(//a[contains(text(),'This is a Survey Title')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(survey)).size() < 1);
		
		System.out.println("------- Completed --> verify_Survey_NOT_Exist() -----------");

	}

	public void delete_Survey() throws InterruptedException {
		this.verify_Survey_Title_Dropdown();
		this.click_Survey_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Survey() -----------");
	}
	
	public void delete_Archived_Survey() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyArchiveBtn();
		this.clickArchiveBtn();
		Thread.sleep(1000);
		this.verifyArchiveCard();
		this.click_Survey_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Archived_Template_Survey() -----------");
	}
	
	// ------------------create_Survey_Template----------------------
	By surveys = By.xpath("//a[contains(text(),'Surveys')]");
	By surveyTemplate = By.xpath("//a[contains(text(),'Survey Templates')]");
	By newSurveyTemplate = By.xpath("//a[@class='btn btn-success'][contains(text(),' New Survey Template')]");
	By templateSucessMessage = By.xpath("//div[@class='margin-top-small']//p[contains(text(),'Successfully created Survey Template Title')]");
	By survTemplateTitle = By.xpath("(//a[contains(text(),'Survey Template Title')])[1]");
	By surveyTemplateDropdown = By.xpath("//button[@id='dropdownMenu1'][1]");
	By editedSurveyTemplateDropdown = By.xpath("(//a[contains(text(),'Edited Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]");
	By editTemplate = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Edit')]");
	By saveBtn2 = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By archive = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Archive')]");
	By archiveCard = By.xpath("//div[@id='archived-surveys']");
	By archiveBtn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");
	By archivedSurveyTemplate = By.xpath("(//a[contains(text(),'Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]");
	By copyTemplate = By.xpath("//div[@class='col-md-10 narrow']//li[5]//a[1][contains(text(),'Copy')]");
	By copyToTemplate = By.xpath("//a[contains(text(),'Copy to Template')]");
	By templateDropDown = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By template = By.xpath("//div[@class='content']//li[2]//a[1]");
	By newSurveyTemplateTitle = By.xpath("//h1[contains(text(),'New Survey From Survey Template')]");
	By newSurveyFromTemplateDropDown = By.xpath("(//a[contains(text(),'New Survey From Survey Template')]/following::button[@id='dropdownMenu1'])[1]");
	By editSurveyQuestions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Survey Questions')]");
	By surveyVisible = By.xpath("//span[@class='bold dark-blue visibility_toggle_label'][contains(text(),'Survey Is Visible')]");

	String surveyTemplateTitle = "Survey Template Title";
	String surveyTemplateTitle2 = "Edited Survey Template Title";
	String surveyTemplateTitle3 = "Survey Template Title - Copy";

	public void verifyNewSurveyTemplate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyTemplate)));
	}
	
	public void verifyTemplateSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(templateSucessMessage)));
	}
	
	public void verifySurveyTemplateTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survTemplateTitle)));
	}
	
	public void verifyEditedSurveyTemplateDropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editedSurveyTemplateDropdown)));
	}
	
	public void verifyWorkroomBreachCrumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbWorkroom)));
	}
	
	public void verifyArchiveCard() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveCard)));
	}
	
	public void verifyArchiveBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveBtn)));
	}
	
	public void verifyTemplate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(template)));
	}
	
	public void verifySurveyTemplateCreated() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyTemplateTitle)));
	}
	
	public void verifyEditSurveyQuestions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editSurveyQuestions)));
	}
	
	public void verifySurveyVisible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveyVisible)));
	}
	
	public void verifyNewSurveyFromTemplate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyFromTemplateDropDown)));
	}
	
	public void clickSurveyTemplate() {
		driver.findElement(surveyTemplate).click();
	}
	
	public void clickNewSurveyTemplate() {
		driver.findElement(newSurveyTemplate).click();
	}
	
	public void enterSurveyTemplateTitle() throws InterruptedException {
		driver.findElement(surveyTitleInputField).click();
		driver.findElement(surveyTitleInputField).sendKeys(surveyTemplateTitle);
	}
	
	public void enterSurveyTemplateTitle2() throws InterruptedException {
		driver.findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(surveyTitleInputField).clear();
		driver.findElement(surveyTitleInputField).sendKeys(surveyTemplateTitle2);
	}
	
	public void enterSurveyTemplateTitle3() throws InterruptedException {
		driver.findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(surveyTitleInputField).clear();
		driver.findElement(surveyTitleInputField).sendKeys(surveyTemplateTitle3);
	}
	
	public void verifyTemplateTitlesExist() throws InterruptedException {
		String surveyTitle = "//h1[contains(text(),'Survey Template Title')]";
		String question1 = "//p[contains(text(),'what happened to the good old days?')]";
		String question2 = "//p[contains(text(),'what happened to Gilbert Grape?')]";
		Assert.assertTrue(driver.findElements(By.xpath(surveyTitle)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question1)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(question2)).size() != 0);
	}
	
	public void verifyTemplateCopyExists() throws InterruptedException {
		String template = "//a[contains(text(),'Survey Template Title - Copy')]";
		Assert.assertTrue(driver.findElements(By.xpath(template)).size() > 0);
		Thread.sleep(3000);
	}
	
	public void verifyTemplatesDeleted() throws InterruptedException {
		String template = "//a[contains(text(),'Survey Template Title - Copy')]";
		String template2 = "//a[contains(text(),'Survey Template Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(template)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(template2)).size() < 1);
		Thread.sleep(3000);
		System.out.println("------- Completed --> verify_Templates_Deleted() -----------");
	}
	
	public void click_Template_Title_Dropdown() throws InterruptedException {
		driver.findElement(surveyTemplateDropdown).click();
	}
	
	public void clickEditedSurveyTemplateDropdown() throws InterruptedException {
		driver.findElement(editedSurveyTemplateDropdown).click();
	}
	
	public void clickEditTemplate() throws InterruptedException {
		driver.findElement(editTemplate).click();
	}
	
	public void clickArchiveTemplate() throws InterruptedException {
		driver.findElement(editTemplate).click();
	}
	
	public void clickArchive() throws InterruptedException {
		driver.findElement(archive).click();
	}
	
	public void clickArchiveBtn() throws InterruptedException {
		driver.findElement(archiveBtn).click();
	}
	
	public void clickArchivedSurveyTemplateDropdown() throws InterruptedException {
		driver.findElement(archivedSurveyTemplate).click();
	}

	public void clickCopyTemplate() throws InterruptedException {
		driver.findElement(copyTemplate).click();
	}
	
	public void clickCopyTemplateToTemplate() throws InterruptedException {
		driver.findElement(copyToTemplate).click();
	}
	
	public void clickTemplateDropDown() throws InterruptedException {
		driver.findElement(templateDropDown).click();
	}
	
	public void clickTemplate() throws InterruptedException {
		driver.findElement(template).click();
	}
	
	public void clickNewSurveyFromTemplateDropDown() throws InterruptedException {
		driver.findElement(newSurveyFromTemplateDropDown).click();
	}
	
	public void clickSurveys2() throws InterruptedException {
		driver.findElement(surveys).click();
	}
		
	public void clickSaveBtn2() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(saveBtn2).click();
	}
	
	public void verifyArchivedSurveyTemplateTitle() throws InterruptedException {
		String element = "(//a[contains(text(),'Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verifySurveyTemplateDeleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
		
		System.out.println("------- Completed --> verify_Survey_Template_Deleted() -----------");
	}
	
	public void verifyArchivesNOTPresent() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Archives')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
		
		System.out.println("------- Completed --> verify_Archives_NOT_Present() -----------");
	}
	
	public void verifyEditedTemplateSurveyDeleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]";
		String element2 = "(//a[contains(text(),'Edited Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(element2)).size() < 1);
		
		System.out.println("------- Completed --> verify_edited_Template_Survey_Deleted-----------");
	}
	
	// ------------------ Iframe Text Box Send Keys ---------------------
	public void surveyTemplateDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a an Edited Message");
		driver.switchTo().defaultContent();
	}
	
	// ------------------ Functions ----------------------
	public void create_Survey_Template() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifyNewSurveyTemplate();
		this.clickNewSurveyTemplate();
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle();
		Thread.sleep(2000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifyTemplateSucessMessage();
		System.out.println("------- Completed --> create_Survey_Template() -----------");
	}
	
	public void copy_Survey_Template() throws InterruptedException {
		this.click_Template_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.clickCopyTemplate();
		Thread.sleep(1500);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle3();
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyWorkroomBreachCrumb();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Survey_Template() -----------");
	}
	
	public void copy_Survey_Template_To_Template() throws InterruptedException {
		this.click_Template_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.clickCopyTemplateToTemplate();
		Thread.sleep(1500);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle3();
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyWorkroomBreachCrumb();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Survey_Template() -----------");
	}
	
	public void clickandTypeSurveyTitleInputField2(String surveytitle2) throws InterruptedException {
		driver.findElement(surveyTitleInputField).click();
		driver.findElement(surveyTitleInputField).sendKeys(surveytitle2);
	}

	// ------------------ Functions ----------------------
	public void create_Survey_From_Survey_Template(String surveytitle2) throws InterruptedException {
		this.clickSurveys2();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField2(surveytitle2);
		Thread.sleep(2000);
		this.clickTemplateDropDown();
		Thread.sleep(1000);
		this.verifyTemplate();
		this.clickTemplate();
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveyTemplateCreated();
		System.out.println("------- Completed --> create_Survey_From_Survey_Template() -----------");
	}
	
	public void build_Survey_Template_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1000);
		this.verifyEditSurveyQuestions();
		Thread.sleep(1000);
		this.clickSurveyBtnOn();
		Thread.sleep(1000);
		this.verifySurveyVisible();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> build_Survey_Template_Make_Visible() -----------");
	}
	
	public void back_To_Template_Main_Page() throws InterruptedException {
		this.verifyTemplateTitlesExist();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(1000);
		this.verifySurveyTemplateTitle();
		System.out.println("------- Completed --> back_To_Template_Main_Page() -----------");
	}
	
	public void back_To_Survey_Templates() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(1000);
		this.verifySurveyTemplateTitle();
		System.out.println("------- Completed --> back_To_Survey_Template_Copy() -----------");
	}
	
	public void edit_Survey_Template_Title() throws InterruptedException {
		this.click_Template_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.clickEditTemplate();
		Thread.sleep(1000);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle2();
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyWorkroomBreachCrumb();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Survey_Template_Title() -----------");
	}
	
	public void archive_Survey_Template() throws InterruptedException {
		this.click_Template_Title_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.clickArchive();
		Thread.sleep(1500);
		this.verifyArchiveCard();
		this.verifyArchivedSurveyTemplateTitle();
		System.out.println("------- Completed --> archive_Survey_Template() -----------");
	}
	
	// ------------------ Functions ----------------------
	public void delete_Archived_Template_Survey() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyArchiveBtn();
		this.clickArchiveBtn();
		Thread.sleep(1000);
		this.verifyArchiveCard();
		this.clickArchivedSurveyTemplateDropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Archived_Template_Survey() -----------");
	}

	public void delete_Edited_Template_Survey() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifyEditedSurveyTemplateDropdown();
		this.clickEditedSurveyTemplateDropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Template_Survey() -----------");
	}

	public void delete_Template_Survey() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifySurveyTemplateTitle();
		this.click_Template_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Template_Survey() -----------");
	}
	
	public void delete_Survey_Templates() throws InterruptedException {
		this.click_Template_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Survey_Templates() -----------");
	}
	
	public void delete_New_Survey_From_Template() throws InterruptedException {
		this.clickNewSurveyFromTemplateDropDown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_New_Survey_From_Template() -----------");
	}
	
	// ------------------ schedulers ----------------------
	By schedulers = By.xpath("//a[contains(text(),'Schedulers')]");
	By newSchedulers = By.xpath("//a[@class='btn btn-success'][contains(text(),'New Scheduler')]");
	By newOption = By.xpath("(//a[contains(.,' New Option')])[1]");
	By newOptionBox = By.xpath("//h4[contains(text(),'New Option')]");
	By breadCrumbScheduler = By.xpath("//a[contains(text(),'Workroom Schedulers')]");
	By schedulers_Title_Dropdown = By.xpath("(//a[contains(text(),'This is a Schedulers Title')]/following::div[@class='dropdown header-actions'])[1]");
	By edited_Schedulers_Title_Dropdown = By.xpath("(//a[contains(text(),'This is an Edited Schedulers Title')]/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_Title = By.xpath("//a[contains(text(),'This is a Schedulers Title')]");
	By respondAs = By.xpath("//select[@id='respond_as']");
	By user_AutomationTester = By.xpath("//option[contains(text(),'Automation Tester')]");
	By firstDateCheckBox = By.xpath("(//input[starts-with (@id,'survey_answers_')])[1]");
	By secondDateCheckBox = By.xpath("(//input[starts-with (@id,'survey_answers_')])[2]");
	By schedulerSucessMessage = By.xpath("//*[@id='wrap']/main//div/p[contains(text(),'Successfully')]");
	By schedulerQuestion = By.xpath("//p[contains(text(),'what happened to the good old days?')]");
	By pdf = By.partialLinkText("PDF");
	By excel = By.partialLinkText("Excel");
	
	String schedulersTitle = "This is a Schedulers Title";
	String editedSchedulersTitle = "This is an Edited Schedulers Title";
	String location = "NC";
	
	public void verifyNewSchedulers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSchedulers)));
	}
	
	public void verifySchedulerTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveyTitleInputField)));
	}
	
	public void verifyNewOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newOption)));
	}
	
	public void verifyNewOptionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newOptionBox)));
	}
	
	public void verifySchedulersTitleDropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title_Dropdown)));
	}
	
	public void verifyEditedSchedulersTitleDropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Schedulers_Title_Dropdown)));
	}
	
	public void verifySchedulersTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title)));
	}
	
	public void verifySchedulerSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulerSucessMessage)));
	}
	
	public void verifyBreadCrumbScheduler() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbScheduler)));
	}
	
	public void clickSchedulersSubNav() {
		driver.findElement(schedulers).click();
	}
	
	public void clickNewSchedulersBtn() {
		driver.findElement(newSchedulers).click();
	}
	
	public void clickTypeSchedulersTitleField() throws InterruptedException {
		driver.findElement(surveyTitleInputField).click();
		driver.findElement(surveyTitleInputField).sendKeys(schedulersTitle);
	}
	
	public void editSchedulersTitleField() throws InterruptedException {
		driver.findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(surveyTitleInputField).clear();
		driver.findElement(surveyTitleInputField).sendKeys(editedSchedulersTitle);
	}
	
	public void clickNewOption() {
		driver.findElement(newOption).click();
	}
	
	public void clickBreadCrumbScheduler() throws InterruptedException {
		driver.findElement(breadCrumbScheduler).click();
		Thread.sleep(1000);
	}
	
	public void click_Schedulers_Title_Dropdown() {
		driver.findElement(schedulers_Title_Dropdown).click();
	}
	
	public void click_Edited_Schedulers_Title_Dropdown() {
		driver.findElement(edited_Schedulers_Title_Dropdown).click();
	}
	
	public void typeInSchedulersTextBox() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		driver.switchTo().defaultContent();
	}
	
	public void formCalendarUpComingDate() throws InterruptedException {
		By startDate = By.xpath("//input[@id='survey_question_values_1_value_datetime']");
		By EndDate = By.xpath("//input[@id='survey_question_values_1_value_datetime_end']");
		By form_Location = By.xpath("//input[@id='survey_question_values_1_value_location']");
		//-----
		By startDate2 = By.xpath("//input[@id='survey_question_values_2_value_datetime']");
		By EndDate2 = By.xpath("//input[@id='survey_question_values_2_value_datetime_end']");
		By form_Location2 = By.xpath("//input[@id='survey_question_values_2_value_location']");
		//------
		By startDate3 = By.xpath("//input[@id='survey_question_values_3_value_datetime']");
		By EndDate3 = By.xpath("//input[@id='survey_question_values_3_value_datetime_end']");
		By form_Location3 = By.xpath("//input[@id='survey_question_values_3_value_location']");

		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 3); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(startDate).clear();
		driver.findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(EndDate).clear();
		driver.findElement(EndDate).sendKeys(strDateTwo);
		driver.findElement(form_Location).sendKeys(location);
		
		//--------
		driver.findElement(startDate2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(startDate2).clear();
		driver.findElement(startDate2).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(EndDate2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(EndDate2).clear();
		driver.findElement(EndDate2).sendKeys(strDateTwo);
		driver.findElement(form_Location2).sendKeys(location);
		
		//--------
		driver.findElement(startDate3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(startDate3).clear();
		driver.findElement(startDate3).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(EndDate3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(EndDate3).clear();
		driver.findElement(EndDate3).sendKeys(strDateTwo);
		driver.findElement(form_Location3).sendKeys(location);
	}
	
	public void clickRespondAs() {
		driver.findElement(respondAs).click();
	}
	
	public void clickOptionAutomationTester() {
		driver.findElement(user_AutomationTester).click();
	}
	
	public void clickFirstDateCheckBox() {
		driver.findElement(firstDateCheckBox).click();
	}
	
	public void clickSecondDateCheckBox() {
		driver.findElement(secondDateCheckBox).click();
	}
	
	public void clickSchedulersTitle() {
		driver.findElement(schedulers_Title).click();
	}
	
	public void click_PDF() {
		driver.findElement(pdf).click();
	}
	
	public void click_Excel() {
		driver.findElement(excel).click();
	}
	
	public void verify_Scheduler_Question_And_Chart() throws InterruptedException {
		String question1 = "//p[contains(text(),'This is a test that sending text through iframes w')]";
		String highChart = "//div[@id='highcharts-0']";
		Assert.assertTrue(driver.findElements(By.xpath(question1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(highChart)).size() > 0);
	}
	
	public void verify_Edited_Changes() throws InterruptedException {
		String title = "//h1[contains(text(),'This is an Edited Schedulers Title')]";
		String textBoxMessage = "//*[contains(text(),'This is an edited text box message')]";
		String attachment = "//*[@id=\"survey_files\"]/ul/li[contains(.,'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(textBoxMessage)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(attachment)).size() > 0);

	}
	
	public void editedDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(500);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is an edited text box message");
		driver.switchTo().defaultContent();
	}

	public void create_Scheduler() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickAutoBEWorkRoom();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		this.verifyNewSchedulers();
		this.clickNewSchedulersBtn();
		this.verifySurveyTitleInputField();
		this.clickTypeSchedulersTitleField();
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Scheduler() -----------");
	}
	
	public void create_Schedulers_Option() throws InterruptedException {
		// ---Text Field Question------
		this.verifyNewOption();
		this.clickNewOption();
		this.verifyNewOptionBox();
		this.typeInSchedulersTextBox();
		this.formCalendarUpComingDate();
		this.clickSaveBtnBox();
		Thread.sleep(1500);
		this.verifySurveySucessMessage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Schedulers_Option() -----------");
	}
	
	public void build_Schedulers_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1000);
		this.verifySubmitBtn();
		this.clickSurveyBtnOn();
		Thread.sleep(1000);
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifySchedulersTitleDropDown();
		System.out.println("------- Completed --> build_Scheduler_Make_Visible() -----------");
	}
	
	public void nonAdmin_Navigates_To_Schedulers() throws InterruptedException {
		this.verifyAutoBE();
		this.clickAutoBEWorkRoom();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		Thread.sleep(1000);
		this.verifySchedulersTitle();
		System.out.println("------- Completed --> user_navigates_To_Schedulers() -----------");
	}
	
	public void admin_Navigates_To_Schedulers() throws InterruptedException {
		this.verifyAutoBE();
		this.clickAutoBEWorkRoom();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		Thread.sleep(1000);
		this.verifySchedulersTitleDropDown();
		System.out.println("------- Completed --> user_navigates_To_Schedulers() -----------");
	}
	
	public void respond_To_Scheduler() throws InterruptedException {
		this.clickSchedulersTitle();
		Thread.sleep(1000);
		this.verify_Submit();
		this.clickSecondDateCheckBox();
		Thread.sleep(1000);
		driver.findElement(submitBtn).click();
		Thread.sleep(1000);
		this.verifySchedulerSucessMessage();
		System.out.println("------- Completed --> respond_To_Survey() -----------");
	}
	
	public void view_Schedulers_Reponses_Non_Admin() throws InterruptedException {
		this.verifySchedulersTitleDropDown();
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Scheduler_Question_And_Chart();
		this.clickBreadCrumbScheduler();
		System.out.println("------- Completed --> view_Scheduler_Reponses_Non_Admin() -----------");
	}
	
	public void view_Schedulers_Reponses_As_Admin() throws InterruptedException {
		this.verifySchedulersTitleDropDown();
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Scheduler_Question_And_Chart();
		System.out.println("------- Completed --> view_Schedulers_Reponses_As_Admin() -----------");
	}
	
	
	//----switch tab pdf -----
	By download_Report_Btn = By.xpath("//a[@id='download_report_button']");
	
	public void verify_Download_Report_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_Report_Btn)));
	}
	
	public void switch_Tab_Verify_Job_Progress_Download_Btn() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		this.verify_Download_Report_Btn();
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}

	public void download_Schedulers_As_PDF() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifySchedulersTitle();
		System.out.println("------- Completed --> download_As_PDF() -----------");
	}
	
	public void download_Schedulers_As_Excel() throws InterruptedException {
		this.click_Excel();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifySchedulersTitle();
		System.out.println("------- Completed --> download_As_Excel() -----------");
	}
	
	public void download_Survey_As_PDF() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbWorkroom(); // survey bread crumb
		Thread.sleep(1000);
		this.verify_Survey_Title_Dropdown();
		System.out.println("------- Completed --> download_Survey_As_PDF() -----------");
	}
	
	public void download_Survey_As_Excel() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbWorkroom();// survey bread crumb
		Thread.sleep(1000);
		this.verify_Survey_Title_Dropdown();
		System.out.println("------- Completed --> download_Survey_As_Excel() -----------");
	}
	
	public void edit_Schedulers() throws InterruptedException {
		this.verifySchedulersTitleDropDown();
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Edit();
		this.verifySurveyTitleInputField();
		this.editSchedulersTitleField();
		this.editedDescriptionTextBox();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyBreadCrumbScheduler();
		this.verify_Edited_Changes();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Schedulers() -----------");
	}
	
	public void delete_Schedulers() throws InterruptedException {
		this.verifySchedulersTitleDropDown();
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Survey() -----------");
	}
		
	public void delete_Edited_Schedulers() throws InterruptedException {
		this.verifyEditedSchedulersTitleDropDown();
		this.click_Edited_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Survey() -----------");
		
	}

}
