package try1;

import java.util.ArrayList;
import java.util.*;

public class design_stack {



    static class MinStack {
        static class pair{
            int a =0;
            int b=0;
            pair(int a , int b ){this.a =a; this.b=b;}

        }
        List<pair> l = new ArrayList<>();

        int mini = Integer.MAX_VALUE;
        public MinStack() {


        }

        public void push(int val) {
            mini= Math.min(val,mini); // get the minimum till now in the stack
            l.add(new pair(val,mini));

        }

        public void pop() {
            // before removing always check if possible or not
            if(! l.isEmpty()){
                l.remove(l.size()-1); // remove last element
                // stack goes back to previous state else if possible else reset mini
                if(l.isEmpty()) // if stack is empty, reset mini
                {
                    mini = Integer.MAX_VALUE;
                }

            }
        }

        public int top() {
            if( !l.isEmpty()){
                return  l.get(l.size()-1).a;
            }
            return 0; // just for sake of returning
        }

        public int getMin() {
            return l.get(l.size()-1).b; // return mini of current state of stack
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


}


