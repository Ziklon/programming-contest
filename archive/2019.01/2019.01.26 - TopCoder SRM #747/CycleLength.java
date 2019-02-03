package com.darkbit.problems;

import java.util.Arrays;

public class CycleLength {
  public int solve(int seed, int a, int b, int m) {
    int[] dist = new int[1 << 20];

    Arrays.fill(dist, -1);

    long state = seed;
    dist[seed] = 0;
    for (int i = 0; i < dist.length; ++i) {
      state = (state * a + b) % m;
      int intState = (int) state;
      if (dist[intState] != -1) {
        return i - dist[intState] + 1;
      } else dist[intState] = i + 1;
    }

    return 0;
  }
}
