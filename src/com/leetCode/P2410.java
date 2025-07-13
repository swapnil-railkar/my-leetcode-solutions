package com.leetCode;

import java.util.Arrays;

public class P2410 {
	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int pi = players.length - 1;
        int ti = trainers.length - 1;
        while(pi >= 0 && ti >=0) {
            int trainer = trainers[ti];
            if(trainer >= players[pi]) {
                ti--;
                pi--;
                count++;
            } else {
                while(pi >= 0 && players[pi] > trainer) {
                    pi--;
                }
                if(pi >= 0) {
                    ti--;
                    pi--;
                    count++;
                }
            }
        }
        return count;
    }
}
