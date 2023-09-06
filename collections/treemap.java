package collections;

import java.util.Map;
import java.util.TreeMap;

public class treemap {

    public static void main(String[] args) {

        String k1=null;
        String k2 = null;
        TreeMap<String,Integer> om = new TreeMap<>(); //ordered map
         // 1 2 3 4 5 k1 . .. . .k2 .. . .inf
        String floor= om.floorKey(k2); // can return null
        String ceil = om.ceilingKey(k1); //O(logN)
        if (floor != null) {
            System.out.println(om.get(floor));
        }
    }
}
