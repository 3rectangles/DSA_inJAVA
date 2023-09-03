package try1;

import collections.Array;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class binary_search1 {

    public static void main(String[] args) {
        Solution ob =new Solution();

        int[] ans;
        int[] s= {5,25,75};
        ans =ob.twoSum(s,100);

        System.out.println(Arrays.toString(ans));
    }

   static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int ans[]= new int[2];

            for( int i =0 ; i < numbers.length; i++){
                int a =numbers[i];
               // numbers[i]= Integer.MAX_VALUE;
                int index =search(i,target-a,numbers);
                numbers[i]=a;
                if( index > -1){
                    ans[0]=i+1;
                    ans[1]=index+1;

                if(index == i ) // same element,either check left or right
                    {
                        if((index -1) >=0 &&  numbers[index-1] == target-a)
                            ans[1]=index;
                        else
                            ans[1]=index+1+1;

                    }
                    return ans;
                }
            }


            return ans;

        }

        public int search(int at ,int i , int[] numbers){

            int index=-1;
            // binary search
            int l =0;
            int r = numbers.length-1;

            while (l <=r)
            {
                int mid = (l + (r-l)/2);
                //System.out.println(mid +" mid \n");
                if( numbers[mid] == i)
                    return mid;

                else if (numbers[mid] > i)
                    r = mid-1;
                else if (numbers[mid] < i)
                    l = mid+1;
//                else if ( mid ==at) {
//                    if( numbers[])
//                }

            }
            //return 0;
            return index;
        }
    }


}


