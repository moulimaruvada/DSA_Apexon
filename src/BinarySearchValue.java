public class BinarySearchValue {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,5,7,9,13,15,17};
        int value = 5;
        System.out.println(isNumberexist(array, value));

    }

    private static boolean isNumberexist(int[] array, int value) {
        int low =0;
        int high = array.length-1;

        while (low <= high) {
            int mid  = (low+high)/2;

            if (array[mid] == value){
                return true;
            }

            if (array[mid] < value) {
                low = mid+1;
            } else if (array[mid] > value){
                high = mid -1;
            }
        }
        return false;
    }
}
