import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;

public class SecondLargestInArray {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9,5,4,6,3,2,7};
        int highest = -1;
        int secondHighest = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>highest){
                secondHighest=highest;
                highest=arr[i];
            } else if (arr[i]>secondHighest) {
                secondHighest=arr[i];
            }

        }
        int x[]={9,5,4,6,3,2,7};
        System.out.println(Arrays.asList(arr).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        System.out.println(Arrays.stream(x).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        System.out.println("Highest " +highest);
        System.out.println("Second Highest " +secondHighest);

    }
}
