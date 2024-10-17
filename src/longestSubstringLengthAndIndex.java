import java.util.Arrays;

public class longestSubstringLengthAndIndex {
    public static void main(String[] args) {
        String s = "aaabbbbassssssdd";
        System.out.println(Arrays.toString(longestSubstring(s)));
    }

    private static int[] longestSubstring(String s) {
        int count = 1;
        int max = 0;
        int index = -1;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    index = Math.abs(count-i);
                    count = 1;
                }
            }
        }
        return new int[]{index,max};

    }

}

