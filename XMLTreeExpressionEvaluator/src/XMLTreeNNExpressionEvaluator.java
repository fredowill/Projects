import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {

        NaturalNumber num0 = new NaturalNumber2();
        NaturalNumber num1 = new NaturalNumber2();

        if (exp.child(0).hasAttribute("number")) {
            num0 = new NaturalNumber2(
                    Integer.parseInt(exp.child(0).attributeValue("value")));
        } else {
            evaluate(exp.child(0));
        }

        if (exp.child(1).hasAttribute("number")) {
            num1 = new NaturalNumber2(
                    Integer.parseInt(exp.child(1).attributeValue("value")));
        } else {
            evaluate(exp.child(0));
        }

        if (exp.label().equals("times")) {
            num0.multiply(num1);

        } else if (exp.label().equals("divide")) {
            if (num1.isZero()) {
                Reporter.fatalErrorToConsole("Error, cannot divide by zero");
            }
            num0.divide(num1);

        } else if (exp.label().equals("plus")) {
            num0.add(num1);

        } else if (exp.label().equals("minus")) {
            if (num1.compareTo(num0) > 0) {
                Reporter.fatalErrorToConsole(
                        "Error, cannot subract a number to be negative");
            }
        }
        NaturalNumber outcome = new NaturalNumber2();
        outcome.copyFrom(num1);
        return outcome;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
