package cs.softengine;

import java.util.Random;

public class CryptFinder {
    public static void main(String [] args){

        Random randy = new Random();
        int greetNum = randy.nextInt(3) + 1;
        System.out.println(greeting(greetNum));
    }

    public static String greeting(int greetNum){
        String greet1 = "Hello, World!";
        String greet2 = "Maybe, World!";
        String greet3 = "Goodbye, World!";

        switch(greetNum){
            case 1:
                return greet1;
            case 2:
                return greet2;
            case 3:
                return greet3;
        }

        return "You shouldn't get to this return statement.";
    }
}
