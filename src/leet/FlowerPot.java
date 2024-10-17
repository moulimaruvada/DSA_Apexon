package leet;

public class FlowerPot {
    public static void main(String[] args) {
        int[] flowerbed = {0,1,1,0,0,0};
        int n = 1;
        System.out.println(canFlowersBePlotted(flowerbed, n));
    }

    private static boolean canFlowersBePlotted(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length && flowerbed[i] == 1) i += 2;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) { i+=2; continue; }
            if (i != flowerbed.length - 1 && flowerbed[i+1] == 1) { i+=3; continue; }
            if (i != 0 && flowerbed[i-1] == 1) { i+=1; continue; }
            n--;
            i+=2;
        }
        return n == 0;
    }
}
