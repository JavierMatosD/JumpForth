/**
 * @author Javier Matos Denizac
 * JumpForth Interpreter
 */


public class Main {


    public static void main(String[] args) {
        long start = System.nanoTime();
        Stack stack = new ArrayStack();
//        Stack stack = new ListStack();
        Interpreter program = new Interpreter(args, stack);
        program.execute();
        System.out.println("Runtime: " + (System.nanoTime() - start));
    }

}
/*
                Linked List Implementation
Program output for double linked list implementation of JumpForth language (COLLABORATIVE PORTION):
Input: 1 dup dup 1 + dup 100000 < -10 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Time in nano seconds: 1650932898

                Array Implementation
program output for array implementation of JumpForth language (COLLABORATIVE PORTION):
Input: 1 dup dup 1 + dup 100000 < -10 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Time in nano seconds: 1603312168

             Linked List Implementation
Program output for double linked list implementation of JumpForth language (INDIVIDUAL PORTION):
Input: 1 dup dup 1 + dup 5 shove yank drop 100000 < -15 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Time in nano seconds:2439860669

                Array Implementation
program output for array implementation of JumpForth language (INDIVIDUAL PORTION):
Input: 1 dup dup 1 + dup 5 shove yank drop 100000 < -15 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Time in nano seconds: 20202362814
 */