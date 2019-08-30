package testCases;

import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;

@Listeners(CustomListener.class)
public class ToDisplayDomesticDestinationFlightList extends testCore {

    BookAFlight book;

    @Test
    public void displayFlightList() throws InterruptedException {

        book= PageFactory.initElements(testCore.driver,BookAFlight.class);
        book.popularDomesticDestinationList();
        book.clickOnAllPopularDomesticDestinations();

    }
}
