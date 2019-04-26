package com.darkbit.problems;

import net.egork.collections.map.Counter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CTwoShuffledSequences {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    seq = ArrayUtils.radixSort(seq);
    Counter<Integer> counter = new Counter<>();
    for (int e : seq) counter.add(e);

    for (int key : counter.keySet())
      if (counter.get(key) > 2) {
        out.printLine("NO");
        return;
      }

    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    for (int key : counter.keySet()) {
      if (counter.get(key) == 2) {
        l1.add(key);
        l2.add(key);
      } else l2.add(key);
    }
    Collections.sort(l2);
    Collections.sort(l1);
    Collections.reverse(l1);

    out.printLine("YES");
    out.printLine(l2.size());
    out.printLine(l2.toArray());
    out.printLine(l1.size());
    out.printLine(l1.toArray());
  }
}
