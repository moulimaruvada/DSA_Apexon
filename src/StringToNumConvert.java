
public class StringToNumConvert {
    public static void main(String[] args) {
        System.out.println(atoi("123a"));
    }

    public static int atoi(String str) {
        int ans = 0;
        int res = 1;
        if (str.startsWith("-")) {
            res = -1;
            str = str.replace("-","");
        }
        if (str.isEmpty() || !str.matches("^[0-9]+$")) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            ans = ans*10 + val;
        }
        return  ans*res;
    }

}
