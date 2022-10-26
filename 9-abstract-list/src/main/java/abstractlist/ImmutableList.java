package abstractlist;

import java.util.AbstractList;

public class ImmutableList<E> extends AbstractList {

  private final Object[] array;

  public ImmutableList(Object[] array){
    this.array = array;
  }

  public E get(int index){
    return (E) array[index];
  }

  public int size(){
    return array.length;
  }
}
