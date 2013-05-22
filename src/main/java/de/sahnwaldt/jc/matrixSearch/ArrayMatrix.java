package de.sahnwaldt.jc.matrixSearch;


public class ArrayMatrix<T>
implements Matrix<T>
{
  private final IntList zero;

  private final IntList size;
  
  private final T[] values;
  
  /**
   * @param size size of matrix in each dimension
   * @param values
   */
  public ArrayMatrix(IntList size, T[] values) {
    
    this.zero = new ArrayIntList(size.size(), false);
    if (! size.compareAll(zero, +1)) throw new IllegalArgumentException("expected positive sizes, got "+size);
    
    int total = 1;
    for (int d = 0; d < size.size(); d++) {
      total *= size.get(d);
    }
    if (total != values.length) throw new IllegalArgumentException("expected "+total+" elements for "+size+" matrix, got "+values.length);
    
    this.size = size;
    this.values = values;
  }
  
  /**
   * @return size of matrix in each dimension
   */
  public IntList size() {
    return size;
  }
  
  /**
   * @param pos index in each dimension
   * @return value at given position
   */
  public T get(IntList pos) {
    return values[index(pos)];
  }
  
  private int index(IntList pos) {
    
    if (pos.compareAny(zero, -1) || ! pos.compareAll(size, -1)) throw new IllegalArgumentException("expected position between "+zero+" (inclusive) and "+size+" (exclusive), got "+pos);
    
    int index = 0;
    for (int d = 0; d < pos.size(); d++) {
      if (d > 0) index *= size.get(d);
      index += pos.get(d);
    }
    return index; 
  }

}
