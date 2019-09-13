package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;

import java.lang.reflect.Method;
import java.util.List;

public class ModifySearch {


    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    JavascriptExecutor js;


     @FindBy(how = How.XPATH,using = Configuration.imagewait)
     WebElement imagewait;
    @FindBy(how = How.XPATH, using =Configuration.radio)
    WebElement radio;
    @FindBy(how = How.TAG_NAME, using = Configuration.rButtons)
    List<WebElement> rButtons;
    @FindBy(how = How.XPATH, using = Configuration.oneWayButton)
    WebElement oneWayButton;
    @FindBy(how = How.XPATH, using = Configuration.roundTripButton)
    WebElement roundTripButton;
    @FindBy(how = How.XPATH, using = Configuration.origin)
    WebElement origin;
    @FindBy(how = How.XPATH,using = Configuration.originTmenu)
    WebElement originTmenu;
    //@FindBy(how = How.XPATH, using = "//div[contains(@class,'filterSidePanel')]//div[contains(@class,'row')]//div[2]//div[1]//span[3]")
   // WebElement originAirpot;
    @FindBy(how = How.XPATH, using = Configuration.destination)
    WebElement destination;
    @FindBy(how = How.XPATH, using = Configuration.destionationTmenu)
    WebElement destionationTmenu;
    @FindBy(how = How.XPATH, using = Configuration.depart)
    WebElement depart;
    @FindBy(how = How.XPATH, using = Configuration.retrn)
    WebElement retrn;
    @FindBy(how = How.XPATH, using = Configuration.modifyMonth)
    WebElement month;
    @FindBy(how = How.XPATH, using = Configuration.modifyYear)
    WebElement year;
    @FindBy(how = How.XPATH,using = Configuration.date)
    WebElement date;
    @FindBy(how = How.XPATH, using = Configuration.returnjourneydate)
    WebElement returnjourneydate;
    @FindBy(how = How.XPATH,using = Configuration.allResult)
    WebElement allresults;
    //@FindBy(how = How.CSS,using = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(1)")
    //WebElement retrnMonth;
    //@FindBy(how = How.CSS,using = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(2)")
    //WebElement retrnYear;
    @FindBy(how = How.XPATH,using = Configuration.retrnDate)
    WebElement retrnDate;

    @FindBy(how = How.XPATH,using = Configuration.searchOnline)
    WebElement searchOnline;
    List<WebElement> radioBtnCounts;
    List<WebElement> radioBtntext;
    WebElement destionationAirport;
    WebElement originAirport;
    Select select;
    String tagname="input";
    String tag="span";



    //Defining the constructor for the ModifySearch class

    public ModifySearch(WebDriver driver) {

        this.driver = driver;
        action = new Actions(this.driver);
        wait = new WebDriverWait(this.driver, 30);
        js = (JavascriptExecutor) this.driver;


    }


   //Method for counting the radio buttons in modify search section

    public int countRadioButtons() {
        try {


            if (radio.isEnabled()){

                radioBtnCounts=radio.findElements(By.tagName(tagname));
                System.out.println(radioBtnCounts.size());

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return radioBtnCounts.size();
    }

    //Method for displaying the radio buttons text in modify search section

    public String getRadioButtonText() {

        String radioButtonText=radio.getText();
        System.out.println(radioButtonText );

        return radioButtonText;
    }


    //Method for checking the radio buttons status in modify search section

    public boolean VerifyButtonStatus() throws InterruptedException {

        Thread.sleep(10000);
        if(roundTripButton.isSelected()) {
            System.out.println("round trip Button is already selected");
            wait.until(ExpectedConditions.elementToBeClickable(oneWayButton));
            oneWayButton.click();
            System.out.println("Switched to One Way button");
        }
        else if(oneWayButton.isSelected()){
            System.out.println("One way button is already selected");
            roundTripButton.click();
            System.out.println("Switched to Round Trip button");

        }
      return true;
    }



    //Method for checking  the radio button status for One way Flight in modify search section

    public void ButtonStatusToOneWay() throws InterruptedException {

        Thread.sleep(10000);
        //action=new Actions(this.driver);
        if (oneWayButton.isSelected()) {
            System.out.println("One way Button is already selected");
        } else {
            wait.until(ExpectedConditions.elementSelectionStateToBe(oneWayButton,false));
            oneWayButton.click();
            System.out.println("one way button is clicked");
        }


    }


    //Method for checking  the radio button status for Round Trip in modify search section

    public boolean ButtonStatusToRoundTrip(){

        wait.until(ExpectedConditions.elementSelectionStateToBe(roundTripButton,false));
        roundTripButton.click();
        System.out.println("Round Trip button is clicked");
        do {
            return true;
        }
        while (roundTripButton.isSelected());


    }



    //Method for selecting and displaying the origin destination in modify search section

    public String selectOriginPlace(String Origin) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(allresults));
        origin.clear();
        origin.sendKeys(Origin);
        originAirport= originTmenu.findElement(By.xpath("//span[contains(text(),'NYC')]"));
        wait.until(ExpectedConditions.visibilityOf(originAirport));
        action.moveToElement(originAirport).click();
        System.out.println("Origin Airport is selected");
        return originAirport.getText();

    }


    //Method for selecting and displaying the return destination in modify search section

    public String selectReturnPlace(String dest) throws InterruptedException {

        destination.clear();
        destination.sendKeys(dest);
        Thread.sleep(5000);
        destionationAirport= destionationTmenu.findElement(By.xpath("//span[contains(text(),'NYC')]"));
        wait.until(ExpectedConditions.visibilityOf(destionationAirport));
        action.moveToElement(destionationAirport).click();
        System.out.println("Kolkata Airport is selected");
        return destionationAirport.getText();
    }


    //Method for checking alert and accepting alert on page while same place is chosen for origin and return field in modify search section

    public void sameOriginAndDestination(){

        //if(originAirport.getText()==destionationAirport.getText()) {

            Alert alert= driver.switchTo().alert();
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.accept();



        //}


    }


    //Method for selecting and clicking on departure date in modify search section

    public void SelectDepartureDate(String Dmonth,String Dyear) throws InterruptedException {
        Thread.sleep(2000);
        depart.click();
        action.moveToElement(month).click();
        select =new Select(month);
        select.selectByValue(Dmonth);
        action.moveToElement(year).click();
        select=new Select(year);
        select.selectByValue(Dyear);
        date.click();
        //retrnDate.click();


    }


    //Method for selecting and clicking on return date in modify search section

    public void SelectReturnDate(String Amonth,String Ayear) throws InterruptedException{

        WebElement retrnmonth=returnjourneydate.findElement(By.xpath(Configuration.returnMonth));
        action.moveToElement(retrnmonth).click();
        select=new Select(retrnmonth);
        select.selectByValue(Amonth);
        WebElement retrnyear=returnjourneydate.findElement(By.xpath(Configuration.returnYear));
        action.moveToElement(retrnyear).click();
        select=new Select(retrnyear);
        select.selectByValue(Ayear);
        retrnDate.click();
    }


    //Method for clicking on Search Online button in modify search section

    public void ClickSearchOnline() throws InterruptedException {

        searchOnline.click();
        //sameOriginAndDestination();


    }


}
