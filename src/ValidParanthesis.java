
public class ValidParanthesis {
    public static void main(String[] args) {
        //Valid Paranthesis
        validParanthesis("{[]}");
    }

    public static void validParanthesis(String str) {

        char[] ch = new char[str.length()];
        int pointer = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                ch[++pointer] = str.charAt(i);
            } else {
                if (i > 0 && (ch[pointer] == '{' &&str.charAt(i) == '}' ||
                        ch[pointer] == '[' &&str.charAt(i) == ']' ||
                        ch[pointer] == '(' &&str.charAt(i) == ')')) {
                    pointer--;
                } else {
                    pointer++;
                    break;
                }
            }
        }
        if (pointer == -1) {
            System.out.println("Valid");
        }
    }

}
