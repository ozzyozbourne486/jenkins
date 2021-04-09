package frame.work.qait.QueryGate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frame.work.Keys.ComOp;
import io.qameta.allure.Step;

public class QueryGate extends ComOp {

    private String id;
    private String name;
    private String passkey;
    private Connection con;
    private Statement stmt;
    private ResultSet res;

    public QueryGate(WebDriver driver) {
        this.driver = driver;
    }

    @Step("proceed to the next page")
    public void moveToNextPage() {
        driver.findElement(By.xpath(QueryGateKeys.proceed)).click();
    }

    @Step("get the name of the next page")

    public String getPageName() {

        return driver.findElement(By.xpath(QueryGateKeys.heading)).getText();
    }

    @Step("navigate to the tatoc Query Gate page")
    public void nav() {
        driver.navigate().to(QueryGateKeys.nav);
    }

    @Step("Querying the DataBase")
    public void queryDb() {
        try {
            con = DriverManager.getConnection(QueryGateKeys.dbUrl, QueryGateKeys.dbUserName, QueryGateKeys.dbPassword);
            stmt = con.createStatement();
            var query = "select id from identity where symbol = '" + getSymbol() + "'";
            res = stmt.executeQuery(query);
            if (res.next()) {
                id = res.getString("id");
            }
            query = "select name, passkey from credentials where id = " + id;
            res = stmt.executeQuery(query);
            if (res.next()) {
                name = res.getString("name");
                passkey = res.getString("passkey");
            }
            res.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSymbol() {
        return getWebText(QueryGateKeys.symbol);
    }

    private String getWebText(String val) {

        return driver.findElement(By.xpath(val)).getText();

    }

    private void setKeys(String xp, String val) {
        driver.findElement(By.xpath(xp)).sendKeys(val);
    }

    @Step("Enter the values queried from the DataBase")
    public void inputValues() {
        setKeys(QueryGateKeys.input, name);
        setKeys(QueryGateKeys.passkey, passkey);
    }

}
