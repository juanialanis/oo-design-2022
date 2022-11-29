package circularlist;

public interface MyList<E> extends Iterable<E> {

  public E delete();

  public boolean add(E o);

  public E get();

  public int size();

  public boolean isEmpty();

  public int getLastIndex();

  public int getFirstIndex();

  public boolean insertAll(CircularBuffer<E> e);

}
