package de.sahnwaldt.jc.matrixBinarySearch;

import java.util.Arrays;

public class ArrayDimensions
implements Dimensions
{
  private final int[] dimensions;
  
  private final boolean mutable;
  
  public ArrayDimensions(int count) {
    dimensions = new int[count];
    mutable = true;
  }
  
  public ArrayDimensions(Dimensions that, boolean mutable) {
    dimensions = new int[that.count()];
    for (int d = 0; d < dimensions.length; d++) {
      dimensions[d] = that.get(d);
    }
    this.mutable = mutable;
  }
  
  @Override
  public int count() {
    return dimensions.length;
  }

  @Override
  public int get(int dimension) {
    return dimensions[dimension];
  }

  @Override
  public void set(int dimension, int value) {
    if (! mutable) throw new IllegalStateException("immutable");
    dimensions[dimension] = value;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (obj.getClass() != this.getClass()) return false;
    ArrayDimensions that = (ArrayDimensions)obj;
    return Arrays.equals(this.dimensions, that.dimensions);
  }
  
  @Override
  public int hashCode() {
    return Arrays.hashCode(dimensions);
  }
  
  @Override
  public String toString() {
    return Arrays.toString(dimensions);
  }
  
}
