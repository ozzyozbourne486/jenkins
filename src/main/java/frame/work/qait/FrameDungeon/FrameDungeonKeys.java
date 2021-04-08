package frame.work.qait.FrameDungeon;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

class FrameDungeonKeys {

    static String nav;
    static String heading;
    static String repaintbox;
    static String changingbox;
    static String unchangingbox;
    static String proceed;
    static String frameOne;
    static String frameTwo;
    static String att;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("FrameDungeon");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            repaintbox = mainObj.getString("repaintbox");
            unchangingbox = mainObj.getString("unchangingbox");
            changingbox = mainObj.getString("changingbox");
            att = mainObj.getString("att");
            frameOne = mainObj.getString("frameOne");
            frameTwo = mainObj.getString("frameTwo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FrameDungeonKeys() {
    }
}
