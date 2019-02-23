package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BArrayKColoring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), k = in.readInt();
    int[] seq = in.readIntArray(n);
    List<Integer>[] items = new List[5001];
    for (int i = 0; i < items.length; ++i) items[i] = new ArrayList<>();

    for (int i = 0; i < seq.length; ++i) items[seq[i]].add(i);

    int count = 0;
    for (int i = 0; i < items.length; ++i) count = Math.max(count, items[i].size());

    if (count > k || n < k) {
      out.printLine("NO");
      return;
    }

    int color = 0;
    int[] ans = new int[n];
    for (int i = 0; i < items.length; ++i) {
      if (items[i].size() > 0) {
        for (int e : items[i]) {
          ans[e] = color + 1;
          color = (color + 1) % k;
        }
      }
    }
    out.printLine("YES");
    out.printLine(ans);
  }
}
