import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Krutin and Ephratah
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Declaration of integer max value for certain test cases.
     */
    private static final int INTEGER_MAX_VALUE = 0;

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    /**
     * test no argument constructor, Reason: boundary.
     */
    @Test
    public void testConstructorNoArgs() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test integer argument constructor, Reason: routine.
     */
    @Test
    public void test1ConstructorInt() {
        /*
         * Set up variables
         */
        final int ten = 10;
        NaturalNumber n = this.constructorTest(ten);
        NaturalNumber nExpected = this.constructorRef(ten);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test integer argument constructor to show zero is an empty constructor ,
     * Reason: boundary.
     */
    @Test
    public void test2ConstructorInt() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef(0);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test string argument constructor, Reason: routine.
     */
    @Test
    public void test1ConstructorString() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest("123");
        NaturalNumber nExpected = this.constructorRef("123");
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test string argument constructor to show zero is an empty constructor ,
     * Reason: boundary.
     */
    @Test
    public void test2ConstructorString() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef("0");
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test natural number argument constructor, Reason: routine.
     */
    @Test
    public void test1ConstructorNN() {
        /*
         * Set up variables
         */
        final int twenty = 20;
        NaturalNumber check = new NaturalNumber2(twenty);
        //making this natural number to pass the test a natural number
        NaturalNumber n = this.constructorTest(check);
        NaturalNumber nExpected = this.constructorRef(check);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test natural number argument constructor to show zero is an empty
     * constructor, Reason: boundary.
     */
    @Test
    public void test2ConstructorNN() {
        /*
         * Set up variables
         */
        NaturalNumber check = new NaturalNumber2();
        NaturalNumber n = this.constructorTest(check);
        NaturalNumber nExpected = this.constructorRef();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testMultiplyBy10 using integer 2 on NN 10, Reason: routine.
     */
    @Test
    public void test1MultiplyBy10() {
        /*
         * Set up variables
         */
        final int ten = 10;
        NaturalNumber n = this.constructorTest(ten);
        NaturalNumber nExpected = this.constructorRef(ten);
        /*
         * call method under test
         */
        n.multiplyBy10(2);
        nExpected.multiplyBy10(2);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testMultiplyBy10 using integer 0 on NN 0, Reason: boundary.
     */
    @Test
    public void test2MultiplyBy10() {
        /*
         * Set up variables
         */
        final int zero = 0;
        NaturalNumber n = this.constructorTest(zero);
        NaturalNumber nExpected = this.constructorRef(zero);
        /*
         * call method under test
         */
        n.multiplyBy10(zero);
        nExpected.multiplyBy10(zero);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testMultiplyBy10 using integer 0 on NN 7, Reason: boundary for
     * integer.
     */
    @Test
    public void test3MultiplyBy10() {
        /*
         * Set up variables
         */
        final int seven = 7;
        NaturalNumber n = this.constructorTest(seven);
        NaturalNumber nExpected = this.constructorRef(seven);
        /*
         * call method under test
         */
        n.multiplyBy10(0);
        nExpected.multiplyBy10(0);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testMultiplyBy10 using integer 8 on NN 0, Reason: boundary for NN.
     */
    @Test
    public void test4MultiplyBy10() {
        /*
         * Set up variables
         */
        final int eight = 8;
        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);
        /*
         * call method under test
         */
        n.multiplyBy10(eight);
        nExpected.multiplyBy10(eight);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testMultiplyBy10 using integer (integer max value) on NN 0, Reason:
     * boundary.
     */
    @Test
    public void test5MultiplyBy10() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);
        /*
         * call method under test
         */
        n.multiplyBy10(INTEGER_MAX_VALUE);
        nExpected.multiplyBy10(INTEGER_MAX_VALUE);
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
    }

    /**
     * test testDivideBy10 on NN 0, Reason: boundary, lowest numbers.
     */
    @Test
    public void test1DivideBy10() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);
        /*
         * call method under test
         */
        int temp = n.divideBy10();
        int tempExpected = nExpected.divideBy10();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(temp, tempExpected);
    }

    /**
     * test testDivideBy10 on NN 12, Reason: routine.
     */
    @Test
    public void test2DivideBy10() {
        /*
         * Set up variables
         */
        final int twelve = 12;
        NaturalNumber n = this.constructorTest(twelve);
        NaturalNumber nExpected = this.constructorRef(twelve);
        /*
         * call method under test
         */
        int temp = n.divideBy10();
        int tempExpected = nExpected.divideBy10();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(temp, tempExpected);
    }

    /**
     * test testDivideBy10 on NN integer max value, Reason: routine.
     */
    @Test
    public void test3DivideBy10() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest(INTEGER_MAX_VALUE);
        NaturalNumber nExpected = this.constructorRef(INTEGER_MAX_VALUE);
        /*
         * call method under test
         */
        int temp = n.divideBy10();
        int tempExpected = nExpected.divideBy10();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(temp, tempExpected);
    }

    /**
     * test testDivideBy10 on NN 12, Reason: routine.
     */
    @Test
    public void test4DivideBy10() {
        /*
         * Set up variables
         */
        final int twelve = 12;
        NaturalNumber n = this.constructorTest(twelve);
        NaturalNumber nExpected = this.constructorRef(twelve);
        /*
         * call method under test
         */
        int temp = n.divideBy10();
        int tempExpected = nExpected.divideBy10();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(temp, tempExpected);
    }

    /**
     * test IsZero on NN 10, Reason: Boundary.
     */
    @Test
    public void testIsZeroFalse() {
        /*
         * Set up variables
         */
        final int ten = 10;
        NaturalNumber n = this.constructorTest(ten);
        NaturalNumber nExpected = this.constructorRef(ten);
        /*
         * call method under test
         */
        boolean ans = n.isZero();
        boolean ansExpected = nExpected.isZero();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(ans, ansExpected);
    }

    /**
     * test IsZero on NN 0, Reason: Boundary.
     */
    @Test
    public void testIsZeroTrue() {
        /*
         * Set up variables
         */
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();
        /*
         * call method under test
         */
        boolean ans = n.isZero();
        boolean ansExpected = nExpected.isZero();
        /*
         * assert calls
         */
        assertEquals(n, nExpected);
        assertEquals(ans, ansExpected);
    }

}
