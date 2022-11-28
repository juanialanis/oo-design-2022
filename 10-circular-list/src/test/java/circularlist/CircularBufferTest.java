package circularlist;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class CircularBufferTest {

    CircularBuffer list;

    @BeforeEach
    public void setUp() {
        list = new CircularBuffer<Integer>();
    }

    @Test
    public void addTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        assertThat(list.size()).isEqualTo(9);
    }

    @Test
    public void addIndexOutOfBoundsTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        
        assertThatThrownBy(() -> {list.add(11);}).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void deleteTest() {
        list.add(1);
        list.add(2);
        int size = list.size();
        list.delete();
        assertThat(list.size()).isEqualTo(size - 1);
    }

    @Test
    public void deleteOutOfBoundsTest() {
        assertThatThrownBy(() -> {list.delete();}).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void getTest() {
        list.add(1);
        list.add(2);
        assertThat(list.get()).isEqualTo(1);
    }

    @Test
    public void getIllegalStateTest() {
        assertThatThrownBy(() -> {list.get();}).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void isEmpytTest() {
        list.add(1);
        list.add(2);
        assertThat(list.isEmpty()).isEqualTo(false);
    }

    @Test
    public void isEmpytTest2() {
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void iteratorTest() {
        list.add(1);
        list.add(2);
        assertThat(list.iterator().hasNext()).isEqualTo(true);
        assertThatThrownBy(() -> {list.iterator().remove();}).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void iteratorDeleteTest() {
        list.add(1);
        list.add(2);
        int number = 0;
        for (Object i : list) {
            number++;
            assertThat(i).isEqualTo(number);
        }
    }

    @Test
    public void ciruclarBufferTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.delete();
        list.delete();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        assertThat(list.getFirstIndex()).isEqualTo(2);
        assertThat(list.getLastIndex()).isEqualTo(1);
        
    }

    @Test
    public void insertAllTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        CircularBuffer list2 = new CircularBuffer<Integer>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list.insertAll(list2);

        assertThat(list.size()).isEqualTo(8);
        
    }


}
