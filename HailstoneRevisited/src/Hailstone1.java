import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
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
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {

        NaturalNumber zero = new NaturalNumber1L(0);
        NaturalNumber one = new NaturalNumber1L(1);
        NaturalNumber two = new NaturalNumber1L(2);
        final int three = 3;
        NaturalNumber nn3 = new NaturalNumber1L(three);
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        while (copy != one) {
            if (copy.divide(two) == zero) {
                copy = copy.divide(two);
            } else {
                copy = copy.multiply(nn3);
            }
        }
        return copy;
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
        out.println("Enter a natural number that is greater than 1");

        int num = in.nextInteger();

        NaturalNumber a = new NaturalNumber1L(num);
        generateSeries(a, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
