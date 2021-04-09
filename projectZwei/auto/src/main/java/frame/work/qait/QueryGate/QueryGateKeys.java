package frame.work.qait.QueryGate;

import org.json.JSONObject;
import java.io.IOException;
import static frame.work.Keys.FileConfig.con;

public class QueryGateKeys {

    static String nav;
    static String heading;
    static String proceed;
    static String dbUrl;
    static String dbUserName;
    static String dbPassword;
    static String symbol;
    static String passkey;
    static String input;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("QueryGate");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            dbUrl = mainObj.getString("dbUrl");
            dbUserName = mainObj.getString("dbUserName");
            dbPassword = mainObj.getString("dbPassword");
            input = mainObj.getString("input");
            passkey = mainObj.getString("passkey");
            symbol = mainObj.getString("symbol");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private QueryGateKeys() {
    }

}
