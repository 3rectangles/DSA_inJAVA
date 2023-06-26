package DSA;

import java.util.BitSet;
import java.util.*;

// Convert the struct node to a Java class named node
class node {
    List<DSA.node> child;
    int count;
    int eof;

    // Replace the constructor with a Java constructor
    public node() {
        child = new ArrayList<>(2);
        child.add(null);
        child.add(null);
    }
}

public class Trie_binary_XOR {

   
    node root;

    public int findMaximumXOR(List<Integer> nums) {
        int ans = 0;
        root = new node(); // Initialise trie

        // Insert numbers in trie
        for (int elm : nums)
            insert(elm);

        // Find max possible xor in trie
        for (int elm : nums) {
            int q = findmax(elm);
            System.out.println(q);
            ans = Math.max(ans, q);
        }
        return ans;
    }

    void insert(int a) {
        node temp = root;
        BitSet bs = BitSet.valueOf(new long[]{a});

        for (int i = 31; i >= 0; i--) {
            if (temp.child.get(bs.get(i) ? 1 : 0) == null) // not present
                temp.child.set(bs.get(i) ? 1 : 0, new node());
            temp = temp.child.get(bs.get(i) ? 1 : 0);
        }

        temp.eof = 1;
    }

    int findmax(int n) {
        node t = root;
        BitSet bs = BitSet.valueOf(new long[]{n});
        int ans = 0;

        for (int j = 31; j >= 0; j--) {
            if (t.child.get(!bs.get(j) ? 1 : 0) != null) { // if complement bit exists
                ans += (1 << j);
                t = t.child.get(!bs.get(j) ? 1 : 0);
            } else { // no contribution
                t = t.child.get(bs.get(j) ? 1 : 0);
            }
        }
        return ans;
    }
}






    