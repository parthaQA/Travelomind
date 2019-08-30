package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
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


  @Test(priority = 0,description = "test case to display all the countries and state list from billing details section in Itinerary Page")
  public void getCountryList()  {

      try {

          bk = PageFactory.initElements(testCore.driver, BookAFlight.class);
          bk.clickFlight();
          detail=bk.clickSelect();
          //detail = PageFactory.initElements(BaseTC.driver, Itinerary.class);
          detail.billingCountryState();

      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

  }
}
