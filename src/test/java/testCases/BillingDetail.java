package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.Itinerary;


@Listeners(CustomListener.class)
public class BillingDetail extends testCore {


    BookAFlight bk;
    Itinerary detail;
    ITestResult result;
    int expectCountryCount=238,expectedStateCount=55;


  @Test(description = "test case to display all the countries and state list from billing details section in Itinerary Page")
  public void getCountryList()  {

      try {

          bk = PageFactory.initElements(testCore.driver, BookAFlight.class); //Initiating all page elements of BookAFlight page object class.
          bk.clickFlight(); //calling method to click on flight
          detail=bk.clickSelect();  //Initiating all page elements of Itinerary page object class and calling click flight method.
          int countryCount=detail.getbillCountry();
          Assert.assertEquals(countryCount,expectCountryCount); //verify actual number of countries with expected numbers.
          int stateCount=detail.getBillState();
          Assert.assertEquals(stateCount,expectedStateCount); ////verify actual number of states with expected numbers.


      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

  }
}
