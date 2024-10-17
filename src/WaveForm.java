public class WaveForm {
    public static void main(String[] args) {

        int[] arr = new int[]{10, 5, 6, 3, 2, 20, 100, 80};

        arrayWaveForm(arr);
    }

    public static void swap(int[] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void arrayWaveForm(int[] arr) {
        for (int i = 0; i < arr.length; i+=2) {

            if (i > 0 && arr[i] < arr[i-1]) {
                swap(arr,i,i-1);
            }

            if (i<arr.length-1 && arr[i] < arr[i+1]) {
                swap(arr,i,i+1);
            }
        }

        for (int a: arr) {
            System.out.println(a);
        }
    }
}
