package testCases;

import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

@Listeners(CustomListener.class)
public class GetRadioButtonTextInModifySaerchSection extends testCore {


    ModifySearch modify;
    BookAFlight book;
    String expectedButtonText="One WayRound Trip";

    @Test(description = "test case to count number of radio buttons in modify search section on flight details page")
    public void getButtonCounts() {

        try {
            //pageInit= PageFactory.initElements(BaseTC.driver, ModifySearch.class);
            book = PageFactory.initElements(testCore.driver, BookAFlight.class);
            modify = book.clickFlight();
            String actualButtonText=modify.getRadioButtonText();
            Assert.assertEquals(actualButtonText,expectedButtonText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
