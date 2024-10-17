
public class FirstNonReapeatedChar {

    public static void main(String[] args) {
        String str = "abbacd";
        char[] a = new char[256];
        for (char c: str.toCharArray()) {
            a[c]++;
        }
        int index = -1;
        int i;
        for (i=0; i<str.length(); i++) {
            if (a[str.charAt(i)] == 1) {
                index = 1;
                break;
            }
        }
        if (index != -1) {
            System.out.println(str.charAt(i));
        }
    }
}
