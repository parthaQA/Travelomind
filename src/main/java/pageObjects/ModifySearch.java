package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ModifySearch {


    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    JavascriptExecutor js;

     @FindBy(how = How.XPATH,using = "//div[contains(@class,'noMargin headerBar relative')]//img[contains(@class,'callImage')]")
     WebElement imagewait;
    @FindBy(how = How.XPATH, using = "//div[@id='round_trip']")
    WebElement radio;
    @FindBy(how = How.TAG_NAME, using = "input")
    List<WebElement> rButtons;
    @FindBy(how = How.XPATH, using = "//div[@id='round_trip']//input[1]")
    WebElement oneWayButton;
    @FindBy(how = How.XPATH, using = "//body//input[2]")
    WebElement roundTripButton;
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Origin')]")
    WebElement origin;
    @FindBy(how = How.XPATH,using = "//div[@id='traveller_menu']")
    WebElement originTmenu;
    //@FindBy(how = How.XPATH, using = "//div[contains(@class,'filterSidePanel')]//div[contains(@class,'row')]//div[2]//div[1]//span[3]")
   // WebElement originAirpot;
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Destination')]")
    WebElement destination;
    @FindBy(how = How.XPATH, using = "//div[@id='traveller_menu2']")
    WebElement destionationTmenu;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Depart']")
    WebElement depart;
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Return')]")
    WebElement retrn;
    @FindBy(how = How.XPATH, using = "//select[@title='Select month']")
    WebElement month;
    @FindBy(how = How.XPATH, using = "//select[@title='Select year']")
    WebElement year;
    @FindBy(how = How.XPATH,using = "//div[@class='btn-light ng-star-inserted'][contains(text(),'28')]")
    WebElement date;
    @FindBy(how = How.XPATH, using = "//ngb-datepicker-navigation-select[contains(@class,'ngb-dp-navigation-select')]")
    WebElement returnjourneydate;
    //@FindBy(how = How.CSS,using = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(1)")
    //WebElement retrnMonth;
    //@FindBy(how = How.CSS,using = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(2)")
    //WebElement retrnYear;
    @FindBy(how = How.XPATH,using = "//div[@class='btn-light ng-star-inserted'][contains(text(),'30')]")
    WebElement retrnDate;

    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Search Online')]")
    WebElement searchOnline;
    List<WebElement> radioBtnCounts;
    List<WebElement> radioBtntext;
    Select select;


    public ModifySearch(WebDriver driver) {

        this.driver = driver;
        action=new Actions(this.driver);
        wait=new WebDriverWait(this.driver,20);
        js = (JavascriptExecutor)this.driver;
    }


    public void countRadioButtons() {
        try {


            if (radio.isEnabled()){

                radioBtnCounts=radio.findElements(By.tagName("input"));
                System.out.println(radioBtnCounts.size());

            }
            else
                System.out.println("Button is disbled");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void getRadioButtonText(){


        try
        {
        if (radio.isEnabled()){
            radioBtntext=radio.findElements(By.tagName("span"));

            for(int i=0;i<radioBtntext.size();i++)

                System.out.println(radioBtntext.get(i).getText());

        }
        else
            System.out.println("Button is disbled");

    } catch (Exception e) {
        e.printStackTrace();

    }

    }


    public void VerifyButtonStatus(){

        if(roundTripButton.isSelected())
            System.out.println("round trip Button is selected");

        else {
            oneWayButton.click();
            System.out.println("One way button is selected");

        }
    }

    public void ButtonStatusToOneWay(){
        if(oneWayButton.isSelected()) {
            System.out.println("One way button is selected");

        }
        else{
            action=new Actions(this.driver);
            action.moveToElement(oneWayButton).perform();
            System.out.println("one way button is clicked");
    }}

    public void ButtonStatusToRoundTrip(){

        roundTripButton.click();

    }

    public String selectOriginPlace() throws InterruptedException {

        Thread.sleep(10000);
        origin.clear();
        origin.sendKeys("new york");
        WebElement originAirport= originTmenu.findElement(By.xpath("//span[contains(text(),'JFK')]"));
        action.moveToElement(originAirport).click();
        System.out.println("Origin Airport is selected");
        return originAirport.getText();

    }

    public String selectReturnPlace() throws InterruptedException {

        destination.clear();
        destination.sendKeys("kolkata");
        WebElement destionationAirport= destionationTmenu.findElement(By.xpath("//span[contains(text(),'CCU')]"));
        action.moveToElement(destionationAirport).click();
        System.out.println("Kolkata Airport is selected");
        return destionationAirport.getText();
    }

    public void SelectDepartureDate() throws InterruptedException {
        depart.click();
        action.moveToElement(month).click();
        select =new Select(month);
        select.selectByValue("10");
        action.moveToElement(year).click();
        select=new Select(year);
        select.selectByValue("2019");
        date.click();
        //retrnDate.click();


    }


    public void SelectReturnDate() throws InterruptedException{

        WebElement retrnmonth=returnjourneydate.findElement(By.xpath("//select[@title='Select month']"));
        action.moveToElement(retrnmonth).click();
        select=new Select(retrnmonth);
        select.selectByValue("12");
        WebElement retrnyear=returnjourneydate.findElement(By.xpath("//select[@title='Select year']"));
        action.moveToElement(retrnyear).click();
        select=new Select(retrnyear);
        select.selectByValue("2019");
        retrnDate.click();
    }

    public void ClickSearchOnline(){

        searchOnline.click();

    }


}
