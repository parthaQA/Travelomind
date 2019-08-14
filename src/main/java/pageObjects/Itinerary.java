package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;


public class Itinerary  {

    Select select;
    WebDriver driver;

    @FindBy(how = How.ID,using = Configuration.firstName)
    WebElement firstName;
    @FindBy(how = How.XPATH,using = Configuration.middleName)
    WebElement middleName;
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
