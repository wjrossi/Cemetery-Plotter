package cs.softengine;

import java.io.File;

/**
 * Created by DanielKindler on 10/26/15.
 */
public class DropboxClient {
    static final String AUTH_URL = "https://api.dropboxapi.com/1/oauth/"; // + <request token>
    static final String GET_FILE_URL = "https://content.dropboxapi.com/1/files/auto/"; // + <file path>
    static final String PUT_FILE_URL = "https://content.dropboxapi.com/1/files_put/auto/"; // + <file name> + ?param=val

    /**
     * Authorize user with dropbox
     * @return boolean if user logged in successfully or not
     */
    public boolean login() {
        return false;
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
     * @param file the file to be saved
     * @return boolean if file saved successfully or not
     */
    public boolean saveFile(File file) { return true;
    }
}

