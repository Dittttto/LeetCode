class Solution {
    static char[][] map;
    public boolean isValidSudoku(char[][] board) {
        map = board;
        for(int i = 0; i< board.length ;i ++){
            for(int j = 0; j < board.length; j++) {
                if(!checkRow(i) || !checkCol(j)) return false;
                if(i % 3 == 0 && j %3 == 0 && !checkRec(i, j)) return false;
            }
        }
        return true;
    }
    
    public boolean count(int[] check) {
        for(int ch: check) if(ch > 1) return false;
        return true;
    }
    
    public boolean checkRow(int x) {
        int[] check = new int[10];
        for(char c: map[x]) {
            if(c == '.') continue;
            check[c - '0'] += 1;
        }
        
        return count(check);
    }
    
    public boolean checkCol(int y) {
        int[] check = new int[10];
        for(int i = 0; i< map.length; i++) {
            if(map[i][y] == '.') continue;
            check[map[i][y] - '0'] += 1;
        }
        
        return count(check);
    }
    
    public boolean checkRec(int x, int y) {
        int[] check = new int[10];
        for(int i = x; i < x+3 ;i++) {
            for(int j = y; j < y+3; j++) {
                if(map[i][j] == '.') continue;
                check[map[i][j] - '0'] += 1;
            }
        }
        
        return count(check);
    }
}