package testing.junit.practico.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;


public class BoundedQueueTest {

    BoundedQueue queue;

    @BeforeEach
    public void setUp() {
       queue = new BoundedQueue(10);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    public void testConstructor(int capacity) {
        assertNotEquals(queue, null);
    }

    @ParameterizedTest
    @CsvSource({"-1", "-2", "-3"})
    public void testNegativeCapacity(int capacity) {
        assertThrows(IllegalArgumentException.class, () -> new BoundedQueue(capacity));
    }

    @ParameterizedTest()
    @CsvSource({
    "'[5,1,2,foo]', 3",
    "'[3,foo,bar]', 2",
    "'[5]', 0",
    })
    public void testSize(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, Integer expected) {
        int size = q.size();
        assertEquals(expected, size);
    }

    // The first element of the string '[4,1,2,3]' is the cap of the queue (in this case, 4)
    @ParameterizedTest()
    @CsvSource({
    "'[4,1,2,3]', 4, '[1, 2, 3, 4]'",
    "'[4,2,8,0]', foo, '[2, 8, 0, foo]'",
    "'[5,1,2,3]', 4, '[1, 2, 3, 4]'",
    "'[7,2,8,0]', bar, '[2, 8, 0, bar]'",
    })
    public void testEnqueue(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, Object item, String expected) {
        int prevSize = q.size();
        q.enQueue(item);
        int size = q.size();
        String res = q.toString();
        assertEquals(expected, res);
        assertEquals(prevSize, size - 1);
    }

    // The first element of the string '[5,1,2,3]' is the cap of the queue (in this case, 5)
    @ParameterizedTest()
    @CsvSource({
    "'[5,foo,1,bar]', foo",
    "'[3,2,1]', 2",
    })
    public void testDequeue(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, Object expected) {
        int prevSize = q.size();
        Object last = q.deQueue();
        int size = q.size();
        assertEquals(expected.toString(), last.toString());
        assertEquals(prevSize, size + 1);
    }

    @Test
    public void testDequeueSizeZero() {
        assertThrows(IllegalStateException.class, () -> queue.deQueue());
    }

    @Test
    public void testEnqueueNull() {
        assertThrows(NullPointerException.class, () -> queue.enQueue(null));
    }

    @ParameterizedTest()
    @CsvSource({
    "'[2,foo,bar]', 1",
    "'[3,2,1,foo]', 2",
    })
    public void testEnqueueFull(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, Object enqueue) {
        assertThrows(IllegalStateException.class, () -> q.enQueue(enqueue));
    }

    @ParameterizedTest()
    @CsvSource({
    "'[3,1,2,3]', true",
    "'[5,2,1]', false",
    })
    public void testFull(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, boolean expected) {
        boolean status = q.isFull();
        assertEquals(expected, status);
    }

    @ParameterizedTest()
    @CsvSource({
    "'[3,1,2,3]', false",
    "'[3]', true",
    })
    public void testEmpty(@ConvertWith(BoundedQueueFromStringCap.class) BoundedQueue q, boolean expected) {
        boolean status = q.isEmpty();
        assertEquals(expected, status);
    }

    @ParameterizedTest()
    @CsvSource({
    "'[1,2,3]', '[1, 2, 3]'",
    "'[0,1,2]', '[0, 1, 2]'",
    })
    void testToString(@ConvertWith(BoundedQueueFromString.class) BoundedQueue q, String expected) {
        String res = q.toString();
        assertEquals(expected, res);
    }
}
