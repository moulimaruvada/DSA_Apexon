package leet;


public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    private static String reverseVowels(String string) {
        int left = 0;
        int right = string.length()-1;
        String vowel = "aeiouAEIOU";
        char[] wordArray = string.toCharArray();
        while (left < right ) {
            while (left < right && vowel.indexOf(wordArray[left]) == -1)
                left++;
            while (left < right && vowel.indexOf(wordArray[right]) == -1)
                right--;

            char c = wordArray[left];
            wordArray[left] = wordArray[right];
            wordArray[right] = c;
            left++;
            right--;

        }
        return new String(wordArray);
    }
}
