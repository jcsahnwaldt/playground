package de.sahnwaldt.jc.matrixSearch;


public class LinearMatrixSearch<T>
extends AbstractMatrixSearch<T>
{
  /**
   * @param matrix must not be null
   * @param val must not be null
   */
  public LinearMatrixSearch(Matrix<T> matrix, T val) {
    super(matrix, val);
  }
  
  @Override
  protected void doSearch(IntList min, IntList max) {
    doSearch(min, max, size.size());
  }
  
  protected void doSearch(IntList min, IntList max, int dim) {
    if (dim == 0) {
      // processed all dimensions - check this position
      if (matrix.get(min).equals(val)) {
        // remember immutable copy of position
        found.add(new ArrayIntList(min, false));
      }
    }
    else {
      --dim;
      int lo = min.get(dim);
      int hi = max.get(dim);
      for (int tmp = lo; tmp <= hi; tmp++) {
        // temporarily use new min position
        min.set(dim, tmp);
        doSearch(min, max, dim);
        min.set(dim, lo);
      }
    }
  }
  
}
