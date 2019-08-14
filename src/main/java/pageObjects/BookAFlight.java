package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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


    WebDriverWait wait;

    public BookAFlight(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }





   public ModifySearch clickFlight()  {
        flight.click();

     return PageFactory.initElements(driver,ModifySearch.class);
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
