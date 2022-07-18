import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HW {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW() {
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        out.println("Enter a positive integer");
        String userInput = in.nextLine();
        boolean positive = false;
        boolean fail = false;
        int n = 0;
        if (FormatChecker.canParseInt(userInput)) {
            n = Integer.parseInt(userInput);
            if (n > 0) {
                positive = true;
            }
        }
        while (positive == fail) {
            out.println("Enter a positive integer");
            userInput = in.nextLine();
            if (FormatChecker.canParseInt(userInput)) {
                n = Integer.parseInt(userInput);
                if (n > 0) {
                    positive = true;
                }
            }
        }

        return n;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */

        out.println(getPositiveInteger(in, out));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
