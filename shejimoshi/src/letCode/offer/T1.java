package letCode.offer;

import java.util.HashSet;
import java.util.Set;

public class T1 {
    public boolean isUnique(String astr) {
        Set<String> stringSet = new HashSet<>();
        for (int i = 0;i<astr.length();i++){
            if (stringSet.contains(astr.charAt(i)+""))
                return false;
            else stringSet.add(astr.charAt(i)+"");
        }
        return true;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        String ss = "abc";
        System.out.println(t1.isUnique(ss));
    }
}
