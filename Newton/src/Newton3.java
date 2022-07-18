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
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *
     * @param eps
     *            positive number to compute square root of
     * @return estimate of square root
     *
     */
    private static double sqrt(double x, double eps) {
        double r = Math.abs(x);
        final double error = eps;

        while (((r * r) - x) > (error * error)) {
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
        double n = in.nextDouble();
        out.println("Enter a value for epsilon.");
        double eps = in.nextDouble();
        while (choice.equals("Y")) {

            out.println("Aprox. = " + sqrt(n, eps));

            out.println("Would you like to do another? [Y/N]");
            choice = in.nextLine();
            out.println("Enter a positive number.");
            n = in.nextDouble();
            out.println("Enter a value for epsilon.");
            eps = in.nextDouble();

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
