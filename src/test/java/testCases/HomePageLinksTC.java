package testCases;


import dd_core.testCore;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePageLinks;

public class HomePageLinksTC extends testCore {

    HomePageLinks hPLinks;

    @Test
    public void displaylink(){

        hPLinks= PageFactory.initElements(testCore.driver,HomePageLinks.class);
        hPLinks.displayLinks();
    }
}
