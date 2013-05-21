package de.sahnwaldt.jc.matrixBinarySearch;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void testSearch() {
    
    Matrix<Integer> matrix;
    
    Integer[] nine = {
      0,1,2,
      3,4,5,
      6,7,8
    };
    
    matrix = new ArrayMatrix<>(d(9), nine);
    
    checkSearch(matrix, -1);
    checkSearch(matrix, 0, d(0));
    checkSearch(matrix, 1, d(1));
    checkSearch(matrix, 2, d(2));
    checkSearch(matrix, 3, d(3));
    checkSearch(matrix, 4, d(4));
    checkSearch(matrix, 5, d(5));
    checkSearch(matrix, 6, d(6));
    checkSearch(matrix, 7, d(7));
    checkSearch(matrix, 8, d(8));
    checkSearch(matrix, 9);
    
    matrix = new ArrayMatrix<>(d(3, 3), nine);
    
    checkSearch(matrix, -1);
    checkSearch(matrix, 0, d(0,0));
    checkSearch(matrix, 1, d(0,1));
    checkSearch(matrix, 2, d(0,2));
    checkSearch(matrix, 3, d(1,0));
    checkSearch(matrix, 4, d(1,1));
    checkSearch(matrix, 5, d(1,2));
    checkSearch(matrix, 6, d(2,0));
    checkSearch(matrix, 7, d(2,1));
    checkSearch(matrix, 8, d(2,2));
    checkSearch(matrix, 9);
  }

  private <T> void checkSearch(Matrix<T> matrix, T val, IntList ... results) {
    assertEquals(list(results), new BinarySearch<>(matrix, val).search());
  }
  
  private static IntList d(int ... array) {
    return new ArrayIntList(array);
  }
  
  @SuppressWarnings("unchecked")
  private static <T> List<T> list(T ... values) {
    return Arrays.asList(values);
  }

}
