package mylist;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class CricularBufferTest {

    MyArrayList list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<Integer>();
    }

    @Test
    public void insertTest() {
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);
        assertThat(list.length()).isEqualTo(11);
    }

    @Test
    public void deleteLastTest() {
        list.insert(1);
        list.insert(2);
        int size = list.length();
        list.delete(2);
        assertThat(list.length()).isEqualTo(size - 1);
    }

    @Test
    public void deleteOutOfBoundsTest() {
        list.insert(1);
        list.insert(2);
        assertThatThrownBy(() -> {list.delete(20);}).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> {list.delete(-5);}).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getOutOfBoundsIndexTest() {
        int i = list.getIndex(50);
        assertThat(i).isEqualTo(-1);
    }

    @Test
    public void obtainTest() {
        list.insert(1);
        list.insert(2);
        assertThat(list.obtain(0)).isEqualTo(1);
    }

    @Test
    public void obtainOutOfBoundsTest() {
        list.insert(1);
        list.insert(2);
        assertThatThrownBy(() -> {list.obtain(14);}).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> {list.obtain(-2);}).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void iteratorTest() {
        list.insert(1);
        list.insert(2);
        assertThat(list.iterator().hasNext()).isEqualTo(true);
        assertThatThrownBy(() -> {list.iterator().remove();}).isInstanceOf(UnsupportedOperationException.class);
    }
}
