package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjectConfiguation.Configuration;

import java.util.List;

public class HomePageLinks {

    WebDriver driver;
    @FindBy(how = How.TAG_NAME,using = Configuration.link)
    List<WebElement> link;
    @FindBy(how = How.TAG_NAME, using = Configuration.anchor)
    List<WebElement> anchor;
    @FindBy(how = How.TAG_NAME, using = Configuration.image)
    List<WebElement> image;



    public  HomePageLinks(WebDriver driver){
        this.driver=driver;
    }

    public void displayLinks(){

        System.out.println(link.size());
        for(int i=0;i<link.size();i++){
            System.out.println(link.get(i).getAttribute("href"));
        }

        System.out.println(anchor.size());
        for(int i=0;i<anchor.size();i++){
            System.out.println(anchor.get(i).getAttribute("href"));
        }
        System.out.println(image.size());
        for(int i=0;i<image.size();i++){
            System.out.println(image.get(i).getAttribute("src"));
        }

    }

}

