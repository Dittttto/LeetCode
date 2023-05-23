class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i< board.length ;i ++){
            for(int j = 0; j < board.length; j++) {
                if(!checkRow(i, board) || !checkCol(j, board)) return false;
                if(i % 3 == 0 && j %3 == 0 && !checkRec(i, j, board)) return false;
            }
        }
        return true;
    }
    
    public boolean count(int[] check) {
        for(int ch: check) if(ch > 1) return false;
        return true;
    }
    
    public boolean checkRow(int x, char[][] board) {
        int[] check = new int[10];
        for(char c: board[x]) {
            if(c == '.') continue;
            check[c - '0'] += 1;
        }
        
        return count(check);
    }
    
    public boolean checkCol(int y, char[][] board) {
        int[] check = new int[10];
        for(int i = 0; i< board.length; i++) {
            char c = board[i][y];
            if(c == '.') continue;
            check[c - '0'] += 1;
        }
        
        return count(check);
    }
    
    public boolean checkRec(int x, int y, char[][] board) {
        int[] check = new int[10];
        for(int i = x; i < x+3 ;i++) {
            for(int j = y; j < y+3; j++) {
                if(board[i][j] == '.') continue;
                check[board[i][j] - '0'] += 1;
            }
        }
        
        return count(check);
    }
}