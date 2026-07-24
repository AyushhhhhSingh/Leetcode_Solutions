class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        // Pehle first position (starting index) dhoondo
        result[0] = findBound(nums, target, true);

        // Agar element array me mila hi nahi, to search aage karne ki zarurat nahi hai
        if (result[0] == -1) {
            return result;
        }

        // Fir last position (ending index) dhoondo
        result[1] = findBound(nums, target, false);

        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid; // Match mila, isko save karo

                if (isFirst) {
                    // Aur pehle (left side) match mil sakta hai kya?
                    end = mid - 1;
                } else {
                    // Aur baad me (right side) match mil sakta hai kya?
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // Quick Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] range = sol.searchRange(nums, target);
        System.out.println("[" + range[0] + ", " + range[1] + "]"); // Output: [3, 4]
    }
}