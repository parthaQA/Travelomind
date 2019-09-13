package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjectConfiguation.Configuration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoiceOfCustomer {

    WebDriver driver;
    @FindBy(how = How.XPATH,using = Configuration.voc)
    WebElement voc;
    Set<String> window;
    @FindBy(how = How.XPATH,using = Configuration.americanAir)
    WebElement americanAir;
    @FindBy(how = How.XPATH,using = Configuration.forwardArrow)
    WebElement forwardArrow;


//Defining the constructor for the VoiceOfCustomer class

    public  VoiceOfCustomer(WebDriver driver){
        this.driver=driver;
    }



    //Method for clicking on Voice of Customer menu in Home page

    public void clickVOC(){

        try {
            voc.isEnabled();
            voc.click();
        }catch (Exception e){
            System.out.println("button is not enabled");
        }
    }


    //Method for switcing to Voice of Customer window and returing back to Home page window.

    public void SwitchToVocTab() {
        try {
            String homewindow=driver.getWindowHandle();
            window=driver.getWindowHandles();
            Iterator<String> it=window.iterator();

            for(int i=0;i<window.size();i++){

                String windows=it.next();
                driver.switchTo().window(windows);
            }
            Thread.sleep(2000);
            driver.switchTo().window(homewindow);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }


}
