package de.sahnwaldt.jc.matrixBinarySearch;


public abstract class AbstractIntList
implements IntList
{
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (! (obj instanceof IntList)) return false;
    IntList that = (IntList)obj;
    if (this.size() != that.size()) return false;
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i) != that.get(i)) return false;
    }
    return true;
  }
  
  @Override
  public int hashCode() {
    int result = 1;
    for (int i = 0; i < this.size(); i++) {
      result = 31 * result + this.get(i);
    }
    return result;
  }
  
  @Override
  public String toString() {
    boolean first = true;
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < this.size(); i++) {
      if (first) first = false; else sb.append(", ");
      sb.append(this.get(i));
    }
    sb.append(']');
    return sb.toString();
  }

  @Override
  public boolean compareAll(IntList that, int compare) {
    if (this.size() != that.size()) throw new IllegalArgumentException("expected "+this.size()+" elements, found "+that.size());
    for (int i = 0; i < this.size(); i++) {
      if (Integer.compare(this.get(i), that.get(i)) != compare) return false;
    }
    return true;
  }

  @Override
  public boolean compareAny(IntList that, int compare) {
    if (this.size() != that.size()) throw new IllegalArgumentException("expected "+this.size()+" elements, found "+that.size());
    for (int i = 0; i < this.size(); i++) {
      if (Integer.compare(this.get(i), that.get(i)) == compare) return true;
    }
    return false;
  }

}
