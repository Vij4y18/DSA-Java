package Medium;

import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int freq;
    int availableTime;

    Pair(int freq, int availableTime) {
        this.freq = freq;
        this.availableTime = availableTime;
    }
}

public class TaskScheduler {

    static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        Queue<Pair> coolDownQueue = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !coolDownQueue.isEmpty()) {
            time++;

            while (!coolDownQueue.isEmpty() && coolDownQueue.peek().availableTime == time) {
                pq.offer(coolDownQueue.poll().freq);
            }

            if (!pq.isEmpty()) {
                int current = pq.poll();
                current--;

                if (current > 0) {
                    coolDownQueue.offer(new Pair(current,time+n+1));
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }
}
