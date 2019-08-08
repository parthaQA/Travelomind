package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.Itinerary;
import base.BaseTC;


@Listeners(Listener.class)
public class BillingDetail extends BaseTC   {


    BookAFlight bk;
    Itinerary detail;
    ITestResult result;


  @Test(priority = 0)
  public void getCountryList()  {

      try {

          bk = PageFactory.initElements(BaseTC.driver, BookAFlight.class);
          bk.clickFlight();
          bk.clickSelect();
          detail = PageFactory.initElements(BaseTC.driver, Itinerary.class);
          detail.billingCountryState();

      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

  }
}
