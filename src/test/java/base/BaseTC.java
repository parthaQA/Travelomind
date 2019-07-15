package base;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BaseTC {


    public WebDriver driver;
    NgWebDriver ngdriver=new NgWebDriver((JavascriptExecutor)driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("");
    String url="https://www.travelomind.com/";

    @BeforeMethod
    public void launchBrowser(){

        System.setProperty("webdriver.chrome.driver","D:\\Selenium Drivers\\chromedriver.exe");
        driver=new ChromeDriver(options);
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
