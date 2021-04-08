package frame.work.qait.PopUpWindows;

import org.json.JSONObject;
import static frame.work.Keys.FileConfig.con;
import java.io.IOException;

public class PopUpWindowKeys {

    static String nav;
    static String heading;
    static String proceed;
    static String inputbox;
    static String submitbuttom;
    static String launchpopup;

    static {
        try {
            JSONObject o = new JSONObject(con());
            var mainObj = o.getJSONObject("PopUpWindow");
            nav = mainObj.getString("nav");
            heading = mainObj.getString("heading");
            proceed = mainObj.getString("proceed");
            inputbox = mainObj.getString("inputbox");
            submitbuttom = mainObj.getString("submitbutton");
            launchpopup = mainObj.getString("launchpopup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PopUpWindowKeys() {
    }

}
