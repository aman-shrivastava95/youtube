//top down
class Solution {
    int dp[] ;
    public int rob(int[] nums) {
        dp = new int[nums.length] ;
        for(int i = 0;i<dp.length;i++)
            dp[i] = -1 ;
        return robUtil(nums, nums.length-1) ;
    }
    private int robUtil(int nums[], int pos){
        if(pos==0) return nums[pos] ;
        if(pos < 0) return 0 ;
        if(dp[pos]!=-1)
            return dp[pos] ;
        
        int choice1 = nums[pos]+ robUtil(nums, pos-2) ;
        int choice2 = robUtil(nums, pos-1) ;
        
        dp[pos] = Math.max(choice1, choice2) ;
        return dp[pos] ;
    }
}


//bottom up
class Solution{
    public int rob(int[] nums){
        int n = nums.length ;
        if(n< 2)
            return nums[0] ;
        int dp[] = new int[n] ;
        dp[0] = nums[0] ;
        dp[1] = Math.max(nums[0],nums[1]) ;
        for(int i=2; i<n; i++){
            dp[i]= Math.max(nums[i]+dp[i-2],dp[i-1]) ;
        }
        return dp[n-1] ;
    }
}




