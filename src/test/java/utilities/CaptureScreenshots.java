package utilities;

import dd_core.testCore;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshots extends testCore  {

    ITestResult result;

    public  void screenShot(ITestResult result){

        this.result=result;


        File scrShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrShotFile, new File("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\Screenshots\\"+result.getMethod().getMethodName()+".jpeg"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
