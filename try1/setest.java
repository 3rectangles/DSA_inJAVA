package try1;
import java.util.*;


public class setest {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        List<Integer> l=new  ArrayList<>();
        l.add(1);l.add(1);l.add(1);l.add(4);l.add(13);
        set.addAll(l);
        Object[] arr= set.toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println( set);

    }
}
