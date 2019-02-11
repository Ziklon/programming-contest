package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BPowersOfTwo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    TreeMap<Integer, Integer> counters = new TreeMap<>();

    for (int e : seq) counters.put(e, counters.getOrDefault(e, 0) + 1);
    int ans = 0;

    while (!counters.isEmpty()) {
      int lastKey = counters.lastKey();
      int cnt = counters.get(lastKey);
      if (cnt == 1) counters.remove(lastKey);
      else {
        counters.put(lastKey, cnt - 1);
      }
      int p1 = 1;
      while (p1 <= lastKey) p1 *= 2;
      int need = p1 - lastKey;

      Integer needCount = counters.get(need);
      if (needCount != null) {
        ans++;
        if (needCount == 1) counters.remove(need);
        else counters.put(need, needCount - 1);
      }
    }
    out.printLine(ans);
  }
}
