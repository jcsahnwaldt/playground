package de.sahnwaldt.jc.matrixSearch;

public interface IntList
{
  public int size();
  
  public int get(int dimension);

  public void set(int dimension, int value);
  
  public boolean compareAll(IntList that, int compare);
  
  public boolean compareAny(IntList that, int compare);
}
