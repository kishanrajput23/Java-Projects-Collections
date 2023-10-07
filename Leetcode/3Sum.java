class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return list;
        }
        int current = 0, left, right, sum;
        while(nums[current] <= 0 && current < nums.length - 2){
            left = current + 1;
            right = nums.length - 1;
            if(current > 0 && nums[current] == nums[current - 1]){
                current++;
                continue;
            }
            while(left < right){
                sum = nums[current] + nums[left] + nums[right];
                if(sum == 0){
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right - 1]){
                        right--;
                    }
                    list.add(Arrays.asList(nums[current], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
            current++;
        }
        return list;
    }
}