package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CTreeDiameter {

  int l1, l2;

  int[] split(int n, int div) {

    int[] ans = new int[n];
    int who = 0;
    List<Integer>[] items = new List[2];
    for (int i = 0; i < 2; ++i) items[i] = new ArrayList<>();
    for (int i = 1; i <= n; ) {
      for (int j = 1; j <= div; ++j) {
        items[who].add(i++);
        if (i == n + 1) break;
      }
      who ^= 1;
    }
    for (int i = 0; i < items[0].size(); ++i) ans[i] = items[0].get(i);
    for (int i = 0; i < items[1].size(); ++i) ans[i + items[0].size()] = items[1].get(i);

    l1 = items[0].size();
    l2 = items[1].size();

    return ans;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int a = 0; a < t; ++a) {

      int n = in.readInt();
      int n1 = n >> 1;
      int n2 = n - n1;
      int ans = 0;

      for (int i = 0; (1 << i) < n; ++i) {
        int[] arr = split(n, 1 << i);
        out.print(String.format("%d %d ", l1, l2));
        out.printLine(arr);
        out.flush();
        ans = Math.max(ans, in.readInt());
      }
      out.printLine(String.format("%d %d", -1, ans));
      out.flush();
    }
  }
}
