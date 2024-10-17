package leet;

public class ReverseString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(revereseString(s));
    }

    private static String revereseString(String s) {
        StringBuilder sb = new StringBuilder();
        String[] stringArray = s.split(" ");

        int size = stringArray.length-1;

        for (int i = size; i >= 0; i--) {
            if (!stringArray[i].isEmpty()) {
                sb.append(stringArray[i].trim());
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}
