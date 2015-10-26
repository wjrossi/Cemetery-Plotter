package cs.softengine;

import java.io.File;

/**
 * Created by DanielKindler on 10/26/15.
 */

public class DropboxClient {

    /**
     * Authorize user with dropbox
     * @return boolean if user logged in successfully or not
     */
    public boolean login(){ return false;}

    /**
     * Retrieve file with name from server
     * @param fileName the name of the file
     * @return boolean if user logged in successfully or not
     */
    public File getFile(String fileName){ return null;}

    /**
     * Save file with to server
     * @param file the file to be saved
     * @return boolean if file saved successfully or not
     */
    public boolean saveFile(File file){ return true;}


}

