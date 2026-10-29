package Hard_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/alien-dictionary/1
// GFG has updated the problem so we have to calculate the unique chars(K) by ourself

public class AlienDictionary {
    private static String findOrder(String [] dict, int N, int K) {
        // creating edges
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<K; i++) adj.add(new ArrayList<>());

        for (int i=0; i<N-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(),s2.length());
            boolean found = false;

            for (int j=0; j<len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    found = true;
                    int row = s1.charAt(j) - 'a';
                    int col = s2.charAt(j) - 'a';

                    adj.get(row).add(col);
                    break;
                }
            }
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }

        // calculating in-Degree
        int[] inDegree = new int[K];
        for (int i=0; i<K; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Topo Sort
        Queue<Integer> q = new LinkedList<>();
        String res = "";
        int processingCnt = 0;

        for (int i=0; i<K; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            res += (char) (curr + 'a');
            processingCnt++;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return processingCnt == K ? res : "";
    }

    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        int n = 5;
        int k = 4;

        System.out.println(findOrder(dict,n,k));
    }
}
