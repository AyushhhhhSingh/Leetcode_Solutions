class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;

        for(int i=0; i < candies.length; i++){
            int candy = candies[i];
            if(candy > maxCandies){
                maxCandies = candy;
            }
        }
        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < candies.length; i++){
            int candy = candies[i];
            if(candy + extraCandies >= maxCandies){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}