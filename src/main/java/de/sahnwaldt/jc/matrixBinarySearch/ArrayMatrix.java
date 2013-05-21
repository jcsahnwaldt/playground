package de.sahnwaldt.jc.matrixBinarySearch;


public class ArrayMatrix<T>
implements Matrix<T>
{

  private final Dimensions size;
  
  private final T[] values;
  
  /**
   * @param size size of matrix in each dimension
   * @param values
   */
  public ArrayMatrix(Dimensions size, T[] values) {
    
    int total = 1;
    for (int d = 0; d < size.count(); d++) {
      if (size.get(d) <= 0) throw new IllegalArgumentException("expected positive sizes, got "+size);
      total *= size.get(d);
    }
    if (total != values.length) throw new IllegalArgumentException("expected "+total+" elements for "+size+" matrix, got "+values.length);
    
    this.size = size;
    this.values = values;
  }
  
  /**
   * @return size of matrix in each dimension
   */
  public Dimensions size() {
    return size;
  }
  
  /**
   * @param pos index in each dimension
   * @return value at given position
   */
  public T get(Dimensions pos) {
    return values[index(pos)];
  }
  
  private int index(Dimensions pos) {
    int index = 0;
    if (pos.count() != size.count()) throw new IllegalArgumentException("expected "+size.count()+" dimensions, got "+pos.count());
    for (int d = 0; d < pos.count(); d++) {
      if (pos.get(d) < 0 || pos.get(d) >= size.get(d)) throw new IllegalArgumentException("expected index 0.."+(size.get(d)-1)+" for dimension "+d+", got "+pos.get(d));
      if (d > 0) index *= size.get(d);
      index += pos.get(d);
    }
    return index; 
  }

}
