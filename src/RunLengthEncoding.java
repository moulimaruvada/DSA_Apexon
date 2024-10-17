import java.util.HashMap;
import java.util.Map;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String s = "aabbca";
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> m :map.entrySet()) {
            sb.append(m.getKey()).append(m.getValue());
        }
        System.out.print(sb);
        System.out.println("");
        runLengthEncoding(s);
    }


    public static void runLengthEncoding(String string) {
        for (int i = 0; i < string.length(); i++) {
            int count = 1 ;
            while (i<string.length()-1 && string.charAt(i) == string.charAt(i+1)) {
                count++;
                i++;
            }
            System.out.print(string.charAt(i)+""+count);

        }
    }

}
