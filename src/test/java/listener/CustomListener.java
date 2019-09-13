package listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import dd_core.testCore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
import utilities.CaptureScreenshots;

import java.io.IOException;

public class CustomListener extends testCore implements ITestListener {






    public void onStart(ITestContext context) {



    }

    public void onFinish(ITestContext context) {

        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {

        logger.info("*** Running test method " + result.getMethod().getMethodName() + "...");
       try {
            ExtentTestManager.startTest(result.getMethod().getMethodName());
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().log(Status.PASS, result.getMethod().getMethodName()+" passed");
        logger.info(result.getMethod().getMethodName()+"test Passed");
    }

    public   void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+"test Failed");
        CaptureScreenshots capture=new CaptureScreenshots();
        capture.screenShot(result);
        ExtentTestManager.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"Test Failed"+result.getThrowable());
        ExtentTest test=extent.createTest(result.getMethod().getMethodName());
        try {
            test.addScreenCaptureFromPath("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\Screenshots\\"+result.getMethod().getMethodName()+".jpeg");
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {


        ExtentTestManager.getTest().log(Status.SKIP, result.getMethod().getMethodName()+"Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }


}