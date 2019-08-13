package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.FilterYourPreferences;


@Listeners(Listener.class)
public class FilteringSearchResultsTC extends BaseTC {

    BookAFlight book;
    FilterYourPreferences filter;

    @Test
    public void filterSearch() throws InterruptedException {

        book=PageFactory.initElements(BaseTC.driver,BookAFlight.class);
        filter=PageFactory.initElements(BaseTC.driver,FilterYourPreferences.class);
        book.clickFlight();
        filter.getDepartingFromAirlineDetails();
        filter.getArrivingAtAilineDetails();
        filter.getAirlinesList();


    }
}
