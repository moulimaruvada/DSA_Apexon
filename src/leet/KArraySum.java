package leet;

public class KArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        System.out.println( maxOperations(arr,2));
    }

    public static int maxOperations(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int operationCount = 0;
        int left = 0;
        int right = 1;
        while(left < nums.length && right < nums.length && temp[left] != -1 && temp[right] != -1) {
            if (nums[left] > k && left < nums.length-1) {
                left++;
            }
            if (nums[right] > k && right < nums.length-1) {
                right++;
            }
            if(nums[left] != 0 && nums[right] != 0 && nums[left]+nums[right] == k) {
                nums[left] = 0;
                temp[left] = -1;
                nums[right] = 0;
                temp[right] = -1;
                operationCount++;
                left++;
                right++;
            }
            if(right == nums.length-1) {
                left++;
                right = left+1;
            } else if(right < nums.length-1) {
                right++;
            }


        }
        return operationCount;
    }
}
