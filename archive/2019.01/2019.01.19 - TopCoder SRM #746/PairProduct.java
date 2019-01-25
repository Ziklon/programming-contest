package com.darkbit.problems;

import java.util.HashMap;
import java.util.Map;

public class PairProduct {
  public int[] findPair(int n, int a0, int step, long p) {

    long[] seq = new long[n];
    seq[0] = a0;
    for (int i = 1; i < n; ++i) seq[i] = seq[i - 1] + step;

    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) map.put(seq[i], i);

    if (p == 0) {
      if (map.containsKey(0L)) {
        return new int[] {map.get(0L), map.get(0L)};
      }
      return new int[0];
    }

    for (int i = 0; i < n; ++i) {
      long a = seq[i];

      if (a != 0 && p % a == 0 && map.containsKey(p / a)) {
        return new int[] {i, map.get(p / a)};
      }
    }
    return new int[0];
  }
}
