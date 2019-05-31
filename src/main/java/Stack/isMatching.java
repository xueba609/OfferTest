package Stack;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */
//思路：栈 如果是左括号，压栈。如果是右括号，判断栈顶是否匹配
public class isMatching {
    public boolean isMatching1(String s){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            switch (ch){
                case '(':
                case '[':
                case'{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case'}':{
                //遇到右括号，栈还为空
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left=stack.pop();
                    if(!((left=='('&&ch==')')||(left=='['&&ch==']')||(left=='{'&&ch=='}'))){
                        return false;
                    }
                    break;
                }
                default:
                    break;
        }
    }
    //循环走完，判断栈是否为空
    if(stack.isEmpty()){
            return true;
    }else {
            return false;
    }
}

    public static void main(String[] args) {
        String s="()[]{}";
        isMatching i=new isMatching();
        System.out.println(i.isMatching1(s));
    }
}
