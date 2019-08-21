package listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import dd_core.testCore;
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

        Reporter.log("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {

        Reporter.log(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {

        Reporter.log(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        try {
            ExtentTestManager.startTest(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    public   void onTestFailure(ITestResult result) {
        CaptureScreenshots capture=new CaptureScreenshots();
        capture.screenShot(result);
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
        ExtentTest test=extent.createTest(result.getMethod().getMethodName());
        try {
            test.addScreenCaptureFromPath("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\Screenshots\\"+result.getMethod().getMethodName()+".jpeg");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {


        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }


}