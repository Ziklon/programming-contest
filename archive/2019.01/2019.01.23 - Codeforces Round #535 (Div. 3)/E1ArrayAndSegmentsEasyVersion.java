package com.darkbit.problems;

import net.egork.collections.Pair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class E1ArrayAndSegmentsEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] array = new int[n];
    int[][] seg = new int[m][];

    for (int i = 0; i < n; ++i) array[i] = in.readInt();

    for (int i = 0; i < m; ++i) seg[i] = new int[] {in.readInt() - 1, in.readInt() - 1};

    int ans = 0;
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < n; ++i) {

      int[] copy = array.clone();
      List<Integer> tmp = new ArrayList<>();
      for (int j = 0; j < m; ++j) {
        if (seg[j][0] <= i && seg[j][1] >= i) continue;
        update(copy, seg[j][0], seg[j][1], -1);
        tmp.add(j + 1);
      }

      int score = getScore(copy);
      if (score > ans) {
        ans = score;
        lst = tmp;
      }
    }
    out.printLine(ans);
    out.printLine(lst.size());
    if (!lst.isEmpty()) out.printLine(lst.toArray());
  }

  int getScore(int[] seq) {
    int maxi = Integer.MIN_VALUE;
    int mini = Integer.MAX_VALUE;
    for (int item : seq) {
      maxi = Math.max(maxi, item);
      mini = Math.min(mini, item);
    }
    return maxi - mini;
  }

  void update(int[] seq, int l, int r, int add) {
    for (int i = l; i <= r; ++i) seq[i] += add;
  }
}
