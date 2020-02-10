 public class ArrayStack  implements Stack{
        int stack_pointer; //index of the stack
        int[] stack;

        //constructor
        public ArrayStack(){
            this.stack = new int[10];
            this.stack_pointer = 0;
        }


        /**
         * size()
         * @return
         * Function returns the size of the stack
         */
        public int size(){
//        System.out.println("size of stack: "+ stack_pointer);
            if(stack_pointer == 0){
                return 0;
            } else return stack_pointer; // + 1 ;
//        return stack_pointer-1;
        }

        /**
         * push(int)
         * @param toPush
         * Functions an integer onto the stack
         */
        public void push(int toPush) {
            //if we are at the top of the top of the stack we will double the array
            if (size() == stack.length) {
                stack = doubleArray(stack.length);
            }
            stack[stack_pointer] = toPush;
            stack_pointer++;
        }

        /**
         * pop()
         * @return int
         * Function removes and returns the top of the stack
         */
        public int pop(){

            //if the size of the stack if less than half of the array size than we reduce the size
            if(size()  < stack.length/2 && stack.length > 10){
                stack = reduceArraySize(stack.length);
            }
            //add check to ensure stack is not empty
            if(!isEmpty()){
                int popped = stack[stack_pointer-1];
                stack_pointer--;
                return popped;
            }
            System.out.println("Popped an empty stack");
            return 0;
        }

        /**
         * isEmpty()
         * @return
         * Function returns true if the stack si empty False otherwise
         */
        public boolean isEmpty(){
            if(stack_pointer > 0){
                return false;
            }
            return true;
        }

        /**
         * print()
         * function prints the contents of the stack
         */
        public void printStack(){
            for(int i = 0 ; i < stack_pointer; i++){
                System.out.println(stack[i]);
            }
        }

        /**
         * top()
         * @return
         * Function returns top of the stack
         */
        public int top(){
            if(stack_pointer > 0){
                return stack[stack_pointer-1];
            }
            return stack[stack_pointer];
        }


        /**
         * doubleArray(int)
         * @param size
         * @return array 2x the length of size
         * Function resizes the array to twice the size and copies the contents of the stack
         * onto the new array
         */
        public int[] doubleArray(int size){
            int[] doubleA = new int[2*size];
            for(int i = 0; i< stack_pointer;i++){
                doubleA[i]=stack[i];
            }
            return doubleA;
        }

        /**
         * reduceArraySize(int)
         * @param size
         * @return
         * Function shrinks the array to half its original size and copies the stack over
         */
        public int[] reduceArraySize(int size){
            int[] newA = new int[size/2];
            for(int i = 0; i< stack_pointer;i++){
                newA[i]=stack[i];
            }
            return newA;
        }

        /**
         * insertBottom
         * @param   toInsert
         * @return  void
         * Function inserts a number to the beginning to the array
         */
        public void insertBottom(int toInsert){
            //check the size of the array

            //if array length is large enough to insert without resizing then we will just copy everything to a new array
            if(stack.length - stack_pointer > 0){
                int[] new_stack = new int[stack.length];
                new_stack[0] = toInsert;
                int j = 0;
                for (int i = 1; i < stack.length;i++){
                    new_stack[i] = stack[j];
                    j++;
                }
                stack = new_stack;
                stack_pointer++;
            }
            //if not we will double the size of the array and then copy
            else {
                stack = doubleArray(stack.length);
                insertBottom(toInsert);
            }

        }

        /**
         * extractBottom()
         * @param void
         * @return void
         * Function extracts the 0th index of the array(stack) and shifts everything over one
         */
        public int extractBottom(){
            int bottom = stack[0];
            for(int i = 1; i < stack.length;i++){
                stack[i-1] = stack[i];

            }
            stack_pointer--;
            //stack[stack.length] = bottom;
            return bottom;
        }



}
