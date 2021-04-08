package frame.work.qait.HoverMenu;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

class HoverMenuKeys {

    static String nav;
    static String heading;
    static String proceed;
    static String menuTitle;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("HoverMenu");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            menuTitle = mainObj.getString("menutitle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HoverMenuKeys() {
    }
}
