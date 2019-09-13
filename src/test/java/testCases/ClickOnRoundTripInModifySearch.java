package testCases;

import dd_core.testCore;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

public class ClickOnRoundTripInModifySearch extends testCore {

    ModifySearch pageInit;
    BookAFlight book;


    @Test(description = "test case to click on RoundTrip radio button in Modify search")
    public void clickOnRoundTrip() {


        try {
            book = PageFactory.initElements(testCore.driver, BookAFlight.class);
            pageInit = book.clickFlight();
            boolean verify = pageInit.VerifyButtonStatus();
            boolean actual = pageInit.ButtonStatusToRoundTrip();
            Assert.assertEquals(verify, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
