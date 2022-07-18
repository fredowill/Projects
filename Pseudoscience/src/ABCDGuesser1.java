import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program gets the user's input of mew, w, x, y, and z all to the power of
 * a number in the charming theory in an attempt to get 0.08% within the value
 * mew.
 *
 *
 * @author Ephratah Meskel
 *
 */
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param w
     *            positive double greater than one
     * @param x
     *            positive double greater than one
     * @param y
     *            positive double greater than one
     * @param z
     *            positive double greater than one
     * @param mu
     *            positive double greater than zero
     * @param out
     *            outputs to the user
     *
     * @return a positive double that is within 0.08% of mew.
     *
     */
    private static double approximation(double w, double x, double y, double z,
            double mu, SimpleWriter out) {
        final double[] jager = { -5, -4, -3, -2, -1, -1 / 2.0, -1 / 3.0,
                -1 / 4.0, 0, 1 / 4.0, 1 / 3.0, 1 / 2.0, 1, 2, 3, 4, 5 };

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        final double h = 100;
        double currentPcntError = h;

        int u = 0, m = 0, n = 0, j = 0;
        while (u < jager.length) {
            while (m < jager.length) {
                while (n < jager.length) {
                    while (j < jager.length) {

                        double nextEstimate = (Math.pow(w, jager[j])
                                * Math.pow(x, jager[n]) * Math.pow(y, jager[m])
                                * Math.pow(z, jager[u]));

                        double nextPcntError = Math
                                .abs((nextEstimate - mu) / mu) * h;

                        if (nextPcntError < currentPcntError) {
                            a = jager[j];
                            b = jager[n];
                            c = jager[m];
                            d = jager[u];
                            currentPcntError = nextPcntError;
                        }
                        j++;

                    }
                    n++;
                    j = 0;

                }
                m++;
                n = 0;

            }
            u++;
            m = 0;

        }
        double bestAprox = ((Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                * Math.pow(z, d)));
        out.println("The exponent a is: " + a);
        out.println("The exponent b is: " + b);
        out.println("The exponent c is: " + c);
        out.println("The exponent d is: " + d);
        out.println(
                "The relative percent error is: " + (currentPcntError) + "%");
        return bestAprox;
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        String userInput = in.nextLine();
        boolean positive = false;
        boolean fail = false;
        double n = 0;
        if (FormatChecker.canParseDouble(userInput)) {
            n = Double.parseDouble(userInput);
            if (n > 0) {
                positive = true;
            }
        }
        while (positive == fail) {
            out.println("Enter a double greater than 0");
            userInput = in.nextLine();
            if (FormatChecker.canParseDouble(userInput)) {
                n = Double.parseDouble(userInput);
                if (n > 0) {
                    positive = true;
                }
            }
        }

        return n;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        String userInput = in.nextLine();
        boolean positive = false;
        boolean fail = false;
        double n = 0;
        if (FormatChecker.canParseDouble(userInput)) {
            n = Double.parseDouble(userInput);
            if (n > 1.0) {
                positive = true;
            }
        }
        while (positive == fail) {
            out.println("Enter a double greater than 1");
            userInput = in.nextLine();
            if (FormatChecker.canParseDouble(userInput)) {
                n = Double.parseDouble(userInput);
                if (n > 1.0) {
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
         * Values w, x, y, and z, and mew are intialized and entered by the user
         */
        double w, x, y, z, mu;

        out.println("mu:");
        mu = getPositiveDouble(in, out);

        out.println("W:");
        w = getPositiveDoubleNotOne(in, out);

        out.println("x:");
        x = getPositiveDoubleNotOne(in, out);

        out.println("y:");
        y = getPositiveDoubleNotOne(in, out);

        out.println("z:");
        z = getPositiveDoubleNotOne(in, out);

        out.println("The closest estimate of mew is: "
                + approximation(w, x, y, z, mu, out));

        /*
         * double relativeError = (Math.abs(approximation(w, x, y, z, mu) - mu))
         * / mu; /* Close input and output streams
         */
        in.close();
        out.close();
    }

}
