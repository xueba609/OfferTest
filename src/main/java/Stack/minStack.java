package Stack;

import java.util.Stack;

/*
实现最小栈：O（1）
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 */
//思路：两个栈，一个栈正常存储，另外一个栈用来每一次插入，保存当前的最小值
public class minStack {
    Stack<Integer> min;
    Stack<Integer> normal;
    /** initialize your data structure here. */
    public minStack() {
        this.min=new Stack<Integer>();
        this.normal=new Stack<Integer>();
    }

    public void push(int x) {
     this.normal.push(x);
     if(this.min.isEmpty()||this.min.peek()>=x){
         this.min.push(x);
     }else{
         this.min.push(this.min.peek());
     }
    }
    public void pop() {
        this.normal.pop();
        this.min.pop();
    }

    public int top() {
    return this.normal.peek();
    }

    public int getMin() {
    return this.min.peek();
    }
}
