package testing.junit.practico.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class Ejercicio1Test {

    @Test
    public void testFindLastAvoidFail() {

        // arrange
        int x[] = { 1, 2, 3 };
        int y = 2;

        // act
        int index = Ejercicio1.findLast(x, y);
        // assert
        assertEquals(index, 1);
    }

    @Test
    public void testFindLastAvoidFault() {

        int x[] = null;
        int y = 2;

        assertThrows(NullPointerException.class, () -> Ejercicio1.findLast(x, y));
    }

    @Test
    public void testFindLastRunFaultAndFail() {

        int x[] = { 1, 2, 3 };
        int y = 1;

        int index = Ejercicio1.findLast(x, y);
        assertEquals(index, 0);
    }

    @Test
    public void testFindLastNotFound() {

        int x[] = { 0, 1, 3 };
        int y = 2;
        int index = Ejercicio1.findLast(x, y);
        assertEquals(index, -1);

    }

    @Test
    public void testFindLastFixedAvoidFail() {

        int x[] = { 1, 2, 3 };
        int y = 2;

        int index = Ejercicio1.findLastFixed(x, y);
        assertEquals(index, 1);
    }

    @Test
    public void testFindLastFixedAvoidFault() {

        int x[] = null;
        int y = 2;

        assertThrows(NullPointerException.class, () -> Ejercicio1.findLastFixed(x, y));
    }

    @Test
    public void testFindLastFixedRunFaultAndFail() {

        int x[] = { 1, 2, 3 };
        int y = 1;

        int index = Ejercicio1.findLastFixed(x, y);
        assertEquals(index, 0);
    }

    @Test
    public void testLastZeroRunFaultAndFail() {

        int x[] = { 0, 1, 0 };

        int index = Ejercicio1.lastZero(x);
        assertEquals(index, 2);
    }

    @Test
    public void testLastZeroNoZeroes() {

        int x[] = { 1, 1, 1 };

        int index = Ejercicio1.lastZero(x);
        assertEquals(index, -1);
    }

    @Test
    public void testLastZeroAvoidFail() {

        int x[] = { 0, 1, 2 };

        int index = Ejercicio1.lastZero(x);
        assertEquals(index, 0);
    }

    @Test
    public void testLastZeroAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.lastZero(x));
    }

    @Test
    public void testLastZeroFixedRunFaultAndFail() {

        int x[] = { 0, 1, 0 };

        int index = Ejercicio1.lastZeroFixed(x);
        assertEquals(index, 2);
    }

    @Test
    public void testLastZeroFixedAvoidFail() {

        int x[] = { 0, 1, 2 };

        int index = Ejercicio1.lastZeroFixed(x);
        assertEquals(index, 0);
    }

    @Test
    public void testLastZeroFixedAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.lastZeroFixed(x));
    }

    @Test
    public void testNumZeroRunFaultAndFail() {

        int x[] = { 0, 0, 0 };

        int zeroes = Ejercicio1.numZero(x);
        assertEquals(zeroes, 3);
    }

    @Test
    public void testNumZeroNullArray() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.numZero(x));
    }

    @Test
    public void testNumZeroAvoidFail() {

        int x[] = { 1, 0 };

        int zeroes = Ejercicio1.numZero(x);
        assertEquals(zeroes, 1);
    }

    @Test
    public void testNumZeroFixedRunFaultAndFail() {

        int x[] = { 0, 0, 0 };

        int zeroes = Ejercicio1.numZeroFixed(x);
        assertEquals(zeroes, 3);
    }

    @Test
    public void testNumZeroFixedAvoidFail() {

        int x[] = { 1, 0 };

        int zeroes = Ejercicio1.numZeroFixed(x);
        assertEquals(zeroes, 1);
    }

    @Test
    public void testOddOrPosRunFaultAndFail() {

        int x[] = { -3, 1, 3 };

        int oddpos = Ejercicio1.oddOrPos(x);

        assertEquals(oddpos, 3);
    }

    @Test
    public void testOddOrPosAvoidFail() {

        int x[] = { 3, 1, 3 };

        int oddpos = Ejercicio1.oddOrPos(x);

        assertEquals(oddpos, 3);
    }

    @Test
    public void testOddOrPosAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.oddOrPos(x));
    }

    @Test
    public void testOddOrPosFixedRunFaultAndFail() {

        int x[] = { -3, 1, 3 };

        int oddpos = Ejercicio1.oddOrPosFixed(x);

        assertEquals(oddpos, 3);
    }

    @Test
    public void testOddOrPosFixedAvoidFail() {

        int x[] = { 3, 1, 3 };

        int oddpos = Ejercicio1.oddOrPosFixed(x);

        assertEquals(oddpos, 3);
    }

    @Test
    public void testOddOrPosFixedAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.oddOrPosFixed(x));
    }

    @Test
    public void testCountPositiveRunFaultAndFail() {

        int x[] = { 1, 2, 0 };

        int pos = Ejercicio1.countPositive(x);

        assertEquals(pos, 2);
    }

    @Test
    public void testCountPositiveAvoidFail() {

        int x[] = { 1, 2, 3 };

        int pos = Ejercicio1.countPositive(x);

        assertEquals(pos, 3);
    }

    @Test
    public void testCountPositiveAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.countPositive(x));
    }

    @Test
    public void testCountPositiveFixedRunFaultAndFail() {

        int x[] = { 1, 2, 0 };

        int pos = Ejercicio1.countPositiveFixed(x);

        assertEquals(pos, 2);
    }

    @Test
    public void testCountPositiveFixedAvoidFail() {

        int x[] = { 1, 2, 3 };

        int pos = Ejercicio1.countPositiveFixed(x);

        assertEquals(pos, 3);
    }

    @Test
    public void testCountPositiveFixedAvoidFault() {

        int x[] = null;

        assertThrows(NullPointerException.class, () -> Ejercicio1.countPositiveFixed(x));
    }
}
