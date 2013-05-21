package de.sahnwaldt.jc.matrixBinarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearch<T>
{
  
  private static final Comparator<Comparable<Object>> NATURAL_ORDER =
  new Comparator<Comparable<Object>>() {
    @Override
    public int compare(Comparable<Object> c1, Comparable<Object> c2) {
      return c1.compareTo(c2);
    }
  };

  @SuppressWarnings("unchecked")
  private Comparator<? super T> naturalOrder() {
    return (Comparator<? super T>) NATURAL_ORDER;
  }
  
  private final Matrix<T> matrix;
  
  private final IntList zero;
  
  private final IntList size;
  
  private final T val;
  
  private final Comparator<? super T> comp;
  
  private List<IntList> found;
  
  /**
   * Use default comparator.
   * @param matrix
   * @param val
   */
  public BinarySearch(Matrix<T> matrix, T val) {
    this(matrix, val, null);
  }
  
  /**
   * @param matrix must not be null
   * @param val must not be null
   * @param comp if null, use default comparator
   */
  public BinarySearch(Matrix<T> matrix, T val, Comparator<? super T> comp) {
    if (matrix == null) throw new NullPointerException("matrix");
    if (val == null) throw new NullPointerException("val");
    if (comp == null) comp = naturalOrder();
    
    this.matrix = matrix;
    this.size = matrix.size();
    this.zero = new ArrayIntList(size.size(), false);
    this.val = val;
    this.comp = comp;
  }
  
  /**
   * search whole matrix
   */
  public List<IntList> search() {
    
    IntList from = new ArrayIntList(zero, true); // all zero
    
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
  public List<IntList> search(IntList min, IntList max) {
    
    if (min.compareAny(zero, -1) || ! min.compareAll(size, -1)) throw new IllegalArgumentException("expected position between "+zero+" (inclusive) and "+size+" (exclusive), got "+min);
    if (max.compareAny(zero, -1) || ! max.compareAll(size, -1)) throw new IllegalArgumentException("expected position between "+zero+" (inclusive) and "+size+" (exclusive), got "+max);
    if (min.compareAny(max, +1)) throw new IllegalArgumentException("min position "+min+" is partly greater than max position "+max);

    found = new ArrayList<>();
    // make modifiable copies of positions
    doSearch(new ArrayIntList(min, true), new ArrayIntList(max, true));
    return found;
  }
  
  private void doSearch(IntList min, IntList max) {
    if (min.equals(max)) {
      // make immutable copy
      if (compare(min, val) == 0) found.add(new ArrayIntList(min, false));
    }
    // TODO: for some segments, we do some comparisons twice
    else if (compare(min, val) <= 0 && compare(max, val) >= 0) {
      split(min, max, size.size());
    }
    // else val is not in this segment
  }
  
  private void split(IntList min, IntList max, int dim) {
    if (dim == 0) {
      doSearch(min, max);
    }
    else {
      --dim;
      int lo = min.get(dim);
      int hi = max.get(dim);
      if (lo == hi) {
        split(min, max, dim);
      }
      else {
        int m = (lo + hi) >>> 1;
        
        max.set(dim, m);
        split(min, max, dim);
        max.set(dim, hi);
        
        min.set(dim, m + 1);
        split(min, max, dim);
        min.set(dim, lo);
      }
    }
  }
      
  private int compare(IntList pos, T val) {
    return comp.compare(matrix.get(pos), val);
  }

}
