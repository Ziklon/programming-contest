package com.darkbit.problems;

import net.egork.collections.Pair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

public class DGCDCounting {
  List<Integer>[] G;
  int[] V;

  Pair<Integer, Integer>[] dp;
  boolean[] vis;

  Pair<Integer, Integer> max(Pair<Integer, Integer> p, Pair<Integer, Integer> q) {
    if (p.first.intValue() > q.first.intValue() && p.second > 1) return p;
    if (q.first.intValue() > p.first.intValue() && q.second > 1) return q;
    return p;
  }

  Pair<Integer, Integer> join(Pair<Integer, Integer> p, Pair<Integer, Integer> q) {
    return Pair.makePair(
        p.first.intValue() + q.first.intValue(), IntegerUtils.gcd(p.second, q.second));
  }

  Pair<Integer, Integer> go(int idx) {
    Pair<Integer, Integer> cur = dp[idx];
    if (cur.first == -1) {
      cur = Pair.makePair(1, V[idx]);

    }
    return cur;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    G = new List[n];
    V = new int[n];
    dp = new Pair[n];
    vis = new boolean[n];
    for (int i = 0; i < n; ++i) dp[i] = Pair.makePair(-1, -1);
    for (int i = 0; i < n; ++i) G[i] = new ArrayList<>();

    for (int i = 0; i < n; ++i) V[i] = in.readInt();

    for (int i = 1; i < n; ++i) {
      int u = in.readInt(), v = in.readInt();
      G[u].add(v);
      G[v].add(u);
    }
  }
}
