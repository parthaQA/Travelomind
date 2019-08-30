package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class BookAFlight {

    public WebDriver driver;
    //@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]")
    //WebElement flight;
    @FindBy(how = How.XPATH, using = Configuration.flight)
    WebElement flight;
    @FindBy(how = How.XPATH, using =Configuration.los)
    WebElement los;
    @FindBy(how = How.XPATH, using = Configuration.mia)
    WebElement mia;
    @FindBy(how = How.XPATH, using = Configuration.select)
    WebElement select;
    @FindBy(how = How.CSS, using = Configuration.searchPageFare)
    WebElement searchPageFare;
    @FindBy(how = How.CLASS_NAME,using = Configuration.toast_noti)
    WebElement notification;
    @FindBy(how = How.XPATH,using = Configuration.domestic)
    WebElement domestic;
    @FindBy(how = How.CLASS_NAME,using = Configuration.selectdestinations)
    List<WebElement> selectDestinations;


    WebElement destinations;
    Actions actions;
    JavascriptExecutor js;



    WebDriverWait wait;

    public BookAFlight(WebDriver driver) throws IOException {
        this.driver = driver;
        wait=new WebDriverWait(this.driver,20);
        actions=new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;

    }





   public ModifySearch clickFlight()  {
        flight.click();

     return PageFactory.initElements(driver,ModifySearch.class);
    }


    public void popularDomesticDestinationList(){


       destinations=driver.findElement(By.xpath(Configuration.domesticBlock));

        int rownum=0;
        for(int i=1;i<10;i++){
           String count= destinations.findElements(By.tagName(Configuration.domesticDestinations)).get(i).getText();
            System.out.println(count);
            rownum++;
        }

        System.out.println(rownum);


    }

    public void clickOnAllPopularDomesticDestinations() throws InterruptedException {


        //destinations = driver.findElement(By.className(Configuration.domesticBlock));

        List<WebElement> selectDomesticSection=domestic.findElements(By.xpath(Configuration.domesticDestinations));

        wait.until(ExpectedConditions.visibilityOfAllElements(selectDomesticSection));

        for (int i = 0; i <selectDomesticSection.size()-1; i++) {
            Thread.sleep(5000);
            System.out.println(selectDestinations.get(i).getText()+" is clicked");
            js.executeScript(Configuration.firstpart+i+Configuration.lastpart);
            this.driver.navigate().back();
            this.driver.navigate().refresh();
        }




    }





   public Itinerary clickSelect(){
        WebElement s;
        s=wait.until(ExpectedConditions.visibilityOf(select));
        s.click();

        return PageFactory.initElements(driver,Itinerary.class);
    }

    public String verifySearchPageAmt(){
        return searchPageFare.getText();
    }

}
