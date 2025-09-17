package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P2353 {
	Map<String, TreeSet<Wrapper>> cuisinFoodMap = new HashMap<>();
    Map<String, String> foodCuisineType = new HashMap<>();
    Map<String, Integer> foodRatingMap = new HashMap<>();

    public P2353(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i< foods.length; i++) {
            foodCuisineType.put(foods[i], cuisines[i]);
            foodRatingMap.put(foods[i], ratings[i]);
            Wrapper w = new Wrapper(foods[i], ratings[i]);
            if(cuisinFoodMap.containsKey(cuisines[i])) {
                cuisinFoodMap.get(cuisines[i]).add(w);
            } else {
            	TreeSet<Wrapper> pq = new TreeSet<>((a, b) -> {
            		if(a.rating == b.rating) {
            			return a.food.compareTo(b.food);
            		}
            		return Integer.compare(b.rating, a.rating);
            	});
                pq.add(w);
                cuisinFoodMap.put(cuisines[i], pq);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineType.get(food);
        TreeSet<Wrapper> pq = cuisinFoodMap.get(cuisine);
        Wrapper delete = new Wrapper(food, foodRatingMap.get(food));
        pq.remove(delete);
        foodRatingMap.put(food, newRating);
        pq.add(new Wrapper(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        return cuisinFoodMap.get(cuisine).first().food;
    }

    private static class Wrapper{
        String food;
        int rating;
        Wrapper(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }
}
