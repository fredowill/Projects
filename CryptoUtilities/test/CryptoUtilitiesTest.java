import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Ephratah Meskel
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    /**
     * test reduceToGCD for 0 and 0 REason: boundary, lowest numbers
     */
    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * test reduceGCD for integer max value and integer max value REason:
     * boundary, highest numbers
     */
    @Test
    public void testReduceToGCD_IntMaxValue() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        n.increment();
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * test reduceGCD for 30 and 21 Reason: routine
     */
    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * test reduceGCD for 52 and 13 Reason: routine
     */
    @Test
    public void testReduceToGCD_52_13() {
        NaturalNumber n = new NaturalNumber2(52);
        NaturalNumber nExpected = new NaturalNumber2(13);
        NaturalNumber m = new NaturalNumber2(13);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * test reduceGCD for 100 and 100 Reason: routine
     */
    @Test
    public void testReduceToGCD_100_100() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber nExpected = new NaturalNumber2(100);
        NaturalNumber m = new NaturalNumber2(100);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * test reduceGCD for 0 Reason: boundary, lowest number
     */
    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * test reduceGCD for 1 Reason: boundary, lowest false case number
     */
    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * test reduceGCD for 2 Reason: routine
     */
    @Test
    public void testIsEven_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * test reduceGCD for 2 Reason: routine
     */
    @Test
    public void testIsEven_19() {
        NaturalNumber n = new NaturalNumber2(19);
        NaturalNumber nExpected = new NaturalNumber2(19);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * test reduceGCD for 38729132 Reason: routine
     */
    @Test
    public void testIsEven_38729132() {
        NaturalNumber n = new NaturalNumber2(38729132);
        NaturalNumber nExpected = new NaturalNumber2(38729132);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * test reduceGCD for 38729133 Reason: routine
     */
    @Test
    public void testIsEven_38729133() {
        NaturalNumber n = new NaturalNumber2(38729133);
        NaturalNumber nExpected = new NaturalNumber2(38729133);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * test reduceGCD for intMaxValue Reason: boundary, max value
     */
    @Test
    public void testIsEven_IntMaxValue() {

        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(Integer.MAX_VALUE);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    /**
     * test powerMod for 0, 0, 2 Reason: boundary, lowest power
     */
    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * test powerMod for 17, 18, 19 Reason: routine
     */
    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * test powerMod for 9, 9, 9 Reason: routine case
     */
    @Test
    public void testPowerMod_9_9_9() {
        NaturalNumber n = new NaturalNumber2(9);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(9);
        NaturalNumber pExpected = new NaturalNumber2(9);
        NaturalNumber m = new NaturalNumber2(9);
        NaturalNumber mExpected = new NaturalNumber2(9);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * test powerMod for intMax, 1, intMax Reason: boundary, highest number case
     */
    @Test
    public void testPowerMod_IntMaxValue() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber mExpected = new NaturalNumber2(2147483647);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * test powerMod for 12, 0, 4: boundary, lowest exponent number case
     */
    @Test
    public void testPowerMod_12_0_4() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(4);
        NaturalNumber mExpected = new NaturalNumber2(4);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * test is prime for 2: routine case
     */
    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsPrime2_3() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber nExpected = new NaturalNumber2(3);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsPrime2__EvenComp_12() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber nExpected = new NaturalNumber2(12);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void compositeWitness_7_2() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void Compositeness_243_31() {
        NaturalNumber n = new NaturalNumber2(243);
        NaturalNumber w = new NaturalNumber2(31);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void isPrime2_big() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

}