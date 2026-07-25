/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        // Step 1: Find the Peak Element Index
        int peak = findPeak(mountainArr, 0, length - 1);

        // Step 2: Try finding target in the left (increasing) half
        int leftResult = binarySearchAscending(mountainArr, target, 0, peak);
        if (leftResult != -1) {
            return leftResult; // Return smallest index if found
        }

        // Step 3: Try finding target in the right (decreasing) half
        return binarySearchDescending(mountainArr, target, peak + 1, length - 1);
    }

    // Binary search to find Peak Index
    private int findPeak(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // We are in the ascending part -> peak is to the right
                left = mid + 1;
            } else {
                // We are in the descending part -> peak is mid or to the left
                right = mid;
            }
        }
        return left; // left == right is the peak
    }

    // Binary search for Ascending order
    private int binarySearchAscending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Binary search for Descending order
    private int binarySearchDescending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            if (val > target) left = mid + 1;  // Greater element is to the left
            else right = mid - 1;             // Smaller element is to the right
        }
        return -1;
    }
}