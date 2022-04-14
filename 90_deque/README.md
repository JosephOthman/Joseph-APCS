PLAN / METHODS TO IMPLEMENT
* addFirst, addLast
* getFirst, getLast
* removeFirst, removeLast
* size
* isEmpty

We decided to use LinkedList because ArrayList would have methods with O(n) runtime, such as add and remove.
With LinkedList, these methods have O(1) runtime.

We chose to implement these methods because they are the most fundamental of a Deque. Adding, removing, and
getting at either side are completely necessary. Size and isEmpty are also helpful since they can allow us
to catch errors like when the Deque is empty.
