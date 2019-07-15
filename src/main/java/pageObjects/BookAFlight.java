package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Supplier;

public class BookAFlight  {

    public WebDriver driver;
    @FindBy (how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]")
    WebElement flight;
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Los Angeles (LAX)')")
    WebElement los;
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Miami (MIA)')")
    WebElement mia;
    @FindBy(how = How.XPATH,using = "//img[@src='../../../assets/select.png']")
    WebElement select;
    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/app-all-flights/div[1]/div/div/div[4]/div[3]/div[4]/div/div/div[1]/div[2]/div[2]/div[1]/span[5]")
    WebElement searchPageFare;


    WebDriverWait wait;

    public BookAFlight(WebDriver driver){
        this.driver=driver;}




    public void clickFlight()  {
        wait=new WebDriverWait(driver, 20);
        flight.click();
        wait.withMessage("waiting for element");


    }

    public String clickSelect(){
        String amt=verifySearchPageAmt();
        select.click();
        return amt;
    }

    public String verifySearchPageAmt(){
        return searchPageFare.getText();
    }

}
