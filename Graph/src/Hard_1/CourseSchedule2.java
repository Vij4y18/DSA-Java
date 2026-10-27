package Hard_1;

import java.util.*;

public class CourseSchedule2 {
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        // creating adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            adj.get(prereq).add(course);
        }

        // calculating inDegree
        int[] inDegree = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Kahn's algo
        Queue<Integer> q = new LinkedList<>();
        int processingCnt = 0;
        int[] res = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            res[processingCnt++] = curr;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return processingCnt == numCourses ? res : new int[] {};
    }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }
}
