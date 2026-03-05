package BsOnAnswers;

public class PaintersPartition {
    public static int max(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }
        return mx;
    }
    public static int sum(int[] arr) {
        int cnt = 0;
        for(int i : arr) {
            cnt+=i;
        }
        return cnt;
    }
    public static int canAllocate(int[] arr, int pages) {
        int allocatedStudents = 1;
        int pagecnt = 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] + pagecnt <= pages) {
                pagecnt += arr[i];
            } else {
                allocatedStudents += 1;
                pagecnt = arr[i];
            }
        }
        return allocatedStudents;
    }
    public static int books(int[] arr, int k) {
        int low = max(arr);
        int high = sum(arr);

        while(low<=high) {
            int mid = (low+high)/2;

            if(canAllocate(arr,mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    static void main() {
        int[] arr = {1,2,3,4,5};
        int k = 3;

        System.out.println(books(arr,k));
    }
}
