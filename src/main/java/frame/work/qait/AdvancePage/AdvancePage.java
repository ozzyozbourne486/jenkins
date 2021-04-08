package frame.work.qait.AdvancePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class AdvancePage extends ComOp {

    public AdvancePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("movin to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(AdvancePageKeys.proceed)).click();
    }

    @Step("getting page name")
    public String getPageName() {
        return driver.findElement(By.xpath(AdvancePageKeys.heading)).getText();
    }

    @Step("navigating to the advance tatoc page")
    public void nav() {
        driver.navigate().to(AdvancePageKeys.nav);
    }

}
