package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PaintTheFence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    List<Integer> left[] = new List[n + 1];
    List<Integer> right[] = new List[n + 1];
    for (int i = 0; i < left.length; ++i) {
      left[i] = new ArrayList<>();
      right[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; ++i) {
      int x = in.readInt() - 1, y = in.readInt();
      left[x].add(i);
      right[y].add(i);
    }
    int counter[] = new int[m + 1];

    TreeSet<Integer> set = new TreeSet<>();
    int empty = 0;
    for (int b = 0; b < n; ++b) {
      set.addAll(left[b]);
      set.removeAll(right[b]);

      if (set.isEmpty()) empty++;
      else if (set.size() == 1) {
        counter[set.first()]++;
      }
    }

    for (int i = 0; i < m; ++i) out.printLine(counter[i] + empty);
  }
}
