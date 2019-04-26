package com.darkbit.problems;

import net.egork.collections.map.Indexer;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BTaxiDriversAndLyft {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int x[] = in.readIntArray(n + m);
    int t[] = in.readIntArray(n + m);

    int ans[] = new int[m];
    int next[] = new int[n + m];
    Arrays.fill(next, -1);

    Indexer<Integer> indexer = new Indexer<>();
    for (int i = 0; i < x.length; ++i) if (t[i] == 1) indexer.get(i);

    for (int i = x.length - 1; i >= 0; --i) {
      if (t[i] == 1) next[i] = i;
      else if (i + 1 < x.length) next[i] = next[i + 1];
    }
    int prev = -1;
    for (int i = 0; i < x.length; ++i) {
      if (t[i] == 0) {
        int inext = next[i];
        if (prev == -1) ans[indexer.get(inext)]++;
        else if (inext == -1) ans[indexer.get(prev)]++;
        else {
          int dist1 = Math.abs(x[i] - x[prev]);
          int dist2 = Math.abs(x[i] - x[inext]);
          if (dist2 < dist1) ans[indexer.get(inext)]++;
          else ans[indexer.get(prev)]++;
        }
      }

      if (t[i] == 1) prev = i;
    }

    out.printLine(ans);
  }
}
