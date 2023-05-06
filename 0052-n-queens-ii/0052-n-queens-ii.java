import java.util.*;
class Solution {
    public int totalNQueens(int n) {
        String[][] map = new String[n][];
        for(int i = 0; i< n; i++) {
            map[i] = new String[n];
            Arrays.fill(map[i], "#");
        }
        
        return go(map, n, 0);
    }
    
    public int go(String[][] map, int n, int depth) {
        if(depth == map.length) {
            return 1;
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(!valid(map, i, depth)) continue;
            map[depth][i] = "Q";
            result += go(map, n, depth+1);
            map[depth][i] = "#";
        }
        
        return result;
    }
    
    public boolean valid(String[][] map, int x, int depth) {
        if(map[depth][x].equals("Q")) return false;
        // top
        for(int i = depth - 1; i >= 0 ;i--) {
            if(map[i][x].equals("Q")) return false;
        }
        
        // left top
        for(int i = 0; i < depth; i++) {
            if(depth - i - 1 < 0 || x-i - 1 < 0) continue;
            if(map[depth - i - 1][x - i - 1].equals("Q")) return false;
        }
        
        // right top
        for(int i = 0; i < depth;i++) {
            if(depth - i-1 < 0 || x+i+1 >= map.length) continue;
            if(map[depth -i - 1][x + i + 1].equals("Q")) return false;
        }
        
        return true;
    }
}