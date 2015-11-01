package cs.softengine;
import java.io.*;
import java.util.Scanner;



/**
 * Created by DanielKindler on 11/1/15.
 */
public class EncryptionClient {
    public static final int OFFSET = 7699;

    public static File decrypt(File f, int offset, String savename) throws IOException {
        try {
            return encrypt(f, 26-offset, savename);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File encrypt(File f, int offset, String docname) throws IOException {
        File fout = new File(docname);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        offset = offset % 26 + 26;

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                StringBuilder encoded = new StringBuilder();
                for (char i : sc.nextLine().toCharArray()) {
                    if (Character.isLetter(i)) {
                        if (Character.isUpperCase(i)) {
                            encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                        } else {
                            encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                        }
                    } else {
                        encoded.append(i);
                    }
                }

                bw.write(encoded.toString());
                bw.newLine();
            }
            sc.close();
            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fout;
    }
}
