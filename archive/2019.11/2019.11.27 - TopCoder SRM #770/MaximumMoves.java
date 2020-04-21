package com.darkbit.problems;

public class MaximumMoves {
    public long getMaximumMoves(long P, long Q) {

        if (Q < P) return -1;
        if (Q - P == 1) return -1;

        return Math.abs(P - Q) / 2;
    }
}
