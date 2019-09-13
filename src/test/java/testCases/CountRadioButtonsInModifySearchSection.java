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
public class CountRadioButtonsInModifySearchSection extends testCore {

    ModifySearch modify;
    BookAFlight book;
    int expectedButtonCount=2;


    @Test(description = "test case to count number of radio buttons in modify search section on flight details page")
    public void getButtonCounts() {

        try {
            //pageInit= PageFactory.initElements(BaseTC.driver, ModifySearch.class);
            book = PageFactory.initElements(testCore.driver, BookAFlight.class);
            modify = book.clickFlight();
            int actualButtonCount=modify.countRadioButtons();
            Assert.assertEquals(actualButtonCount,expectedButtonCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}