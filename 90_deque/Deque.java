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
public interface Deque<T> {
  public void addFirst(T x);//adds element at first index

  public void addLast(T x);//adds element at last index

  public T removeFirst();//removes element at first index
  
  public T removeLast();//removes element at last index

  public T getFirst();//gets value of first element

  public T getLast();//gets value of last element

  public int size();//returns size of the LinkedList

  public boolean isEmpty();//returns true if LL is empty, false if not empty


}
