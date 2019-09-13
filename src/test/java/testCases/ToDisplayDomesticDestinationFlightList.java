package testCases;

import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;

import java.io.IOException;

@Listeners(CustomListener.class)
public class ToDisplayDomesticDestinationFlightList extends testCore {

    BookAFlight book,book1;   //Creating object of BooKAFlight class.
   int expected_count=9;


    @Test(description = "Displaying all the details of Popular domestic flights details ")
    public void displayPopularDomesticDestinationFlightList() throws InterruptedException, IOException {

        book= PageFactory.initElements(testCore.driver,BookAFlight.class); //initiating the Object page elements using Page factory.
        book1=new BookAFlight(logger); //Passing logger object to BookAflight class
        int count=book.popularDomesticDestinationList(); //calling module popularDomesticDestinationList() to display all the details of Popular Domestic Destinations.
        Assert.assertEquals(count,expected_count); //verifying the actual result with expected result.
    }
}
