import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxAddresses {
    public static void main(String[] args) {
        String[] ips = {
                "10.0.0.1 bytes=32 time=50ms TTL=63",
                "10.0.0.2 bytes=32 time=50ms TTL=73",
                "10.0.0.4 bytes=32 time=50ms TTL=83",
                "10.0.0.2 bytes=32 time=50ms TTL=93",
        };
        maxIpAddresses(ips);
    }

    public static void maxIpAddresses(String[] addresses) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < addresses.length; i++) {
            String[] st = addresses[i].split(" ");
            if (validateIp(st)) {
                map.put(st[0],map.getOrDefault(st[0],0)+1);
            }
        }
        int max = Collections.max(map.values());
        map.entrySet().stream().filter(x -> x.getValue() == max)
                .forEach(y -> System.out.println(y.getKey()));
    }

    public static boolean validateIp(String[] st) {
        boolean isValid = true;
        String ip = st[0];
        if (ip.isEmpty())
            return false;
        String[] ipSlit = ip.split("\\.");
        if (ipSlit.length != 4)
            return false;
        for (String s : ipSlit) {
            if (s.length() > 1 && s.charAt(0) == '0')
                return false;
            if (!s.matches("^[0-9]+$"))
                return false;
            if (Integer.parseInt(s) > 255)
                return false;
        }
        return isValid;
    }
}
