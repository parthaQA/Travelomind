package dd_core;

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
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

    @BeforeSuite
    public void init() throws IOException {

        if (driver == null) {

            fis = new FileInputStream(System.getProperty("user.dir") + "C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\src\\main\\java\\dd_properties\\config.properties");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir") + "C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\src\\main\\java\\dd_properties\\object.properties");
            object.load(fis);



            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

                driver = new FirefoxDriver();
            }
        }

        excel = new ExcelReader(System.getProperty("user.dir") + "C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\TestData\\bill.xlsx");
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);


    }


    @BeforeMethod
    public static void startDriver(){

        Reporter.log("*******Beginning of Test***********");
        driver.get(config.getProperty("testsite"));

    }


    @AfterMethod
    public static void captureScreenshot(ITestResult result){

        String methodname=result.getMethod().getMethodName();
        File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(srcfile,new File("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\Screenshots\\"+ methodname+".png"));
        }

        catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }


    @AfterSuite
    public static void quitDriver(){

        Reporter.log("*******End of Test***********");

    }
}
