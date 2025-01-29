package com.leetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P49 {

    public List<List<String>> solution(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        for (String str : strs) {
            addStringToGroup(groups, str);
        }
        return groups;
    }

    private void addStringToGroup(List<List<String>> groups, String currString) {
        boolean addedToGroup = false;
        for (int i =0; i< groups.size() && !addedToGroup; i++) {
            String member = groups.get(i).get(0);
            if (isAnagram(member, currString)) {
                groups.get(i).add(currString);
                addedToGroup = true;
            }
        }

        if (!addedToGroup) {
            List<String> newGroup = new ArrayList<>();
            newGroup.add(currString);
            groups.add(newGroup);
        }
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            char[] chr1 = str1.toCharArray();
            Arrays.sort(chr1);
            char[] chr2 = str2.toCharArray();
            Arrays.sort(chr2);

            return Arrays.equals(chr1, chr2);
        }
    }
}
