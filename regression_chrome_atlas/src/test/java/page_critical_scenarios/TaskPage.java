package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import page_common_functions.AtlasNavBar;
import org.openqa.selenium.support.ui.Select;

public class TaskPage {
	private final PrintStream stdout = System.out;
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By taskSubMenu = By.xpath("//a[contains(text(),'Tasks')]");
	By addTaskGroup = By.xpath("//a[@class='btn btn-default no-mobile'][contains(text(),' Add Task Group')]");
	By taskTitle = By.xpath("//a[contains(text(),'This is a Task Title')]");
	By markComplete = By.xpath("//*[@id='tasksModal']//div/button[2][contains(.,'Mark Complete')]");
	By results = By.xpath("//*[@id='tasks']/tbody//tr//td/div/ul/li[5]/a[contains(text(),'Results')]");
	By percentCompleted = By.xpath("//h4[contains(text(),'Percent Completed')]");
	By completed100Percent = By.xpath("//span[contains(text(),'100% Complete')]");
	By taskGroupTitleInputField = By.xpath("//input[@id='task_group_title']");
	By dueDate = By.xpath("//input[@id='task_group_due']");
	By reminderDate = By.xpath("//input[@id='task_group_reminder']");
	By saveTaskButton = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");

	public TaskPage(WebDriver driver) {
		this.driver = driver;
	}

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

