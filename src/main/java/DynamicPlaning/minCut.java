package DynamicPlaning;
//给定一个字符串 s,把 s 分割成一系列的子串，分割的每一个子串都为回文串
//返回最小的分割次数
//比如，给定 s = "aab",
//返回1，因为一次cut就可以产生回文分割["aa","b"]
public class minCut {
    int minCut (String s){
        if(s.isEmpty()){
            return 0;
        }
        int length=s.length();
        //用于储存到每个字母的最小分割次数
        int [] result=new int[length+1];
        //初始化,注意边界，0代表0个元素，
        for(int i=0;i<length+1;i++){
            result[i]=i-1;
        }
        for(int i=1;i<length+1;i++){
            for(int j=0;j<i;j++){
                ///F(i) = min{F(i), 1 + F(j)},
                //从最长串判断，如果从第j+1到i为回文字符串
                //则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if (isPalindrome(s, j, i - 1)){
                   result[i]=Math.min(result[i],1+result[j]);
                }
            }
        }
        return result[length];
    }

    private boolean isPalindrome(String s, int j, int i) {
        while(j<i){
            if(s.charAt(j)!=s.charAt(i)){
                return false;
            }
            j++;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        minCut minCut=new minCut();
        System.out.println(minCut.minCut("a"));
    }
}
