public class StringPossibilities {
    public static void main(String[] args) {
        String a = "abc";
        stringRec(a);
    }
    //a,b,c,ab,ac,bc,abc

    private static void stringRec(String a) {
        char[] c = a.toCharArray();
        char[] result = new char[c.length];
        for (int i = 0; i<c.length; i++) {
            result[i] = c[i];
        }
        int i=0;
        int j=0;
        int n = c.length;
        recu(c,result,i,j,n);
    }

    private static void recu(char[] c, char[] result, int i, int j, int n) {

    }
}
