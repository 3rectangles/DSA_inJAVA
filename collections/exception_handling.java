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
