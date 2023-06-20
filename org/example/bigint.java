package org.example;

import java.math.BigInteger;

public class bigint {
    public static void main(String[] args) {
       // String q = (String)Math.pow(10,20);
        BigInteger base = new BigInteger("10");
       int ex = 20; // primitive datatypes or wrapper class

        BigInteger a = base.pow(ex);
        System.out.println(a);
        int b=1;
       // System.out.println(a.add(new BigInteger(b)));


        BigInteger y = new BigInteger(100 + ""); //BigINteger takes string only

    }
}
