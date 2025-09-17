import java.util.*;

class FoodRatings {

    private static class Pair {
        String food;
        int rating;
        Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }

    private HashMap<String, String> foodCuisineMap = new HashMap<>();
    private HashMap<String, Integer> rankMap = new HashMap<>();
    private HashMap<String, PriorityQueue<Pair>> cuisineHeapMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            foodCuisineMap.put(foods[i], cuisines[i]);
            rankMap.put(foods[i], ratings[i]);

            cuisineHeapMap.putIfAbsent(cuisines[i], new PriorityQueue<>(
                (a, b) -> {
                    if (a.rating != b.rating) return b.rating - a.rating; // higher rating first
                    return a.food.compareTo(b.food); // tie-break lexicographically
                }
            ));

            cuisineHeapMap.get(cuisines[i]).offer(new Pair(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        rankMap.put(food, newRating);
        // Push updated pair into heap
        cuisineHeapMap.get(cuisine).offer(new Pair(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = cuisineHeapMap.get(cuisine);

        // Remove outdated entries
        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            if (rankMap.get(top.food) == top.rating) {
                return top.food; // top is valid
            }
            pq.poll(); // discard outdated
        }
        return ""; // shouldn't happen per problem guarantees
    }
}
