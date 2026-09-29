package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

                    /*
                    0
                   / \
                  1   2
                 /|\  |\
                4 8 5 5 6 9
               / \ | | | | |
              2  1 7 9 3 0 3
                  |   |   |
                  8   6   5
                      |
                      1
                    */
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(4, 8, 0)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6, 9, 0)));
        adj.add(new ArrayList<>(Arrays.asList(4, 7, 8, 0)));
        adj.add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.add(new ArrayList<>(Arrays.asList(8, 1, 7, 9, 3)));
        adj.add(new ArrayList<>(Arrays.asList(6, 0, 3, 5, 1)));
        adj.add(new ArrayList<>(Arrays.asList(6, 0, 3, 5, 1)));
        adj.add(new ArrayList<>(Arrays.asList(7, 9, 3, 6, 0)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5, 1, 6)));

        System.out.println(dfsIterative(adj));
        System.out.println(dfs(adj)); // Recursive approach
    }

    // Iterative approach
    static ArrayList<Integer> dfsIterative(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        st.push(0);

        while (!st.isEmpty()) {
            Integer node = st.pop();

            if (vis[node]) continue;

            vis[node] = true;
            result.add(node);

            for (int i = adj.get(node).size() - 1; i >= 0; i--) {
                if (!vis[adj.get(node).get(i)]) {
                    st.push(adj.get(node).get(i));
                }
            }
        }

        return result;
    }

    // Recursive approach and this is the Standard DFS approach
    static ArrayList<Integer> result = new ArrayList<>();

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];

        dfsHelper(0, vis, adj);

        return result;
    }

    static void dfsHelper (Integer node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        result.add(node);

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfsHelper (it, vis, adj);
            }
        }
    }
}
