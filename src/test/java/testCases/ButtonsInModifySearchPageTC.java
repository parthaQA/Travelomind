package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BookAFlight;
import pageObjects.ModifySearch;

@Listeners(Listener.class)
public class ButtonsInModifySearchPageTC extends BaseTC {

    ModifySearch pageInit;
    BookAFlight book;


    @Test
    public void getButtonDetails(){


        try {
            //pageInit= PageFactory.initElements(BaseTC.driver, ModifySearch.class);
            book=PageFactory.initElements(BaseTC.driver,BookAFlight.class);
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
