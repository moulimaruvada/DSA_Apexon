package leet;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdasdddddderwr"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while (right < size) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                max = Math.max(max, right-left);
                left = Math.max(left, (map.get(ch))+1);
            }
            map.put(ch, right);
            right++;

        }
        max = Math.max(max, right-left);
        return max;
    }
}
