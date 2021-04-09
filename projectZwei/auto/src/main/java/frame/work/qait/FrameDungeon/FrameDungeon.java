package frame.work.qait.FrameDungeon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class FrameDungeon extends ComOp {

    public FrameDungeon(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(FrameDungeonKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {
        return driver.findElement(By.xpath(FrameDungeonKeys.heading)).getText();
    }

    @Step("navigate to the tatoc FrameDungeon page")
    public void nav() {
        driver.navigate().to(FrameDungeonKeys.nav);
    }

    private void switchFrame(String fr) {
        driver.switchTo().frame(fr);
    }

    private String getAtt(String xp, String attribute) {
        return driver.findElement(By.xpath(xp)).getAttribute(attribute);
    }

    @Step("switching to default frame")
    public void toDefault() {
        driver.switchTo().defaultContent();
    }

    private void toParent() {
        driver.switchTo().parentFrame();
    }

    @Step("solving the frame dungeon maze")
    public void changingboxes() {
        switchFrame(FrameDungeonKeys.frameOne);
        var answer = getAtt(FrameDungeonKeys.unchangingbox, FrameDungeonKeys.att);
        switchFrame(FrameDungeonKeys.frameTwo);
        var toBeMatched = getAtt(FrameDungeonKeys.changingbox, FrameDungeonKeys.att);
        toParent();
        while (!answer.equals(toBeMatched)) {
            wait(FrameDungeonKeys.repaintbox).click();
            switchFrame(FrameDungeonKeys.frameTwo);
            toBeMatched = wait(FrameDungeonKeys.changingbox).getAttribute(FrameDungeonKeys.att);
            toParent();
        }
    }

    private WebElement wait(String paths) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paths)));
    }

}
