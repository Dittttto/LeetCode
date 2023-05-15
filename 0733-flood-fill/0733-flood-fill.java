import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] check = new boolean[image.length][image[0].length];
        int origin = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        check[sr][sc] = true;
        
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,-1,0,1};
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            for(int i = 0; i< 4; i++) {
                int x = dx[i] + pos[0];
                int y = dy[i] + pos[1];
                
                if(x < 0 || x >= image.length) continue;
                if(y < 0 || y >= image[0].length) continue;
                if(check[x][y] || image[x][y] != origin) continue;
                q.add(new int[]{x,y});
                image[x][y] = color;
                check[x][y] = true;
            }
        }
        
        return image;
    }
}