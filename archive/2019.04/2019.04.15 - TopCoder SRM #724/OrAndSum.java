package com.darkbit.problems;

import java.util.Arrays;

public class OrAndSum {
  public String isPossible(long[] pairOr, long[] pairSum) {
    return solve(pairOr, pairSum) ? "Possible" : "Impossible";
  }

  boolean solve(long[] pairOr, long[] pairSum) {

    long[] pairAnd = new long[pairOr.length];

    for (int i = 0; i < pairAnd.length; ++i) {
      pairAnd[i] = pairSum[i] - pairOr[i];
      if (pairAnd[i] < 0) return false;
    }

    for (int bit = 0; bit < 64; ++bit) {
      boolean[] can = new boolean[2];
      Arrays.fill(can, true);
      for (int i = 0; i < pairAnd.length; ++i) {
        int or = (int) ((pairOr[i] >> bit) & 1);
        int and = (int) ((pairAnd[i] >> bit) & 1);

        boolean[] ncan = new boolean[2];

        for (int a = 0; a < 2; ++a)
          for (int b = 0; b < 2; ++b)
            if (can[a] && (a | b) == or && (a & b) == and) {
              ncan[b] = true;
            }
        can = ncan;
      }
      if (!can[0] && !can[1]) return false;
    }
    return true;
  }
}
