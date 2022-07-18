import components.statement.Statement;

/**
 * Utility class with method to count the number of calls to primitive
 * instructions (move, turnleft, turnright, infect, skip) in a given
 * {@code Statement}.
 *
 * @author Put your name here
 *
 */
public final class CountPrimitiveCalls {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CountPrimitiveCalls() {
    }

    /**
     * Reports the number of calls to primitive instructions (move, turnleft,
     * turnright, infect, skip) in a given {@code Statement}.
     *
     * @param s
     *            the {@code Statement}
     * @return the number of calls to primitive instructions in {@code s}
     * @ensures <pre>
     * countOfPrimitiveCalls =
     *  [number of calls to primitive instructions in s]
     * </pre>
     */
    public static int countOfPrimitiveCalls(Statement s) {
        int count = 0;
        switch (s.kind()) {
            case BLOCK: {
            	for(int i = 0; i < s.lengthOfBlock(); i++) {
            		Statement temp = s.removeFromBlock(i);
            		count += countOfPrimitiveCalls(temp);
            		s.addToBlock(i, temp);
            	}

                break;
            }
            case IF: {
            	Statement temp = s.newInstance();
            	Statement.Condition c = s.disassembleIf(s);
            	count = countOfPrimitiveCalls(temp);
            	s.assembleIf(c, temp);

                break;
            }
            case IF_ELSE: {
            	Statement ifStmt = s.newInstance();
            	Statement elseStmt = s.newInstance();
            	Statement.Condition c = s.disassembleIfElse(ifStmt, elseStmt);
            	
            	count = countOfPrimitiveCalls(ifStmt) + countOfPrimitiveCalls(elseStmt);
            	s.assembleIfElse(c, ifStmt, elseStmt);

                break;
            }
            case WHILE: {
            	Statement temp = s.newInstance();
            	Statement.Condition c = s.disassembleWhile(temp);
            	count = countOfPrimitiveCalls(temp);
            	s.assembleWhile(c, temp);

                break;
            }
            case CALL: {
            	String temp = s.disassembleCall();
            	if(temp.equals("turnright") || temp.equals("turnleft") || 
            			temp.equals("move") || temp.equals("skip") || temp.equals("infect")) {
            		count++;
            	}
            	s.assembleCall(temp);
                break;
            }
            default: {
                /*
                 * we can only get one of the above following structures hence there is no chance that
                 * there would be a default case
                 */
                break;
            }
        }
        return count;
    }

}
