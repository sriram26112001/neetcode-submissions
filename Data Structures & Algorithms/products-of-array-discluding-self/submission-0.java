class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productPrefix = new int[nums.length];
        int[] productPostFix = new int[nums.length];
        int[] output = new int[nums.length];
        int product = 1;
        for(int i = 0;i < nums.length ;i++)
        {
            product = product * nums[i];
            productPrefix[i] = product;
        }
        product = 1;
        for(int i = nums.length - 1;i >= 0 ;i--)
        {
            product = product * nums[i];
            productPostFix[i] = product;
        }
        for(int i = 0;i < nums.length;i++)
        {
            if(i == 0)
            {
                output[i] = productPostFix[i + 1];
            }
            else if(i == nums.length - 1)
            {
                output[i] = productPrefix[i - 1];
            }
            else
            {
                output[i] = productPrefix[i - 1] * productPostFix[i + 1];
            }
        }
        return output;
    }
}  
