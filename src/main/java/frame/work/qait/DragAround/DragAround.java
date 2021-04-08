package frame.work.qait.DragAround;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class DragAround extends ComOp {

    public DragAround(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(DragAroundKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {
        return driver.findElement(By.xpath(DragAroundKeys.heading)).getText();
    }

    @Step("navigate to the tatoc Drag and Drop page")
    public void nav() {
        driver.navigate().to(DragAroundKeys.nav);
    }

    @Step("performing the drag and drop action")
    public void doAction() {
        var action = new Actions(driver);
        var toBeDragged = driver.findElement(By.xpath(DragAroundKeys.dragme));
        var toBeDroped = driver.findElement(By.xpath(DragAroundKeys.dropbox));
        var dragAndDrop = action.clickAndHold(toBeDragged).moveToElement(toBeDroped).release(toBeDroped).build();
        dragAndDrop.perform();
    }
}
