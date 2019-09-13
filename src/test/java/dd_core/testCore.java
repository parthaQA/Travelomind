package dd_core;

import com.aventstack.extentreports.ExtentReports;
import com.paulhammant.ngwebdriver.NgWebDriver;
import excelReader.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import listener.CustomListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class testCore {

    public static Properties config=new Properties();
    public static Properties object=new Properties();
    public static WebDriver driver=null;
   public static ExcelReader excel=null;
    public static WebDriverWait wait;
    public static Actions action;
    public static NgWebDriver ngdriver=new NgWebDriver((JavascriptExecutor)driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    public static FileInputStream fis;
    public static String screenshotName;
    public static ExtentReports extent;
    public static Logger logger = LogManager.getLogger();



    @BeforeSuite
    public static void init() throws IOException {




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
    public static void startDriver() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        driver.get(config.getProperty("testsite"));
        logger.info("start of execution");
    }

    public static void EndOfTest(){
        logger.info("End of execution");

    }



    @AfterSuite
    public  void quitDriver(){

        //driver.quit();

    }
}
