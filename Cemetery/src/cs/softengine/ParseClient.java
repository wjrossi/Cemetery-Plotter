package cs.softengine;

import org.parse4j.*;
import org.parse4j.callback.*;
import java.io.*;

public class ParseClient {
    private static String FILE_OBJ_ID = "cSRdwJXtdV";
    private static ParseObject saveObject = ParseObject.createWithoutData("Save", FILE_OBJ_ID);
    private static String APP_ID = "PMjsWvJ0jF5SvX70J7n19JaJ40SwsRSDbSz2wedp";
    private static String APP_REST_ID = "eZZDX9qchn88zkLhh02Q8xRToOTzlfrSVBEzs7qM";
    private static File file = null;

    public ParseClient() {
        Parse.initialize(APP_ID, APP_REST_ID);
    }

    /**
     * Retrieve file with name from server
     * @return boolean if user logged in successfully or not
     */
    public static File getFile() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Save");
        query.getInBackground(FILE_OBJ_ID, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your game score
                    saveObject = object;
                    ParseFile parseFile = saveObject.getParseFile("file");

                    while (parseFile == null) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ie) {
                            // do nothing
                        }
                    }

                    parseFile.getDataInBackground(new GetDataCallback() {
                        public void done(byte[] data, ParseException e) {
                            if (e == null && data != null) {
                                // data has the bytes for the file
                                try {
                                    File file = new File("cemetery.cloud.db");
                                    FileOutputStream fileWrite = new FileOutputStream(file);

                                    for (byte b : data) {
                                        fileWrite.write(b);
                                        fileWrite.flush();
                                    }

                                    fileWrite.close();
                                    setFile(file);
                                } catch (IOException io) {
                                    io.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        });

        while (file == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                // do nothing
            }
        }

        return file;
    }

    public static void setFile(File newFile) {
        file = newFile;
    }

    /**
     * Save file with to server
     * @param file the file to be saved
     * @return boolean if file saved successfully or not
     */
    public boolean saveFile(File file) throws ParseException, FileNotFoundException {
        byte[] data = new byte[(int) file.length()];

        try {
            FileInputStream fileRead = new FileInputStream(file);
            fileRead.read(data);
            fileRead.close();
        } catch (Exception e) { // unable to compress
            e.printStackTrace();
        }

        ParseFile parseFile = new ParseFile(file.getName(), data);
        parseFile.save();

        saveObject.put("file", parseFile);
        saveObject.save();

        return true;
    }
}


