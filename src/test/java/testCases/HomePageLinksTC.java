package testCases;


import dd_core.testCore;
import listener.CustomListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageLinks;




@Listeners(CustomListener.class)
public class HomePageLinksTC extends testCore {

    HomePageLinks hPLinks;



    @Test(description = "to display  all the links, images and attibutes from home page")
    public void displaylink(){
        hPLinks= PageFactory.initElements(testCore.driver,HomePageLinks.class);
        hPLinks.displayLinks();
        logger.info("test case passed");

    }
}
