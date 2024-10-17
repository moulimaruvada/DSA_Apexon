import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Flight f1 = new Flight(12,20);
        Flight f2 = new Flight(14,24);
        Flight f3 = new Flight(18,12);
        Flight f4 = new Flight(10,90);
        List<Flight> ar = new ArrayList<>();
        ar.add(f1);
        ar.add(f2);
        ar.add(f3);
        ar.add(f4);
        //Collections.sort(ar);
        //Collections.sort(ar,new Test());
        //ar.stream().sorted(Comparator.comparing((x1,x2) -> Integer.compare(x1,x2))
        System.out.println(ar.stream().max(Comparator.comparing(x -> x.getAge())).get());;
        System.out.println(ar);



        //1
//        String s = "aaaaabbbbsssssd";
//        StringBuilder sb = new StringBuilder();
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c: s.toCharArray()) {
//            map.put(c, map.getOrDefault(c,0)+1);
//        }
//        for (Map.Entry<Character, Integer> m :map.entrySet()) {
//            sb.append(m.getKey()).append(m.getValue());
//        }
//        System.out.print(sb);


        //3
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        printInorder(root);


        //5
//        int[] arr1 = new int[]{2,3,5,8,9};
//        int[] arr2 = new int[]{10,12,14,16,18,20};
//        System.out.println(findMedianSortedArrays(arr1,arr2));
//        System.out.println(medianUsingArrayCopy(arr1,arr2));

        //8
//        String str = "abbacd";
//        char[] a = new char[256];
//        for (char c: str.toCharArray()) {
//            a[c]++;
//        }
//        int index = -1;
//        int i;
//        for (i=0; i<str.length(); i++) {
//            if (a[str.charAt(i)] == 1) {
//                index = 1;
//                break;
//            }
//        }
//        if (index != -1) {
//            System.out.println(str.charAt(i));
//        }


        //9
//        String ab = "geeks for geeks contribute practice";
//        String word1 = "geeks";
//        String word2 = "practice";
//
//        int d1 = -1;
//        int d2 = -1;
//        int min = Integer.MAX_VALUE;
//        String[] ar = ab.split(" ");
//
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i].equals(word1)) {
//                d1 = i;
//            }
//            if (ar[i].equals(word2)) {
//                d2 = i;
//            }
//            if (d1!=-1 && d2!=-1) {
//               min = Math.min(min, (Math.abs((d1-d2)))-1);
//            }
//        }
//        System.out.println(min);

        //10
//        System.out.println(atoi("123a"));


        //11
        List<Integer> arr = Arrays.asList(1,5,1,1,2,3);
        // System.out.println(findMinimum(arr));
        int[] array1 = new int[]{5,6,1,2,3,4};
        System.out.println("Minimum in rotated array "+sorted(array1));


        //13
        int[] arr1 = new int[]{1,5,1,1,2,3};
        System.out.println(minSubArray(arr1,3));

        //14
        System.out.println("Is Power " +isPower(10,1000));

        //Valid Paranthesis
        validParanthesis("{[]}");

        //count duplicates
        countDuplicates("abasdredasfeerf");

        //human readable time
        System.out.println(humanReadableTime(123132));

        //valid IP and max occurence
        String[] ips = {
                "10.0.0.1 bytes=32 time=50ms TTL=63",
                "10.0.0.2 bytes=32 time=50ms TTL=73",
                "10.0.0.4 bytes=32 time=50ms TTL=83",
                "10.0.0.2 bytes=32 time=50ms TTL=93",
        };
        maxIpAddresses(ips);


    }



    public static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data);
        printInorder(node.right);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
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

    public static void medianUsingArrayCopy(int[] arr1, int[] arr2) {
        int i = arr1.length;
        int j = arr2.length;

        int[] arr3 = new int[i + j];

        // Merge two array into one array
        System.arraycopy(arr1, 0, arr3, 0, i);
        System.arraycopy(arr2, 0, arr3, i, j);

        // Sort the merged array
        int ans = 0;
        if (arr3.length % 2 == 0) {
            ans = (arr3[(arr3.length/2)-1] + arr3[(arr3.length/2)])/2;
        } else  {
            ans = arr3[arr3.length/2];
        }

        // calling the method
        System.out.print("Median = " + ans);
    }

    public static int findMinimum(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;

        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr.get(mid) == arr.get(low) && arr.get(mid) == arr.get(high)) {
                min = Math.min(arr.get(mid),min);
                low++;
                high--;
            }

            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                min = Math.min(arr.get(mid),min);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void validParanthesis(String str) {

        char[] ch = new char[str.length()];
        int pointer = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                ch[++pointer] = str.charAt(i);
            } else {
                if (i > 0 && (ch[pointer] == '{' && str.charAt(i) == '}' ||
                        ch[pointer] == '[' && str.charAt(i) == ']' ||
                        ch[pointer] == '(' && str.charAt(i) == ')')) {
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

    public static int minSubArray(int[] arr,int a) {
        int currentPrefixSum = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentPrefixSum +=arr[i];

            if (currentPrefixSum == a) {
                minLength = Math.min(minLength, i+1);
            }

            int prefixSum =  currentPrefixSum - a;

            if (map.containsKey(prefixSum)) {
                int foundIndex = map.get(prefixSum);
                int currentIndex = i;
                minLength = Math.min(minLength, currentIndex-foundIndex);
            }

            map.put(currentPrefixSum, i);

        }
        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }

    public static String humanReadableTime(int c) {
        int hoursInSeconds = 3600;
        int minutesSeconds = 60;

        StringBuilder a = new StringBuilder();

        int hours = c / hoursInSeconds;
        int minutes = (c % hoursInSeconds) / minutesSeconds;
        int seconds = c % minutesSeconds;

        if (String.valueOf(hours).length() == 1) {
            a.append("0");
        }
        a.append(hours).append(":");

        if (String.valueOf(minutes).length() == 1) {
            a.append("0");
        }
        a.append(minutes).append(":");
        if (String.valueOf(seconds).length() == 1) {
            a.append("0");
        }
        a.append(seconds);

        return String.valueOf(a);
    }

    public static int sorted(int [] s) {
        int low = 0;
        int high = s.length-1;

        int min = Integer.MAX_VALUE;

        if (s[low] <= s[high]) {
            return s[low];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (s[mid] == s[low] && s[mid] == s[high]) {
                min = Math.min(min, s[mid]);
                low++;
                high--;
            }

            if (s[mid] > s[high]) {
                low = mid + 1;
            } else {
                min = Math.min(min, s[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static boolean isPower(int power, int value) {
        boolean isPower = false;
        int ans = 1;
        float res1 = (float)(Math.log(value) /
                Math.log(power));

        return (res1%1==0);
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
