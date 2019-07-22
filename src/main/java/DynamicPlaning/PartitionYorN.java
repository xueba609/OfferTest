package DynamicPlaning;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 题目描述：给定字符串s和单词字典dict，确定s是否可以被分割成一个或多个字典单词的空格分隔序列。
 *
 * 例如，给定
 * s =“leetcode”，
 * dict = [“leet”，“code”]。
 */
public class PartitionYorN {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.isEmpty()){
            return false;
        }
        if(dict.isEmpty()){
            return false;
        }
        Iterator<String> iterator=dict.iterator();
        //得到字典单词的最大长度
        int maxLength=0;
        while (iterator.hasNext()){
            int length=iterator.next().length();
            if(length>maxLength){
                maxLength=length;
            }
        }
        //用来储存前j是否可以分割,注意边界为s.length()+1
        boolean [] booleans=new boolean[s.length()+1];
        //" "
        booleans[0]=true;
        for(int i=1;i<=s.length();i++){
            for (int j=i-1;j>=0;j--){
                //如果子串大于字典最大的单词长度，跳过
                if((i-j)>maxLength){
                    break;
                }
                //
                if(booleans[j]&&dict.contains(s.substring(j,i))){
                    booleans[i]=true;
                    break;
                }
            }
        }
        return booleans[s.length()];
    }

    public static void main(String[] args) {
        PartitionYorN p = new PartitionYorN();
        String s = "leetcode";
        Set<String> set = new HashSet<String>();
            set.add("leet");
            set.add("code");
           boolean b= p.wordBreak(s, set);
            System.out.println(b);
    }
}

