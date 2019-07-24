package testCases;

import dataProvider.BillingDetailsDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import base.BaseTC;
import pageObjects.Itinerary;


public class BookFlight {

    BookAFlight book;
    Itinerary itr;
    //String expectedAmt="$ (USD) 292.80";
    //excelReader.ExcelReader elx=new excelReader.ExcelReader("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\TestData\\BillingDetailsDataProvider.xlsx");


    @Test(dataProvider = "getdata", dataProviderClass = BillingDetailsDataProvider.class)
    public void bookFlight(String firstname, String lastname,String city, String crdname, String securitycode, String phnum,
                           String emailid, String crdnumber, String address,String zip,String num, String expiremnth,String expireyr, String male)  {

        try {
            BaseTC base=new BaseTC();
            base.launchBrowser();
            book=PageFactory.initElements(base.driver,BookAFlight.class);
            book.clickFlight();
            String expectedAmt=book.clickSelect();
            itr=PageFactory.initElements(base.driver,Itinerary.class);
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
            base.closeBrowser();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
