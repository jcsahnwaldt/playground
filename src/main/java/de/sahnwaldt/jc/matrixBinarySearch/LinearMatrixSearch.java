package de.sahnwaldt.jc.matrixBinarySearch;


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
  }
  
}
