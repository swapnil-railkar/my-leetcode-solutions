package com.leetCode;

import java.util.Arrays;

public class P2126 {
	public boolean solution(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long totalMass = mass;
        for(int asteroid : asteroids) {
            if(asteroid > totalMass) {
                return false;
            }
            totalMass += asteroid;
        }
        return true;
    }
}
