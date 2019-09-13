package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectConfiguation.Configuration;

import java.beans.Visibility;

public class FlightList {

    public WebDriver driver;
    @FindBy(how = How.CLASS_NAME,using = Configuration.flightList)
    WebElement flightList;




    //Defining the constructor for the FlightList  class
    public FlightList(WebDriver driver) {
        this.driver=driver;
        new WebDriverWait(driver,20);
    }


    //method for displaying all the flights count appears on Search Page
    public void findFlightList() {
        try {

            System.out.println(flightList.getSize());

        }

        catch(Exception e){
            e.printStackTrace();
        }

    }



}

