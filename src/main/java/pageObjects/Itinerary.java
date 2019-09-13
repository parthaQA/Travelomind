package pageObjects;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;

import java.util.List;


public class Itinerary  {

    Select select;
    WebDriver driver;
    Logger logger;

    @FindBy(how = How.ID,using = Configuration.firstName)
    WebElement firstName;
    @FindBy(how = How.XPATH,using = Configuration.mandatoryFName)
    WebElement manFirstName;
    @FindBy(how = How.CLASS_NAME,using = Configuration.middleName)
    List<WebElement> middleName;
    @FindBy(how = How.ID,using = Configuration.lastName)
    WebElement lastName;
    @FindBy(how = How.CSS,using = Configuration.gender)
    WebElement gender;
    @FindBy(how = How.ID,using = Configuration.countryCode)
    WebElement countryCode;
    @FindBy(how = How.NAME,using = Configuration.phoneNumber)
    WebElement phoneNumber;
    @FindBy(how = How.ID,using = Configuration.email)
    WebElement email;
    @FindBy(how = How.ID,using = Configuration.cardNumber)
    WebElement cardNumber;
    @FindBy(how = How.ID,using = Configuration.cardHolderName)
    WebElement cardHolderName;
    @FindBy(how = How.ID,using = Configuration.month)
    WebElement month;
    @FindBy(how = How.ID,using = Configuration.year)
    WebElement year;
    @FindBy(how = How.ID,using = Configuration.cvv)
    WebElement cvv;
    @FindBy(how = How.CSS,using = Configuration.billCountry)
     WebElement billCountry;
    @FindBy(how = How.ID,using = Configuration.billAddress)
    WebElement billAddress;
    @FindBy(how = How.ID,using = Configuration.billCity)
    WebElement billCity;
    @FindBy(how = How.CSS,using = Configuration.billState)
    WebElement billState;
    @FindBy(how = How.ID,using = Configuration.zipCode)
    WebElement zipCode;
    @FindBy(how = How.ID,using = Configuration.billPhNumber)
    WebElement billPhNumber;
    @FindBy(how = How.ID,using = Configuration.dateOfBirth)
    WebElement dateOfBirth;
    @FindBy(how = How.XPATH,using = Configuration.selectYear)     //*[contains(text(),'here')]
    WebElement selectYear;
    @FindBy(how = How.XPATH,using = Configuration.selectMonth)
    WebElement selectMonth;
    @FindBy(how = How.CSS,using = Configuration.selectDay)
    WebElement selectDay;
    @FindBy(how = How.CSS,using = Configuration.verifyAmt)
    WebElement verifyAmt;
    @FindBy(how = How.XPATH,using = Configuration.book)
    WebElement book;
    @FindBy(how = How.CSS,using = Configuration.error)
    WebElement error;



    //Defining the constructor for the Itinerary  class

    public Itinerary(WebDriver driver)
    {
        this.driver=driver;
    }

    public Itinerary(Logger logger){
        this.logger=logger;
    }


  //Method for providing first name and last name of passenger traveling in itinerary page
    public void passengerDetail(String firstname, String lastname) {
        if (manFirstName.isDisplayed()) {
            firstName.sendKeys(firstname);
        }
        if (manFirstName.isDisplayed()){
            lastName.sendKeys(lastname);

        }
        if (manFirstName.isDisplayed()) {
            middleName.get(1).sendKeys("middle");
        }
    }


    //Method for selecting Date of Birth of passenger traveling in itinerary page

    public void selectDOB(String dyear,String dmonth) {

        if(manFirstName.isDisplayed()){

            dateOfBirth.click();
            select = new Select(selectYear);
            select.selectByValue(dyear);
            select = new Select(selectMonth);
            select.selectByValue(dmonth);
            selectDay.click();
        }
    }


  // Method for selecting Gender of passenger traveling in itinerary page
    public void selectGender(String male) {


        if (manFirstName.isDisplayed()) {
            select = new Select(gender);
            select.selectByValue(male);
        }
    }



  // Method for selecting Country Code of passenger in itinerary page
    public void selectCountryCode(String countrycode) {

        if (manFirstName.isDisplayed()) {

            select = new Select(countryCode);
            select.selectByValue(countrycode);
        }
    }


    // Method for providing card details in billing section in itinerary page

    public void selectcardInfo(String crdHoldername,String Securitycode, String phnum, String emailid, String crdnumber) {

          if (manFirstName.isDisplayed()) {

              phoneNumber.sendKeys(phnum);
              email.sendKeys(emailid);
              cardNumber.sendKeys(crdnumber);
              cardHolderName.sendKeys(crdHoldername);
              cvv.sendKeys(Securitycode);
          }

      }


    // Method for selecting Card expiration details in itinerary page

      public void selectCardExpirationDetail(String expiremnth,String expireyr){

          if (manFirstName.isDisplayed()) {

              select = new Select(month);
              select.selectByValue(expiremnth);

          }
          if (this.driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-traveller-detail[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[4]/div[1]/span[1]")).isDisplayed()) {
              select = new Select(year);
              select.selectByValue(expireyr);
          }
    }



    // Method for displaying all the Bill Countries and states in billing section of itinerary page

    public int getbillCountry() throws InterruptedException {

            Thread.sleep(4000);
            select = new Select(billCountry);
            System.out.println("************Country List**************");
            System.out.println(billCountry.getText());
            int count = billCountry.findElements(By.tagName("option")).size() - 1;
            System.out.println(billCountry.findElements(By.tagName("option")).size() - 1);

            return count;
    }

    // Method for displaying all the Bill  states in billing section of itinerary page.

    public int getBillState(){

        System.out.println("************State List**************");
        select = new Select(billState);
        System.out.println(billState.getText());
        int count=billState.findElements(By.tagName("option")).size()-1;
        System.out.println(billState.findElements(By.tagName("option")).size()-1);
        return count;
    }


    // Method for providing billing address, city, zip code, ph nnumber of passenger in itinerary page

    public void billInfo(String city, String address,String zip,String num) {

        if (manFirstName.isDisplayed()) {

            billAddress.sendKeys(address);
            billCity.sendKeys(city);
            zipCode.sendKeys(zip);
            billPhNumber.sendKeys(num);
        }
    }

    // Method for selecting  Bill Country and state in billing section of itinerary page

    public void setBillCountry(String billc,String bills) throws InterruptedException {

        if (manFirstName.isDisplayed()) {

            select = new Select(billCountry);
            select.selectByValue(billc);
            Thread.sleep(3000);
            select = new Select(billState);
            select.selectByValue(bills);

        }

    }



    // Method for verifying the fare amount of itinerary page

    public String verifyFare(){
        return verifyAmt.getText();



    }


    // Method for clicking on Confirm booking button

    public void confirmBooking(){
        book.submit();

    }


}
