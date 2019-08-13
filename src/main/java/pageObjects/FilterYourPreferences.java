package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterYourPreferences {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(how = How.ID,using = "collapseAirport")
    WebElement airport;
    @FindBy(how = How.CLASS_NAME,using= "sameairport")
    WebElement sameAirport;
    @FindBy(how = How.XPATH,using= "//span[contains(text(),'Same Departing / Returning Airport')]")
    WebElement returnAirport;
    @FindBy(how = How.XPATH,using = "//div[@id='collapseAirport']//div[3]")
    WebElement departingFrom;
    @FindBy(how = How.CLASS_NAME,using = "airlineName")
    List<WebElement> airlineName;
    @FindBy(how = How.XPATH,using = "//div[@id='collapseAirport']//div[4]")
    WebElement arrivingAt;
    @FindBy(how = How.XPATH,using = "//div[@id='collapseAirline']")
    WebElement airlines;
    @FindBy(how = How.CLASS_NAME,using = "airline")
    List<WebElement> airlineList;
    String airline="airlineName";





    public FilterYourPreferences(WebDriver driver) {

        this.driver = driver;
        action=new Actions(this.driver);
        wait=new WebDriverWait(this.driver,20);
        js = (JavascriptExecutor)this.driver;
    }


    public void getDepartingFromAirlineDetails(){

        List <WebElement> departing=departingFrom.findElements(By.className(airline));
        System.out.println(departing.size());
        for (int i=0;i<departing.size();i++){
            System.out.println(departing.get(i).getText());
        }


    }

    public void getArrivingAtAilineDetails(){

        List<WebElement> arriving=arrivingAt.findElements(By.className(airline));

        System.out.println(arriving.size());
        for (int i=0;i<arriving.size();i++){
            System.out.println(arriving.get(i).getText());
        }


    }


    public void getAirlinesList(){

        List<WebElement> airlinenames=airlines.findElements(By.className(airline));
        System.out.println(airlinenames.size());
        for(int i=0;i<airlinenames.size();i++){
            System.out.println(airlinenames.get(i).getText());
        }
    }
}
