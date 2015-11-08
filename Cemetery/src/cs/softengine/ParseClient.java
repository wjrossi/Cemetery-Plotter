package cs.softengine;
import org.parse4j.*;
import org.parse4j.callback.*;
import java.io.File;

/**
 * Created by DanielKindler on 11/8/15.
 */
public class ParseClient {

    private static String FILE_OBJ_ID = "rQupr9UOFz";
    private static String APP_ID = "PMjsWvJ0jF5SvX70J7n19JaJ40SwsRSDbSz2wedp";
    private static String APP_REST_ID = "eZZDX9qchn88zkLhh02Q8xRToOTzlfrSVBEzs7qM";

    public ParseClient() {
        Parse.initialize(APP_ID, APP_REST_ID);
    }


    /**
     * Retrieve file with name from server
     * @param fileName the name of the file
     * @return boolean if user logged in successfully or not
     */
    public File getFile(String fileName) {
        return null;
    }

    /**
     * Save file with to server
     * @param inFile the file to be saved
     * @return boolean if file saved successfully or not
     */
    public boolean saveFile(File inFile) throws ParseException {

        String str = inFile.toString();
        byte[] data = str.getBytes();

        ParseFile file = new ParseFile(inFile.getName(), data);
        ParseObject saveObj = ParseObject.createWithoutData("File", FILE_OBJ_ID);
        saveObj.add("file", file);

        saveObj.saveInBackground();

        return true;
    }



}
