class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pd = 1;
        int pdz = 1;
        boolean hasZero = false;
        int cnt = 0;
        int[] answer = new int[nums.length];
        for(int num: nums){
            if(num!= 0) pd *= num;
            if(num == 0){
                hasZero = true;
                cnt++;
            }
            pdz *= num;
        }
        
        
        int idx = 0;
        for(int num: nums) {
            if(hasZero) {
                if(cnt > 1) {
                    answer[idx++] = 0;
                }else {
                    answer[idx++] = num == 0 ? pd : 0;
                }
            }else {
                answer[idx++] = pdz / num;
            }
        }
        
        
        
        return answer;
    }
}