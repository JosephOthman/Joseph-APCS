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

public class MRKPirateBae  {
  public static void main(String[] args) {
    Finn<Integer> elevens = new Finn<Integer>();
    elevens.addFirst(1);
    elevens.addFirst(2);
    elevens.addFirst(3);
    elevens.addFirst(4);
    elevens.addFirst(5);
    elevens.addLast(6);
    elevens.addLast(7);
    elevens.addLast(8);
    elevens.addLast(9);
    elevens.addLast(10);
    System.out.println(elevens);

    System.out.println(elevens.removeFirst());
    System.out.println(elevens.removeLast());
    System.out.println(elevens);

    System.out.println(elevens.getFirst());
    System.out.println(elevens.getLast());
    System.out.println(elevens.size());
    System.out.println(elevens.isEmpty());
  }
}
