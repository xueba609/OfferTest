abstract class A{
    public A(){ //3.调用父类构造
        this.print() ; //4.调用被子类覆写的方法
    }
    public abstract void print() ;
}
class B extends A{
    private int num = 100 ;
    public B(int num) { //2.调用子类实例化对象
        super() ; //3.隐含一行语句，实际要先调用父类构造
        this.num = num ; //7.为类中属性初始化
    }
    public void print() { //5.此时子类对象的属性还没有被初始化
        System.out.println(this.num) ; //6.对应其数据类型的默认值
    }
}
public class Test{
    public static void main(String[] args) {
        new B(30) ; //1.实例化子类对象
    }
}
