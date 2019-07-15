package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Itinerary extends BookAFlight {

    Select select;

    @FindBy(how = How.ID,using = "nm0")
    WebElement firstName;
    @FindBy(how = How.XPATH,using = "//input[@type='text]'")
    WebElement middleName;
    @FindBy(how = How.ID,using = "lm0")
    WebElement lastName;
    @FindBy(how = How.CSS,using = "#gender0")
    WebElement gender;
    @FindBy(how = How.ID,using = "contry")
    WebElement countryCode;
    @FindBy(how = How.NAME,using = "phn")
    WebElement phoneNumber;
    @FindBy(how = How.ID,using = "eml")
    WebElement email;
    @FindBy(how = How.ID,using = "crdno1")
    WebElement cardNumber;
    @FindBy(how = How.ID,using = "nmeOnCd1")
    WebElement cardHolderName;
    @FindBy(how = How.ID,using = "month1")
    WebElement month;
    @FindBy(how = How.ID,using = "year1")
    WebElement year;
    @FindBy(how = How.ID,using = "cvv1")
    WebElement cvv;
    @FindBy(how = How.ID,using = "cntry")
     WebElement billCountry;
    @FindBy(how = How.ID,using = "billAddr")
    WebElement billAddress;
    @FindBy(how = How.ID,using = "cty")
    WebElement billCity;
    @FindBy(how = How.ID,using = "st")
    WebElement billState;
    @FindBy(how = How.ID,using = "zipCode")
    WebElement zipCode;
    @FindBy(how = How.ID,using = "phnNumber")
    WebElement billPhNumber;
    @FindBy(how = How.ID,using = "dob0")
    WebElement dateOfBirth;
    @FindBy(how = How.XPATH,using = "//select[@title='Select year']")     //*[contains(text(),'here')]
    WebElement selectYear;
    @FindBy(how = How.XPATH,using = "//select[@title='Select month']")
    WebElement selectMonth;
    @FindBy(how = How.CSS,using = "#traveller > div > form > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(1) > div.input-group > ngb-datepicker > div.ngb-dp-months > div > ngb-datepicker-month-view > div:nth-child(4) > div:nth-child(4) > div")
    WebElement selectDay;
    @FindBy(how = How.CSS,using = "#traveller > div > form > div.row.ng-star-inserted > table > tbody > tr:nth-child(3) > td.ng-star-inserted")
    WebElement verifyAmt;
    @FindBy(how = How.XPATH,using = "//*[@id=\"traveller\"]/div/form/div[11]/div/button")
    WebElement book;
    @FindBy(how = How.CSS,using = "#traveller > div > form > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(3) > div.inlineErrMgs.ng-star-inserted > span")
    WebElement error;

    public Itinerary(WebDriver driver) {
        super(driver);
    }


    public void passengerDetail() {
        if (firstName.getText().isEmpty() & lastName.getText().isEmpty()) {
            firstName.sendKeys("Partha Sen");
            lastName.sendKeys("sen");
        }
    }

    public void selectDOB() {

        dateOfBirth.click();
        select = new Select(selectYear);
        select.selectByValue("1992");
        select = new Select(selectMonth);
        select.selectByValue("11");
        selectDay.click();


    }
    public void selectGender() {
        select = new Select(gender);
        select.selectByValue("1: MALE");
    }

    public void selectCountryCode() {

        select = new Select(countryCode);
        select.selectByValue("99: Object");

    }

      public void selectcardInfo() {

          if (phoneNumber.getText().isEmpty() & email.getText().isEmpty() & cardNumber.getText().isEmpty()
                  & cardHolderName.getText().isEmpty()) {
              phoneNumber.sendKeys("8828162737");
              email.sendKeys("partha.senuwsb@gmail.com");
              cardNumber.sendKeys("4111111111111111");
              cardHolderName.sendKeys("partha sen");
              cvv.sendKeys("456");
          }

      }


        public void selectCardExpirationDetail(){

        select = new Select(month);
        select.selectByValue("11: 11");
        select = new Select(year);
        select.selectByValue("5: 2023");

    }

    public void billingCountryState(){
        select = new Select(billCountry);
        System.out.println(billCountry.getText());
        select = new Select(billState);
        System.out.println(billState.getText());

    }

    public void billInfo(){
        billAddress.sendKeys("Saltlake city");
        billCity.sendKeys("Kolkata");
        zipCode.sendKeys("700111");
        billPhNumber.sendKeys("8828");
    }

    public void setBillCountry() throws InterruptedException {
        select = new Select(billCountry);
        select.selectByValue("99: Object");
        Thread.sleep(3000);
        select = new Select(billState);
        select.selectByValue("West Bengal");
    }

    public String verifyFare(){
        return verifyAmt.getText();



    }

    public void confirmBooking(){
        book.submit();

    }


}
