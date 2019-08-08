package testCases;

import base.BaseTC;
import listener.Listener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.VoiceOfCustomer;

@Listeners(Listener.class)
public class VoiceOfCustomerTC extends BaseTC {

    VoiceOfCustomer voc;

    @Test
    public void executeVocTc() throws InterruptedException {

        voc= PageFactory.initElements(BaseTC.driver,VoiceOfCustomer.class);
        voc.clickVOC();
        voc.SwitchToVocTab();
    }
}
