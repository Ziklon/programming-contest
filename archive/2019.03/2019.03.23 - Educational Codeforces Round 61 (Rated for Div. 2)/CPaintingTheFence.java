package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CPaintingTheFence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    List<IntIntPair> segments = new ArrayList<>();
    int cnt[] = new int[n];

    for (int i = 0; i < m; ++i) {
      int x = in.readInt() - 1, y = in.readInt() - 1;
      for (int j = x; j <= y; ++j) cnt[j]++;
      segments.add(IntIntPair.makePair(x, y));
    }
    int ans = 0;

    for (int e = 0; e < m; ++e) {
      int cnt_pos = 0, ones[] = new int[n];
      for (int i = segments.get(e).first; i <= segments.get(e).second; ++i) {
        --cnt[i];
      }

      for (int i = 0; i < n; ++i) {
        if (cnt[i] > 0) cnt_pos++;
        if (cnt[i] == 1) ++ones[i];
      }

      for (int i = 1; i < n; ++i) ones[i] += ones[i - 1];

      for (int v = e + 1; v < m; ++v) {

        int prev = segments.get(v).first - 1;
        int lost_ones = ones[segments.get(v).second] - (prev < 0 ? 0 : ones[prev]);
        ans = Math.max(ans, cnt_pos - lost_ones);
      }

      for (int i = segments.get(e).first; i <= segments.get(e).second; ++i) {
        ++cnt[i];
      }
    }

    out.printLine(ans);
  }
}
