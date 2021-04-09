package frame.work.qait.LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class LandingPage extends ComOp {

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("get the name of the next page")
    public String getPageName() {

        return driver.findElement(By.xpath(LandingPageKeys.heading)).getText();
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(LandingPageKeys.proceed)).click();
    }

    @Step("navigate to the tatoc home page")
    public void nav() {
        driver.navigate().to(LandingPageKeys.nav);
    }

}
