package mylist;

import java.util.Collection;

public interface MyList<E> extends Iterable<E> {

  public E delete(int index);

  public boolean insert(E o);

  public boolean insertAll(Collection<? extends E> e);

  public int getIndex(E e);

  public int length();

  public E obtain(int index);

}
