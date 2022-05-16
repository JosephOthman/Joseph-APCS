import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
  /**
    ArrayPriorityQueue class
      IVs
        - ArrayList<>() al
        +
      Methods
        -
        +
  */

  private ArrayList<Integer> al;
  public int size;

  public ArrayPriorityQueue() {
    al = new ArrayList<Integer>();
    size = 0;
  }

  public void add(int x) {
    if (isEmpty()) {
      al.add(0, x);
    }
    else {
      int ind = al.size();
      while (ind > 0 && al.get(ind-1) < x) {
        ind--;
      }
      al.add(ind, x);
    }
    size++;
  }

  public boolean isEmpty() {
    return al.size() == 0;
  }

  public int peekMin() {
    return al.get(al.size() - 1);
  }

  public int removeMin() {
    size--;
    return al.remove(al.size() - 1);
  }

  public int size() {
    return al.size();
  }

  public String toString() {
    String retVal = "{";
    for(int i = 0; i<=al.size()-1; i++) {
      retVal += al.get(i);
      retVal += " ";

    }
     retVal += "}";
    return retVal;
  }

  public static void main(String[] args) {
    ArrayPriorityQueue KDubs = new ArrayPriorityQueue();
    KDubs.add(4);
    KDubs.add(3);
    KDubs.add(3);
    KDubs.add(2);
    KDubs.add(1);
    KDubs.add(4);
    KDubs.add(5);
    System.out.println(KDubs);
    System.out.println(KDubs.removeMin());
    System.out.println(KDubs.peekMin());
    System.out.println(KDubs);
  }
}
