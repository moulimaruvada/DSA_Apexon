public class CountingDuplicates {
    public static void main(String[] args) {
        countDuplicates("abasdredasfeerf");
    }

    public static void countDuplicates(String a) {
        char[] ch = new char[256];
        for (int i = 0; i < a.length(); i++) {
            ch[a.charAt(i)]++;
        }
        int count = 0;
        for (char c :ch) {
            if (c > 1) {
                count++;
            }
        }
        System.out.println(count);
    }

}
