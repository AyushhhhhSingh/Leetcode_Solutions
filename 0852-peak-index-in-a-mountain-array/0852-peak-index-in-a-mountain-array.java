class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end ){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){
                // you are in descending part of the array
                // this may be the answer but look at left
                //this is why end is not equal to end-1
                end = mid;
            }else{
                // you are in the ascending part of the array
                start = mid + 1; // because we know that mid+1 element is greater than mid element 
            }
        }
        // int he end, start == end and pointing to the larger number because of the above two checks
        // start and end always try to find the max elements in the above 2 checks
        // hence when they are pointing to just one element that is the max element in the array
        return start;  // or return end as both are equal
    }
}