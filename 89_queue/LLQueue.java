/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW89 --
2022-04-11
time spent: 0.4 hrs

DISCO:
- "push-thru" code is where we use the funcitonality of a different class to do
all the work for us.
- Hypothesis: Linked Lists work better with queues, since we can enqueue and dequeue
both in O(1) time.

QCC:
- When to use AL or LL queues as opposed to the other queues we coded?

**/
import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {
  LinkedList<T> L = new LinkedList<T>();

  public T dequeue() {
    T retVal = L.get(0);
    L.remove();
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

    Queue<Integer> Adi = new LLQueue<Integer>();
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


    Queue<String> wu = new LLQueue<String>();
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
