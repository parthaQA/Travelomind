package testCases;

import listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import dataProvider.Data_Provider;
import dd_core.testCore;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.Itinerary;

@Listeners(CustomListener.class)
public class BookFlight extends testCore {

    BookAFlight book;
    Itinerary itr;
    ITestResult result;




    @Test(dataProvider = "getdata", description = "test case to book a flight between two destination")
    public void bookFlight(String firstname, String lastname,String city, String crdname, String securitycode, String phnum,
                           String emailid, String crdnumber, String address,String zip,String num,
                           String expiremnth,String expireyr, String male, String billcountry, String billstate,
                           String countrycode, String dobYear, String dobMonth)  {

        try {
            book=PageFactory.initElements(testCore.driver,BookAFlight.class);
            book.clickFlight();
            itr=book.clickSelect();
            //itr=PageFactory.initElements(BaseTC.driver,Itinerary.class);
            itr.passengerDetail(firstname,lastname);
            itr.billInfo(city,address,zip,num);
            itr.selectcardInfo(crdname,securitycode,phnum,emailid,crdnumber);
            itr.setBillCountry(billcountry, billstate);
            itr.selectDOB(dobYear,dobMonth);
            itr.selectGender(male);
           // itr.billingCountryState();
            itr.selectCardExpirationDetail(expiremnth,expireyr);
            itr.selectCountryCode(countrycode);




        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

   @DataProvider
    public static Object[][] getdata() {

        return Data_Provider.getdata("Login");
        // Data_Provider data=new Data_Provider();


    }}