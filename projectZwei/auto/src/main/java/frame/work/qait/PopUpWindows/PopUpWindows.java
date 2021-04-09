package frame.work.qait.PopUpWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class PopUpWindows extends ComOp {

    public PopUpWindows(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(PopUpWindowKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {

        return driver.findElement(By.xpath(PopUpWindowKeys.heading)).getText();
    }

    @Step("navigate to the tatoc PopUpWindow page")
    public void nav() {
        driver.navigate().to(PopUpWindowKeys.nav);
    }

    @Step("Lauching the popup window")
    public void launchPopUp() {
        driver.findElement(By.xpath(PopUpWindowKeys.launchpopup)).click();
    }

    private void switchToWindow(String window) {
        driver.switchTo().window(window);
    }

    @Step("Handling the Popup")
    public void handlePopUp() {

        var mainWindowHandle = driver.getWindowHandle();
        var winHandles = driver.getWindowHandles();
        var iterator = winHandles.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindowHandle.equals(childWindow)) {

                switchToWindow(childWindow);
                driver.findElement(By.xpath(PopUpWindowKeys.inputbox)).sendKeys("osaid khan");
                driver.findElement(By.xpath(PopUpWindowKeys.submitbuttom)).click();
            }
        }
        switchToWindow(mainWindowHandle);
    }
}
