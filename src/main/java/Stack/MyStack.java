package Stack;

public class MyStack {
    private int [] array;
    int top;

    public MyStack(){
       this.top=0;
    }
    //压栈
    public void push(int v){
           this.array[top++]=v;
    }
    //出栈
    public int pop(){
        return this.array[--top];

    }
    //只出数据
    public int peek(){
         return this.array[this.top-1];
    }
    //返回大小
    public int size(int key){
          return top;
    }
    //判断是否为空
    public boolean isEmpty(){
        return this.top==0;
    }

}
