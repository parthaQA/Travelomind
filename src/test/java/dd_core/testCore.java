package dd_core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.paulhammant.ngwebdriver.NgWebDriver;
import excelReader.ExcelReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ExtentManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class testCore {

    public static Properties config=new Properties();
    public static Properties object=new Properties();
    public static WebDriver driver=null;
   public static ExcelReader excel=null;
    public static WebDriverWait wait;
    public static Actions action;
    NgWebDriver ngdriver=new NgWebDriver((JavascriptExecutor)driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    FileInputStream fis;
    public static String screenshotName;
    public static ExtentReports extent;
    public static Logger log;
    public static ExtentTest tes;


    @BeforeSuite
    public void init() throws IOException {




        if (driver == null) {

            fis = new FileInputStream("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\src\\main\\java\\dd_properties\\config.properties");
            config.load(fis);

            fis = new FileInputStream( "C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\src\\main\\java\\dd_properties\\object.properties");
            object.load(fis);



            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

                driver = new FirefoxDriver();
            }
        }

        excel = new ExcelReader("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\TestData\\bill.xlsx");
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }


    @BeforeMethod
    public static void startDriver() throws IOException {

        driver.get(config.getProperty("testsite"));
    }




    @AfterSuite
    public  void quitDriver(){

        Reporter.log("*******End of Test Suite***********");
        //driver.quit();

    }
}
