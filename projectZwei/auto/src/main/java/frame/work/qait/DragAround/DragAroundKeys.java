package frame.work.qait.DragAround;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

class DragAroundKeys {

    static String nav;
    static String heading;
    static String proceed;
    static String dropbox;
    static String dragme;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("DragAround");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            dragme = mainObj.getString("dragme");
            dropbox = mainObj.getString("dropbox");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DragAroundKeys() {
    }

}
