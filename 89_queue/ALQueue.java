/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW89 --
2022-04-11
time spent: 0.4 hrs

DISCO:
- Queues follow the FIFO formula, meaning that the first thing entered is the first
thing leaving.
- Queues are basically just backwards linked lists. We add behind instead of at the
front, and we pop off the front instead of the back.

QCC:
- When to use queue vs llist vs stack?

**/
import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {
  ArrayList<T> L = new ArrayList<T>();

  public T dequeue() {
    T retVal = L.get(0);
    L.remove(0);
    return retVal;
  }

  public void enqueue( T x ) {
    L.add(x);
  }

  public boolean isEmpty() {
    return (L.size() == 0);
  }

  public T peekFront() {
    T retVal = L.get(0);
    return retVal;
  }

  public String toString() {
    String k = L.toString();
    return k;
  }



  public static void main(String[] args) {

    Queue<Integer> Adi = new ALQueue<Integer>();
    Adi.enqueue(1);
    Adi.enqueue(2);
    Adi.enqueue(3);
    Adi.enqueue(4);
    Adi.enqueue(5);
    Adi.enqueue(6);
    Adi.enqueue(7);
    //System.out.println(Adi);
    while(!Adi.isEmpty()) {
      System.out.println(Adi.peekFront());
      Adi.dequeue();
    }


    Queue<String> wu = new ALQueue<String>();
    wu.enqueue("RZA");
    wu.enqueue("GZA");
    wu.enqueue("ODB");
    wu.enqueue("Inspectah Deck");
    wu.enqueue("Raekwon the Chef");
    wu.enqueue("U-God");
    wu.enqueue("Ghostface");
    wu.enqueue("Method Man");
    System.out.println(wu);
    while(!wu.isEmpty()) {
      System.out.println(wu.peekFront() + " raps for the Wu");
      wu.dequeue();
    }
  }

}
