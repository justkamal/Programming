package interviewBit.stack;

//Try attempt : 1

import java.util.Stack;



public class MinStack extends Stack<Integer>{

    int min = 0;
    
    public void push(int x) {
        if(this.isEmpty() || x > this.min){
            this.push(x);
        }
        if(x <= min){
            this.push(2*x - min);
            this.min = x;
        }
    }

    public Integer pop() {
        if(this.isEmpty())
            return -1;
        if(this.peek() > this.min){
            return super.pop();
        } else {
            int prev = this.min;
            this.min = 2*this.min - this.top();
            return prev;
        }
    }
    
    public int top() {
        if(this.peek() < this.min)
            return min;
        else
            return this.peek();
    }

    public int getMin() {
        return this.min;
    }
}

