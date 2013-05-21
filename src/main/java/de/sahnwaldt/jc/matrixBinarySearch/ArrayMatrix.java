package de.sahnwaldt.jc.matrixBinarySearch;

import java.util.Arrays;

public class ArrayMatrix<T> {

  private final int[] size;
  
  private final T[] values;
  
  /**
   * @param size size of matrix in each dimension
   * @param values
   */
  public ArrayMatrix(int[] size, T[] values) {
    
    int total = 1;
    for (int d = 0; d < size.length; d++) {
      if (size[d] <= 0) throw new IllegalArgumentException("expected positive sizes, got "+Arrays.toString(size));
      total *= size[d];
    }
    if (total != values.length) throw new IllegalArgumentException("expected "+total+" elements for "+Arrays.toString(size)+" matrix, got "+values.length);
    
    this.size = size;
    this.values = values;
  }
  
  /**
   * @return size of matrix in each dimension
   */
  public int[] size() {
    return Arrays.copyOf(size, size.length);
  }
  
  /**
   * @param pos index in each dimension
   * @return value at given position
   */
  public T get(int[] pos) {
    return values[index(pos)];
  }
  
  private int index(int[] pos) {
    int index = 0;
    if (pos.length != size.length) throw new IllegalArgumentException("expected "+size.length+" dimensions, got "+pos.length);
    for (int d = 0; d < pos.length; d++) {
      if (pos[d] < 0 || pos[d] >= size[d]) throw new IllegalArgumentException("expected index 0.."+(size[d]-1)+" for dimension "+d+", got "+pos[d]);
      if (d > 0) index *= size[d];
      index += pos[d];
    }
    return index; 
  }

}
