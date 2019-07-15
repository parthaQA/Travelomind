package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import base.BaseTC;
import pageObjects.Itinerary;


public class BookFlight {



    BookAFlight book;
    Itinerary itr;
    //String expectedAmt="$ (USD) 292.80";

    @Test(priority = 0)
    public void bookFlight()  {

        try {
            BaseTC base=new BaseTC();
            base.launchBrowser();
            book=PageFactory.initElements(base.driver,BookAFlight.class);
            book.clickFlight();
            String expectedAmt=book.clickSelect();
            itr=PageFactory.initElements(base.driver,Itinerary.class);
            itr.passengerDetail();
            itr.selectDOB();
            itr.selectGender();
            itr.billInfo();
            itr.setBillCountry();
           // itr.billingCountryState();
            itr.selectCardExpirationDetail();
            itr.selectcardInfo();
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
