package frame.work.qait.HoverMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class HoverMenu extends ComOp {

    public HoverMenu(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(HoverMenuKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {

        return driver.findElement(By.xpath(HoverMenuKeys.heading)).getText();
    }

    @Step("navigate to the tatoc HoverMenu page")
    public void nav() {
        driver.navigate().to(HoverMenuKeys.nav);
    }

    @Step("Performing the Hover Action")
    public void hover() {
        var actions = new Actions(driver);
        actions.moveToElement(findByXpath(HoverMenuKeys.menuTitle)).perform();
        actions.moveToElement(findByXpath(HoverMenuKeys.proceed)).perform();

    }

    private WebElement findByXpath(String path) {
        return driver.findElement(By.xpath(path));
    }
}
