package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Function {

   static int c =777;
    public static String add(int a, String b) // Method Overlading
    {
        String s = b.toLowerCase() + a + c;
        return s;
    }
    public static String add( String a, int b)  // Method Overlading
    {
        return  a.toUpperCase()+b +c;
    }


    public static void call(){
        System.out.println(add(23,"QweRtY"));
        System.out.println(add("QweRtY",24));
    }


    // variable arguments

    public static void variable(int k, int ...arr){
        System.out.printf("length of array %d%n", arr.length);
        System.out.println(arr.getClass()); // class [I
        System.out.println(arr.getClass().getSimpleName()); //int[]
        String a = arr.toString();
        String b = Arrays.toString(arr);
        System.out.println(a+" "+b); //[I@7ef20235 [1, 2, 3, 4, 5]
        System.out.println(k);

    }

    public static void main(String[] args) {
        call();
        variable(6,1,2,3,4,5);



    }
}



