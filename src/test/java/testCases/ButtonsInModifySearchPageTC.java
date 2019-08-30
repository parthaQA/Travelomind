package testCases;

import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

@Listeners(CustomListener.class)
public class ButtonsInModifySearchPageTC extends testCore {

    ModifySearch pageInit;
    BookAFlight book;


    @Test(description = "test case to check button status and button text from modify search section on flight details page")
    public void getButtonDetails(){


        try {
            //pageInit= PageFactory.initElements(BaseTC.driver, ModifySearch.class);
            book=PageFactory.initElements(testCore.driver,BookAFlight.class);
            pageInit=book.clickFlight();
            pageInit.countRadioButtons();
            pageInit.getRadioButtonText();
            pageInit.VerifyButtonStatus();
            //Thread.sleep(3000);
            pageInit.ButtonStatusToOneWay();



        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

}
