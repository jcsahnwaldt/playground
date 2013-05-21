package de.sahnwaldt.jc.matrixBinarySearch;

public class ArrayIntList
extends AbstractIntList
{
  private final int[] array;
  
  private final boolean mutable;
  
  public ArrayIntList(int count, boolean mutable) {
    array = new int[count];
    this.mutable = mutable;
  }
  
  public ArrayIntList(IntList that, boolean mutable) {
    array = new int[that.size()];
    for (int d = 0; d < array.length; d++) {
      array[d] = that.get(d);
    }
    this.mutable = mutable;
  }
  
  public ArrayIntList(int ... array) {
    this(false, array);
  }
  
  public ArrayIntList(boolean mutable, int ... array) {
    this.array = array;
    this.mutable = mutable;
  }
  
  @Override
  public int size() {
    return array.length;
  }

  @Override
  public int get(int index) {
    return array[index];
  }

  @Override
  public void set(int index, int value) {
    if (! mutable) throw new IllegalStateException("immutable");
    array[index] = value;
  }
  
}
