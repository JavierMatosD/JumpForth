public class ListStack extends DoubleLinkedList implements Stack{
    int counter = 0;
    DoubleLinkedList stack = new DoubleLinkedList();

    /**
     * size
     * function returns the size of the stack
     * @return
     */
    public int size(){
        return counter;
    }

    /**
     * push
     * @param toPush
     * Function pushes to the stack
     */
    public void push(int toPush){
        stack.add(toPush);
        counter++;
    }

    /**
     * pop
     * @return
     * Function pops the stack
     */
    public int pop(){
        if(counter > 0){
            int removed = stack.remove();
            counter --;
            return removed;
        }
        return 0;
    }

    /**
     * printStack
     * Function prints the stack
     */
    public void printStack(){
        stack.print();
    }

    /**
     * top()
     * @return
     * Function returns the top of the stack
     */
    public int top(){
        if(stack.tail != null) {
            return stack.tail.data;
        }
        return stack.head.data;

    }

    /**
     * insertBottom
     * @param toInsert
     * Function inserts to the bottom of the stack
     */
    public void insertBottom(int toInsert) {
        stack.addToHead(toInsert);
        counter++;
    }


    /**
     * extractBottom
     * @return
     * Function pulls the bottom of the stack
     */
    public int extractBottom() {
        int bottom = stack.removeFromBottom();
        counter--;
        return bottom;
    }

    /**
     * isEmpty
     * @return
     * Function returns true if the stack is empty
     */
    public boolean isEmpty() {
        if(head == null && tail == null){
            return true;
        }
        return false;
    }
}

