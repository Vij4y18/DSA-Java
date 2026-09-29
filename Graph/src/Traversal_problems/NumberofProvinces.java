package Traversal_problems;

public class NumberofProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(findCircleNum(isConnected));
    }


    static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int result = 0;
        boolean[] vis = new boolean[v];

        for (int i=0; i<v; i++) {

            if (!vis[i]) {
                result++;
                dfsHelper(i, vis, isConnected);
            }
        }
        return result;
    }

    static void dfsHelper (int node, boolean[] vis, int[][] isConnected) {
        vis[node] = true;

        for (int i=0; i<isConnected.length; i++) {
            if (!vis[i] && isConnected[node][i] == 1) {
                dfsHelper (i, vis, isConnected);
            }
        }
    }
}
