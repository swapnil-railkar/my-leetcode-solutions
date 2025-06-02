package com.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P135 {
	public int candy(int[] ratings) {
        if(ratings.length == 1) {
            return 1;
        }
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.rating, b.rating));
        for(int i = 0; i< ratings.length; i++) {
            pq.add(new Wrapper(ratings[i], i));
        }
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        while(!pq.isEmpty()) {
            Wrapper wrapper = pq.remove();
            int rating = wrapper.rating;
            int index = wrapper.index;
            if(index == 0) {
                if(ratings[index + 1] < rating) {
                    count[index] = count[index+1] + 1;
                } else if(ratings[index + 1] == rating) {
                    count[index] = count[index+1];
                }
            } else if(index == ratings.length - 1) {
                if(ratings[index - 1] < rating) {
                    count[index] = count[index-1] + 1;
                } else if(ratings[index - 1] == rating) {
                    count[index] = count[index-1];
                }
            } else {
                if(ratings[index-1] < rating && ratings[index + 1] < rating) {
                    int maxRating = Math.max(count[index - 1], count[index + 1]);
                    count[index] = maxRating + 1;
                } else if(ratings[index-1] < rating) {
                    count[index] = count[index-1] + 1;
                } else if(ratings[index+1] < rating) {
                    count[index] = count[index+1] + 1;
                }
            }
        }
        int sum = 0;
        for(int n : count) {
            sum += n;
        }
        return sum;
    }

    private static class Wrapper{
        int rating;
        int index;
        Wrapper(int rating, int index) {
            this.rating = rating;
            this.index = index;
        }
    }
}
