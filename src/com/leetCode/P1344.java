package com.leetCode;

public class P1344 {
	public double solution(int hour, int minutes) {
		double minuteHandAng = minutes * 6;
        if(hour == 12) {
            hour = 0;
        }
        double hourHandBase = hour * 60 * 0.5;
        double hourHandExtra = minutes * 0.5;
        double hourHandAng = hourHandBase + hourHandExtra;
        double ang = Math.max(minuteHandAng, hourHandAng) - Math.min(minuteHandAng, hourHandAng);
        return ang > 180 ? 360 - ang : ang;
    }
}
