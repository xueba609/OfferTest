package FaceAndFace;

import java.io.InputStream;
import java.util.*;

/*
*小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
有一天，小易又开了一局游戏，当玩到第 m 个方块落下时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数。
 */
class Person{
    private String name ;
    private int age ;
    public Person(String name, int age) {
        this.age = age ;
        this.name = name ;
    }
    @Override
    public String toString() {
        return "姓名："+this.name+",年龄："+this.age ;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false ;
        }
        if(this == obj) {
            return true ;
        }
// 不是Person类对象
        if (!(obj instanceof Person)) {
            return false ;
        }
        Person person = (Person) obj ; // 向下转型，比较属性值
        return this.name.equals(person.name) && this.age==person.age ;
    }
}
class Student{}
public class Test {
    public static void main(String[] args) {
        /*Person per1 = new Person("yuisama", 20) ;
        Person per2 = new Person("yuisama", 20) ;
        System.out.println(per1.equals(per2));
        Integer num1 = new Integer(10) ;
        Integer num2 = new Integer(10) ;
        Integer num3=10;
        Integer num4=10;
        Integer num5=150;
        Integer num6=150;
        System.out.println(num1 == num2);//false
        System.out.println(num1 == new Integer(10));//false
        System.out.println(num3 == num4);//true
        System.out.println(num1 == num4);//false
        System.out.println(num5 == num6);//false
        System.out.println(num1.equals(new Integer(10)));//true
        String str = "truesds" ; // String类型
        boolean num = Boolean.parseBoolean(str) ;
        System.out.println(num);
        String str1 = String.valueOf(100) ;
        System.out.println(str1);*/
//        String str2 = "100";
//        int num9 = Integer.parseInt(str2);
//        System.out.println(num9 * 2);
//        // 此时集合里面只保存String类型
//        List<String> list = new ArrayList<>();
//        list.add("Hello");
//// 重复数据
//        list.add("Hello");
//        list.add("Bit");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//
//        }
//        Set<String> set = new HashSet<>();
//        set.add("Hello");
//// 重复元素
//        set.add("Hello");
//        set.add("Bit");
//        set.add("Hello");
//        set.add("Java");
//        System.out.println(set);
        Set<String> set = new TreeSet<>() ;
        set.add("C") ;
        set.add("C") ;
        set.add("D") ;
        set.add("B") ;
        set.add("A") ;
        System.out.println(set) ;

    }}