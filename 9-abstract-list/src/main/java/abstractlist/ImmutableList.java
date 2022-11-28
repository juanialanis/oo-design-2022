package abstractlist;

import java.util.AbstractList;

public class ImmutableList<E> extends AbstractList<E> {

  private final E[] array;

  public ImmutableList(E[] array){
    this.array = array;
  }

  public E get(int index){
    return array[index];
  }

  public int size(){
    return array.length;
  }
}
