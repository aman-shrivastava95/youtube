//Pivot approach
/*class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1)return nums[0]==target?0:-1 ;
        int pivot = findPivot(nums) ;
        //if(pivot>=0)return pivot ;
        //the pivot is coming fine, lets do the binary search
        int ans = -1 ;
        if(pivot == 0) {
             ans = Arrays.binarySearch(nums,0,nums.length,target) ;
        } 
        else if(target < nums[0]){
            ans = Arrays.binarySearch(nums,pivot,nums.length, target) ;
        }else{
            ans = Arrays.binarySearch(nums,0,pivot+1, target) ;
        }
        return (ans < 0)?-1:ans ;
        
    }
    //The idea to find the pivot is, that from the pivot all the elements will 
    private int findPivot(int arr[]){
        int n = arr.length ;
        int lo = 0 ;
        int hi = arr.length-1 ;
        while(lo < hi){
            int mid  = (lo+hi)/2 ;
            if(mid+1 < n && arr[mid] > arr[mid+1] )return mid+1 ;
            if(arr[mid] < arr[lo])
                hi = mid ;
            else
                lo = mid +1 ;
        }
        return lo ;
    }
}
*/
//single pass approach
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0 ;
        int hi = nums.length-1  ;
        while(lo<=hi){
            int mid = (lo+hi)/2 ;
            if(nums[mid]==target)
                return mid ;
            //check which half this is
            if(nums[mid] >= nums[0]){
                if(target >= nums[0]){
                    if(target > nums[mid])
                        lo = mid +  1 ;
                    else 
                        hi = mid - 1 ;
                }else{
                    lo = mid + 1 ;
                }
            }else{
                if(target < nums[0]){
                    if(target > nums[mid])
                        lo = mid+1 ;
                    else 
                        hi = mid-1 ;
                }else{
                    hi = mid-1;
                }
                
            }
        }
        return -1 ;
    }
}


