package de.sahnwaldt.jc.matrixBinarySearch;


public class LinearSearch<T>
extends AbstractMatrixSearch<T>
{
  /**
   * @param matrix must not be null
   * @param val must not be null
   */
  public LinearSearch(Matrix<T> matrix, T val) {
    super(matrix, val);
  }
  
  @Override
  protected void doSearch(IntList min, IntList max) {
  }
  
}
