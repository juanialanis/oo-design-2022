package mylist;

import java.util.Collection;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>{

  private final static int DEFAULT_SIZE = 10;
  private E[] elements;
  private int count;

  public MyArrayList(){
    elements = (E[]) new Object[DEFAULT_SIZE];
    count = 0;
  }

  @Override
  public E delete(int index) {
    if(index > count || index < 0){
      throw new IndexOutOfBoundsException();
    }
    if(index == count){
      count--;
      return elements[index];
    }
    Object result = elements[index];
    for(int i = index; i < count-1 ; i++){
      elements[i] = elements[i+1];
      elements[i+1] = null;
    }
    count--;
    return (E) result;
  }

  @Override
  public boolean insert(E o) {
    if(count == elements.length){
      E[] newElements = (E[]) new Object[2*count];
      for(int index = 0; index < count; index++){
        newElements[index] = elements[index];
      }
      elements = newElements;
    }
    elements[count++] = o;
    return false;
  }

  @Override
  public boolean insertAll(Collection<? extends E> e) {
    for (E element : e) {
        this.insert(element);
    }
    return false;
  }

  @Override
  public int getIndex(Object e) {
    for(int i = 0; i < count; i++){
      if(elements[i].equals(e)){
        return i;
      }
    }
    return -1;
  }

  @Override
  public int length() {
    return count;
  }

  @Override
  public E obtain(int index) {
    if(index > count || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return elements[index];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private int pos=0;

      public boolean hasNext() {
        return count > pos && elements[pos] != null;
      }

      public E next() {
        return elements[pos++];
      }

      public void remove() {
        throw new UnsupportedOperationException("Cannot remove an element of an array.");
      }
    };
  }
}
