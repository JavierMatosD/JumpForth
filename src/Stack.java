public interface Stack {

    //returns the size of the stack
    public int size();

    //pushes onto the stack
    public void push(int toPush);

    //pops off the stack
    public int pop();

    //prints the stack
    public void printStack();

    //returns the top of the stack
    public int top();

    //inserts to bottom of the stack
    public void insertBottom(int toInsert);

    //pulls from bottom of the stack
    public int extractBottom();

    //returns true if stack is empty
    public boolean isEmpty();

}
