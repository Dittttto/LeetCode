import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for(int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) list.add(entry);
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        return list.subList(0, k).stream().mapToInt(x-> x.getKey()).toArray();
    }
}