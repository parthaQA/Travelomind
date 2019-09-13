package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.FilterYourPreferences;


@Listeners(CustomListener.class)
public class FilteringSearchResultsTC extends testCore {

    BookAFlight book;
    FilterYourPreferences filter;

    @Test (description = "test case for clicking on first row flight from domestic airline section and listing out the search result details")
    public void filterSearch() throws InterruptedException {

        book=PageFactory.initElements(testCore.driver,BookAFlight.class);
        filter=PageFactory.initElements(testCore.driver,FilterYourPreferences.class);
        book.clickFlight();
        filter.getDepartingFromAirlineDetails();
        filter.getArrivingAtAilineDetails();
        filter.getAirlinesList();


    }
}
