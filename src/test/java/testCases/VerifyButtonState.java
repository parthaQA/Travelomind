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
public class VerifyButtonState extends testCore {

    ModifySearch pageInit;
    BookAFlight book;


    @Test(description = "test case to check button status and toggle between two radio buttons")
    public void toggleBetweenRadioButtons(){


        try {
            book=PageFactory.initElements(testCore.driver,BookAFlight.class);
            pageInit=book.clickFlight();
            boolean actual=pageInit.VerifyButtonStatus();
            Assert.assertTrue(actual,"true");



        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

}
