import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] check = new boolean[strs.length];
        List<List<String>> list = new ArrayList<>();
        
        for(int i = 0; i< strs.length; i++) {
            if(check[i]) continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(strs[i]);
            check[i] = true;
            
            for(int j = i+1; j<strs.length;j++) {
                if(strs[i].length() != strs[j].length()) continue;
                if(strs[i].equals(strs[j])){
                    tmp.add(strs[j]);
                    check[j] = true;
                }else {
                    if(checkAnagram(strs[i], strs[j])) {
                        tmp.add(strs[j]);
                        check[j] = true;
                    }
                }
            }
            
            Collections.sort(tmp);
            list.add(tmp);
        }
        
        return list;
    }
    
    public boolean checkAnagram(String str1, String str2) {
        int[] alph = new int[26];
        // int[] alph2 = new int[26];
        
        char[] arr = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            alph[arr[i] - 'a' ] -= 1;
            alph[arr2[i] - 'a' ] += 1;
        }
        
        for(int i=0; i< alph.length; i++) {
            if(alph[i] != 0) return false;
        }
        
        return true;
    }
}