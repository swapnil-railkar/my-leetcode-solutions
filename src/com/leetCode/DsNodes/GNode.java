package com.leetCode.DsNodes;

import java.util.ArrayList;
import java.util.List;

public class GNode {
    public int val;
    public List<GNode> neighbors;

    public GNode() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }

    public GNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public GNode(int val, List<GNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
