package circularlist;

import java.util.Collection;
import java.util.Arrays;
import java.util.Iterator;

class CircularBuffer<E> implements MyList<E>{

  private final static int DEFAULT_SIZE = 10;

  private int capacity = 0;
  private int size = 0;
  private int head = 0;
  private int tail = -1;
  private E[] array;

  CircularBuffer()
  {
    this.capacity = DEFAULT_SIZE;
    array = (E[]) new Object[capacity];;
  }

  @Override
  public boolean add(E element) throws ArrayIndexOutOfBoundsException {
    int index = (tail + 1) % capacity;
    
    if (size == capacity) {
      throw new ArrayIndexOutOfBoundsException("Buffer Overflow");
    }
    
    array[index] = element;
    size++;
    tail++;
    return true;
  }

  @Override
  public E delete() throws IllegalStateException
  {

    if (size == 0) {
      throw new IllegalStateException("Empty Buffer");
    }

    int index = head % capacity;

    Object element = array[index];

    head++;
    size--;

    return (E) element;
  }

  @Override
  public E get() throws IllegalStateException{

    if (size == 0) {
      throw new IllegalStateException("Empty Buffer");
    }

    int index = head % capacity;

    return (E) array[index];
  }

  @Override
  public boolean isEmpty() { 
    return size == 0; 
  }

  @Override
  public int size() { 
    return size; 
  }


  @Override
  public int getLastIndex() { 
    return tail % capacity; 
  }

  @Override
  public int getFirstIndex() { 
    return head % capacity; 
  }

  @Override
  public boolean insertAll(CircularBuffer<E> e) {
    for (E element : e) {
        this.add(element);
    }
    return false;
  }


  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private int pos=0;

      public boolean hasNext() {
        return size > pos && array[pos] != null;
      }

      public E next() {
        return array[pos++];
      }

      public void remove() {
        throw new UnsupportedOperationException("Cannot remove an element of an array.");
      }
    };
  }
}
