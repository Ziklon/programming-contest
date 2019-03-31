package com.darkbit.problems;

import net.egork.collections.map.Indexer;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UEFAChampionsLeague {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int tt = in.readInt();

    for (int t = 0; t < tt; ++t) {

      Indexer<String> indexer = new Indexer<>();

      int points[] = new int[4];
      int goals[] = new int[4];
      for (int i = 0; i < 12; ++i) {
        String a, b, c;
        int x, y;
        a = in.readString();
        x = in.readInt();
        c = in.readString();
        y = in.readInt();
        b = in.readString();
        goals[indexer.get(a)] += x - y;
        goals[indexer.get(b)] += y - x;
        if (x == y) {
          points[indexer.get(a)] += 1;
          points[indexer.get(b)] += 1;
        } else if (x > y) {
          points[indexer.get(a)] += 3;
        } else {
          points[indexer.get(b)] += 3;
        }
      }
      List<int[]> teams = new ArrayList<>();
      for (int i = 0; i < 4; ++i) teams.add(new int[] {points[i], goals[i], i});

      Collections.sort(
          teams,
          (p, q) -> {
            if (p[0] != q[0]) return q[0] - p[0];
            return q[1] - p[1];
          });

      String[] ans = new String[2];
      for (int i = 0; i < 2; ++i) {
        int idx = teams.get(i)[2];
        for (String key : indexer.keySet()) {
          if (indexer.get(key).intValue() == idx) {
            ans[i] = key;
          }
        }
      }

      out.printLine(ans);
    }
  }
}
