package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoiceOfCustomer {

    WebDriver driver;
    @FindBy(how = How.XPATH,using = "//*[@id=\"navbar\"]/div[7]/span")
    WebElement voc;
    Set<String> window;
    @FindBy(how = How.XPATH,using = "//*[@id=\"reviewContainer\"]/div/div[2]/div[2]/p")
    WebElement americanAir;
    @FindBy(how = How.XPATH,using = "//*[@id=\"domestic\"]/img[2]")
    WebElement forwardArrow;



    public  VoiceOfCustomer(WebDriver driver){
        this.driver=driver;
    }


    public void clickVOC(){

        try {
            voc.isEnabled();
            voc.click();
        }catch (Exception e){
            System.out.println("button is not enabled");
        }
    }

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
