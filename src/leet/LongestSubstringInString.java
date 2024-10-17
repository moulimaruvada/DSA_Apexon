package leet;

public class LongestSubstringInString {
    public static void main(String[] args) {
        String[] dict = new String[]{"CODGE","ODG","LODGES","SODG","dodge","mODJ","LODGESSSS"};
        String toSearch = "ODG";
        findTheLongestWordWithSubstring(dict, toSearch);
    }

    private static void findTheLongestWordWithSubstring(String[] dict, String toSearch) {
        int max = 0;
        for (int i = 0; i < dict.length; i++) {
            if(ifContains(dict[i],toSearch)) {
                max = Math.max(max, dict[i].length());
            }
        }
        System.out.println("longest word with sub string = "+max);
    }

    private static boolean ifContains(String s, String string) {
        int left = 0;
        int right = string.length();
        while (left <= s.length()-string.length() && right <=s.length()) {
            String subString = s.substring(left, right);
            if (subString.equals(string)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
