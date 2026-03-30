package Recursion_Hard;



public class WordSearch {
    static boolean search (int i, int j, String word, char[][] board,int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j]; // Take back up
        board[i][j] = '.';

        boolean found = search(i+1,j,word,board,index+1) ||
                        search(i-1,j,word,board,index+1) ||
                        search(i,j+1,word,board,index+1) ||
                        search(i,j-1,word,board,index+1);

        board[i][j] = temp;// BackTrack

        return found;

    }
    static boolean exist (String word, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++){
                if(search(i,j,word,board,0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String word = "SEE";
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(word,board));
    }
}
