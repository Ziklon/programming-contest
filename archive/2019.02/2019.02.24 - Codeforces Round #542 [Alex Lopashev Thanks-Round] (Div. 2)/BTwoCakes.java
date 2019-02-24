package com.darkbit.problems;

import net.egork.collections.Pair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Map;
import java.util.PriorityQueue;

public class BTwoCakes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    PriorityQueue<Pair<Integer, Integer>> Q = new PriorityQueue<>();

    for (int i = 0; i < 2 * n; ++i) {
      Q.add(Pair.makePair(in.readInt(), i));
    }

    long ans = 0;
    int first = 0;
    int second = 0;
    int who = 0;
    while (!Q.isEmpty()) {
      Pair<Integer, Integer> cur = Q.poll();
      if (who == 0) {
        ans += Math.abs(cur.second - first);
        first = cur.second;
      } else {
        ans += Math.abs(cur.second - second);
        second = cur.second;
      }
      who ^= 1;
    }
    out.printLine(ans);
  }
}
