public class SnowStack {
    public static void main(String[] args) {
        //int[] arr = new int[]{3,0,1,0,4};
        int[] arr1 = {1,8,6,2,5,4,8,3,7};
        //System.out.println(maxWater(arr, arr.length));
        System.out.println(maxWater(arr1, arr1.length));
    }

    public static int maxWater(int arr[], int n)
    {
        int size = n - 1;

        // Let the first element be stored as
        // previous, we shall loop from index 1
        int prev = arr[0];

        // To store previous wall's index
        int prev_index = 0;
        int water = 0;

        // To store the water until a larger wall
        // is found, if there are no larger walls
        // then delete temp value from water
        int temp = 0;
        for (int i = 1; i <= size; i++) {

            if (arr[i] >= prev) {
                prev = arr[i];
                prev_index = i;
                temp = 0;
            }
            else {

                water += prev - arr[i];
                temp += prev - arr[i];
            }
        }

        if (prev_index < size) {

            water -= temp;
            prev = arr[size];

            for (int i = size; i >= prev_index; i--) {

                if (arr[i] >= prev) {
                    prev = arr[i];
                }
                else {
                    water += prev - arr[i];
                }
            }
        }

        // Return the maximum water
        return water;
    }
}
