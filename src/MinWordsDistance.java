
public class MinWordsDistance {
    public static void main(String[] args) {
        String ab = "geeks for geeks contribute practice";
        String word1 = "geeks";
        String word2 = "practice";

        int d1 = -1;
        int d2 = -1;
        int min = Integer.MAX_VALUE;
        String[] ar = ab.split(" ");

        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals(word1)) {
                d1 = i;
            }
            if (ar[i].equals(word2)) {
                d2 = i;
            }
            if (d1!=-1 && d2!=-1) {
               min = Math.min(min, (Math.abs((d1-d2)))-1);
            }
        }
        System.out.println(min);

    }

}