	public void verifyAddTaskGroup() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addTaskGroup)));
	}

	public void verifyTaskGroupTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(taskGroupTitleInputField)));
	}
	
	public void verifyTaskTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(taskTitle)));
	}
	
	public void verifyMarkComplete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(markComplete)));
	}
	
	public void verifyResults() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results)));
	}
	
	public void verifyPercentCompleted() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(percentCompleted),
				                         (ExpectedConditions.elementToBeClickable(completed100Percent))));
	}

	// ------------------ Elements ---------------------
	public void clickAutoBEWorkRoom() {
		driver.findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		driver.findElement(collaborateActiveOff).click();
	}

	public void clickTasks() {
		driver.findElement(taskSubMenu).click();
	}

	public void clickAddTaskGroup() {
		driver.findElement(addTaskGroup).click();
	}
	
	public void clickTaskTitle() {
		driver.findElement(taskTitle).click();
	}
	
	public void clickMarkComplete() {
		driver.findElement(markComplete).click();
	}
	
	public void clickResults() {
		driver.findElement(results).click();
	}

	public void newTaskGroupForm() throws InterruptedException {
		driver.findElement(taskGroupTitleInputField).click();
		driver.findElement(taskGroupTitleInputField).sendKeys("This is a Task Group Title");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// ----convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		c2.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// ----converting Date Object to String
		Date CurrentDate = c1.getTime();
		;
		String strDateOne = (dateFormat.format(CurrentDate));
		Date currentDatePlusTwo = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTwo));
		// --------Sendings Dates to Due Date and Reminder Date Fields--------
		driver.findElement(dueDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(dueDate).clear();
		driver.findElement(dueDate).sendKeys(strDateOne);
		driver.findElement(reminderDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(reminderDate).clear();
		driver.findElement(reminderDate).sendKeys(strDateTwo);
		driver.findElement(saveTaskButton).click();
	}

	public void verifyTaskGroupExist(WebDriver driver, ExtentTest test) throws InterruptedException {
		String taskGroupTitle = "//td[contains(text(),'This is a Task Group Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(taskGroupTitle)).size() != 0);
		Thread.sleep(2000);
	}

	// ------------------ Functions ----------------------
	public void add_Task_Group() throws InterruptedException {
		//this.verifyWelcomeHeader();
		//Thread.sleep(1500);
		//this.clickAutoBEWorkRoom();
		//Thread.sleep(1500);
		//this.verifyCollaborateActiveOff();
		//this.clickCollaborateActiveOff();
		//Thread.sleep(1500);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickTasks();
		Thread.sleep(1500);
		this.verifyAddTaskGroup();
		this.clickAddTaskGroup();
		Thread.sleep(1500);
		this.verifyTaskGroupTitleInputField();
		this.newTaskGroupForm();
		Thread.sleep(3000);
		this.verifyAddTaskGroup();
		this.verifyTaskGroupAndTaskExist();
		System.out.println("------- Completed -->  add_Task_Group() -----------");
	}
	
	public void navigate_To_Tasks() throws InterruptedException {
		//this.verifyWelcomeHeader();
		//this.clickAutoBEWorkRoom();
		//Thread.sleep(1000);
		//this.verifyCollaborateActiveOff();
		//this.clickCollaborateActiveOff();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickTasks();
		Thread.sleep(1000);
		this.verifyTaskTitle();
		System.out.println("------- Completed -->  navigate_To_Tasks() -----------");
	}
	
	public void respond_To_Task() throws InterruptedException {
		this.clickTaskTitle();
		Thread.sleep(1000);
		this.verifyMarkComplete();
		this.clickMarkComplete();
		System.out.println("------- Completed -->  respondToTask() -----------");
	}
	
	public void verify_Response_To_Task() throws InterruptedException {
		this.clickTaskDropdown();
		Thread.sleep(1000);
		this.verifyResults();
		this.clickResults();
		Thread.sleep(2000);
		this.verifyPercentCompleted();
		this.clickTasks();
		Thread.sleep(1000);
		System.out.println("------- Completed -->  verify_Response_To_Task() -----------");
	}
	
	// ---------------------------------------------------------------
	// -------------Create New Task ----------------------------------
	By addTaskBtn = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'Add Task')]");
	By taskTitleInputField = By.xpath("//input[@id='task_title']");
	By taskDueDate = By.xpath("//input[@id='task_due']");
	By taskReminderDate = By.xpath("//input[@id='task_reminder_date']");
	By fileTitle = By.xpath("//input[@id='file_title']");
	By dropdownBtn = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By selectGroup = By.xpath("//span[contains(text(),'This is a Task Group Title')]");
	By taskSucessMessage = By.xpath("//p[contains(text(),'Task created, you may now assign users to complete')]");
	By workroomAdmin = By.xpath("//span[@class='translation_missing']/following::div[@class='person-name'][contains(text(),'Workroom Admin')]");
	By auto_Director = By.xpath("//span[@class='translation_missing']/following::div[@class='person-name'][contains(text(),'Auto Director')]");
	By autoDirector = By.xpath("//span[contains(text(),'Auto Director')]");
	By taskSucessMessage2 = By.xpath("//p[contains(text(),'Successfully updated This is a Task Title')]");

	// input[@id='file_title']
	public void verifyTaskTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(taskTitleInputField)));
	}

	public void verifyGroup() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(selectGroup)));
	}

	public void verifyTaskSucessMessage() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(taskSucessMessage)));
		Thread.sleep(3000);
	}

	public void verifyWorkroomAdmin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin)));
	}
	
	public void verifyAutoDirector() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director)));
	}

	public void verifyTaskSucessMessage2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(taskSucessMessage2)));
	}

	public void newTaskForm() throws InterruptedException {
		driver.findElement(taskTitleInputField).click();
		driver.findElement(taskTitleInputField).sendKeys("This is a Task Title");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// ----convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		c2.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// ----converting Date Object to String
		Date CurrentDate = c1.getTime();
		;
		String strDateOne = (dateFormat.format(CurrentDate));
		Date currentDatePlusTwo = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTwo));
		// --------Sendings Dates to Due Date and Reminder Date Fields--------
		driver.findElement(taskDueDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(taskDueDate).clear();
		driver.findElement(taskDueDate).sendKeys(strDateOne);
		driver.findElement(taskReminderDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(taskReminderDate).clear();
		driver.findElement(taskReminderDate).sendKeys(strDateTwo);
		// -------- Writing Text into Iframe Description Box --------------
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
		// ----------Write File Attachment Title ---------------
		driver.findElement(fileTitle).click();
		driver.findElement(fileTitle).sendKeys("File Title for Attachment");
	}

	public void clickAddTaskBtn() throws InterruptedException {
		driver.findElement(addTaskBtn).click();
	}

	public void attachFileForUpload() throws InterruptedException {
		// --------------Attach File For Upload ---------------------------
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		Thread.sleep(2000);
	}

	public void linkTaskToGroup() throws InterruptedException {
		// --------------Link task to Group --------------------
		driver.findElement(dropdownBtn).click();
		this.verifyGroup();
		driver.findElement(selectGroup).click();
	}

	public void saveTaskBtn() throws InterruptedException {
		driver.findElement(saveTaskButton).click();
	}

	public void addTaskUsers() throws InterruptedException {
		WebElement respondants = driver.findElement(By.xpath("(//*[contains(text(),'Respondents')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", respondants);
		Thread.sleep(1500);
		// ------------- Div users------------------------
		By workroomAdmin = By.xpath("//div[contains(text(),'Workroom Admin')]");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin)));
		
		driver.findElement(workroomAdmin).click();
		
		Thread.sleep(1000);
		verifyWorkroomAdmin();// Call expected condition
		String saveBtn = "//aside//button[@name='button'][contains(text(),'Save')]";
		driver.findElement(By.xpath(saveBtn)).click();
	}
	
	public void addTaskUsers_B() throws InterruptedException {
		WebElement respondants = driver.findElement(By.xpath("(//*[contains(text(),'Respondents')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", respondants);
		Thread.sleep(1000);
		// ------------- Div users------------------------
		By workroomAdmin = By.xpath("//div[contains(text(),'Auto Director')]");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin)));
		
		driver.findElement(workroomAdmin).click();
		
		Thread.sleep(1000);
		verifyAutoDirector();// Call expected condition
		String saveBtn = "//aside//button[@name='button'][contains(text(),'Save')]";
		driver.findElement(By.xpath(saveBtn)).click();
	}

	public void verifyTaskGroupAndTaskExist() throws InterruptedException {
		String taskGroup = "//td[contains(text(),'This is a Task Group Title')]";
		// String task = "//a[contains(text(),'This is a Task Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(taskGroup)).size() != 0);
		// Assert.assertTrue(driver.findElements(By.xpath(task)).size() != 0);
	}

	public void verifyEditedTaskExist() throws InterruptedException {
		String task = "//a[contains(text(),'This is a Task Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(task)).size() != 0);
	}

	// ---------- Calling Functions -------------------------------
	public void create_Task_FillForm() throws InterruptedException {
		this.clickAddTaskBtn();
		Thread.sleep(1500);
		this.verifyTaskTitleInputField();
		Thread.sleep(1500);
		this.newTaskForm();
		System.out.println("------- Completed --> create_Task_FillForm() -----------");
	}

	// ---------- Calling Functions -------------------------------
	public void create_Task_AttachFile() throws InterruptedException {
		Thread.sleep(1500);
		this.attachFileForUpload();
		System.out.println("------- Completed --> create_Task_AttachFile() -----------");
	}

	// ---------- Calling Functions -------------------------------
	public void create_Task_LinkGroup() throws InterruptedException {
		this.linkTaskToGroup();
		Thread.sleep(1000);
		this.saveTaskBtn();
		Thread.sleep(1000);
		this.verifyTaskSucessMessage();
		System.out.println("------- Completed --> create_Task_LinkGroup() -----------");
	}

	// ---------- Calling Functions -------------------------------
	public void create_Task_Add_Users() throws InterruptedException {
		this.addTaskUsers();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Task_Add_Users() -----------");
	}
	
	public void create_Task_Add_Users_B() throws InterruptedException {
		this.addTaskUsers_B();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Task_Add_Users() -----------");
	}

	// ---------- Calling Functions -------------------------------
	public void verify_Task_Group_And_Task_Created() throws InterruptedException {
		this.verifyTaskSucessMessage2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Task_Group_And_Task_Created() -----------");
	}
	By taskDropdownBtn = By.xpath("(//div[@class='dropdown header-actions no-mobile'])[2]");
	By editOption = By.xpath("//div[@class='dropdown header-actions no-mobile open']//a[contains(text(),'Edit')]");
	By deleteOption = By.xpath("//div[@class='dropdown header-actions no-mobile open']//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By groupDropdownBtn = By.xpath("(//div[@class='dropdown header-actions no-mobile'])[1]");
	By deleteOption2 = By.xpath("//a[contains(text(),'Delete')]");

	public void verifyContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void clickTaskDropdown() throws InterruptedException {
		driver.findElement(taskDropdownBtn).click();
	}

	public void clickEditOption() throws InterruptedException {
		driver.findElement(editOption).click();
	}

	public void newTaskForm2() throws InterruptedException {
		driver.findElement(taskTitleInputField).click();
		driver.findElement(taskTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(taskTitleInputField).sendKeys("This is a Task Title Create a Real One");
		// -------- Writing Text into Iframe Description Box --------------
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
		// ----------Write File Attachment Title ---------------
		driver.findElement(fileTitle).click();
		driver.findElement(fileTitle).sendKeys("File Title for Attachment Create Your Own");
	}

	public void clickDeleteOption() throws InterruptedException {
		driver.findElement(deleteOption).click();
	}

	public void clickContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	public void clickGroupDropdown() throws InterruptedException {
		driver.findElement(groupDropdownBtn).click();
	}

	public void clickDeleteOption2() throws InterruptedException {
		driver.findElement(deleteOption2).click();
	}

	// ---------- Calling Functions -------------------------------
	public void edit_Task() throws InterruptedException {
		this.clickTaskDropdown();
		Thread.sleep(3000);
		this.clickEditOption();
		Thread.sleep(1500);
		this.verifyTaskTitleInputField();
		Thread.sleep(1500);
		this.newTaskForm2();
		Thread.sleep(1500);
		this.saveTaskBtn();
		Thread.sleep(1500);
		this.verifyAddTaskGroup();
		Thread.sleep(2000);
		this.verifyEditedTaskExist();
		Thread.sleep(1500);
		System.out.println("------- Completed --> edit_Task() -----------");
	}

	// ---------- Calling Functions -------------------------------
	public void delete_Task() throws InterruptedException {
		this.clickTaskDropdown();
		Thread.sleep(2000);
		this.clickDeleteOption();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		this.verifyAddTaskGroup();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Task() -----------");
	}

	public void verifyTaskGroupAndTaskNOTExist() throws InterruptedException {
		String taskGroup = "//td[contains(text(),'This is a Task Group Title')]";
		String task = "//a[contains(text(),'This is a Task Title Create a Real One')]";
		Assert.assertTrue(driver.findElements(By.xpath(taskGroup)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(task)).size() < 1);
	}

	// ---------- Calling Functions -------------------------------
	public void delete_Group() throws InterruptedException {
		this.clickGroupDropdown();
		Thread.sleep(1500);
		this.clickDeleteOption2();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		Thread.sleep(1000);
		this.clickContinueBtn();
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verifyTaskGroupAndTaskNOTExist();
		System.out.println("------- Completed --> delete_Group() -----------");
	}
}
