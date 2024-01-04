import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[3000];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i < Math.sqrt(3000); i++){
            if(isPrime[i]){
                for(int j = i * i; j < 3000; j += i){
                    isPrime[j] = false;
                }
            }    
        }
        
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int value = nums[i] + nums[j] + nums[k];
                    if(isPrime[value]){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}