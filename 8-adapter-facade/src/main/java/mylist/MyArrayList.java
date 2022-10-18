package mylist;

import java.util.Collection;

public class MyArrayList<E> implements MyList<E>{

  private final static int DEFAULT_SIZE = 10;
  private Object[] elements;
  private int count;

  public MyArrayList(){
    elements = new Object[DEFAULT_SIZE];
    count = 0;
  }

  @Override
  public Object delete(int index) {
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
    return result;
  }

  @Override
  public boolean insert(Object o) {
    if(count == elements.length){
      Object[] newElements = new Object[2*count];
      for(int index = 0; index < count; index++){
        newElements[index] = elements[index];
      }
      elements = newElements;
    }
    elements[count++] = o;
    return false;
  }

  @Override
  public boolean insertAll(Collection e) {
    for(Object element: e){
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
  public Object obtain(int index) {
    if(index > count || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return elements[index];
  }
  
}
