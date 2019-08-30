package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.FlightList;

@Listeners(CustomListener.class)
public class ShowAllFlights extends testCore {


    FlightList list;
    BookAFlight buk;





    @Test(description = "to display all the flight details between two destination (round trip)")
    public  void showAllFlights(){
        try {
            buk=PageFactory.initElements(testCore.driver,BookAFlight.class);
            buk.clickFlight();
            list=PageFactory.initElements(testCore.driver,FlightList.class);
            list.findFlightList();





    }
        catch (Exception e){
            e.printStackTrace();
        }
 }

}
