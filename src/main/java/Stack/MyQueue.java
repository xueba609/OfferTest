package Stack;

import java.util.Stack;

//两个栈实现一个队列
/*
*使用栈实现队列的下列操作：
push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
示例:
 */
public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
           in=new Stack<Integer>();
           out=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int v=in.pop();
                out.push(v);
            }
        }
        int v=out.pop();
        return v;
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int v=in.pop();
                out.push(v);
            }
        }
        int v=out.peek();
        return v;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
   return in.isEmpty()&&out.isEmpty();
    }
}
