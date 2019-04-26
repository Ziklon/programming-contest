package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class Fencing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    for (int a = 0; a < t; ++a) {
      int n = in.readInt(), m = in.readInt(), k = in.readInt();
      Set<IntIntPair> set = new HashSet<>();

      int ans = k * 4;
      int x[] = new int[k], y[] = new int[k];
      for (int i = 0; i < k; ++i) {
        int xi = in.readInt(), yi = in.readInt();
        set.add(IntIntPair.makePair(xi, yi));
        x[i] = xi;
        y[i] = yi;
      }

      for (int i = 0; i < k; ++i) {
        int count = 0;
        for (int j = 0; j < 4; ++j) {
          int xi = x[i] + dx[j];
          int yi = y[i] + dy[j];
          if (Math.min(xi, yi) < 1 || xi > n || yi > m) continue;
          if (set.contains(IntIntPair.makePair(xi, yi))) count++;
        }
        ans -= count;
      }
      out.printLine(ans);
    }
  }
}
