import java.util.*;


public class Main {
    public static void main(String[] args) {
        String str = "abbacd";
//        OptionalInt a = str.chars().filter(c-> {
//            long count = str.chars().filter( cc -> cc == c).count();
//            return count == 1;
//        }).findFirst();
//
//        System.out.println((char) a.getAsInt());
//        System.out.println(atoi());
//        robot("DOWN UP 2xRIGHT DOWN 3xLEFT");
//        int[] arr = new int[]{10,5,6,3,2,20,100,80};
//        waveForm(arr);
        pascalTraingle(5);
//            String[][] ar = new String[][]{{"jerry","65"},{"bob","91"},{"jerry","23"},{"Eric","12"}};
//            studentAverage(ar);
//            String a = "Asd";
//        makeReadable(359999);
//        duplicateCount("abd1qax1df");
//        int[] arr1 = new int[]{1,100,50,-51,1,1};
//        findEvenIndex(arr1);
        runLengthEncoding("aaaabbbcd");
        longestSubstring("abcdddddeff");
        validParanthesis("{[()[]{}]}");
        Character[][] lt = new Character[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        sodukuValidator(lt);
        List<Integer> arr = new ArrayList<>(
                Arrays.asList(4, 5, 6, 1, 2, 3));
        System.out.println("The minimum element is "
                + findMin(arr));

        //13
        int[] arr1 = new int[]{1,5,1,1,2,3};
        // System.out.println(minSubArray(arr1,3));

        // min();
        int[] ar2 = new int[]{7,8};
        pattern(8, ar2);


    }


    public static int atoi () {
        String s = "-12311";

        int res = 0;
        int sign = 1;

        if (s.startsWith("-")) {
            sign = -1;
            s = s.replace("-","");
        }

        if (s.isEmpty() || !s.matches("^[0-9]+$")) {
            return 0;
        }



        for (int i =0;i<s.length();i++) {
            res = res*10 + s.charAt(i) - '0';
        }
        return res*sign;
    }

    public static void robot (String moves) {
        StringBuilder finalString = new StringBuilder();
        if (moves.contains(" ")) {
            String[] movesStr = moves.split(" ");
            for (int j =0; j<movesStr.length; j++) {
                if (movesStr[j].contains("x")) {
                    finalString.append(getString(movesStr[j]));
                } else {
                    finalString.append(movesStr[j].charAt(0));
                }
            }
        } else {
            finalString.append(moves);
        }
        if (finalString.length() == 0) {
            System.out.println("(0,0)");
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < finalString.length(); i++) {
            if (finalString.charAt(i) == 'U') {
                y++;
            } else if (finalString.charAt(i) == 'D') {
                y--;
            } else if (finalString.charAt(i) == 'L') {
                x--;
            } else if (finalString.charAt(i) == 'R') {
                x++;
            }
        }
        System.out.println(x+","+y);
    }

    public static StringBuilder getString(String move) {
        String[] countStr = move.split("x");
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(countStr[0]); i++) {
            resultString.append(countStr[1].charAt(0));
        }
        return resultString;
    }

