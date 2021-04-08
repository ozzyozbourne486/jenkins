package frame.work.Keys;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listerners extends ComOp implements ITestListener {

    ExtentReports extents = ExtendReporter.extendReportGenerator();
    ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onFinish(ITestContext arg0) {
        extents.flush();
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        try {
            var testInstance = arg0.getInstance();
            var cl = arg0.getTestClass().getRealClass();
            var path = (String) cl.getDeclaredField("path").get(testInstance);

            extentTest.get().fail(arg0.getThrowable());
            extentTest.get().fail("failure", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            extentTest.get().fail(e.getCause());
        }
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        test = extents.createTest(arg0.getMethod().getMethodName()).assignAuthor("Osaid Khan")
                .assignDevice(System.getProperty("os.name")).assignCategory("Training");
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "QAIT AUTOMATION TRAINING");
        extentTest.get().info("SELENIUM TESTING");

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        try {
            extentTest.get().log(Status.PASS, "success");
            var testInstance = arg0.getInstance();
            var cl = arg0.getTestClass().getRealClass();
            var path = (String) cl.getDeclaredField("path").get(testInstance);
            extentTest.get().pass("Screenshot Capture Success",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());

        } catch (Exception e) {
            extentTest.get().log(Status.WARNING, e.getCause());
            extentTest.get().warning("Screenshot Capture Failure");
        }

    }

}
