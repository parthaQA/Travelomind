package testCases;

import base.BaseTC;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.Itinerary;
import base.BaseTC;

public class BillingDetail   {


    BaseTC base;
    Itinerary detail;


  @Test(priority = 0)
  public void getCountryList()  {

      try {
          base = new BaseTC();
          base.launchBrowser();
          BookAFlight bk = PageFactory.initElements(base.driver, BookAFlight.class);
          bk.clickFlight();
          bk.clickSelect();
          detail = PageFactory.initElements(base.driver, Itinerary.class);
          detail.setBillCountry();
          detail.billingCountryState();
          base.closeBrowser();

      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

  }
}
