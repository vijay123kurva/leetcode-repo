class Solution {
    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                slow = next(nums, slow, forward);

                if (slow == -1) {
                    break;
                }

                fast = next(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                fast = next(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                if (slow == fast) {

                  
                    if (slow == next(nums, slow, forward)) {
                        break;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private int next(int[] nums, int index, boolean forward) {

        
        if ((nums[index] > 0) != forward) {
            return -1;
        }

        int n = nums.length;

        int nextIndex = (index + nums[index]) % n;

        if (nextIndex < 0) {
            nextIndex += n;
        }

    
        if (nextIndex == index) {
            return -1;
        }

        return nextIndex;
    }
}