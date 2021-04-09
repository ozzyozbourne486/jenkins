package frame.work.qait;

import org.testng.Assert;
import org.testng.annotations.Test;
import frame.work.qait.LandingPage.LandingPage;
import frame.work.qait.PopUpWindows.PopUpWindows;
import frame.work.qait.QueryGate.QueryGate;
import frame.work.qait.Setup.Setup;
import frame.work.qait.AdvancePage.AdvancePage;
import frame.work.qait.CookieHandling.CookieHandling;
import frame.work.qait.DragAround.DragAround;
import frame.work.qait.FrameDungeon.FrameDungeon;
import frame.work.qait.GridGate.GridGate;
import frame.work.qait.HoverMenu.HoverMenu;

public class AnotherTest {

    public String path;
    private final String platform = "windows";
    private final String browser = "firefox";

    @Test
    public void landingPage() throws Exception {
        var landingPageobj = new LandingPage(Setup.driverSetup(browser, platform));
        landingPageobj.nav();
        landingPageobj.moveToNextPage();
        Assert.assertEquals(landingPageobj.getPageName(), "Grid Gate");
        landingPageobj.end();
        path = landingPageobj.getpath();

    }

    @Test
    public void gridGate() throws Exception {
        var gridGateObj = new GridGate(Setup.driverSetup(browser, platform));
        gridGateObj.nav();
        gridGateObj.moveToNextPage();
        Assert.assertEquals(gridGateObj.getPageName(), "Frame Dungeon");
        gridGateObj.end();
        path = gridGateObj.getpath();

    }

    /*
     * @Test public void frameDungeon() throws Exception { var frameDungeonObj = new
     * FrameDungeon(Setup.driverSetup(browser, platform)); frameDungeonObj.nav();
     * frameDungeonObj.changingboxes(); frameDungeonObj.moveToNextPage();
     * frameDungeonObj.toDefault();
     * Assert.assertEquals(frameDungeonObj.getPageName(), "Drag Around");
     * frameDungeonObj.end(); path = frameDungeonObj.getpath();
     * 
     * }
     */

    @Test
    public void dragAround() throws Exception {
        var dragAroundObj = new DragAround(Setup.driverSetup(browser, platform));
        dragAroundObj.nav();
        dragAroundObj.doAction();
        dragAroundObj.moveToNextPage();
        Assert.assertEquals(dragAroundObj.getPageName(), "Popup Windows");
        dragAroundObj.end();
        path = dragAroundObj.getpath();

    }

    @Test
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

    @Test
    public void cookieHandling() throws Exception {
        var cookieHandlingObj = new CookieHandling(Setup.driverSetup(browser, platform));
        cookieHandlingObj.nav();
        cookieHandlingObj.setCookie();
        cookieHandlingObj.moveToNextPage();
        Assert.assertEquals(cookieHandlingObj.getPageName(), "End");
        cookieHandlingObj.end();
        path = cookieHandlingObj.getpath();

    }

    @Test
    public void advancePage() throws Exception {
        var advancePageObj = new AdvancePage(Setup.driverSetup(browser, platform));
        advancePageObj.nav();
        advancePageObj.moveToNextPage();
        Assert.assertEquals(advancePageObj.getPageName(), "Hover Menu");
        advancePageObj.end();
        path = advancePageObj.getpath();

    }

    @Test
    public void hoverMenu() throws Exception {
        var hoverMenuObj = new HoverMenu(Setup.driverSetup(browser, platform));
        hoverMenuObj.nav();
        hoverMenuObj.hover();
        hoverMenuObj.moveToNextPage();
        Assert.assertEquals(hoverMenuObj.getPageName(), "Query Gate");
        hoverMenuObj.end();
        path = hoverMenuObj.getpath();

    }

    @Test
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
