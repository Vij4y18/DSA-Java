package Hard_1;
import java.util.*;

class wordPair {
    String word;
    int steps;

    wordPair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class WordLadder {
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<wordPair> q = new LinkedList<>();
        q.offer(new wordPair(beginWord,1));

        Set<String> st = new HashSet<>();
        for (int i=0; i<wordList.size(); i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i=0; i<word.length(); i++) {
                for (char ch='a'; ch<='z'; ch++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);

                    if (st.contains(newWord)) {
                        q.offer(new wordPair(newWord, steps + 1));
                        st.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
