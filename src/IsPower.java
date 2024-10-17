public class IsPower {
    public static void main(String[] args) {
        System.out.println("Is Power " +isPower(10,1000));
    }

    public static boolean isPower(int power, int value) {
        boolean isPower = false;
        int ans = 1;
        float res1 = (float)(Math.log(value) /
                Math.log(power));

        return (res1%1==0);
    }

    public void asdas() {
        LatestTest asa = new LatestTest();
    }

}


