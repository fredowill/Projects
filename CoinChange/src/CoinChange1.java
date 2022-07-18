import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculates the least amount of coins needed to make the same amount of money
 * in dollars
 *
 * @author Ephratah Meskel
 *
 */
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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
         * Put your main program code here
         *
         *
         */
        out.println("Enter an amount of money in change");
        int userInput = in.nextInteger();
        int dollars, halfD, quarters, dimes, nickles, pennies;
        final int h = 100, f = 50, q = 25, d = 10, n = 5, p = 1;

        dollars = userInput / h;
        userInput = userInput % h;

        out.println("Amount of Dollars: " + dollars);
        out.println(userInput);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
