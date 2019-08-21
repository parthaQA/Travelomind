package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.VoiceOfCustomer;

@Listeners(CustomListener.class)
public class VoiceOfCustomerTC extends testCore {

    VoiceOfCustomer voc;

    @Test
    public void executeVocTc() throws InterruptedException {

        voc= PageFactory.initElements(testCore.driver,VoiceOfCustomer.class);
        voc.clickVOC();
        voc.SwitchToVocTab();
    }
}
