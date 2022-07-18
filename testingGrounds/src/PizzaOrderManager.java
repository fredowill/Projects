import org.junit.Test;

/**
 * Simple pizza order manager: inputs orders from a file and computes and
 * displays the total price for each order.
 *
 * @author Put your name here
 *
 */
public final class PizzaOrderManager {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PizzaOrderManager() {
    }

    public String longestCommonPrefix(String[] strs) {
        String arb = strs[0];
        String prefix = "";
        for (int i = 0; i < arb.length(); i++) {
            prefix = arb.substring(i);
            for (int j = 0; i < strs.length - 1; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return prefix;
                }
            }
        }
        return prefix;
    }

    @Test
    public void test() {
        String[] strs = { "flower", "flow", "flight" };

        String test = this.longestCommonPrefix(strs);

        System.out.println(test);

    }

}