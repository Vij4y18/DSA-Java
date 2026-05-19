package Easy;

public class LinearSearch {

    static boolean linearSearch (int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5,8,4,9,2,3,1};
        int target = 2;
        System.out.println(linearSearch(arr,target));
    }
}
