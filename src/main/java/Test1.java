import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String s="爱讯飞789swr1wwen34ifly65tek";
        char [] array=s.toCharArray();
        search(array);
    }
    private static void search(char[] array) {
        if(array.length==0){
            return;
        }
        int len=array.length;
        ArrayList<Character> arrayList=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(array[i]>='0'&&array[i]<='9'){
                arrayList.add(array[i]);
            }
        }
        if(arrayList.size()==0){
            System.out.print("-1");
        }
        Collections.sort(arrayList);
        Iterator<Character> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}
