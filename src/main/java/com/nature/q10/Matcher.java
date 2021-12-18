package com.nature.q10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matcher {

    private final String s;

    private final List<String> group;


    private Set<SE> last, curr;

    public Matcher(String s, List<String> group) {
        this.s = s;
        this.group = group;
        this.last = new HashSet<>();
    }

    public boolean match() {
        for (String regex : this.group) {
            this.curr = new HashSet<>();
            boolean match = this.doMatch(regex);
            this.last = this.curr;
            if (!match) {
                return false;
            }
        }
        for (SE se : this.last) {
            if (se.getStart() == s.length() || se.getEnd() != null && se.getEnd() == s.length()) {
                return true;
            }
        }
        return false;
    }

    private boolean doMatch(String regex) {
        if (this.last.isEmpty()) {
            return this.doMatch(regex, new SE(0, null));
        }
        boolean match = false;
        for (SE se : this.last) {
            if (this.doMatch(regex, se)) {
                match = true;
            }
        }
        return match;
    }

    private boolean doMatch(String regex, SE se) {
        if (se.getEnd() == null) {
            SE curr = this.doMatch(regex, se.getStart());
            if (curr == null) {
                return false;
            }
            this.curr.add(curr);
        } else {
            boolean match = false;
            for (int i = se.getStart(); i < se.getEnd(); i++) {
                SE curr = this.doMatch(regex, i);
                if (curr != null) {
                    match = true;
                    this.curr.add(curr);
                }
            }
            return match;
        }
        return true;
    }

    private SE doMatch(String regex, int start) {
        Integer end = null;
        Character pre = null;
        for (int i = 0; i < regex.length(); i++) {
            char c = regex.charAt(i);
            if (c == '*') {
                if (pre == '.') {
                    end = s.length();
                    break;
                } else {
                    int si = start;
                    while (si < s.length() && s.charAt(si) == pre) {
                        si++;
                        end = end == null ? start + 1 : end + 1;
                    }
                }
            } else {
                if (c == '.') {
                    end = end == null ? start + 1 : end + 1;
                } else if (c == s.charAt(start)) {
                    start++;
                } else {
                    return null;
                }
                pre = c;
            }
        }
        if (end != null && end > s.length()) {
            end = s.length();
        }
        return new SE(start, end);
    }
}
