package ImplmentaionProblems;

import java.util.Stack;

class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int indx;
    public StockSpanner() {
        st = new Stack<>();
        indx = -1;
    }

    public int next(int price) {
        indx++;

        while(!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int ans = indx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price,indx});
        return ans;
    }
}

public class Celebrity {
    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();

        System.out.println(sp.next(100)); // 1
        System.out.println(sp.next(80));  // 1
        System.out.println(sp.next(60));  // 1
        System.out.println(sp.next(70));  // 2
        System.out.println(sp.next(60));  // 1
        System.out.println(sp.next(75));  // 4
        System.out.println(sp.next(85));  // 6
    }
}
