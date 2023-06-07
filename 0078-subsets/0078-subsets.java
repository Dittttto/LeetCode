import java.util.*;

class Solution {
    static HashSet<List<Integer>> set;

    public List<List<Integer>> subsets(int[] nums) {        
        set = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();
        go(nums, list, 0, 0);
        List<List<Integer>> answer = new ArrayList<>();
        for(List<Integer> r : set) {
            answer.add(r);
        }
        
        return answer;
    }
    
    public void go(int[] arr, List<Integer> out, int depth, int selected) {
        if(selected > arr.length) {
            return;
        }
        set.add(new ArrayList<>(out));
        if(depth >= arr.length) return;
        out.add(arr[depth]);
        go(arr, out, depth+1, selected+1 );
        out.remove(out.size() - 1);
        go(arr, out, depth+1, selected+1 );
    }
}