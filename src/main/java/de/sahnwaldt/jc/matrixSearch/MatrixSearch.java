package de.sahnwaldt.jc.matrixSearch;

import java.util.Collection;

public interface MatrixSearch<T>
{
  /**
   * search whole matrix
   */
  public Collection<IntList> search();
  
  /**
   * search section of matrix
   * @param min position of first element, inclusive
   * @param max position of last element, inclusive
   */
  public Collection<IntList> search(IntList min, IntList max);
}
