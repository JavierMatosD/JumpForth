/**
 * @author Javier Matos Denizac
 * JumpForth Interpreter
 */


public class Main {


    public static void main(String[] args) {
        int BILLION = 1000000000;
        long start = System.nanoTime();
        Stack stack = new ArrayStack();
//        Stack stack = new ListStack();
        Interpreter program = new Interpreter(args, stack);
        program.execute();
        System.out.println("Runtime: " + (System.nanoTime() - start) + " Nanoseconds" + " or approx " + (System.nanoTime() - start)/BILLION + " second(s)");
        System.out.println("Number of executions: " + program.numExecutions);
    }

}
/*
                Linked List Implementation
Program output for double linked list implementation of JumpForth language (COLLABORATIVE PORTION):
Input: 1 dup dup 1 + dup 100000 < -10 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Runtime: 1606507317 Nanoseconds or approx 1 second(s)
Number of executions: 1,349,648

                Array Implementation
program output for array implementation of JumpForth language (COLLABORATIVE PORTION):
Input: 1 dup dup 1 + dup 100000 < -10 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Runtime: 1571527552 Nanoseconds or approx 1 second(s)
Number of executions: 1,349,648

             Linked List Implementation
Program output for double linked list implementation of JumpForth language (INDIVIDUAL PORTION):
Input: 1 dup dup 1 + dup 5 shove yank drop 100000 < -15 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Runtime: 2526485865 Nanoseconds or approx 2 second(s)
Number of executions: 2,199,292

                Array Implementation
program output for array implementation of JumpForth language (INDIVIDUAL PORTION):
Input: 1 dup dup 1 + dup 5 shove yank drop 100000 < -15 swap if jump drop 100 > -7 swap if jump drop
Output: 99
Runtime: 19481251283 Nanoseconds or approx 19 second(s)
Number of executions: 2,199,292
 */