public interface List<T> extends Comparable{
  public abstract int size();
  public abstract T get(int i);
  public abstract int indexOf(Object item);
  public abstract void add(int i, T item);
  public abstract T remove(int i);
  public abstract T min();
  public abstract T max();
  public abstract boolean empty();
  public abstract void addAthead(T item);
  public abstract void addatEnd(T item);
  public abstract void replace(T first, T second);
  public abstract List<T> duplicate(T item);
  public abstract void reverse();
  public abstract String toString();
  public abstract List<T> countGreaterThan(T threshold);
  public abstract boolean equals(Object other);
  public abstract List<T> inorder();
  public abstract void removeEven();
}