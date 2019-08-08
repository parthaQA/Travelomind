package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Supplier;

public class BookAFlight {

    public WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]")
    WebElement flight;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Los Angeles (LAX)')")
    WebElement los;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Miami (MIA)')")
    WebElement mia;
    @FindBy(how = How.XPATH, using = "//img[@src='../../../assets/select.png']")
    WebElement select;
    @FindBy(how = How.CSS, using = "body > app-root > div > app-all-flights > div.boundaryCheck > div > div > div.row.noMargin.contentBar > div.noPadding.contentPanel > div.tabPanel > div > div > div:nth-child(2) > div.flightDtl.relative.cursor.cheapest > div.row.priceHeader > div.col-md-6 > span.finalPrice")
    WebElement searchPageFare;


    WebDriverWait wait;

    public BookAFlight(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }







   public void clickFlight()  {
        flight.click();


    }

   public String clickSelect(){
        WebElement s;
        s=wait.until(ExpectedConditions.visibilityOf(select));
        s.click();
        String amt=verifySearchPageAmt();
        return amt;
    }

    public String verifySearchPageAmt(){
        return searchPageFare.getText();
    }

}
