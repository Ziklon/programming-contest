package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BYetAnotherArrayPartitioningTask {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt(), k = in.readInt();
    int seq[] = in.readIntArray(n);

    int[][] items = new int[n][];
    for (int i = 0; i < n; ++i) items[i] = new int[] {seq[i], i};

    Arrays.sort( items,  (p, q) -> {
          if (p[0] != q[0]) return q[0] - p[0];
          return p[1] - q[1];
        });


    long ans = 0;
    boolean[] used = new boolean[n];
    for (int i = 0; i < m * k; ++i) {
      ans += items[i][0];
      used[items[i][1]] = true;
    }
    out.printLine(ans);
    int count = 0;
    int group = 0;
    for (int i = 0; i < n; ++i) {
      if (used[i]) count++;
      if (count == m && group + 1 < k) {
        group++;
        out.print((i + 1) + " ");
        count = 0;
      }
    }
  }
}
