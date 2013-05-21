package de.sahnwaldt.jc.matrixBinarySearch;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void testSearch() {
    
    Matrix<Integer> matrix;
    
    Integer[] twelve = {
      1,2,3,
      4,5,6,
      7,8,9,
      10,11,12
    };
    
    matrix = new ArrayMatrix<>(d(12), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0));
    checkSearch(matrix, 2, d(1));
    checkSearch(matrix, 3, d(2));
    checkSearch(matrix, 4, d(3));
    checkSearch(matrix, 5, d(4));
    checkSearch(matrix, 6, d(5));
    checkSearch(matrix, 7, d(6));
    checkSearch(matrix, 8, d(7));
    checkSearch(matrix, 9, d(8));
    checkSearch(matrix, 10, d(9));
    checkSearch(matrix, 11, d(10));
    checkSearch(matrix, 12, d(11));
    checkSearch(matrix, 13);
    
    matrix = new ArrayMatrix<>(d(4,3), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0));
    checkSearch(matrix, 2, d(0,1));
    checkSearch(matrix, 3, d(0,2));
    checkSearch(matrix, 4, d(1,0));
    checkSearch(matrix, 5, d(1,1));
    checkSearch(matrix, 6, d(1,2));
    checkSearch(matrix, 7, d(2,0));
    checkSearch(matrix, 8, d(2,1));
    checkSearch(matrix, 9, d(2,2));
    checkSearch(matrix, 10, d(3,0));
    checkSearch(matrix, 11, d(3,1));
    checkSearch(matrix, 12, d(3,2));
    checkSearch(matrix, 13);
    
    matrix = new ArrayMatrix<>(d(3,4), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0));
    checkSearch(matrix, 2, d(0,1));
    checkSearch(matrix, 3, d(0,2));
    checkSearch(matrix, 4, d(0,3));
    checkSearch(matrix, 5, d(1,0));
    checkSearch(matrix, 6, d(1,1));
    checkSearch(matrix, 7, d(1,2));
    checkSearch(matrix, 8, d(1,3));
    checkSearch(matrix, 9, d(2,0));
    checkSearch(matrix, 10, d(2,1));
    checkSearch(matrix, 11, d(2,2));
    checkSearch(matrix, 12, d(2,3));
    checkSearch(matrix, 13);
    
    matrix = new ArrayMatrix<>(d(3,2,2), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1));
    checkSearch(matrix, 3, d(0,1,0));
    checkSearch(matrix, 4, d(0,1,1));
    checkSearch(matrix, 5, d(1,0,0));
    checkSearch(matrix, 6, d(1,0,1));
    checkSearch(matrix, 7, d(1,1,0));
    checkSearch(matrix, 8, d(1,1,1));
    checkSearch(matrix, 9, d(2,0,0));
    checkSearch(matrix, 10, d(2,0,1));
    checkSearch(matrix, 11, d(2,1,0));
    checkSearch(matrix, 12, d(2,1,1));
    checkSearch(matrix, 13);
    
    matrix = new ArrayMatrix<>(d(2,3,2), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1));
    checkSearch(matrix, 3, d(0,1,0));
    checkSearch(matrix, 4, d(0,1,1));
    checkSearch(matrix, 5, d(0,2,0));
    checkSearch(matrix, 6, d(0,2,1));
    checkSearch(matrix, 7, d(1,0,0));
    checkSearch(matrix, 8, d(1,0,1));
    checkSearch(matrix, 9, d(1,1,0));
    checkSearch(matrix, 10, d(1,1,1));
    checkSearch(matrix, 11, d(1,2,0));
    checkSearch(matrix, 12, d(1,2,1));
    checkSearch(matrix, 13);
    
    matrix = new ArrayMatrix<>(d(2,2,3), twelve);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1));
    checkSearch(matrix, 3, d(0,0,2));
    checkSearch(matrix, 4, d(0,1,0));
    checkSearch(matrix, 5, d(0,1,1));
    checkSearch(matrix, 6, d(0,1,2));
    checkSearch(matrix, 7, d(1,0,0));
    checkSearch(matrix, 8, d(1,0,1));
    checkSearch(matrix, 9, d(1,0,2));
    checkSearch(matrix, 10, d(1,1,0));
    checkSearch(matrix, 11, d(1,1,1));
    checkSearch(matrix, 12, d(1,1,2));
    checkSearch(matrix, 13);
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
