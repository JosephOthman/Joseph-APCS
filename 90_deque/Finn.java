/***
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW90 --
2022-04-12
time spent: 0.5 hrs
DISCO:
-
QCC:
- Do we need methods on the interface such as offer and poll?

**/
import java.util.LinkedList;

public class Finn<T> implements Deque<T> {
  public LinkedList jake = new LinkedList<T>();


  public void addFirst(T x){
    jake.add( 0, x );
  }

  public void addLast(T x){
    jake.add(x);
  }

  public T removeFirst(){
    T retVal = (T) jake.getFirst();
    jake.remove(0);
    return retVal;
  }

  public T removeLast(){
    T retVal = (T) jake.getLast();
    jake.remove(jake.size() - 1);
    return retVal;
  }

  public T getFirst(){
    return (T) jake.getFirst();
  }

  public T getLast(){
    return (T) jake.getLast();
  }

  public int size(){
    return jake.size();
  }

  public boolean isEmpty(){
    return jake.isEmpty();
  }

  public String toString(){
    String output = "Front --> ";
    output += jake.toString();
    output += " <-- Back";
    return output;
  }
}
