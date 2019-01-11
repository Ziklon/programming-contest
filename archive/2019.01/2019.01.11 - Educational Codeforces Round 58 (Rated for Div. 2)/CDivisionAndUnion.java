package com.darkbit.problems;

import net.egork.collections.Pair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CDivisionAndUnion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      int n = in.readInt();

      List<Pair<Integer, Pair<Integer, Integer>>> list = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        int a = in.readInt(), b = in.readInt();
        list.add(Pair.makePair(j, Pair.makePair(a, b)));
      }
      Collections.sort(list, Comparator.comparing(a -> a.second.first));

      boolean found = false;
      int[] seq = new int[n];
      int last = -1;
      for (int j = 0; j + 1 < n && !found; ++j) {
        Pair<Integer, Integer> p = list.get(j).second;
        Pair<Integer, Integer> q = list.get(j + 1).second;
        if (p.second.intValue() < q.first.intValue() && last < q.first) {
          found = true;
          for (int k = 0; k <= j; ++k) seq[list.get(k).first] = 1;
          for (int k = j + 1; k < n; ++k) seq[list.get(k).first] = 2;
        }
        last = Math.max(last, Math.max(p.second,q.second));
      }
      if (!found) out.printLine(-1);
      else {
        out.printLine(seq);
      }
    }
  }
}