    public static void waveForm (int[] arr) {
        for (int i = 0; i < arr.length; i+=2) {

            if (i> 0 && arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }

            if (i<arr.length-1 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        for (int m: arr) {
            System.out.println(m);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void pascalTraingle(int n) {
        for (int i = 5; i <= n; i++) {
            for (int u = 0; u <= n-i; u++) {
                System.out.print(" ");
            }

            int c = 1;
            for (int j=1; j<=i ; j++) {
                System.out.print(c + " ");
                c= c * (i-j) / j;
            }
            System.out.println();
        }
    }

    public static void generateNthrow(int N) {
        // nC0 = 1
        int prev = 1;
        System.out.print(prev);

        for (int i = 1; i <= N; i++) {
            // nCr = (nCr-1 * (n - r + 1))/r
            int curr = (prev * (N - i + 1)) / i;
            System.out.print(", " + curr);
            prev = curr;
        }
    }

    public static void studentAverage(String[][] inp) {
        Map<String, List<Integer>> map = new HashMap<>();
        int maxAvg = 0;
        for (int i = 0; i < inp.length; i++) {
            String key = inp[i][0];
            int value = Integer.parseInt(inp[i][1]);

            if (!map.containsKey(key)) {
                List<Integer> al = new ArrayList<>();
                al.add(value);
                map.put(key, al);
            } else {
                map.get(key).add(value);
            }
        }
        for (Map.Entry<String,List<Integer>> a : map.entrySet()) {
            int currentAvg = calculateAvg(a.getValue());
            maxAvg = Math.max(maxAvg,currentAvg);
        }
    }

    public static int calculateAvg(List<Integer> a) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum = sum + a.get(i);
        }
        return sum/a.size();
    }

    public static String makeReadable(int seconds) {
        int anHourInSeconds = 3600;
        int aMinuteInSeconds = 60;

        String hh = Integer.toString((seconds / anHourInSeconds));
        String mm = Integer.toString((seconds % anHourInSeconds) / aMinuteInSeconds);
        String ss = Integer.toString(seconds % aMinuteInSeconds);

        if (hh.length() == 1) {
            hh = "0" + hh;
        }
        if (mm.length() == 1) {
            mm = "0" + mm;
        }
        if (ss.length() == 1) {
            ss = "0" + ss;
        }

        return hh + ":" + mm + ":" + ss;
    }

    static final int NO_OF_CHARS = 256;
    public static int duplicateCount(String text) {
        // Write your code here
        int result = 0;
        int[] count = new int[NO_OF_CHARS];
        for(int i = 0; i < text.length(); ++i){
            count[Character.toLowerCase(text.charAt(i))]++;
        }
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if(count[i] > 1) {
                result++;
            }
        }
        return result;
    }


    public static int findEvenIndex (int[] vals) {
        int result = -1;
        for (int i = 1; i <= vals.length - 1; i++) {
            int[] left = new int[i], right = new int[(vals.length - 1) - i];
            System.arraycopy(vals, 0, left, 0, i);
            System.arraycopy(vals, i + 1, right, 0, (vals.length - 1) - i);
            if (getSumOfArray(left) == getSumOfArray(right)) {
                result = i;
            }
        }
        return result;
    }

    private static int getSumOfArray (int[] vals) {
        return Arrays.stream(vals).sum();
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

    private static String convertTo(String string) {
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c:string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> map2 :map.entrySet()) {
            sb.append(map2.getKey()).append(map2.getValue());
        }
        return sb.toString();
    }

    public static void longestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                max = Math.max(max,count);
                count = 1;
            } else {
                count++;
            }
        }
        max = Math.max(count,max);
        System.out.println(max);
    }

    public static void validParanthesis (String m) {

        int c = -1;
        char[] s = new char[m.length()];
        for (int i = 0; i < m.length(); i++) {

            if (m.charAt(i) == ('{') || m.charAt(i) == ('(')
                    || m.charAt(i) == ('[')) {
                s[++c] = m.charAt(i);
            } else {
                if (i > 0 && m.charAt(i) == ('}') && s[c] == ('{')
                        || m.charAt(i) == (']') && s[c] == ('[')
                        || m.charAt(i) == (')') && s[c] == ('(')) {
                    c--;
                } else {
                    System.out.println("InValid");
                    break;
                }
            }

        }
        if (c == -1) {
            System.out.println("Valid");
        }
    }

    public static boolean sodukuValidator(Character[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add((char) board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public static int bulbsRemaining() {
        boolean[] bulbs = new boolean[101]; // Initialize all bulbs as off
        for (int i = 1; i <= 100; i++) { // Iterate through 1 to 100
            for (int j = i; j <= 100; j += i) { // Toggle bulbs based on multiples of i
                bulbs[j] = !bulbs[j];
            }
        }
        int remaining = 0;
        for (boolean bulb : bulbs) {
            if (bulb) remaining++; // Count the number of bulbs that remain on
        }


        return remaining;
    }

    public static int findMin(List<Integer> arr)
    {
        int low = 0;
        int high = arr.size()-1;
        // If the array is not rotated
        if (arr.get(low) < arr.get(high)) {
            return arr.get(low);
        }
        int ans = 1000000000;
        // Binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid)== arr.get(low) && arr.get(mid) == arr.get(high)) {
                ans = Math.min(ans,arr.get(mid));
                low++;
                high--;
            }
            // If the left half is sorted, the minimum
            // element must be in the right half
            else if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            }

            // If the right half is sorted, the minimum
            // element must be in the left half
            else {
                ans = Math.min(ans,arr.get(mid));
                high = mid - 1;
            }
        }

        // If no minimum element is found, return -1
        return ans;
    }

    public static int minSubArray(int[] arr, int a) {
        int min = Integer.MAX_VALUE;
        int currentPrefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentPrefixSum +=arr[i];

            if (currentPrefixSum == a) {
                int currentLength = i + 1;
                min = Math.min(min,currentLength);
            }

            int requiredPrefixSum = currentPrefixSum - a;

            if (map.containsKey(requiredPrefixSum)) {
                int foundIndex = map.get(requiredPrefixSum);

                min = Math.min(min, i-foundIndex);
            }

            map.put(currentPrefixSum, i);
        }

        if (min >= Integer.MAX_VALUE) return -1;

        return min;
    }

    public static void min() {
        int[] a = new int[]{7,5,1,6,8,3};
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(min,a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=min) {
                secondMin = Math.min(secondMin,a[i]);
            }
        }
        System.out.println(secondMin);

    }

    public static void pattern(int n, int[] arr) {
       String str = "7,8,77,78,87,88,777,778,787,788,877,878,887,888";

       if (arr[0]>arr[1]) {
           int temp = arr[0];
           arr[0] = arr[1];
           arr[1] = temp;
       }

       List<Integer> result = new ArrayList<>();
       for (int i =0; i<arr.length;i++) {
           if (i<n){
               result.add(arr[i]);
           }
       }

       if (result.size() < n) {
           int i=0;
           int j=0;
           n = n-arr.length;
           List<Integer> output = rec(result,arr,i,j,n);
           for (int a: output) {
               System.out.println(a);
           }
       }

    }

    private static List<Integer> rec(List<Integer> result, int[] arr, int i, int j, int n) {
        if (n != 0) {
            //System.out.println(result);
            if (j == arr.length) {
                i++;
                j = 0;
            }
            String num = String.valueOf(result.get(i)) + arr[j];
            result.add(Integer.parseInt(num));
            rec(result, arr, i, j + 1, --n);
        }
        return result;
    }


}