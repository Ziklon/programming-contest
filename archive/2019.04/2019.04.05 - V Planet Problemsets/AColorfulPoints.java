package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AColorfulPoints {

  Set<Integer> sx;
  char[] s;
  int N;
  int[][] lr;

  void update(int p) {
    if (p == 0 || p == N + 1) return;

    if (sx.contains(p)) sx.remove(p);
    if (lr[p][0] != 0 && s[p] != s[lr[p][0]]) sx.add(p);
    if (lr[p][1] != N + 1 && s[p] != s[lr[p][1]]) sx.add(p);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = (" " + in.readString()).toCharArray();
    N = s.length - 1;
    lr = new int[N + 5][2];
    sx = new HashSet<>();
    for (int i = 1; i <= N; ++i) {
      if (i != 1 && s[i] != s[i - 1]) sx.add(i);
      if (i != N && s[i] != s[i + 1]) sx.add(i);
      lr[i][0] = i - 1;
      lr[i][1] = i + 1;
    }

    for (int i = 0; ; ++i) {
      if (sx.isEmpty()) {
        out.printLine(i);
        return;
      }
      List<Integer> items = new ArrayList<>(sx);
      for (int e : items) {
        int t1 = lr[e][0], t2 = lr[e][1];

        lr[t1][1] = t2;
        lr[t2][0] = t1;
        update(t1);
        update(t2);
        sx.remove(e);
      }
    }
  }
}
