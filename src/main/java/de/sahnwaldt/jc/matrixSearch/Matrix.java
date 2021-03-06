package de.sahnwaldt.jc.matrixSearch;

public interface Matrix<T>
{
  /**
   * @return size of matrix in each dimension
   */
  public IntList size();
  
  /**
   * @param pos index in each dimension. must have same number of dimensions as size.
   * @return value at given position
   */
  public T get(IntList pos);

}
