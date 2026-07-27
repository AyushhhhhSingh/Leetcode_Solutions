class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0; // Starting point is 0, so max is at least 0

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i]; // Running Sum
            
            // Maximum altitude update karo
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }
}