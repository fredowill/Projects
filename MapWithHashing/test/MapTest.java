import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map.Pair;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    @Test
    public final void testConstructor() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.constructorTest();
        Map<String, String> mExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m, mExpected);
    }

    @Test
    public final void testAdd() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2");
        Map<String, String> mExpected = this.createFromArgsRef("one", "1",
                "two", "2", "three", "3");
        /*
         * Call method under test
         */
        m.add("three", "3");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m, mExpected);
        assertEquals(m.hasKey("three"), mExpected.hasKey("three"));
        assertEquals(m.hasValue("3"), mExpected.hasValue("3"));
    }

    @Test
    public final void testRemove() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2",
                "three", "3");
        Map<String, String> mExpected = this.createFromArgsRef("one", "1",
                "two", "2");
        /*
         * Call method under test
         */
        m.remove("three");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m, mExpected);
        assertEquals(!m.hasKey("three"), !mExpected.hasKey("three"));
        assertEquals(!m.hasValue("3"), !mExpected.hasValue("3"));

    }

    @Test
    public final void testRemoveAny() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2",
                "three", "3");
        Map<String, String> mExpected = this.createFromArgsRef("one", "1",
                "two", "2");
        /*
         * Call method under test
         */
        Pair<String, String> check = m.removeAny();
        int mSize = m.size();
        int mExpectedSize = mExpected.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mSize, mExpectedSize);
        assertEquals(check.value(), mExpected.hasValue(check.value()));
        assertEquals(!m.hasValue(check.value()),
                mExpected.hasValue(check.value()));
    }

    @Test
    public final void testValue() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2",
                "three", "3");
        Map<String, String> mExpected = this.createFromArgsTest("one", "1",
                "two", "2", "three", "3");
        /*
         * Call method under test
         */
        String s = m.value("one");
        String s1 = m.value("two");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m, mExpected);
        assertEquals(s, "1");
        assertEquals(s1, "2");
    }

    @Test
    public final void testHasKey() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2",
                "three", "3");
        Map<String, String> mExpected = this.createFromArgsTest("one", "1",
                "two", "2", "three", "3");
        /*
         * Call method under test
         */
        Boolean b = m.hasKey("one");
        Boolean b1 = m.hasKey("two");
        Boolean b2 = m.hasKey("hi");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m, mExpected);
        assertEquals(b, true);
        assertEquals(b1, true);
        assertEquals(b2, false);
    }

    @Test
    public final void testSize() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("one", "1", "two", "2");
        Map<String, String> m2 = this.createFromArgsTest("one", "1", "two", "2",
                "three", "3");
        /*
         * Call method under test
         */
        int sz = m.size();
        int sz1 = m2.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sz, 2);
        assertEquals(sz1, 3);
    }

}
