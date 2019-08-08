package testCases;

import base.BaseTC;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePageLinks;

public class HomePageLinksTC extends BaseTC {

    HomePageLinks hPLinks;

    @Test
    public void displaylink(){

        hPLinks= PageFactory.initElements(BaseTC.driver,HomePageLinks.class);
        hPLinks.displayLinks();
    }
}
