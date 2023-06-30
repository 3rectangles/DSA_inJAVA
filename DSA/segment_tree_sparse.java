package DSA;

public class segment_tree_sparse {
    public static void main(String[] args) {
        // Create an array of numbers
        int[] nums = {1, 2, 3, 4, 5};

        // Create a SegmentTree from the array
        SegmentTree st = new SegmentTree(nums);

        // Perform a range sum query
        int sum = st.query(1, 3);
        System.out.println(sum); // Outputs: 9

        // Update an element
        st.update(2, 6);

        // Perform another range sum query
        sum = st.query(1, 3);
        System.out.println(sum); // Outputs: 12
    }

}

// Define a node of the Segment Tree


class SegmentTree {
   static class Node {
        int startInterval, endInterval; // The range this node represents
        int sum; // The sum of the range this node represents
        Node left, right; // The left and right children of this node
    }

    Node root; // The root of the Segment Tree

    // Constructor: takes an array of numbers and builds the Segment Tree
    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    // Recursive function to build the Segment Tree
    private Node buildTree(int[] nums, int start, int end) {
        Node node = new Node();
        // Assign the start and end intervals of this node
        node.startInterval = start;
        node.endInterval = end;
        if (start == end) { // If start equals end, this node represents a single element --> leaf node
            node.sum = nums[start];   // The sum of this node is the single element itself
        } else {
            int mid = start + (end - start) / 2;  // If start < end, this node represents a range of elements
            // Recursively build the left and right children of this node
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum; // The sum of this node is the sum of its left and right children
         }
        return node; // Return the node
    }
    public void update(int idx, int val) {
        update(root, idx, val);
    }

    private void update(Node node, int pos, int val) {
        if (node.startInterval == node.endInterval) { // Leaf node
            node.sum = val;
        } else {
            int mid = node.startInterval + (node.endInterval - node.startInterval) / 2;
            if (pos <= mid) { // Update left child
                update(node.left, pos, val);
            } else { // Update right child
                update(node.right, pos, val);
            }
            node.sum = node.left.sum + node.right.sum; // Update current node's sum
        }
    }

    // Function to perform a range sum query
    public int query(int l, int r) {
        return query(root, l, r);  // polymrphism
    }

    // Recursive function to perform the range sum query
    private int query(Node node, int start, int end) {
        if (start <= node.startInterval && node.endInterval <= end) { // If the queried range completely overlaps with this node's range,
             return node.sum;
        }
        // return 0 as it doesn't contribute to the sum
        if (node.endInterval < start || node.startInterval > end) { // If the queried range does not overlap with this node's range,
           return 0;
        }
        int leftSum = query(node.left, start, end);   // If the queried range partially overlaps with this node's range,
        int rightSum = query(node.right, start, end);
        return leftSum + rightSum; // Return the total sum
    }
}

