package letCode.offer;

import java.util.SplittableRandom;

/**
 * 想法 分别对两个字符串进行排序
 * 排完序之后在重新比较两个字符串
 *
 */
public class T2 {
    public boolean CheckPermutation(String s1, String s2) {
        s1 = maopaoSort(s1);
        s2 = maopaoSort(s2);
        if (s1.equals(s2))
            return true;
        return false;
    }

    public String maopaoSort(String s){
        char[] chars = s.toCharArray();
        for (int i = chars.length-1 ;i>=0;i--){
            for (int j = 0;j<i;j++){
                if (chars[j]>chars[j+1]){
                    char tmp = chars[j];
                    chars[j]=chars[j+1];
                    chars[j+1]=tmp;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        String s1 = "asdfg";
        String s2 = "adsgf";
        System.out.println(t2.CheckPermutation(s1,s2));

    }
}
