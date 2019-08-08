package testCases;

import dataProvider.BillingDetailsDataProvider;
import listener.Listener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import base.BaseTC;
import pageObjects.Itinerary;

@Listeners(Listener.class)
public class BookFlight extends BaseTC {

    BookAFlight book;
    Itinerary itr;
    ITestResult result;


    @Test(dataProvider = "getdata", dataProviderClass = BillingDetailsDataProvider.class)
    public void bookFlight(String firstname, String lastname,String city, String crdname, String securitycode, String phnum,
                           String emailid, String crdnumber, String address,String zip,String num, String expiremnth,String expireyr, String male)  {

        try {
            book=PageFactory.initElements(BaseTC.driver,BookAFlight.class);
            book.clickFlight();
            String expectedAmt=book.clickSelect();
            itr=PageFactory.initElements(BaseTC.driver,Itinerary.class);
            itr.passengerDetail(firstname,lastname);
            itr.billInfo(city,address,zip,num);
            itr.selectcardInfo(crdname,securitycode,phnum,emailid,crdnumber);
            itr.setBillCountry();
            itr.selectDOB();
            itr.selectGender(male);
           // itr.billingCountryState();
            itr.selectCardExpirationDetail(expiremnth,expireyr);

            itr.selectCountryCode();
            String actualAmt=itr.verifyFare();
            Assert.assertEquals(actualAmt,expectedAmt);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
