package de.sahnwaldt.jc.matrixBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class BinarySearch<T> {
  
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
  
  private final int[] size;
  
  private final T val;
  
  private final Comparator<? super T> comp;
  
  private List<int[]> found;
  
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
    this.val = val;
    this.comp = comp;
  }
  
  /**
   * search whole matrix
   */
  public List<int[]> search() {
    
    int[] from = new int[size.length]; // all zero
    int[] to = new int[size.length];
    for (int d = 0; d < to.length; d++) to[d] = size[d] - 1; // highest index
    
    found = new ArrayList<>();
    doSearch(from, to);
    return found;
  }
  
  /**
   * search section of matrix
   * @param min position of first element, inclusive
   * @param max position of last element, inclusive
   */
  public List<int[]> search(int[] min, int[] max) {
    
    if (min.length != size.length) throw new IllegalArgumentException("expected "+size.length+" dimensions for min position, got "+min.length);
    if (max.length != size.length) throw new IllegalArgumentException("expected "+size.length+" dimensions for max position, got "+min.length);
    for (int d = 0; d < size.length; d++) {
      if (min[d] < 0 || min[d] >= size[d]) throw new IllegalArgumentException("dimension "+d+": expected index 0.."+(size[d]-1)+" for min position, got "+min[d]);
      if (max[d] < 0 || max[d] >= size[d]) throw new IllegalArgumentException("dimension "+d+": expected index 0.."+(size[d]-1)+" for max position, got "+max[d]);
      if (min[d] > max[d]) throw new IllegalArgumentException("dimension "+d+": index "+min[d]+" for min position is greater than index "+max[d]+" for max position");
    }
    
    found = new ArrayList<>();
    doSearch(min, max);
    return found;
  }
  
  private void doSearch(int[] min, int[] max) {
    if (Arrays.equals(min, max)) {
      if (compare(min, val) == 0) found.add(min);
    }
    // TODO: for some segments, we do some comparisons twice
    else if (compare(min, val) <= 0 && compare(max, val) >= 0) {
      split(min, max, size.length);
    }
    // else val is not in this segment
  }
  
  private void split(int[] min, int[] max, int dim) {
    if (dim == 0) {
      doSearch(min, max);
    }
    else {
      --dim;
      int lo = min[dim];
      int hi = max[dim];
      if (lo == hi) {
        split(min, max, dim);
      }
      else {
        int m = (lo + hi) >>> 1;
        
        max[dim] = m;
        split(min, max, dim);
        max[dim] = hi;
        
        min[dim] = m + 1;
        split(min, max, dim);
        min[dim] = lo;
      }
    }
  }
      
  private int compare(int[] pos, T val) {
    return comp.compare(matrix.get(pos), val);
  }

}
