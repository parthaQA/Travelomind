package base;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTC {


    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    NgWebDriver ngdriver=new NgWebDriver((JavascriptExecutor)driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("");
    static String url="https://www.travelomind.com/";

    @BeforeMethod
    public void launchBrowser(){

        System.setProperty("webdriver.chrome.driver","D:\\Selenium Drivers\\chromedriver.exe");
        driver=new ChromeDriver(options);
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,20);
        action=new Actions(driver);
        driver.navigate().to(url);
    }


    @AfterMethod
    public  void takeScreenshot(ITestResult result) throws InterruptedException {
        String methodname=result.getMethod().getMethodName();
        File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(srcfile,new File("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\Screenshots\\"+ methodname+".png"));
        }

        catch (Exception e){
            e.printStackTrace();
        }

        //driver.close();
    }}


