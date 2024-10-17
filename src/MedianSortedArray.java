
public class MedianSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,4,6,9,11,13,17};
        int[] arr2 = new int[]{7,9,13,17,18,21,22};
        System.out.println(median(arr1,arr2));
        //System.out.println(medianUsingArrayCopy(arr1,arr2));
        System.out.println(findMedianSortedArrays(arr1,arr2));
        //System.out.println("deepak ="+medianOfTwo(arr1,arr2));
    }

    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

    public static int medianUsingArrayCopy(int[] arr1, int[] arr2) {
        int i = arr1.length;
        int j = arr2.length;

        int[] arr3 = new int[i + j];

        // Merge two array into one array
        System.arraycopy(arr1, 0, arr3, 0, i);
        System.arraycopy(arr2, 0, arr3, i, j);

        // Sort the merged array
        int ans = 0;
        if (arr3.length % 2 == 0) {
            ans = (arr3[(arr3.length/2)-1] + arr3[(arr3.length/2)])/2;
        } else  {
            ans = arr3[arr3.length/2];
        }

        return ans;
    }


    public static int medianOfTwo(int[] arr,int[] arr1){
        if (arr.length < arr1.length) {
            int[] temp = arr;
            arr = arr1;
            arr1 = temp;
        }
        int median=(arr.length+arr1.length)/2;   /* System.out.println(median);*/
        int end =arr1.length/2;
        int start =(median- end)-1;
        while(end >-1){
            if(Math.max(arr[start],arr1[end])<Math.min(arr[start +1],arr1[end +1])){
                return Math.max(arr[start],arr1[end]);
            }else {
                end--;
                start++;
            }
        }
        return -1;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            }
            else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // If the code reaches here, the input arrays were not sorted.
    }

}
