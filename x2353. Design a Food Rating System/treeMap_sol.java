class FoodRatings {

    // Maps food -> cuisine
    private HashMap<String, String> foodCuisineMap = new HashMap<>();
    // Maps food -> rating
    private HashMap<String, Integer> rankMap = new HashMap<>();
    // Maps cuisine -> TreeSet of foods sorted by rating and name
    private HashMap<String, TreeSet<String>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            foodCuisineMap.put(foods[i], cuisines[i]);
            rankMap.put(foods[i], ratings[i]);

            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>(
                (a, b) -> {
                    if (!rankMap.get(a).equals(rankMap.get(b))) {
                        return rankMap.get(b) - rankMap.get(a); // higher rating first
                    }
                    return a.compareTo(b); // tie-break lexicographically
                }
            ));

            cuisineMap.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        TreeSet<String> set = cuisineMap.get(cuisine);

        // Remove old entry
        set.remove(food);

        // Update rating
        rankMap.put(food, newRating);

        // Re-insert with new rating
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first();
    }
}
