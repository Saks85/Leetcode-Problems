import java.util.*;

class MovieRentingSystem {

    // Custom pair for shop-movie combination
    private static class ShopMovie {
        int shop, movie;
        ShopMovie(int s, int m) {
            shop = s;
            movie = m;
        }
    }

    // Sorting comparator for movie search: price → shop
    private static class SearchComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) return a[0] - b[0]; // price
            return a[1] - b[1]; // shop
        }
    }

    // Sorting comparator for rented global report: price → shop → movie
    private static class RentedComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) return a[0] - b[0];       // price
            if (a[1] != b[1]) return a[1] - b[1];       // shop
            return a[2] - b[2];                         // movie
        }
    }

    private Map<Integer, TreeSet<int[]>> movieToShops; // movie -> sorted shops
    private TreeSet<int[]> rentedMovies; // sorted global rented movies
    private Map<String, Integer> priceMap; // "shop-movie" -> price
    private Set<String> rentedSet; // "shop-movie" currently rented

    public MovieRentingSystem(int n, int[][] entries) {
        movieToShops = new HashMap<>();
        rentedMovies = new TreeSet<>(new RentedComparator());
        priceMap = new HashMap<>();
        rentedSet = new HashSet<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(key(shop, movie), price);

            movieToShops.putIfAbsent(movie, new TreeSet<>(new SearchComparator()));
            movieToShops.get(movie).add(new int[]{price, shop});
        }
    }

    // Helper for consistent map key
    private String key(int shop, int movie) {
        return shop + "-" + movie;
    }

    /** Search the 5 cheapest shops for a given movie */
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieToShops.containsKey(movie)) return res;

        TreeSet<int[]> set = movieToShops.get(movie);
        int count = 0;
        for (int[] pair : set) {
            res.add(pair[1]); // shop
            if (++count == 5) break;
        }
        return res;
    }

    /** Rent a movie from a shop */
    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));

        // Remove from unrented
        movieToShops.get(movie).remove(new int[]{price, shop});

        // Add to rented
        rentedMovies.add(new int[]{price, shop, movie});
        rentedSet.add(key(shop, movie));
    }

    /** Drop a previously rented movie back to shop */
    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));

        // Remove from rented
        rentedMovies.remove(new int[]{price, shop, movie});
        rentedSet.remove(key(shop, movie));

        // Add back to unrented
        movieToShops.get(movie).add(new int[]{price, shop});
    }

    /** Get report of cheapest 5 rented movies */
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] r : rentedMovies) {
            res.add(Arrays.asList(r[1], r[2])); // shop, movie
            if (++count == 5) break;
        }
        return res;
    }
}
