import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] map = new String[n][n];
        for(String[] row: map) {
            Arrays.fill(row, ".");
        }

        go(map, n, 0);
        
        return result;
    }
    
    public void go(String[][] map, int n, int depth) {
        if(depth == map.length) {
            ArrayList<String> tmpList = new ArrayList<>();
            for(String[] row: map) {
                String tmp = "";
                for(String str: row) {
                    tmp += str;
                }
                tmpList.add(tmp);
            }
            result.add(tmpList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isValid(map, depth, i)) continue;
            map[depth][i] = "Q";
            go(map, n, depth+1);
            map[depth][i] = ".";
        }
    }

    public boolean isValid(String[][] map, int depth , int i) {
        for (int j = 0; j < depth; j++) {
            if(map[j][i].equals("Q")) return false;
        }
        for (int j = 1; j <= depth; j++) {
            if(depth - j < 0 || i - j < 0) continue;
            if(map[depth - j][i - j].equals("Q")) return false;
        }
        for (int j = 1; j <= depth; j++) {
            if(depth - j < 0 || i + j >= map.length) continue;
            if(map[depth - j][i+j].equals("Q")) return false;
        }
        return true;
    }
}