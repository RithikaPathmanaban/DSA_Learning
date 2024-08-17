
// Consider a long alley with N doors on one side. All the doors are closed initially. You move to and fro in the alley changing the states of the doors as follows:

// You open a door that is already closed, and you close a door that is already opened.
// You start at one end go on altering the state of the doors till you reach the other end, and then you come back and start altering the states of the doors again.
// In the first go, you alter the states of doors numbered 1, 2, 3, …, N.
// In the second go, you alter the states of doors numbered 2, 4, 6, ….
// In the third go, you alter the states of doors numbered 3, 6, 9 ….
// and so on…
// The above procedure will continue till the Nth turn in which you alter the state of the door numbered N. The task is to find the number of open doors at the end of the procedure.


import java.util.*;
public class Alley 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        System.out.println((int)Math.sqrt(N));
        input.close();
    }
}



