package leet;

public class LongestPalindromeSubstring {

    // Function to find the longest palindrome substring
    static String longestPalSubstr(String s) {
        int n = s.length();
        if (n == 0) return "";

        int start = 0, maxLen = 1;

        // Traverse the input string
        for (int i = 0; i < n; i++) {
            // THIS RUNS TWO TIMES
            // for both odd and even length
            // palindromes. j = 0 means odd
            // and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int hi = i + j;

                // Expand substring while it is a palindrome
                // and in bounds
                while (low >= 0 && hi < n && s.charAt(low) == s.charAt(hi)) {
                    int currLen = hi - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    hi++;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    // Driver Code
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(longestPalSubstr(s));
    }
}
