package de.sahnwaldt.jc.matrixSearch;

import java.util.Comparator;

public class BinaryMatrixSearch<T>
extends AbstractMatrixSearch<T>
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
  
  private final Comparator<? super T> comp;
  
  /**
   * Use default comparator.
   * @param matrix
   * @param val
   */
  public BinaryMatrixSearch(Matrix<T> matrix, T val) {
    this(matrix, val, null);
  }
  
  /**
   * @param matrix must not be null
   * @param val must not be null
   * @param comp if null, use default comparator
   */
  public BinaryMatrixSearch(Matrix<T> matrix, T val, Comparator<? super T> comp) {
    super(matrix, val);
    if (comp == null) comp = naturalOrder();
    this.comp = comp;
  }
  
  @Override
  protected void doSearch(IntList min, IntList max) {
    if (min.equals(max)) {
      // remember immutable copy of position
      if (compare(min, val) == 0) found.add(new ArrayIntList(min, false));
    }
    // TODO: for some segments, we do some comparisons twice
    else if (compare(min, val) <= 0 && compare(max, val) >= 0) {
      split(min, max, size.size());
    }
    // else val is not in this segment
  }
  
  /**
   * @param min will be modified temporarily
   * @param max will be modified temporarily
   * @param dim one plus dimension that should be split into two segments
   */
  private void split(IntList min, IntList max, int dim) {
    if (dim == 0) {
      // processed all dimensions - search this segment
      doSearch(min, max);
    }
    else {
      --dim;
      int lo = min.get(dim);
      int hi = max.get(dim);
      if (lo == hi) {
        // can't split this dimension any thinner, it's one element thick. check next dimension.
        split(min, max, dim);
      }
      else {
        // split next dimension into two segments
        int m = (lo + hi) >>> 1;
        
        // temporarily use new max position
        max.set(dim, m);
        split(min, max, dim);
        max.set(dim, hi);
        
        // temporarily use new min position
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
