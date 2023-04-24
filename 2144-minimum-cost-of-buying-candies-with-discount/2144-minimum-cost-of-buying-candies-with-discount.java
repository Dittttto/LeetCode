import java.util.*;
class Solution {
    public int presentation(int[] cost) {
        Arrays.sort(cost);
        int answer = 0;
        int cnt = 0;
        for(int i = cost.length - 1; i >= 0; i--) {
            if(cnt == 2){ 
                cnt = 0;
                continue;
            }
            
            answer += cost[i];
            cnt++;
        }
        
        return answer;
    }
    public int minimumCost(int[] cost) {
        return presentation(cost);
    }
}