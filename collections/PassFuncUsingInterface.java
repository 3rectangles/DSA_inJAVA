/**
 * This class demonstrates the use of lambda expressions to pass functions as parameters.
 * Instead of implementing a class and passing its object to the function, we can directly
 * pass a function using Java's lambda expressions or anonymous classes.
 */
package collections;

interface MyFunction {
    int apply(int value);
}

public class PassFuncUsingInterface {

    public static void main(String[] args) {
        MyFunction squareFunction = (x) -> {
            System.out.println("making a lambda");
            return x * x;
        };
        int result = applyFunction(6, squareFunction);
        System.out.println("\n\nSquare of 6 is: " + result);
    }

    public static int applyFunction(int value, MyFunction function) {
        return function.apply(value);
    }
}
