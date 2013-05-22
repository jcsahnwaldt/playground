package de.sahnwaldt.jc.matrixBinarySearch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void testSearchSingle() {
    
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

  @Test
  public void testSearchMultiple() {
    
    Matrix<Integer> matrix;
    
    Integer[] _12 = {
      1,2,2,3,3,3,4,4,4,5,5,6
    };
    
    matrix = new ArrayMatrix<>(d(12), _12);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0));
    checkSearch(matrix, 2, d(1), d(2));
    checkSearch(matrix, 3, d(3), d(4), d(5));
    checkSearch(matrix, 4, d(6), d(7), d(8));
    checkSearch(matrix, 5, d(9), d(10));
    checkSearch(matrix, 6, d(11));
    checkSearch(matrix, 7);
    
    Integer[] _4_3 = {
      1,2,3,
      2,3,4,
      3,4,5,
      4,5,6
    };
    
    matrix = new ArrayMatrix<>(d(4,3), _4_3);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0));
    checkSearch(matrix, 2, d(0,1), d(1,0));
    checkSearch(matrix, 3, d(0,2), d(1,1), d(2,0));
    checkSearch(matrix, 4, d(1,2), d(2,1), d(3,0));
    checkSearch(matrix, 5, d(2,2), d(3,1));
    checkSearch(matrix, 6, d(3,2));
    checkSearch(matrix, 7);
    
    Integer[] _3_4 = {
      1,2,3,4,
      2,3,4,5,
      3,4,5,6
    };
      
    matrix = new ArrayMatrix<>(d(3,4), _3_4);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0));
    checkSearch(matrix, 2, d(0,1), d(1,0));
    checkSearch(matrix, 3, d(0,2), d(1,1), d(2,0));
    checkSearch(matrix, 4, d(0,3), d(1,2), d(2,1));
    checkSearch(matrix, 5, d(1,3), d(2,2));
    checkSearch(matrix, 6, d(2,3));
    checkSearch(matrix, 7);
    
    Integer[] _3_2_2 = {
      1,2,
      2,3,
      
      2,3,
      3,4,
      
      3,4,
      4,5
    };
      
    matrix = new ArrayMatrix<>(d(3,2,2), _3_2_2);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1), d(0,1,0), d(1,0,0));
    checkSearch(matrix, 3, d(0,1,1), d(1,0,1), d(1,1,0), d(2,0,0));
    checkSearch(matrix, 4, d(1,1,1), d(2,0,1), d(2,1,0));
    checkSearch(matrix, 5, d(2,1,1));
    checkSearch(matrix, 6);
    
    Integer[] _2_3_2 = {
      1,2,
      2,3,
      3,4,
      
      2,3,
      3,4,
      4,5
    };
      
    matrix = new ArrayMatrix<>(d(2,3,2), _2_3_2);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1), d(0,1,0), d(1,0,0));
    checkSearch(matrix, 3, d(0,1,1), d(0,2,0), d(1,0,1), d(1,1,0));
    checkSearch(matrix, 4, d(0,2,1), d(1,1,1), d(1,2,0));
    checkSearch(matrix, 5, d(1,2,1));
    checkSearch(matrix, 6);
    
    Integer[] _2_2_3 = {
      1,2,3,
      2,3,4,
      
      2,3,4,
      3,4,5
    };
      
    matrix = new ArrayMatrix<>(d(2,2,3), _2_2_3);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0));
    checkSearch(matrix, 2, d(0,0,1), d(0,1,0), d(1,0,0));
    checkSearch(matrix, 3, d(0,0,2), d(0,1,1), d(1,0,1), d(1,1,0));
    checkSearch(matrix, 4, d(0,1,2), d(1,0,2), d(1,1,1));
    checkSearch(matrix, 5, d(1,1,2));
    checkSearch(matrix, 6);
    
    // four dimensions
    Integer[] _2_2_2_2 = {
      // cube 0
      1,2,
      2,3,
      
      2,3,
      3,4,
      
      // cube 1 (> cube 0)
      2,3,
      3,4,
      
      3,4,
      4,5
    };
    
    matrix = new ArrayMatrix<>(d(2,2,2,2), _2_2_2_2);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0,0));
    checkSearch(matrix, 2, d(0,0,0,1), d(0,0,1,0), d(0,1,0,0), d(1,0,0,0));
    checkSearch(matrix, 3, d(0,0,1,1), d(0,1,0,1), d(0,1,1,0), d(1,0,0,1), d(1,0,1,0), d(1,1,0,0));
    checkSearch(matrix, 4, d(0,1,1,1), d(1,0,1,1), d(1,1,0,1), d(1,1,1,0));
    checkSearch(matrix, 5, d(1,1,1,1));
    checkSearch(matrix, 6);

    // five dimensions
    Integer[] _2_2_2_2_2 = {
      // cube 0,0
      1,2,
      2,3,
      
      2,3,
      3,4,
      
      // cube 0,1 (> cube 0,0)
      2,3,
      3,4,
      
      3,4,
      4,5,
      
      // cube 1,0 (> cube 0,0)
      2,3,
      3,4,
      
      3,4,
      4,5,
      
      // cube 1,1 (> cube 0,1 & 1,0)
      3,4,
      4,5,
      
      4,5,
      5,6
    };
      
    matrix = new ArrayMatrix<>(d(2,2,2,2,2), _2_2_2_2_2);
    
    checkSearch(matrix, 0);
    checkSearch(matrix, 1, d(0,0,0,0,0));
    checkSearch(matrix, 2, d(0,0,0,0,1), d(0,0,0,1,0), d(0,0,1,0,0), d(0,1,0,0,0), d(1,0,0,0,0));
    checkSearch(matrix, 3, d(0,0,0,1,1), d(0,0,1,0,1), d(0,0,1,1,0), d(0,1,0,0,1), d(0,1,0,1,0), d(0,1,1,0,0), d(1,0,0,0,1), d(1,0,0,1,0), d(1,0,1,0,0), d(1,1,0,0,0));
    checkSearch(matrix, 4, d(0,0,1,1,1), d(0,1,0,1,1), d(0,1,1,0,1), d(0,1,1,1,0), d(1,0,0,1,1), d(1,0,1,0,1), d(1,0,1,1,0), d(1,1,0,0,1), d(1,1,0,1,0), d(1,1,1,0,0));
    checkSearch(matrix, 5, d(0,1,1,1,1), d(1,0,1,1,1), d(1,1,0,1,1), d(1,1,1,0,1), d(1,1,1,1,0));
    checkSearch(matrix, 6, d(1,1,1,1,1));
    checkSearch(matrix, 7);
  }
  
  /**
   * Test matrix with 12 ^ 6 = 2,985,984 elements.
   */
  @Test
  public void testHuge() {
    
    long nanos;
    
    nanos = System.nanoTime();
        
    int max = 67; // max value 6 * 11 + 1
    // add two elements: check that 0 and 68 are not in matrix
    List<Set<IntList>> positions = new ArrayList<>(max + 2);
    for (int val = 0; val < max + 2; val++) {
      positions.add(new HashSet<IntList>());
    }
    
    Integer[] values = new Integer[2985984];
    for (int d0 = 0; d0 < 12; d0++) {
      for (int d1 = 0; d1 < 12; d1++) {
        for (int d2 = 0; d2 < 12; d2++) {
          for (int d3 = 0; d3 < 12; d3++) {
            for (int d4 = 0; d4 < 12; d4++) {
              for (int d5 = 0; d5 < 12; d5++) {
                int index = (((((d0)*12+d1)*12+d2)*12+d3)*12+d4)*12+d5;
                int val = d0+d1+d2+d3+d4+d5+1;
                values[index] = val;
                positions.get(val).add(d(d0,d1,d2,d3,d4,d5));
              }
            }
          }
        }
      }
    }
    
    Matrix<Integer> matrix = new ArrayMatrix<>(d(12,12,12,12,12,12), values);
    
    nanos = System.nanoTime() - nanos;
    
    System.out.println("building matrix: "+(nanos / 1000000000F)+" seconds");

    nanos = System.nanoTime();
    
    for (int val = 0; val < max + 2; val++) {
      checkSearch(matrix, val, positions.get(val));
    }
    
    nanos = System.nanoTime() - nanos;
    
    System.out.println("binary search: "+(nanos / 1000000000F)+" seconds");
  }

  private <T> void checkSearch(Matrix<T> matrix, T val, IntList ... results) {
    checkSearch(matrix, val, new HashSet<>(list(results)));
  }
  
  private <T> void checkSearch(Matrix<T> matrix, T val, Set<IntList> results) {
    checkSearch(new BinarySearch<>(matrix, val), results);
  }
  
  private <T> void checkSearch(MatrixSearch<T> search, Set<IntList> results) {
    assertEquals(results, new HashSet<>(search.search()));
  }
  
  private static IntList d(int ... array) {
    return new ArrayIntList(array);
  }
  
  @SuppressWarnings("unchecked")
  private static <T> List<T> list(T ... values) {
    return Arrays.asList(values);
  }

}
