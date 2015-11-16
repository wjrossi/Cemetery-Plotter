package cs.softengine;
import org.parse4j.*;
import org.parse4j.callback.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.*;
import java.util.Scanner;

/**
 * Created by DanielKindler on 11/8/15.
 */
public class ParseClient {
    private static String FILE_OBJ_ID = "cSRdwJXtdV";
    private static ParseObject saveObject = ParseObject.createWithoutData("Save", FILE_OBJ_ID);
    private static String APP_ID = "PMjsWvJ0jF5SvX70J7n19JaJ40SwsRSDbSz2wedp";
    private static String APP_REST_ID = "eZZDX9qchn88zkLhh02Q8xRToOTzlfrSVBEzs7qM";

    public ParseClient() {
        Parse.initialize(APP_ID, APP_REST_ID);
    }


    /**
     * Retrieve file with name from server
     * @return boolean if user logged in successfully or not
     */
    public static File getFile() {
        ParseFile file = (ParseFile) saveObject.get("file");
        File f = null;
        file.getDataInBackground(new GetDataCallback() {
            public void done(byte[] data, ParseException e) {
                if (e == null) {
                    String str = new String(data, StandardCharsets.UTF_8);
                    // do
                } else {
                    // do
                }
            }
        });

        return f;
    }

    /**
     * Save file with to server
     * @param inFile the file to be saved
     * @return boolean if file saved successfully or not
     */
    public boolean saveFile(File inFile) throws ParseException, FileNotFoundException {
        String str = new Scanner(inFile).useDelimiter("\\Z").next();
        byte[] data = str.getBytes();
        ParseFile file = new ParseFile(inFile.getName(), data);
        file.save();
        saveObject.put("file", file);
        saveObject.saveInBackground();
        return true;
    }
}


