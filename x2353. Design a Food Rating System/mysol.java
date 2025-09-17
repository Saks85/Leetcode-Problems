class FoodRatings {
    HashMap<String, Set<String>> cuisineMap =new HashMap<>();
    HashMap<String, Integer> rankMap= new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n= foods.length;
        for(int i=0; i<n; i++){
  
            if(!cuisineMap.containsKey(cuisines[i])){
                cuisineMap.put(cuisines[i],new TreeSet<String>());

            }
            cuisineMap.get(cuisines[i]).add(foods[i]);
            rankMap.put(foods[i],ratings[i]);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        rankMap.put(food,newRating);
    }
    
    public String highestRated(String cuisine) {
        Set<String> set= cuisineMap.get(cuisine);
        String food=""; int max=0;
        for (String s: set){
            int r=rankMap.get(s);
            if(r>max){
                food= s;
                max=r;
            }
        }
        return food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
