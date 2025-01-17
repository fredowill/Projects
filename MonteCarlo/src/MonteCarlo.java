import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = 0, ptsInSubinterval = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rndx = new Random1L();
        Random rndy = new Random1L();
        /*
         * Generate points and count how many fall in [0.0,0.5) interval
         */
        while (ptsInInterval < n) {
            /*
             * Generate pseudo-random number in [0.0,2.0) interval
             */
            double x = (rndx.nextDouble()) * 2;
            double y = (rndy.nextDouble()) * 2;
            double pnt = Math.sqrt(((1 - x) * (1 - x)) + ((1 - y) * (1 - y)));
            /*
             * Increment total number of generated points
             */
            ptsInInterval++;
            /*
             * Check if point is in [0.0,0.5) interval and increment counter if
             * it is
             */
            if (pnt <= 1) {
                ptsInSubinterval++;
            }
        }
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         *
         * sqrt((x1-x2)^2+(y1-y2)^2)
         */

        double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of percentage: " + estimate + "%");
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

    private static double sqrt(double d) {
        // TODO Auto-generated method stub
        return 0;
    }

}