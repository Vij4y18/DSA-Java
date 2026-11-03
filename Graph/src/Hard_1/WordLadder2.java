package Hard_1;
import java.util.*;

public class WordLadder2 {
    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        System.out.println(findLadders(beginWord,endWord,wordList));
    }
}
