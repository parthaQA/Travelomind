package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ModifySearch {


    WebDriver driver;
    Actions action;

    @FindBy(how = How.XPATH, using = "//div[@id='round_trip']")
    WebElement radio;
    @FindBy(how = How.TAG_NAME, using = "input")
    List<WebElement> rButtons;
    @FindBy(how = How.XPATH, using = "//div[@id='round_trip']//input[1]")
    WebElement oneWayButton;
    @FindBy(how = How.XPATH, using = "//body//input[2]")
    WebElement roundTripButton;
    List<WebElement> radioBtnCounts;
    List<WebElement> radioBtntext;


    public ModifySearch(WebDriver driver) {
        this.driver = driver;
    }


    public void countRadioButtons() {
        try {


            if (radio.isEnabled()){

                radioBtnCounts=radio.findElements(By.tagName("input"));
                System.out.println(radioBtnCounts.size());

            }
            else
                System.out.println("Button is disbled");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void getRadioButtonText(){


        try
        {
        if (radio.isEnabled()){
            radioBtntext=radio.findElements(By.tagName("span"));

            for(int i=0;i<radioBtntext.size();i++)

                System.out.println(radioBtntext.get(i).getText());

        }
        else
            System.out.println("Button is disbled");

    } catch (Exception e) {
        e.printStackTrace();

    }

    }


    public void VerifyButtonStatus(){

        if(roundTripButton.isSelected())
            System.out.println("round trip Button is selected");

        else {
            oneWayButton.click();
            System.out.println("One way button is selected");

        }
    }

    public void ButtonStatusToOneWay(){
        if(oneWayButton.isSelected()) {
            System.out.println("One way button is selected");

        }
        else{
            action=new Actions(this.driver);
            action.moveToElement(oneWayButton).build().perform();
            System.out.println("one way button is clicked");
    }}

    public void ButtonStatusToRoundTrip(){

        roundTripButton.click();

    }

}
