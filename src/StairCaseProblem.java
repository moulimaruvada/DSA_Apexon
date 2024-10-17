public class StairCaseProblem {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToClimb(n+1));;
    }

    private static int waysToClimb(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return  waysToClimb(n-1)+waysToClimb(n-2);
    }
}
