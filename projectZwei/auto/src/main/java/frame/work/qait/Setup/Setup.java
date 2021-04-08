package frame.work.qait.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Setup {

    public static WebDriver driverSetup(String choice, String platform) throws MyException {

        WebDriver driver = null;
        choice = choice.toUpperCase();
        switch (choice) {

        case "FIREFOX":
            driver = fireFoxDriverSetup(platform);
            break;

        case "CHROME":
            driver = chromeDriverSetup(platform);
            break;

        case "OPERA":
            driver = operaDriverSetup(platform);
            break;

        case "EDGE":
            driver = edgeDriverSetup(platform);
            break;

        case "HEADLESS":
            driver = headLessHtmlUnit();
            break;

        default:
            boolean flag = true;
            if (flag) {
                throw new MyException("No Such Browser");
            }
        }

        return driver;
    }

    private static WebDriver fireFoxDriverSetup(String platform) throws MyException {
        var flag = true;
        var path = pathBuilder("geckodriver", platform);
        System.setProperty("webdriver.gecko.driver", path);
        var options = new FirefoxOptions().setHeadless(flag);
        var driver = new FirefoxDriver(options);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;

    }

    private static WebDriver chromeDriverSetup(String platform) throws MyException {
        var flag = true;
        var path = pathBuilder("chromedriver", platform);
        System.setProperty("webdriver.chrome.driver", path);
        var options = new ChromeOptions().setHeadless(flag);
        var driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;

    }

    private static WebDriver operaDriverSetup(String platform) throws MyException {

        var path = pathBuilder("operadriver", platform);
        System.setProperty("webdriver.opera.driver", path);
        var driver = new OperaDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver edgeDriverSetup(String platform) throws MyException {

        var path = pathBuilder("edgedriver", platform);
        System.setProperty("webdriver.edge.driver", path);
        var driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver headLessHtmlUnit() {
        var driver = new HtmlUnitDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    private static String pathBuilder(String browser, String platform) throws MyException {

        String add = "";
        String exe = "";
        String slash = "/";
        switch (platform.toUpperCase()) {
        case "WINDOWS":
            add = "Windows";
            exe = ".exe";
            slash = "\\";
            break;
        case "MAC":
            add = "Mac";
            break;
        case "LINUX":
            add = "Linux";
            break;
        default:
            boolean flag = true;
            if (flag) {
                throw new MyException("No Such platform");
            }
        }

        return String.format("%1$s%2$ssrc%2$sDrivers%2$s%3$s%2$s%4$s%2$s%3$s%5$s", System.getProperty("user.dir"),
                slash, browser, add, exe);

    }

    private Setup() {
    }

    public static void main(String[] args) throws MyException {
        var val = pathBuilder("operadriver", "linux");
        System.out.println(val);
    }

}
