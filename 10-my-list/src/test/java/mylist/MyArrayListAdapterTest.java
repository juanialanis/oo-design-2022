package mylist;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.ArrayList;

public class MyArrayListAdapterTest {

    CircularBufferAdapter list;

    @BeforeEach
    public void setUp() {
        list = new CircularBufferAdapter<Integer>();
    }

    @Test
    public void addAtIndexTest() {
        assertThatThrownBy(() -> {list.add(0,1);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void removeObjectTest() {
        assertThatThrownBy(() -> {list.remove(new Integer(1));}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void isEmptyTest() {
        assertThatThrownBy(() -> {list.isEmpty();}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void containsTest() {
        assertThatThrownBy(() -> {list.contains(2);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void toArrayTest() {
        assertThatThrownBy(() -> {list.toArray();}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void toArrayParamsTest() {
        Integer[] a = new Integer[10];
        assertThatThrownBy(() -> {list.toArray(a);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }


    @Test
    public void containsAllTest() {
        List a = new ArrayList<>();
        assertThatThrownBy(() -> {list.containsAll(a);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void addAllIndexTest() {
        List a = new ArrayList<>();
        assertThatThrownBy(() -> {list.addAll(0,a);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void removeAllTest() {
        List a = new ArrayList<>();
        assertThatThrownBy(() -> {list.removeAll(a);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void retainAllTest() {
        List a = new ArrayList<>();
        assertThatThrownBy(() -> {list.retainAll(a);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void clearTest() {
        assertThatThrownBy(() -> {list.clear();}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void setTest() {
        assertThatThrownBy(() -> {list.set(0, 1);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void addIndexTest() {
        assertThatThrownBy(() -> {list.set(0, 1);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void lastIndexOfTest() {
        assertThatThrownBy(() -> {list.lastIndexOf(0);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void listIteratorTest() {
        assertThatThrownBy(() -> {list.listIterator();}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void listIteratorIndexTest() {
        assertThatThrownBy(() -> {list.listIterator(1);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }

    @Test
    public void subListTest() {
        assertThatThrownBy(() -> {list.subList(1,2);}).isInstanceOf(UnsupportedOperationException.class).hasMessage("Not implemented");
    }
}
