package testCases;

import dataProvider.Data_Provider;
import dd_core.testCore;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

import java.io.IOException;

public class SearchResultForOneWayTrip extends testCore {

    ModifySearch modify;
    BookAFlight book;
    String expectedOrigin="NYC";
    String expectedDestination="NYC";

    @DataProvider(name="getdata")
    public Object[][] getData() throws IOException {
        return Data_Provider.getdata("BookOneWayTrip");
    }

@Test(dataProvider = "getdata", description = "test case to search a one way flight between two destinations")
    public void SearchOneWayFlight(String Origin,String Destination, String Dmonth, String Dyear) throws InterruptedException {

        book= PageFactory.initElements(testCore.driver,BookAFlight.class);
        //modify=PageFactory.initElements(BaseTC.driver,ModifySearch.class);
        modify=book.clickFlight();
        Thread.sleep(10000);
       // modify.ButtonStatusToOneWay();
        String actualOrigin=modify.selectOriginPlace(Origin);
        Assert.assertEquals(actualOrigin,expectedOrigin);
        String actualReturn=modify.selectReturnPlace(Destination);
        Assert.assertEquals(actualReturn,expectedDestination);
        modify.SelectDepartureDate(Dmonth,Dyear);
        modify.ClickSearchOnline();


}

}
