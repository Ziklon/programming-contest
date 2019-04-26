package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DStasAndTheQueueAtTheBuffet {

  long getVal(IntIntPair p, int idx, int n) {
    return (p.first * (idx - 1L)) + (p.second * (n - idx + 0L));
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();

    List<IntIntPair> items = new ArrayList<>();
    for (int i = 0; i < n; ++i) items.add(IntIntPair.makePair(in.readInt(), in.readInt()));

    if (n == 1) {
      out.printLine(getVal(items.get(0), 1, n));
      return;
    }

    int lowest = 0;

    for (int i = 0; i < n; ++i) {}

    Collections.sort(
        items,
        (p, q) -> {
          long p1 = getVal(p, 1, n);
          long p2 = getVal(q, 1, n);

          long q1 = getVal(p, 2, n);
          long q2 = getVal(q, 2, n);
          if (p1 != p2) {
            return (p1 < p2) ? -1 : 1;
          }
          return (q1 < q2) ? 1 : -1;
        });

    long cost = 0;

    for (int i = 0; i < n; ++i) {
      cost += getVal(items.get(i), i + 1, n);
    }

    out.printLine(cost);
  }
}
