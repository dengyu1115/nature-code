package com.nature.q10;

import java.util.Objects;

public class SE {

    private final int start;
    private final Integer end;

    public SE(int start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || hashCode() != o.hashCode()) return false;
        SE se = (SE) o;
        return start == se.start && Objects.equals(end, se.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "SE{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
