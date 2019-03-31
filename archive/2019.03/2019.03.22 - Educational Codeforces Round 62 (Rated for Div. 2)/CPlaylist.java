package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.*;

public class CPlaylist {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    List<int[]> items = new ArrayList<>();
    for (int i = 0; i < n; ++i) items.add(new int[] {in.readInt(), in.readInt()});

    Collections.sort(items, Comparator.comparingInt(p -> p[1]));

    long sum = 0;
    long ans = 0;
    PriorityQueue<Integer> Q = new PriorityQueue<>();
    for (int i = n - 1; i >= 0; --i) {
      Q.add(items.get(i)[0]);
      sum += items.get(i)[0];
      if (Q.size() > k) {
        sum -= Q.poll();
      }
      ans = Math.max(ans, items.get(i)[1] * sum);
    }

    out.printLine(ans);
  }
}
