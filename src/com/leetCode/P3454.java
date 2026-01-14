package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class P3454 {
	public double separateSquares(int[][] squares) {
        TreeMap<Double, List<Event>> events = new TreeMap<>();

        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];

            events.computeIfAbsent(y1, k -> new ArrayList<>())
                    .add(new Event(x1, x2, true));

            events.computeIfAbsent(y2, k -> new ArrayList<>())
                    .add(new Event(x1, x2, false));
        }

        TreeMap<Double, Integer> active = new TreeMap<>();
        double totalArea = 0.0;
        double prevY = 0.0;
        boolean first = true;

        // First pass → total union area
        for (double y : events.keySet()) {
            if (!first) {
                double width = unionWidth(active);
                totalArea += width * (y - prevY);
            }
            first = false;

            for (Event e : events.get(y)) {
                update(active, e, e.isStart ? 1 : -1);
            }
            prevY = y;
        }

        double half = totalArea / 2.0;

        // Second pass → find exact Y
        active.clear();
        prevY = 0.0;
        first = true;
        double accumulated = 0.0;

        for (double y : events.keySet()) {
            if (!first) {
                double width = unionWidth(active);
                double slabArea = width * (y - prevY);

                if (accumulated + slabArea >= half) {
                    return prevY + (half - accumulated) / width;
                }

                accumulated += slabArea;
            }
            first = false;

            for (Event e : events.get(y)) {
                update(active, e, e.isStart ? 1 : -1);
            }
            prevY = y;
        }

        return prevY;
    }

    private void update(TreeMap<Double, Integer> map, Event e, int delta) {
        map.put(e.x1, map.getOrDefault(e.x1, 0) + delta);
        map.put(e.x2, map.getOrDefault(e.x2, 0) - delta);

        if (map.get(e.x1) == 0)
            map.remove(e.x1);
        if (map.get(e.x2) == 0)
            map.remove(e.x2);
    }

    private double unionWidth(TreeMap<Double, Integer> map) {
        double width = 0.0;
        int active = 0;
        double prev = 0.0;
        boolean first = true;

        for (var entry : map.entrySet()) {
            double x = entry.getKey();
            if (!first && active > 0) {
                width += x - prev;
            }
            active += entry.getValue();
            prev = x;
            first = false;
        }
        return width;
    }

    private class Event {
        double x1, x2;
        boolean isStart;

        Event(double x1, double x2, boolean isStart) {
            this.x1 = x1;
            this.x2 = x2;
            this.isStart = isStart;
        }
    }
}
