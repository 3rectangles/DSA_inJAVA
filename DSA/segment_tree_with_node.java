package DSA;

import java.util.*;

public class segment_tree_with_node {

    // Define a Node class to represent a node in the segment tree
    static class Node {
        int a; // The minimum value in the interval represented by this node
    }

    // Define the maximum number of elements in the array
    static final int MAXN = 200_005;

    // Define the segment tree and the input array
    static Node[] seg = new Node[4 * MAXN];
    static int[] arr = new int[MAXN];

    // Function to compute the minimum of two nodes
    static Node f(Node left, Node right) {
        Node ans = new Node();
        ans.a = Math.min(left.a, right.a);
        return ans;
    }

    // Function to build the segment tree from the input array
    static void build(int index, int low, int high) {
        if(seg[index] == null)
            seg[index] = new Node();
        if(low == high) {
            seg[index].a = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(2 * index, low, mid); // Build the left child
        build(2 * index + 1, mid + 1, high); // Build the right child
        seg[index] = f(seg[2 * index], seg[2 * index + 1]); // Compute the parent node
    }

    // Function to update a value in the array and the segment tree
    static void update(int index, int low, int high, int key, int value) {
        if(seg[index] == null)
            seg[index] = new Node();
        if(low == high) {
            seg[index].a = value; // Update the leaf node
            return;
        }
        int mid = low + (high - low) / 2;
        if(key <= mid)
            update(2 * index, low, mid, key, value); // Update in the left child
        else
            update(2 * index + 1, mid + 1, high, key, value); // Update in the right child
        seg[index] = f(seg[2 * index], seg[2 * index + 1]); // Update the parent node
    }

    // Function to query the minimum value in a range [l, r]
    // NO OVERLAP, PARTIAL OVERLAP, COMPLETE OVERLAP
    static Node query(int index, int low, int high, int l, int r) {
        if(seg[index] == null)
            seg[index] = new Node();
        if(l <= low && high <= r) // Complete overlap
            return seg[index];
        if(high < l || r < low) // No overlap
            return new Node() {{ a = Integer.MAX_VALUE; }};
        int mid = low + (high - low) / 2;
        Node left = query(2 * index, low, mid, l, r); // Query the left child
        Node right = query(2 * index + 1, mid + 1, high, l, r); // Query the right child
        return f(left, right); // Combine the results
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt(); // Read the input array
        build(1, 0, size - 1); // Build the segment tree
        int q = scanner.nextInt();
        while(q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            // l,r should be 0 based indexing on input array
            // if not then l-- and r--
            // bec l,r is segment in arr ( which is 0 based indexed)
            Node ansnode = query(1, 0, size - 1, l, r); // Query the minimum value in range [l, r]
            System.out.println(ansnode.a);
        }
        scanner.close();
    }
}

