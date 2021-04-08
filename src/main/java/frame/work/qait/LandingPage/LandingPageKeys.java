package frame.work.qait.LandingPage;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

public class LandingPageKeys {

    static String nav;
    static String heading;
    static String proceed;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("HomePage");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LandingPageKeys() {
    }

}