package frame.work.Keys;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtendReporter {

    public static ExtentReports extendReportGenerator() {

        var path = buildFilePath();
        var spark = new ExtentSparkReporter(path + "One.html");
        spark.config().setReportName("Tatoc Web Automation using Selenium");
        spark.config().setDocumentTitle("Test Results");
        spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR,
                ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG }).apply();
        var extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Ubuntu", "20.04 LTS");
        return extent;
    }

    private ExtendReporter() {
    }

    private static String buildFilePath() {
        var slash = "/";
        var platform = System.getProperty("os.name");
        var platforms = platform.split(" ");
        if (platforms[0].equals("Windows"))
            slash = "\\";
        return String.format("%1$s%2$sExtentReports%2$sExtent", System.getProperty("user.dir"), slash);

    }

    public static void main(String[] args) {
        System.out.println(buildFilePath());
    }

}
