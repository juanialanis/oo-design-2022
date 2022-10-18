package mylist;

import java.util.Collection;

public interface MyList<E> {
  public Object delete(int index);

  public boolean insert(Object o);

  public boolean insertAll(Collection<?> e);

  public int getIndex(Object e);

  public int length();

  public Object obtain(int index); 
}
