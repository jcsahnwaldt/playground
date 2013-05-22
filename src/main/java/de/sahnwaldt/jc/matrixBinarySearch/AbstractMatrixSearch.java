package de.sahnwaldt.jc.matrixBinarySearch;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractMatrixSearch<T>
implements MatrixSearch<T>
{
  protected final Matrix<T> matrix;
  
  protected final IntList zero;
  
  protected final IntList size;
  
  protected final T val;
  
  protected Collection<IntList> found;
  
  /**
   * @param matrix must not be null
   * @param val must not be null
   */
  public AbstractMatrixSearch(Matrix<T> matrix, T val) {
    if (matrix == null) throw new NullPointerException("matrix");
    if (val == null) throw new NullPointerException("val");
    
    this.matrix = matrix;
    this.size = matrix.size();
    this.zero = new ArrayIntList(size.size(), false);
    this.val = val;
  }
  
  /**
   * search whole matrix
   */
  public Collection<IntList> search() {
    
    IntList from = new ArrayIntList(zero.size(), true); // all zero
    
    IntList to = new ArrayIntList(zero.size(), true);
    for (int d = 0; d < to.size(); d++) to.set(d, size.get(d) - 1); // highest index
    
    found = new ArrayList<>();
    doSearch(from, to);
    return found;
  }
  
  /**
   * search section of matrix
   * @param min position of first element, inclusive
   * @param max position of last element, inclusive
   */
  public Collection<IntList> search(IntList min, IntList max) {
    
    if (min.compareAny(zero, -1) || ! min.compareAll(size, -1)) throw new IllegalArgumentException("expected min position between "+zero+" (inclusive) and "+size+" (exclusive), got "+min);
    if (max.compareAny(zero, -1) || ! max.compareAll(size, -1)) throw new IllegalArgumentException("expected max position between "+zero+" (inclusive) and "+size+" (exclusive), got "+max);
    if (min.compareAny(max, +1)) throw new IllegalArgumentException("min position "+min+" is partly greater than max position "+max);

    found = new ArrayList<>();
    // make modifiable copies of positions
    doSearch(new ArrayIntList(min, true), new ArrayIntList(max, true));
    return found;
  }
  
  protected abstract void doSearch(IntList min, IntList max);
}
