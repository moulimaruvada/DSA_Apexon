package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAllAnagrams {
    public static void main(String[] args) {
        List<Integer> ls = findAnagrams("cbaebabacd","abc");
        System.out.println(ls);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans =new ArrayList<>();
        int n = s.length(), m = p.length();
        // sortedP stores the sorted version of string P
        String sortedp = p;
        char str[] = sortedp.toCharArray();
        Arrays.sort(str);
        sortedp = new String(str);
        String temp;
        for (int i = 0; i <= (n - m); i++)
        {
            temp = "";
            // temp stores the every substring of length m
            for (int k = i; k < m + i; k++)
                temp+=s.charAt(k);
            char str2[] = temp.toCharArray();
            Arrays.sort(str2);
            temp=new String(str2);
            // checking sorted version of substring equal to sorted P are not
            if (temp.equals(sortedp))
                ans.add(i);
        }
        return ans;
    }
}

