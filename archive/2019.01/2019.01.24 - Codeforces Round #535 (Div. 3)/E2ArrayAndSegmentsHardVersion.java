package com.darkbit.problems;

import net.egork.collections.intervaltree.SumIntervalTree;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class E2ArrayAndSegmentsHardVersion {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    long[] array = new long[n];
    int[][] seg = new int[m][];

    List<Integer[]>[] st = new List[n];
    List<Integer[]>[] fn = new List[n];
    for (int i = 0; i < n; ++i) {
      st[i] = new ArrayList<>();
      fn[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; ++i) array[i] = in.readInt();

    SumIntervalTree tree =
        new SumIntervalTree(array.clone()) {
          @Override
          protected long joinValue(long left, long right) {
            return Math.min(left, right);
          }

          @Override
          protected long neutralValue() {
            return Long.MAX_VALUE;
          }

          @Override
          protected long emptySegmentResult() {
            return Long.MAX_VALUE;
          }

          @Override
          protected long accumulate(long value, long delta, int length) {
            return value + delta;
          }
        };

    for (int i = 0; i < m; ++i) {
      int[] item = new int[] {in.readInt() - 1, in.readInt() - 1};
      st[item[0]].add(new Integer[] {item[0], item[1]});
      fn[item[1]].add(new Integer[] {item[0], item[1]});
      seg[i] = item;
      tree.update(item[0], item[1], -1);
    }

    long ans = -1;
    int idx = 0;
    for (int i = 0; i < n; ++i) {

      for (Integer[] q : st[i]) {
        tree.update(q[0].intValue(), q[1].intValue(), 1);
      }
      if (array[i] - tree.query(0, n - 1) > ans) {
        idx = i;
        ans = array[i] - tree.query(0, n - 1);
      }
      for (Integer[] q : fn[i]) {
        tree.update(q[0].intValue(), q[1].intValue(), -1);
      }
    }

    out.printLine(ans);
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < m; ++i)
      if (idx < seg[i][0]  || idx > seg[i][1]) {
        lst.add(i + 1);
      }
    out.printLine(lst.size());
    if (!lst.isEmpty()) out.printLine(lst.toArray());
  }
}
