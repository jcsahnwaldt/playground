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
  
  private final Dimensions size;
  
  private final T val;
  
  private final Comparator<? super T> comp;
  
  private List<Dimensions> found;
  
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
  public List<Dimensions> search() {
    
    Dimensions from = new ArrayDimensions(size.count()); // all zero
    Dimensions to = new ArrayDimensions(size.count());
    for (int d = 0; d < to.count(); d++) to.set(d, size.get(d)-1); // highest index
    
    found = new ArrayList<>();
    doSearch(from, to);
    return found;
  }
  
  /**
   * search section of matrix
   * @param min position of first element, inclusive
   * @param max position of last element, inclusive
   */
  public List<Dimensions> search(Dimensions min, Dimensions max) {
    
    if (min.count() != size.count()) throw new IllegalArgumentException("expected "+size.count()+" dimensions for min position, got "+min.count());
    if (max.count() != size.count()) throw new IllegalArgumentException("expected "+size.count()+" dimensions for max position, got "+min.count());
    for (int d = 0; d < size.count(); d++) {
      if (min.get(d) < 0 || min.get(d) >= size.get(d)) throw new IllegalArgumentException("dimension "+d+": expected index 0.."+(size.get(d)-1)+" for min position, got "+min.get(d));
      if (max.get(d) < 0 || max.get(d) >= size.get(d)) throw new IllegalArgumentException("dimension "+d+": expected index 0.."+(size.get(d)-1)+" for max position, got "+max.get(d));
      if (min.get(d) > max.get(d)) throw new IllegalArgumentException("dimension "+d+": index "+min.get(d)+" for min position is greater than index "+max.get(d)+" for max position");
    }
    
    found = new ArrayList<>();
    // make modifiable copies of dimensions
    doSearch(new ArrayDimensions(min, true), new ArrayDimensions(max, true));
    return found;
  }
  
  private void doSearch(Dimensions min, Dimensions max) {
    if (min.equals(max)) {
      // make immutable copy
      if (compare(min, val) == 0) found.add(new ArrayDimensions(min, false));
    }
    // TODO: for some segments, we do some comparisons twice
    else if (compare(min, val) <= 0 && compare(max, val) >= 0) {
      split(min, max, size.count());
    }
    // else val is not in this segment
  }
  
  private void split(Dimensions min, Dimensions max, int dim) {
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
      
  private int compare(Dimensions pos, T val) {
    return comp.compare(matrix.get(pos), val);
  }

}
