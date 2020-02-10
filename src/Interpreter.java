public class Interpreter  {
    Stack stack;
    int program_counter;
    int top; //top of the stack; return value
    String[] args;
    int numInstructions;
    int numExecutions;
    protected int EXECUTION_LIMIT = 1000000000;


    public Interpreter(String[] args, Stack stack){
        this.args = args;
        this.stack = stack;
        this.program_counter = 0;
        this.top=  0;
        this.numInstructions = 0;
        numExecutions = 0;

    }

    /**
     * execute()
     * @param
     * @return void
     * Function executes the jumpFORTH arguments according to language rules.
     * Function Prints end value to the screen
     * EXCEPTION: Throws NumberFormatException
     */

    public int execute(){
        //while the program counter is within bounds
        while(!(program_counter < 0) && !(program_counter >= args.length)){

            //increment execution counter
            numExecutions++;

            //check number of executions to make sure we havn't reached the limit
            if(numExecutions == EXECUTION_LIMIT){
                System.out.println("Limit Reached!");
                top = getTop();
                System.out.println(top);
                return top;
            }

            //try to parse argument as integer and if successful push onto stack
            try{
                int plate = Integer.parseInt(args[program_counter]);
//                System.out.println(args[program_counter]);
                stack.push(plate);
            }
            //this means it was not an integer so it must be an instruction
            catch (NumberFormatException e){
                instructions(args[program_counter]);
            }

            //if our stack is empty then the there is not return value
            //function returns 0 by default if the stack is empty along with a message
            if(stack.size()<1){
            System.out.println("Empty Stack Return value is null");
            return 0;
            }

            //increment our program counter
            ++program_counter;


        }

        top = getTop();
        System.out.println(top);
        return top;
    }
//    public int execute(){
//
////        for (program_counter = 0; program_counter < args.length; ++program_counter){
////            System.out.println("program counter: " + program_counter);
////            stack.printStack();
////            execution_limit++;
////
////            //check the program counter to ensure not over 1B instructions
////            if(execution_limit == 1000000000){
////                System.out.println("Limit Reached!");
////                top = getTop();
////                System.out.println(top);
////                return top;
////            }
////
////            //try to parse as int and if successful push onto stack
////            try{
////                int plate = Integer.parseInt(args[program_counter]);
////                System.out.println(args[program_counter]);
////                stack.push(plate);
////            }
////            //this means it was not an integer so it must be either an
////            //integer constant, instruction, or looping instruction
////            catch (NumberFormatException e){
////                //numInstructions++;
////                instructions(args[program_counter]);
////            }
////
////
////        }
////        if(stack.size()<1){
////            System.out.println("Empty Stack Return value is null");
////            return 0;
////        }
////        top = getTop();
////        System.out.println(top);
////        return top;
//    }

    /**
     * instructions()
     * @param  instruction
     * @return void
     * Function determines what kind of instruction it is and calls the appropriate function
     * to handle that instruction
     */
    public void instructions(String instruction){
        String inst = instruction;
//        System.out.println("program counter: " + program_counter);
//        stack.printStack();
//        System.out.println(inst);

//        System.out.println("program counter: " + program_counter);

        switch(inst){
            case "+":
                add();
                break;
            case "-":
                subtract();
                break;
            case "*":
                multiply();
                break;
            case "/":
                divide();
                break;
            case "dup":
                dup();
                break;
            case "drop":
                drop();
                break;
            case "swap":
                swap();
                break;
            case "rot":
                rot();
                break;
            case "=":
                equal();
                break;
            case "<":
                lessThan();
                break;
            case ">":
                greaterThan();
                break;
            case "jump":
                jump();
                break;
            case "if":
                ifStatement();
                break;
            case "yank":
                yank();
                break;
            case "shove":
                shove();
                break;

        }

    }
    /**
     * add()
     * Function pops two items from the stack and pushes their sum
     */
    public void add(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        stack.push(top+bottom);
    }
    /**
     * subtract()
     * Function pops two items from the stack and pushes the second minus the top
     */
    public void subtract(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        stack.push(bottom-top);
    }

    /**
     * multiply
     *Function pops two items from the stack and pushes their product
     */
    public void multiply(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        stack.push(top*bottom);
    }
    /**
     * divide
     *  Function pops two items from the stack and pushes the second divided by the top
     */
    public void divide(){
//        System.out.println("stack size: "+stack.size());
        if(stack.size() < 2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        stack.push(bottom/top);

    }
    /**
     * dup
     * Function pushes another copy of the top onto the stack
     */
    public void dup(){
        if(stack.size()<1){
            return;
        }
        int top = stack.pop();
        stack.push(top);
        stack.push(top);
    }

    /**
     * drop
     * Function pops and discards the top item
     */
    public void drop(){
        if(stack.size()<1){
            return;
        }
        stack.pop();
    }

    /**
     * swap
     * Function switches the order of the top two items
     */
    public void swap(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        stack.push(top);
        stack.push(bottom);
    }

    /**
     * rot
     * Function moves the third item to the top (over the previous top)
     */
    public void rot(){
        if(stack.size()<3){
            return;
        }
        int first = stack.pop();
        int second = stack.pop();
        int third = stack.pop();
        stack.push(second);
        stack.push(first);
        stack.push(third);
    }

    /**
     * equal
     * Function pops two items and pushes 1 if they are equal and 0 if they are not
     */
    public void equal(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        if ( top == bottom){
            stack.push(1);
        }else{
            stack.push(0);
        }
    }

    /**
     * lessThan
     * Function pops two items and pushes 1 if the one that was deeper is less than the top, or 0 otherwise
     */
    public void lessThan(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();
        int bottom = stack.pop();
        if ( bottom < top){
            stack.push(1);
        }else{
            stack.push(0);
        }
    }

    /**
     * greaterThan
     * Function pop two items and pushes a 1 if the one that was deeper is greater than the top, or 0 otherwise
     */
    public void greaterThan(){
        if(stack.size()<2){
            return;
        }
        int top = stack.pop();

        int bottom = stack.pop();
        if ( bottom > top){
            stack.push(1);
        }else{
            stack.push(0);
        }
    }

    /**
     * jump
     * Function pops one item and adds it to the program counter
     */
    public void jump(){
        if(stack.size()<1){
            return;
        }
        int top = stack.pop();
        program_counter += top;
        // program_counter++;
    }

    /**
     * ifStatement
     * Function pops one item and does nothing if it is greater than 0, if it is 0 or negative it adds one to the
     * program counter and skip the next instruction
     */
    public void ifStatement(){
        if(stack.size()<1){
            return;
        }
        int top = stack.pop();
        if(top <= 0){
            program_counter++;
            // program_counter++;
        }
    }

    public int getTop(){

        top = stack.top();
        return top;
    }

    /**
     * print()
     * @param
     * @return void
     * function prints the program_counter. In other words, it prints the results of the jumpFORTH program
     */
    public void print(){
        System.out.println("Results: "+ program_counter);
    }

    /**
     * yank()
     * @param
     * @return void
     * Functions extracts the bottom of the stack and pushes it to the top
     */
    public void yank(){
        int bottom = stack.extractBottom();
        stack.push(bottom);
    }
    /**
     * shove()
     * @param
     * @return void
     * Functions pops the top of the stack and inserts it at the bottom
     */
    public void shove(){
        int stack_top = stack.pop();
        stack.insertBottom(stack_top);
    }

}
