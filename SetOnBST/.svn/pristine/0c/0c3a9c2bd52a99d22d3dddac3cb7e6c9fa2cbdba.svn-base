import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    @Test
    public final void testConstructor() {

        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        assertEquals(sExpected, s);
    }

    @Test
    public final void testAdd() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green");
        Set<String> sExpected = this.createFromArgsRef("red", "green", "blue");

        /*
         * call method under test
         */
        s.add("blue");

        /*
         * assert calls
         */
        assertEquals(s, sExpected);
    }

    @Test
    public final void testAdd1() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef("red", "green");

        /*
         * call method under test
         */
        s.add("green");

        /*
         * assert calls
         */
        assertEquals(s, sExpected);
    }

    @Test
    public final void testAdd2() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("red");

        /*
         * call method under test
         */
        s.add("red");

        /*
         * assert calls
         */
        assertEquals(s, sExpected);
    }

    @Test
    public final void testRemove() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green", "blue");
        Set<String> sExpected = this.createFromArgsRef("red", "green");

        /*
         * call method under test
         */
        s.remove("blue");

        /*
         * assert calls
         */
        assertEquals(s, sExpected);
    }

    @Test
    public final void testRemove1() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef();

        /*
         * call method under test
         */
        s.remove("red");

        /*
         * assert calls
         */
        assertEquals(s, sExpected);
    }

    @Test
    public final void testsize() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green", "blue");
        Set<String> sExpected = this.createFromArgsRef("red", "green", "blue");
        /*
         * Call method under test
         */
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.size(), s.size());
    }

    @Test
    public final void testsize1() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.size(), s.size());
    }

    @Test
    public final void testsize2() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("one");
        Set<String> sExpected = this.createFromArgsRef("one");
        /*
         * Call method under test
         */
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.size(), s.size());
    }

    @Test
    public final void testcontains() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green", "blue");
        Set<String> sExpected = this.createFromArgsRef("red", "green", "blue");
        /*
         * Call method under test
         */
        boolean ansR = s.contains("blue");
        boolean ansT = sExpected.contains("blue");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ansR, ansT);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testcontains1() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        boolean ansR = s.contains("blue");
        boolean ansT = sExpected.contains("blue");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ansR, ansT);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testcontains2() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        boolean ansR = s.contains("blue");
        boolean ansT = sExpected.contains("blue");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ansR, ansT);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testcontains3() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("green", "yellow", "blue");
        Set<String> sExpected = this.createFromArgsRef("green", "yellow",
                "blue");
        /*
         * Call method under test
         */
        boolean ansR = s.contains("rainbow");
        boolean ansT = sExpected.contains("rainbow");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ansR, ansT);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testcontains4() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("green");
        Set<String> sExpected = this.createFromArgsRef("green");
        /*
         * Call method under test
         */
        boolean ansR = s.contains("green");
        boolean ansT = sExpected.contains("green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ansR, ansT);
        assertEquals(s, sExpected);
    }

    @Test
    public void testRemoveAny() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "green", "blue");
        Set<String> sExpected = this.createFromArgsRef("red", "green", "blue");
        /*
         * Call method under test
         */
        String temp = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, sExpected.contains(temp));
        sExpected.remove(temp);
        assertEquals(sExpected, s);
    }

    @Test
    public void testRemoveAny1() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red");
        Set<String> sExpected = this.createFromArgsRef("red");
        /*
         * Call method under test
         */
        String temp = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, sExpected.contains(temp));
        sExpected.remove(temp);
        assertEquals(sExpected, s);
    }

    @Test
    public void testRemoveAny2() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("red", "blue", "yellow",
                "green");
        Set<String> sExpected = this.createFromArgsRef("red", "blue", "yellow",
                "green");
        /*
         * Call method under test
         */
        String temp = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, sExpected.contains(temp));
        sExpected.remove(temp);
        assertEquals(sExpected, s);
    }

}
