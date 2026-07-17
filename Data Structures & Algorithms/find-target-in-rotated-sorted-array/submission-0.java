class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);
        if(target <= nums[nums.length - 1])
        {
            return search(nums,pivot,nums.length - 1,target);
        }
        return search(nums,0,pivot - 1,target);
    }
    public int search(int[] nums , int low ,int high,int target)
    {
        while(low <= high)
        {
             int mid = (low + high)/2;
            if(nums[mid] ==  target)
            {
                return mid;
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findPivotIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] <= nums[nums.length - 1])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}
