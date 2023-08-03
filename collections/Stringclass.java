package collections;

import java.util.Scanner;

public class Stringclass {

    public static void main(String[] args) {
        String s="trialiaia";
        System.out.println();
       String sub = s.substring(2,s.length());

       // substring
        System.out.println((sub));
        for (int i = 0; i <s.length() ; i++) {
            System.out.println(s.substring(i,s.length()));
        }

        //indexof
        System.out.printf("first occurance:  %d last occirance: %d %n", s.indexOf("ia"), s.lastIndexOf("ia"));


        String s3= new String("string object");
        String s4 ="string object";

     //  Since s3 is created using the new keyword, it points to a different object than the one pointed to by s4, which is a string literal.
     //  So, this condition will be false, and the code inside this block will not be executed.

     if (s3 == s4 ) {
            System.out.println("literal");
        } else if (s3.equals(s4)) {
            System.out.println("value is smae ");
        }

     // s3.equals(s4): This checks if the values of s3 and s4 are the same.
     // The equals() method compares the content of the strings, not their memory references.
     // In this case, both s3 and s4 have the same value "string object",
     // so this condition will be true, and the code inside this block will be executed.
     //
        // contains

     // The contains() method in Java checks if a particular substring is present within the original string.
     // If it finds the substring, it returns true, and if the substring is not found, it returns false.
        if (s3.contains("obj"))
            System.out.println("wokrng of contains");
        String upper =s3.toUpperCase();
        System.out.println(upper);

        // replace: makes new string, replaces all instance of matched word
        String r ="i love pina qwert pina";
        String newr= r.replace("pina","coloda");
        System.out.println(newr);
        System.out.println(r.replace("a","1"));
        int no=12345;
        String change= no+"";
        String changestr="123456";
        System.out.println(changestr==change);
        //its same as
        int[] arr={1,2,3,4,5};
       // arr.to
        System.out.println(arr+"added");  //[I@4f3f5b24added calls arrays tostring function
        System.out.println(arr.toString()+"addded");  //[I@4f3f5b24added calls arrays tostring function




        // string builder class: mutable stings--> to prevent memory
//        String sb = new StringBuilder("string");
        StringBuilder sb = new StringBuilder("qwe");
        System.out.println(sb+"rty"); //qwerty
        sb.insert(1,"yolo"); //qyolowe
        System.out.println(sb);

       // sb.replace();
        sb.delete(3,5);
        String sbstr = sb.toString();
        System.out.println(sbstr); //qyowe
        sb.reverse();
        sb.delete(0,sb.length());
        sb.append("abccba");
        String sbrev =sb.reverse().toString();
        System.out.println(sb + "  " +sbrev); // abccba  abccba

         Scanner sc;
         sc = new Scanner(System.in);
         String pal;
         // pal =sc.next();
         pal="123321";
         StringBuilder sbpal = new StringBuilder(pal);
         String rev = sbpal.reverse().toString();
         if(pal.equals(rev))
           System.out.println("palindrome");

        /**
         * following incorrect because it compares pal (a String) with the reversed StringBuilder object directly,
         * without converting it back to a string.
         * This will not give the correct result.
         */
        if(pal.equals(sbpal.reverse()))
           System.out.println("palindrome test");
         // end

     // STRING TO ARRRAy
        String arrstr= "exmaple";
        char[] arr1= arrstr.toCharArray();
        System.out.println(arr1); //exmaple
        String ex1 = arr1.toString();
     for (char x: arr1) {
      System.out.print(x); //exmaple
     }

        // Array to string

        System.out.println(ex1); //[C@4edde6e5
     String ex2 = new String(arr1);

     System.out.println(ex2);

    }



}
