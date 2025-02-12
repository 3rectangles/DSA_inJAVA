package collections;

import javax.print.attribute.standard.OrientationRequested;
import java.util.*;

public class Array {

    public static int[][] read(){ // reading 2d array, pass by value
        Scanner sc = new Scanner(System.in);
        int rows  = sc.nextInt();
        int cols =sc.nextInt();
        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();

            }

        }

        return mat;
    }
    public  static void print(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));

        }
    }
    public static void main(String[] args) {

        // declare and fill array with specifix value
        int[] arr= new int[10];

        //sortinng 2D array

        int[][] A = new int[3][3];
        Comparator<int[]> cmp = (int[] a, int[] b)->{
            return a[0]-b[0];
        };

        // sorting the array with the start value
        Arrays.sort(A, cmp);



        int[] arr1 = {4, 8, 2}; // Fixed size array with 3 elements
        // OR
        int[] arr2 = new int[]{4, 8, 2}; // Fixed size array with 3 elements

        Arrays.fill(arr,-1);
        arr[3]=6;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        Arrays.fill(arr,-1);
        System.out.println(Arrays.binarySearch(arr,6)); //returns 6
        System.out.println(Arrays.binarySearch(arr,10)); //returns -11

        System.out.println(Arrays.binarySearch(arr,-134)); //returns -1

        // printing array
            String[] myArray = {"Apple", "Banana", "Cherry", "Date"};

            // Printing the array using Arrays.toString
            System.out.println(Arrays.toString(myArray)); // prints array
            System.out.println(myArray.toString()); // prints memory address


        // 2D ARRAYS dynamic

        int[][] mat = new int[5][6]; //  y default all values =0
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i <rows; i++) {
        Arrays.fill(mat[i],-1);
        }
        // printing 2d array
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(mat[i]));

        }

         int[][] mat1 = read();

        print(mat1);

        // 3d 3D array

        // Example 3D array with dimensions 2x3x4
        int[][][] array = new int[2][3][4];

        // Set all values in the 3D array to -1
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                Arrays.fill(array[i][j], -1);
            }
        }

        // OR
        int[][][] dp = new int[100][2][3];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }



        // Create an array of TreeMap objects
        TreeMap<String, Integer>[] arrayOfTreeMaps = new TreeMap[3];

        // Initialize each TreeMap in the array
        for (int i = 0; i < arrayOfTreeMaps.length; i++) {
            arrayOfTreeMaps[i] = new TreeMap<>();
        }

        // Add data to the first TreeMap
        arrayOfTreeMaps[0].put("A", 1);
        arrayOfTreeMaps[0].put("B", 2);

        // Add data to the second TreeMap
        arrayOfTreeMaps[1].put("C", 3);

       arrayOfTreeMaps[1].put("D", 4);

        // Add data to the third TreeMap
        arrayOfTreeMaps[2].put("E", 5);
        arrayOfTreeMaps[2].put("F", 6);

        // Iterate over the array of TreeMaps and print the contents
        for (int i = 0; i < arrayOfTreeMaps.length; i++) {
            System.out.println("TreeMap " + (i + 1) + ": " + arrayOfTreeMaps[i]);
        }
    }
    public void arrOfTreeSet(){
        // Create an array of TreeSet objects

        TreeSet<Integer>[] arrayOfTreeSets = new TreeSet[3];

        // Initialize each TreeSet in the array
        for (int i = 0; i < arrayOfTreeSets.length; i++) {
            arrayOfTreeSets[i] = new TreeSet<>();
        }

        // Add data to the first TreeSet
        arrayOfTreeSets[0].add(1);



    // Add data to the second TreeSet

   arrayOfTreeSets[1].add(3);

   arrayOfTreeSets[1].add(4);

    // Add data to the third TreeSet

    arrayOfTreeSets[2].add(5);
    arrayOfTreeSets[2].add(6);

        // Iterate over the array of TreeSets and print the contents
        for (int i = 0; i < arrayOfTreeSets.length; i++) {
            System.out.println("TreeSet " + (i + 1) + ": " + arrayOfTreeSets[i]);
        }
    // Convert array to list
    Integer[] arr = {1, 2, 3, 4, 5};

    // Creating a deep copy of the array as a list
    List<Integer> list = new ArrayList<>(Arrays.asList(arr));

    //creating shallow copy of list from array


    List<Integer> shallowListCopyFromArray = Arrays.asList(arr);

    // The resulting list is a deep copy, so modifications to the original array
    // will not affect the list, and vice versa.
    System.out.println("Original array: " + Arrays.toString(arr));
    System.out.println("List (deep copy of array): " + list);

    // Shallow copy of the array
    Integer[] shallowCopy = arr;

    // Modifying the original array will affect the shallow copy
    arr[0] = 10;
    System.out.println("Original array after modification: " + Arrays.toString(arr));
    System.out.println("Shallow copy: " + Arrays.toString(shallowCopy));

    // Deep copy of the array
    Integer[] deepCopy = Arrays.copyOf(arr, arr.length);

    // Modifying the original array will not affect the deep copy
    arr[1] = 20;
    System.out.println("Original array after second modification: " + Arrays.toString(arr));
    System.out.println("Deep copy: " + Arrays.toString(deepCopy));

    // Shallow copy of the list
    List<Integer> shallowListCopy = list;

    // Modifying the original list will affect the shallow copy
    list.set(0, 100);
    System.out.println("Original list after modification: " + list);
    System.out.println("Shallow list copy: " + shallowListCopy);

    // Deep copy of the list
    List<Integer> deepListCopy = new ArrayList<>(list);

    // Modifying the original list will not affect the deep copy
    list.set(1, 200);
    System.out.println("Original list after second modification: " + list);
    System.out.println("Deep list copy: " + deepListCopy);


    }

// changed



}

