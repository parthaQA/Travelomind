package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Itinerary  {

    Select select;
    WebDriver driver;

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
    @FindBy(how = How.CSS,using = "#cntry")
     WebElement billCountry;
    @FindBy(how = How.ID,using = "billAddr")
    WebElement billAddress;
    @FindBy(how = How.ID,using = "cty")
    WebElement billCity;
    @FindBy(how = How.CSS,using = "#st")
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

    public Itinerary(WebDriver driver)
    {
        this.driver=driver;
    }


    public void passengerDetail(String firstname, String lastname) {
        if (firstName.getText().isEmpty() & lastName.getText().isEmpty()) {
            firstName.sendKeys(firstname);
            lastName.sendKeys(lastname);

        }
    }

    public void selectDOB() {

        dateOfBirth.click();
        select = new Select(selectYear);
        select.selectByValue("1992");
        select = new Select(selectMonth);
        select.selectByValue("12");
        selectDay.click();


    }
    public void selectGender(String male) {
        select = new Select(gender);
        select.selectByValue(male);
    }

    public void selectCountryCode() {

        select = new Select(countryCode);
        select.selectByValue("99: Object");

    }

      public void selectcardInfo(String crdHoldername,String Securitycode, String phnum, String emailid, String crdnumber) {

          if (phoneNumber.getText().isEmpty() & email.getText().isEmpty() & cardNumber.getText().isEmpty()
                  & cardHolderName.getText().isEmpty()) {
              phoneNumber.sendKeys(phnum);
              email.sendKeys(emailid);
              cardNumber.sendKeys(crdnumber);
              cardHolderName.sendKeys(crdHoldername);
              cvv.sendKeys(Securitycode);
          }

      }


        public void selectCardExpirationDetail(String expiremnth,String expireyr){

        select = new Select(month);
        select.selectByValue(expiremnth);
        select = new Select(year);
        select.selectByValue(expireyr);

    }

    public void billingCountryState(){
        try {
            Thread.sleep(4000);
            select = new Select(billCountry);
            System.out.println("************Country List**************");
            System.out.println(billCountry.getText());
            System.out.println("************State List**************");
            select = new Select(billState);
            System.out.println(billState.getText());
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void billInfo(String city, String address,String zip,String num){
        billAddress.sendKeys(address);
        billCity.sendKeys(city);
        zipCode.sendKeys(zip);
        billPhNumber.sendKeys(num);
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
