package frame.work.Keys;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import java.util.concurrent.ThreadLocalRandom;

public class ComOp {

    private String newpath;
    protected WebDriver driver;

    @Step("taking the screen shot")
    public void screenShot() throws Exception {

        var scrShot = ((TakesScreenshot) driver);
        var srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        newpath = buildFilePath() + genrand() + ".png";
        var destFile = new File(newpath);
        FileUtils.copyFile(srcFile, destFile);

    }

    private String getCurrentDate() {
        var customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        var currentDate = new Date();
        return customFormat.format(currentDate);
    }

    @Step("closing the driver")
    public void end() throws Exception {
        screenShot();
        var s = allureScreenshot();
        driver.close();
    }

    private String genrand() {
        int rand = ThreadLocalRandom.current().nextInt();
        return String.valueOf(rand);

    }

    @Step("setting the screen shto path to the class variable in AppTest class")
    public String getpath() {
        return newpath;
    }

    private String buildFilePath() {
        var slash = "/";
        var platform = System.getProperty("os.name");
        var platforms = platform.split(" ");
        if (platforms[0].equals("Windows"))
            slash = "\\";
        return String.format("%1$s%2$ssrc%2$smain%2$sjava%2$sframe%2$swork%2$sScreenShots%2$s",
                System.getProperty("user.dir"), slash);

    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] allureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void main(String[] args) {
        var s = new ComOp();
        System.out.println(s.buildFilePath());
    }

}
