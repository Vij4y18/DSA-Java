package BsOnAnswers;

public class Finding_sqrt {
    public static int findsqrt(int n) {
        int low = 1;
        int high = n;

        while(low<=high) {
            int mid = (low+high)/2;

            if(mid*mid <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    static void main() {
        int n = 81;
        System.out.println(findsqrt(n));
    }
}
