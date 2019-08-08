package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.FlightList;

@Listeners(Listener.class)
public class ShowAllFlights extends BaseTC   {


    FlightList list;
    BookAFlight buk;
    WebDriver driver;

    @Test
    public  void showAllFlights(){
        try {
            buk=PageFactory.initElements(BaseTC.driver,BookAFlight.class);
            buk.clickFlight();
            list=PageFactory.initElements(BaseTC.driver,FlightList.class);
            list.findFlightList();



    }
        catch (Exception e){
            e.printStackTrace();
        }
 }

}
