public class DoubleLinkedList {
    Node head;
    Node tail;

    //constructor
    public DoubleLinkedList(){
        this.head=this.tail=null;
    }

    //node class for double linked list
    class Node{
        int data;
        Node prev;
        Node next;
        //constructor for Node
        Node(int d) {this.data = d; this.prev = this.next = null;}
    }

    /**
     * add()
     * @param toAdd
     * Function adds a node to the list
     */
    public void add(int toAdd){
        Node newN = new Node(toAdd);
        //three cases
        //1. head and tail is null
        if(head==null && tail == null){
            head = newN;
        }
        //head is not null tail is null
        else if (head!= null && tail == null){
            tail = newN;
            tail.prev = head;
            head.next = tail;
        }
        //3. neither head or tail is null
        else{
            tail.next = newN;
            newN.prev = tail;
            tail = tail.next;
        }
    }

    /**
     * addToBottom
     * @param toAdd
     * @return void
     * Function adds a new node to the head of the list
     */
    public void addToHead(int toAdd){

        Node newNode = new Node(toAdd);
        //empty list
        if(head == null && tail ==null){
            head = newNode;
        }
        //list has one item
        if(head!= null && tail == null){
            tail = head;
            head = newNode;
            head.next = tail;
            tail.prev = head;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = head.prev;
        }
    }

    /**
     * remove()
     * @return int
     * Function removes a node from the list and returns its value
     */
    public int remove(){
        //this list is empty
        if (head == null){
            System.out.println("EMPTY!");
            return 0;
        }
        if(tail == null){
            int popped = head.data;
            head = null;
            return popped;
        }
        if(tail.prev != head){
            int popped = tail.data;
            tail = tail.prev;
            tail.next = null;
            return popped;
        }

        if (tail.prev == head){
            int popped = tail.data;
            tail = null;
            return popped;
        }

        return 1;
    }

    /**
     * removeFromBottom()
     * @param
     * @return void
     * Function removes the head of the list and returns its value (head.next is the new head)
     */
    public int removeFromBottom(){
        //list has one item
        if(head != null && tail == null){
            remove();
        }else{ //more than one item
            int bottom = head.data;
            head = head.next;
            head.prev = null;
            return bottom;
        }
        return 1;
    }



    /**
     * print()
     * Function prints the stack
     */
    public void print(){
        Node temp = head;
        while( temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }
}
