import components.map.Map;
import components.program.Program.Instruction;
import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.statement.StatementKernel.Condition;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIOAndStaticMethod {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIOAndStaticMethod() {
    }

    /**
     *  * Generates the sequence of virtual machine instructions ("byte codes")
     *  * corresponding to {@code s} and appends it at the end of {@code cp}.  *
     *  * @param s  *            the {@code Statement} for which to generate
     * code  * @param context  *            the {@code Context} in which to find
     * user defined instructions  * @param cp  *            the {@code Sequence}
     * containing the generated code  * @updates cp  * @ensures <pre>
      * if [all instructions called in s are either primitive or
      *     defined in context]  and
      *    [context does not include any calling cycles, i.e., recursion] then
      *  cp = #cp * [sequence of virtual machine "byte codes" corresponding to s]
      * else
      *  [reports an appropriate error message to the console and terminates client]
      * </pre>  
     */
    private static void generateCodeForStatement(Statement s,
            Map<String, Statement> context, Sequence<Integer> cp) {
        final int dummy = 0;

        switch (s.kind()) {
            case BLOCK: {
                Statement current = s.newInstance();
                for (int index = 0; index < s.lengthOfBlock(); index++) {
                    current = s.removeFromBlock(index);
                    generateCodeForStatement(current, context, cp);
                    s.addToBlock(index, current);
                }

                break;
            }
            case IF: {
                Statement b = s.newInstance();
                Condition c = s.disassembleIf(b);
                cp.add(cp.length(), conditionalJump(c).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(b, context, cp);
                cp.replaceEntry(jump, cp.length());
                s.assembleIf(c, b);
                break;
            }
            case IF_ELSE: {

                // TODO - fill in case

                break;
            }
            case WHILE: {

                // TODO - fill in case

                break;
            }
            // remaining case CALL goes here
            default:
                break;
        }
    }

    /**
     *  * Converts {@code Condition} into corresponding conditional jump  *
     * instruction byte code.  *  * @param c  *            the {@code Condition}
     * to be converted  * @return the conditional jump instruction byte code
     * corresponding to  *         {@code c}  * @ensures <pre>
      * conditionalJump =
      *  [conditional jump instruction byte code corresponding to c]
      * </pre>  
     */
    private static Instruction conditionalJump(Condition c) {
        return null;
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

        in.close();
        out.close();
    }

}
