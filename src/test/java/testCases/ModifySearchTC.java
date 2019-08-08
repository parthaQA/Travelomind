package testCases;

import base.BaseTC;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;


public class ModifySearchTC extends BaseTC {

    ModifySearch pageInit;
    BookAFlight book;

    @Test
    public void getButtonDetails(){


        try {
            pageInit= PageFactory.initElements(BaseTC.driver, ModifySearch.class);
            book=PageFactory.initElements(BaseTC.driver,BookAFlight.class);
            book.clickFlight();
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
