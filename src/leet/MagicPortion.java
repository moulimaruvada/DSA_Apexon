package leet;

public class MagicPortion {
    public static void main(String[] args) {
        String s = "ABABABABABC";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            if(i*2 <= s.length()) {
                String compareString = s.substring(0,i);
                if (compareString.equals(s.substring(i,i*2))) {
                    stringBuilder.append("*");
                    i=i*2-1;

                }
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder);
    }
}
