class Solution {
    public void wiggleSort(int[] nums) {
          Arrays.sort(nums);
        int n = nums.length-1;
        int []temp = new int[nums.length];

        for(int i=1;i<nums.length;i+=2) temp[i]=nums[n--];
        for(int i=0;i<nums.length;i+=2) temp[i]=nums[n--];
        for(int i=0;i<nums.length;i++) nums[i]=temp[i];
    }
}
