# JumpForth
JumpForth is a Java program that implements and tests a simple interpreted programming language called JumpForth.
Jump Forth is a minimal version of the FORTH language but with a few added features. 
In JumpForth there is just one data type: integer.

JumpForth programs take no inputs. Another way to think of this is that the inputs have to actually 
be embedded in the code for the program.

A JumpForth program produces either a single integer as output, or nothing at all.

JumpForth programs consist of integer constants (like 3, 0, and -23) and instructions, 
separated by spaces. The instructions have access to a data stack, which is initially empty, 
and the integer on top of the stack at the end of execution, if there is one, is the output of the program.

The interpreter steps through the code of a program, processing each item in turn. 
It does this using a program counter that starts at 0, and it adds one to the program 
counter after processing each item. A couple of instructions, if and jump, can also change the 
program counter, allowing for conditional and looping behavior. If the program counter goes out of bounds, 
then execution stops, and the top of the stack (if any) is the output. Execution also stops if we go aver 
an execution step limit, which is set to 1000000000 (one billion).

#Installation
JumpForth can be run on the command line or an IDE  provided you have java installed. 

#Usage
JumpForth can be run on the command line or an IDE. The arguments you pass in are 
what is interpreted by JumpForth.
 
Example program might be: 2 3 + 4 * 5 / 6 - \
Program Output: -2

#Authors and Acknowledgement
Professor Lee Spector at Amherst College: Provided the JumpForth language specifications as well as test cases

Javier Matos: Author