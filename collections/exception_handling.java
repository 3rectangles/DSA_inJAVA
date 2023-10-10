package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exception_handling {
    public static void main(String[] args) {




        String s = "22.1234.234.23";
        Solution ob = new Solution();
        try{
            ob.validIPAddress(s);
        }
        catch ( MyException e){
            System.out.println(e);
        }

    }

}



class Solution {
    public String validIPAddress(String queryIP) throws MyException{


        String[] tokens = queryIP.split("\\."); // split using '.' as delimeter
        System.out.println(Arrays.toString(Arrays.stream(tokens).toArray()));


        try{
            int a = Integer.parseInt(queryIP); // check if string is valid integer
            System.out.println("valid format to be converted to string");
            if(a> 20)
                throw  new MyException("greater than 20");
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }


        return "valid";

    }
}

class MyException extends Exception{
    MyException(String msg){
        super(msg);
    }
}

/**
 It's important to note that catch blocks should be ordered from the most specific (subtypes),
 exceptions to the most generic (superclasses) exceptions.
 This is because Java will choose the first matching catch block it encounters.
 If you put the catch block for Exception before more specific catch blocks, the specific exceptions will never be caught because Exception will catch them first.



 * */




class Example {
    public static void DevideByZero(String[] args) {
        try {
            // Code that may throw exceptions
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // This block will execute because the exception thrown is ArithmeticException
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (NullPointerException e) {
            // This block will not execute because the exception type doesn't match
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (Exception e) {
            // This block will not execute because the previous catch block already handled the exception
            System.out.println("Generic Exception caught: " + e.getMessage());
        }

        // Code continues here after the try-catch blocks
        System.out.println("Program continues...");
    }
}
