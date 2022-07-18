import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        final double epsilon = 0.0001;

        while (((r * r) - x) > (epsilon * epsilon)) {
            r = ((r + x / r) / 2);

        }
        return r;
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
        out.println("Do you wish to calulate a square root? [Y/N]");
        String choice = in.nextLine();
        out.println("Enter a positive number.");

        while (choice.equals("Y")) {
            double n = in.nextDouble();
            out.println("Aprox. = " + sqrt(n));
            out.println("Would you like to do another? [Y/N]");
            choice = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
