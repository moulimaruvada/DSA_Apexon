public class reverseDivisibleBy3 {
    public static void main(String[] args) {
        System.out.println(reverseDivisibleBy3("12375685"));
    }

    public static String reverseDivisibleBy3(String s) {
        char[] ch = new char[s.length()];

        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }

        int left = 0;
        int right = s.length()-1;

        while (left< right) {

            while ((ch[left] - '0') % 3 != 0) {
                left++;
            }
            while ((ch[right] - '0') % 3 != 0) {
                right--;
            }

            if (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }

        }

        for (char i : ch) {
            sb1.append(i);
        }

        return sb1.toString();
    }
}

