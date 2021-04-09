package frame.work.qait;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import frame.work.qait.LandingPage.LandingPage;
import frame.work.qait.PopUpWindows.PopUpWindows;
import frame.work.qait.QueryGate.QueryGate;
import frame.work.qait.Setup.Setup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import frame.work.Keys.Listerners;
import frame.work.qait.AdvancePage.AdvancePage;
import frame.work.qait.CookieHandling.CookieHandling;
import frame.work.qait.DragAround.DragAround;
import frame.work.qait.FrameDungeon.FrameDungeon;
import frame.work.qait.GridGate.GridGate;
import frame.work.qait.HoverMenu.HoverMenu;

@Listeners({ Listerners.class })
@Epic("QAinfo tech trainee")
@Feature("tatoc automation")

public class AppTest {

    public String path;
    private static final String platform = "linux";
    private static final String browser = "chrome";

    @Test(description = "Selenium test landing page")
    @Description("Checking the first page of tatoc automation")
    public void landingPage() throws Exception {
        var landingPageobj = new LandingPage(Setup.driverSetup(browser, platform));
        landingPageobj.nav();
        landingPageobj.moveToNextPage();
        Assert.assertEquals(landingPageobj.getPageName(), "Grid Gate");
        landingPageobj.end();
        path = landingPageobj.getpath();
    }

    @Test(description = "Selenium test GridGate page")
    @Description("Checking the second page of tatoc automation")
    public void gridGate() throws Exception {
        var gridGateObj = new GridGate(Setup.driverSetup(browser, platform));
        gridGateObj.nav();
        gridGateObj.moveToNextPage();
        Assert.assertEquals(gridGateObj.getPageName(), "Frame Dungeon");
        gridGateObj.end();
        path = gridGateObj.getpath();
    }

    @Test(description = "Selenium test FrameDungeon page")
    @Description("Checking the third page of tatoc automation")
    public void frameDungeon() throws Exception {
        var frameDungeonObj = new FrameDungeon(Setup.driverSetup(browser, platform));
        frameDungeonObj.nav();
        frameDungeonObj.changingboxes();
        frameDungeonObj.moveToNextPage();
        frameDungeonObj.toDefault();
        Assert.assertEquals(frameDungeonObj.getPageName(), "Drag Around");
        frameDungeonObj.end();
        path = frameDungeonObj.getpath();
    }

    @Test(description = "Selenium test DragAround page")
    @Description("Checking the fourth page of tatoc automation")
    public void dragAround() throws Exception {
        var dragAroundObj = new DragAround(Setup.driverSetup(browser, platform));
        dragAroundObj.nav();
        dragAroundObj.doAction();
        dragAroundObj.moveToNextPage();
        Assert.assertEquals(dragAroundObj.getPageName(), "Popup Windows");
        dragAroundObj.end();
        path = dragAroundObj.getpath();

    }

    @Test(description = "Selenium test PopUpWindows page")
    @Description("Checking the fifth page of tatoc automation")
    public void popUpWindow() throws Exception {
        var popUpWindowObj = new PopUpWindows(Setup.driverSetup(browser, platform));
        popUpWindowObj.nav();
        popUpWindowObj.launchPopUp();
        popUpWindowObj.handlePopUp();
        popUpWindowObj.moveToNextPage();
        Assert.assertEquals(popUpWindowObj.getPageName(), "Cookie Handling");
        popUpWindowObj.end();
        path = popUpWindowObj.getpath();

    }

    @Test(description = "Selenium test CookieHandling page")
    @Description("Checking the sixth page of tatoc automation")
    public void cookieHandling() throws Exception {
        var cookieHandlingObj = new CookieHandling(Setup.driverSetup(browser, platform));
        cookieHandlingObj.nav();
        cookieHandlingObj.setCookie();
        cookieHandlingObj.moveToNextPage();
        Assert.assertEquals(cookieHandlingObj.getPageName(), "End");
        cookieHandlingObj.end();
        path = cookieHandlingObj.getpath();

    }

    @Test(description = "Selenium test Advance page")
    @Description("Checking the seventh page of tatoc automation")
    public void advancePage() throws Exception {
        var advancePageObj = new AdvancePage(Setup.driverSetup(browser, platform));
        advancePageObj.nav();
        advancePageObj.moveToNextPage();
        Assert.assertEquals(advancePageObj.getPageName(), "Hover Menu");
        advancePageObj.end();
        path = advancePageObj.getpath();

    }

    @Test(description = "Selenium test HoverMenu page")
    @Description("Checking the eigth page of tatoc automation")
    public void hoverMenu() throws Exception {
        var hoverMenuObj = new HoverMenu(Setup.driverSetup(browser, platform));
        hoverMenuObj.nav();
        hoverMenuObj.hover();
        hoverMenuObj.moveToNextPage();
        Assert.assertEquals(hoverMenuObj.getPageName(), "Query Gate");
        hoverMenuObj.end();
        path = hoverMenuObj.getpath();

    }

    @Test(description = "Selenium test QueryGate page")
    @Description("Checking the ninth page of tatoc automation")
    public void queryGate() throws Exception {
        var queryGateObj = new QueryGate(Setup.driverSetup(browser, platform));
        queryGateObj.nav();
        queryGateObj.queryDb();
        queryGateObj.inputValues();
        queryGateObj.moveToNextPage();
        Assert.assertEquals(queryGateObj.getPageName(), "Ooyala Video Player");
        queryGateObj.end();
        path = queryGateObj.getpath();

    }
}
