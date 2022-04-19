package com.kuda.base;

import com.github.f4b6a3.uuid.codec.base.Base16Codec;
import com.github.javafaker.Faker;
import com.kuda.utility.Utility;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
	public static WebDriver driver;
	static Faker faker = new Faker();
	public String projectPath = System.getProperty("user.dir");



	@BeforeClass
	public void setUp() throws IOException {
		if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
			//set property and create instance of chrome browser
			//  System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
			//   driver = new ChromeDriver();

			//			using webdriver manager
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("=====Chrome Browser Session Started=====", true);

			//          Running with headless chrome
			//			ChromeOptions chromeOptions = new ChromeOptions();
			//			chromeOptions.addArguments("--headless");
			//			driver = new ChromeDriver(chromeOptions);

		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
			//set property and create instance of  firefox
			//            System.setProperty("webdriver.gecko.driver", projectPath + "\\Drivers\\geckodriver.exe");
			//            driver = new FirefoxDriver();
			//
			//Headless mode
			//            FirefoxOptions firefoxOptions = new FirefoxOptions();
			//            firefoxOptions.setHeadless(true);
			//            driver = new FirefoxDriver(firefoxOptions);

			//	WebDriverManager.firefoxdriver().setup();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			Reporter.log("=====Firefox  Browser Session Started=====", true);
		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
			//set property and create instance of chrome firefox
			//	System.setProperty("webdriver.edge.driver", projectPath+"\\Drivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Reporter.log("=====Edge Browser Session Started=====", true);
			//	System.out.println(browserName + " browser running");
		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
			//set property and create instance of chrome ie
			//	System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Reporter.log("=====Internet Explorer Browser Session Started=====", true);
		} else {
			//	System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
			//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(Utility.fetchProperty("applicationUrl").toString());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("=====Application Started=====", true);
		//	driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
	}


	public static String postingsInstrumentNumber() {
		com.github.f4b6a3.uuid.codec.UuidCodec<String> codec = new Base16Codec();
		String string = codec.encode(UUID.randomUUID());
		return string;
	}

	public static String randomEmail() {

		return faker.internet().emailAddress();
	}

	public static String randomFirstName() {

		return faker.name().firstName();
	}

	public static String randomLastName() {

		return faker.name().lastName();
	}


	//	  String phone = faker.phoneNumber().cellPhone();
	//	  faker.internet().
	//

	public static String randomStreetAddress() {

		return faker.address().streetAddress();
	}

	public static int randomNumber8Digit() {

		return faker.number().numberBetween(10000000, 90000000);
	}

	public static int randum11DigitNumber()
	{
		return faker.number().numberBetween(1000000000, 900000000);
	}

	public static void text(String text) {
		List<String> list = new ArrayList<String>();
		list.add(text);
		list.add(text);
		Random randomizer = new Random();
		String random = list.get(randomizer.nextInt(list.size()));
	}

	public static String numberRange() {
		List<String> list = new ArrayList<String>();
		list.add("070");
		list.add("080");
		list.add("081");
		list.add("090");
		list.add("091");
		Random randomizer = new Random();
		String random = list.get(randomizer.nextInt(list.size()));
		System.out.println(random);
		return random;
	}


	public static String sectorialClassList() {
		List<String> list = new ArrayList<String>();
		list.add("General");
		list.add("Manufacturing");
		list.add("Governments");
		list.add("Construction");
		list.add("Information And Communication");
		list.add("Education");
		list.add("Oil And Gas");
		Random randomizer = new Random();
		String random = list.get(randomizer.nextInt(list.size()));
		System.out.println(random);
		return random;
	}


	//To choose Webelement
	public static WebElement chooseElement(String Locator) throws IOException {
		WebElement weblement = null;
		if (Locator.endsWith("_XPATH"))
			weblement = driver.findElement(By.xpath(Utility.fetchLocator(Locator)));
		else if (Locator.endsWith("_ID")) {
			weblement = driver.findElement(By.id(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_CSS")) {
			weblement = driver.findElement(By.cssSelector(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_NAME")) {
			weblement = driver.findElement(By.name(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_LINKTEXT")) {
			weblement = driver.findElement(By.linkText(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_CLASSNAME")) {
			weblement = driver.findElement(By.className(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_TAGNAME")) {
			weblement = driver.findElement(By.tagName(Utility.fetchLocator(Locator)));
		}
		return weblement;
	}

	//To get Text of An Elemnt
	public static String getText(String locator) throws InterruptedException, IOException {
		String returnText = chooseElement(locator).getText();
		return returnText;
	}

	//Perform Mouse Hovering
	public static void MouseOver(String Locator) throws IOException {
		Actions act = new Actions(driver);
		act.moveToElement(chooseElement(Locator)).build().perform();
	}

	public static String fn_GetTimeStamp() {
		DateFormat DF = DateFormat.getDateTimeInstance();
		Date dte = new Date();
		String DateValue = DF.format(dte);
		DateValue = DateValue.replaceAll(":", "_");
		DateValue = DateValue.replaceAll(",", "");
		return DateValue;
	}

	public static void doubleClick(String Locator) throws IOException {
		Actions clickFrequencyBtn = new Actions(driver);
		//  WebElement frequencyRadioBt = driver.findElement(By.id(Utility.fetchLocator("frequency_ID")));
		clickFrequencyBtn.doubleClick(chooseElement(Locator)).perform();
	}

	public static void selectDropdowntByVisibleText(String visibleText, String Locator) throws IOException {
		Select select = new Select(chooseElement(Locator));
		select.selectByVisibleText(visibleText);
	}

	public static void selectDropdownByIndex(int index, String Locator) throws IOException {
		Select select2 = new Select(chooseElement(Locator));
		select2.selectByIndex(index);
	}

	public static void sleep(int seconds) throws Exception {
		TimeUnit.SECONDS.sleep(seconds);


	}

	//Perform Action
	//    public static Actions getAction() {
	//        Actions action = new Actions(driver);
	//        return action;
	//	public static String TakeSnapshot(String DestFilePath) throws IOException {
	//		String TS = fn_GetTimeStamp();
	//		TakesScreenshot tss = (TakesScreenshot) driver;
	//		File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
	//		DestFilePath = DestFilePath + TS + ".png";
	//		File DestFileObj = new File(DestFilePath);
	//		FileUtils.copyFile(srcfileObj, DestFileObj);
	//		return DestFilePath;
	//	}

	//To carry out click action for all locators
	public void click(String Locator) throws IOException {
		chooseElement(Locator).click();
		//        if (Locator.endsWith("_XPATH"))
		//            driver.findElement(By.xpath(Utility.fetchLocator(Locator))).click();
		//        else if (Locator.endsWith("_ID")) {
		//            driver.findElement(By.id(Utility.fetchLocator(Locator))).click();
		//        } else if (Locator.endsWith("_CSS")) {
		//            driver.findElement(By.cssSelector(Utility.fetchLocator(Locator))).click();
		//        } else if (Locator.endsWith("_NAME")) {
		//            driver.findElement(By.name(Utility.fetchLocator(Locator))).click();
		//        } else if (Locator.endsWith("_LINKTEXT")) {
		//            driver.findElement(By.linkText(Utility.fetchLocator(Locator))).click();
		//        } else if (Locator.endsWith("_CLASSNAME")) {
		//            driver.findElement(By.className(Utility.fetchLocator(Locator))).click();
		//        } else if (Locator.endsWith("_TAGNAME")) {
		//            driver.findElement(By.tagName(Utility.fetchLocator(Locator))).click();
		//        }
	}

	//To carry out sendkeys function
	public void type(String Locator, String Value) throws IOException {
		chooseElement(Locator).sendKeys(Utility.fetchLocator(Value));
		//        if (Locator.endsWith("_XPATH"))
		//            driver.findElement(By.xpath(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        else if (Locator.endsWith("_ID")) {
		//            driver.findElement(By.id(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        } else if (Locator.endsWith("_CSS")) {
		//            driver.findElement(By.cssSelector(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        } else if (Locator.endsWith("_NAME")) {
		//            driver.findElement(By.name(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        } else if (Locator.endsWith("_LINKTEXT")) {
		//            driver.findElement(By.linkText(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        } else if (Locator.endsWith("_CLASSNAME")) {
		//            driver.findElement(By.className(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        } else if (Locator.endsWith("_TAGNAME")) {
		//            driver.findElement(By.tagName(Utility.fetchLocator(Locator))).sendKeys(Utility.fetchLocator(Value));
		//        }

	}

	@AfterClass
	public void terminateSession() {

		//	public void tearDown(ITestResult result)
		//	{

		// Here will compare if test is failing then only it will enter into if condition
		//sceeshot from here
		//	if(ITestResult.FAILURE==result.getStatus())
		//	{
		//	try
		//	{
		//	// Create refernce of TakesScreenshot
		//	TakesScreenshot ts=(TakesScreenshot)driver;
		//
		//	// Call method to capture screenshot
		//	File source=ts.getScreenshotAs(OutputType.FILE);
		//
		//	// Copy files to specific location here it will save all screenshot in our project home directory and
		//	// result.getName() will return name of test case so that screenshot name will be same
		//	FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
		//
		//	System.out.println("Screenshot taken");
		//	}
		//	catch (Exception e)
		//	{
		//
		//	System.out.println("Exception while taking screenshot "+e.getMessage());
		//	}
		//
		//
		//
		//	}
		//To here

		// close application

		driver.close();

	}
}