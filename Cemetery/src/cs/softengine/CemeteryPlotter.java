package cs.softengine;

public class CemeteryPlotter {

    /**
     * CemeteryPlotter utility
     * @param args n/a
     */
    public static void main(String [] args){
        Cemetery cemetery = new Cemetery(); // initialize cemetery

        // do stuff like cemetery.load(data) ??

        try {
            run();
        } catch (Exception e) {
            // catch some errors??
        } finally {
            cemetery.save(); // clean-up and save data
        }
    }

    /**
     * Run CemeteryPlotter
     */
    public static void run() throws Exception {
        // eventually we will make the gui and show it by calling this
        // for now, use command line..

        System.out.println("CemeteryPlotter");
    }
}
