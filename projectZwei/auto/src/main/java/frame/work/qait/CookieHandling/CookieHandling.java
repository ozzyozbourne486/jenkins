package frame.work.qait.CookieHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class CookieHandling extends ComOp {

    public CookieHandling(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(CookieHandlingKeys.proceed)).click();
    }

    @Step("get the name of the next page")
    public String getPageName() {

        return driver.findElement(By.xpath(CookieHandlingKeys.heading)).getText();
    }

    @Step("navigate to the tatoc cookie handling page")
    public void nav() {
        driver.navigate().to(CookieHandlingKeys.nav);
    }

    private String getWebText(String val) {
        return driver.findElement(By.xpath(val)).getText();
    }

    private void findByXpathAndClick(String path) {
        driver.findElement(By.xpath(path)).click();
    }

    private void configCookie(String[] sit) {
        driver.manage().addCookie(new Cookie(sit[0], sit[1]));
    }

    @Step("setting to the cookie on this page")
    public void setCookie() {
        findByXpathAndClick(CookieHandlingKeys.gentoken);
        var text = getWebText(CookieHandlingKeys.token);
        var sit = text.split(": ");
        configCookie(sit);
    }

}
