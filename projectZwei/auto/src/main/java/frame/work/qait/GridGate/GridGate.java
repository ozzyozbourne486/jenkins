package frame.work.qait.GridGate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class GridGate extends ComOp {

    public GridGate(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(GridGateKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {

        return driver.findElement(By.xpath(GridGateKeys.heading)).getText();
    }

    @Step("navigate to the tatoc GridGate page")
    public void nav() {
        driver.navigate().to(GridGateKeys.nav);
    }

}
