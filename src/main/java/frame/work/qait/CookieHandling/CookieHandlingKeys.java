package frame.work.qait.CookieHandling;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

class CookieHandlingKeys {

    static String nav;
    static String heading;
    static String proceed;
    static String gentoken;
    static String token;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("CookieHandling");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            gentoken = mainObj.getString("gentoken");
            token = mainObj.getString("token");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CookieHandlingKeys() {
    }

}
