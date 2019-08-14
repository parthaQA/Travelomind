package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;


@Listeners(Listener.class)
public class SeachingFlightsFromModifySearchPageTc extends BaseTC {

    ModifySearch modify;
    BookAFlight book;
    String expectedOrigin="JFK";
    String expectedReturn="CCU";

  @Test
    public void searchFlight() throws InterruptedException {

        book= PageFactory.initElements(BaseTC.driver,BookAFlight.class);
        //modify=PageFactory.initElements(BaseTC.driver,ModifySearch.class);
        modify=book.clickFlight();
        String actualOrigin=modify.selectOriginPlace();
        Assert.assertEquals(actualOrigin,expectedOrigin);
        String actualReturn=modify.selectReturnPlace();
        Assert.assertEquals(actualReturn,expectedReturn);
        modify.SelectDepartureDate();
        modify.SelectReturnDate();
        modify.ClickSearchOnline();


    }
}
