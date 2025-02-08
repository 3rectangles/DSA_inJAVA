package collections;
import java.util.function.Function;

public class PassFunc {

    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = x -> x * x;
        int result = applyFunction(5, squareFunction);
        System.out.println("\n\nSquare of 5 is: " + result);
    }

    public static int applyFunction(int value, Function<Integer, Integer> function) {
        return function.apply(value);
    }
}
