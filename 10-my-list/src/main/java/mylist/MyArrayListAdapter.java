package mylist;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularBufferAdapter<E> implements List<E> {

  MyArrayList<E> myArrayList;

  public CircularBufferAdapter() {
    myArrayList = new MyArrayList<E>();
  }

  @Override
  public int size() {
    return myArrayList.length();
  }

  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override public boolean contains(Object o) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public Iterator<E> iterator() {
    return myArrayList.iterator();
   // throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public Object[] toArray(Object[] a) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public boolean add(E e) {
    return myArrayList.insert(e);
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public boolean containsAll(Collection c) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public boolean addAll(Collection c) {
    return myArrayList.insertAll(c);
  }

  @Override
  public boolean addAll(int index, Collection c) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public boolean removeAll(Collection c) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public boolean retainAll(Collection c) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public E get(int index) {
    return myArrayList.obtain(index);
  }

  @Override
  public Object set(int index, Object element) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void add(int index, Object element) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public E remove(int index) {
    return myArrayList.delete(index);
  }

  @Override
  public int indexOf(Object o) {
    return myArrayList.getIndex(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public ListIterator listIterator() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public ListIterator listIterator(int index) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public List subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
