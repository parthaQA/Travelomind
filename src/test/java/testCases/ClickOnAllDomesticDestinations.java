package testCases;

import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;

@Listeners(CustomListener.class)
public class ClickOnAllDomesticDestinations extends testCore {

    BookAFlight book;

    @Test(description = "test case for clicking on all domestic flights from home page one at a time")
    public void ClickOnAllFlights() throws InterruptedException {

        book = PageFactory.initElements(testCore.driver, BookAFlight.class);
        book.clickOnAllPopularDomesticDestinations();
    }
}

