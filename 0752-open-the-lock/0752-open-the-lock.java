import java.util.*;
class Solution {
    public String plusOne(String s, int i ) {
        char[] ch = s.toCharArray();
        if(ch[i] == '9') {
            ch[i] = '0';
        }else {
            ch[i] += 1;
        }
        
        return new String(ch);
    }
    
    public String minusOne(String s, int i ) {
        char[] ch = s.toCharArray();
        if(ch[i] == '0') {
            ch[i] = '9';
        }else {
            ch[i] -= 1;
        }
        
        return new String(ch);
    }
    
    public int bfs(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int cnt = 0;
        
        for(String str: deadends) {
            deads.add(str);
        }
        
        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()) {
            int sz = q.size();
            
            for(int i = 0; i< sz; i++) {
                String cur = q.poll();
                
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return cnt;
                
                for(int j = 0; j < 4;j++){
                    String plus = plusOne(cur, j);
                    String minus = minusOne(cur, j);
                    
                    if(!visited.contains(plus)) {
                        q.offer(plus);
                        visited.add(plus);                        
                    }
                    
                    if(!visited.contains(minus)) {
                        q.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
    }
    
    
    public int openLock(String[] deadends, String target) {
        return bfs(deadends, target);
    }
}