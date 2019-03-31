package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoreSquares {
  public int countLocations(int N, int SX, int SY, int[] Xprefix, int[] Yprefix) {

    int[] X = Arrays.copyOf(Xprefix, N);
    int[] Y = Arrays.copyOf(Yprefix, N);

    Set<IntIntPair> set = new HashSet<>();

    for (int i = Xprefix.length; i < X.length; ++i) {
      X[i] = (X[i - 1] * 47 + 42) % SX;
      Y[i] = (Y[i - 1] * 47 + 42) % SY;
    }

    for (int i = 0; i < N; ++i) set.add(IntIntPair.makePair(X[i], Y[i]));

    Set<IntIntPair> ans = new HashSet<>();
    for (IntIntPair a : set)
      for (IntIntPair b : set) {
        int dx = a.first - b.first;
        int dy = a.second - b.second;
        int nx = b.first + dy;
        int ny = b.second - dx;
        IntIntPair key = IntIntPair.makePair(nx, ny);
        if (set.contains(key)) {
          nx += dx;
          ny += dy;
          key = IntIntPair.makePair(nx, ny);
          if (!set.contains(key)) ans.add(key);
        }
      }

    return ans.size();
  }
}
