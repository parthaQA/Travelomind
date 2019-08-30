package testCases;


import dataProvider.Data_Provider;
import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

import java.io.IOException;


@Listeners(CustomListener.class)
public class SeachingFlightsFromModifySearchPageTc extends testCore {

    ModifySearch modify;
    BookAFlight book;
    String expectedOrigin="JFK";
    String expectedReturn="TYO";

    @DataProvider(name="getdata")
    public Object[][] getData() throws IOException {
        return Data_Provider.getdata("BookRoundTrip");
    }

  @Test(dataProvider = "getdata",description = "test case to search flight from modify search section")
    public void searchFlight(String Origin,String Destination, String Dmonth, String Dyear,String Amonth,String Ayear) throws InterruptedException {

      try {
          book= PageFactory.initElements(testCore.driver,BookAFlight.class);
          //modify=PageFactory.initElements(BaseTC.driver,ModifySearch.class);
          modify=book.clickFlight();
          String actualOrigin=modify.selectOriginPlace(Origin);
          Assert.assertEquals(actualOrigin,expectedOrigin);
          String actualReturn=modify.selectReturnPlace(Destination);
          Assert.assertEquals(actualReturn,expectedReturn);
          modify.SelectDepartureDate(Dmonth,Dyear);
          modify.SelectReturnDate(Amonth,Ayear);
          modify.ClickSearchOnline();
      }
      catch (Exception e){
          e.printStackTrace();
      }



    }



}
